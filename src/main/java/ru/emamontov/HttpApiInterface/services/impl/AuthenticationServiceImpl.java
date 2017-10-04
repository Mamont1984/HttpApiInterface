package ru.emamontov.HttpApiInterface.services.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.emamontov.HttpApiInterface.entities.*;
import ru.emamontov.HttpApiInterface.repositories.UsersRepository;
import ru.emamontov.HttpApiInterface.services.AuthenticationService;
import ru.emamontov.HttpApiInterface.services.EncryptionService;

@Service
public class AuthenticationServiceImpl implements AuthenticationService {

    @Autowired
    UsersRepository usersRepository;
    @Autowired
    EncryptionService encryptionService;

    @Override
    public Entity login(String email, String password) {

        User user = usersRepository.getUser(email);

        if (user == null) {
            return new ErrorEntity(false, ResponseStatus.USER_NOT_EXIST);
        } else if (!user.getHashedPassword().equals(encryptionService.encrypt(password))) {
            return new ErrorEntity(false, ResponseStatus.WRONG_PASSWORD);
        } else if (!user.isVerified()) {
            return new ErrorEntity(false, ResponseStatus.USER_NOT_VERIFIED);
        }

        return new AuthenticationEntity(true, ResponseStatus.OK, user);
    }
}
