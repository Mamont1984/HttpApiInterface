package ru.emamontov.HttpApiInterface.services.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.emamontov.HttpApiInterface.entities.AuthentificationEntity;
import ru.emamontov.HttpApiInterface.entities.Entity;
import ru.emamontov.HttpApiInterface.entities.ErrorEntity;
import ru.emamontov.HttpApiInterface.entities.User;
import ru.emamontov.HttpApiInterface.repositories.UsersRepository;
import ru.emamontov.HttpApiInterface.services.AuthentificationService;
import ru.emamontov.HttpApiInterface.services.EncryptionService;

@Service
public class AuthentificationServiceImpl implements AuthentificationService {

    @Autowired
    UsersRepository usersRepository;
    @Autowired
    EncryptionService encryptionService;

    @Override
    public Entity login(String email, String password) {

        User user = usersRepository.getUser(email);

        System.out.println(user);

        if (user == null) {
        } else if (user.getHashedPassword() != encryptionService.encrypt(password)) {
            new ErrorEntity(false, "Bad password!", "5");
        } else if (!user.isVerified()) {
            new ErrorEntity(false, "User not verified", "6");
        } else {
            return new AuthentificationEntity(true, "User authenticated!", user);
        }
        return new ErrorEntity(false, "User not exist", "4");
    }
}
