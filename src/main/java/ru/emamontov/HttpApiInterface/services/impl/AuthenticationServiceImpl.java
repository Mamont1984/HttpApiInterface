package ru.emamontov.HttpApiInterface.services.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.emamontov.HttpApiInterface.entities.AuthenticationEntity;
import ru.emamontov.HttpApiInterface.entities.Entity;
import ru.emamontov.HttpApiInterface.entities.ErrorEntity;
import ru.emamontov.HttpApiInterface.entities.User;
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

        System.out.println(user);

        if (user == null) {
            return new ErrorEntity(false, "User not exist", "4");
        } else if (!user.getHashedPassword().equals(encryptionService.encrypt(password))) {
            return new ErrorEntity(false, "Bad password!", "5");
        } else if (!user.isVerified()) {
            return new ErrorEntity(false, "User not verified", "6");
        }

        return new AuthenticationEntity(true, "User authenticated!", user);
    }
}
