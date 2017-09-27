package ru.emamontov.HttpApiInterface.services.impl;

import org.springframework.beans.factory.annotation.Autowired;
import ru.emamontov.HttpApiInterface.entities.ConfirmationTokenEntity;
import ru.emamontov.HttpApiInterface.repositories.UsersRepository;
import ru.emamontov.HttpApiInterface.services.RegistrationService;
import ru.emamontov.HttpApiInterface.entities.User;

public class RegistrationServiceImpl implements RegistrationService {
    @Autowired
    UsersRepository usersRepository;

    @Override
    public ConfirmationTokenEntity register(String email, String password) {

        User user = usersRepository.addUser(email, password);

        if (user != null) {
            return new ConfirmationTokenEntity(true,"", user.getConfirmationToken());
        }

        return new ConfirmationTokenEntity(false, "User already exists", "2");
    }
}
