package ru.emamontov.HttpApiInterface.services.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.emamontov.HttpApiInterface.entities.ConfirmationTokenEntity;
import ru.emamontov.HttpApiInterface.repositories.UsersRepository;
import ru.emamontov.HttpApiInterface.services.RegistrationService;
import ru.emamontov.HttpApiInterface.entities.User;

@Service
public class RegistrationServiceImpl implements RegistrationService {

    @Autowired
    UsersRepository usersRepository;

    @Override
    public ConfirmationTokenEntity register(String email, String password) {

        String token = usersRepository.addUser(email, password);

        if (token != null) {
            return new ConfirmationTokenEntity(true,"User created!", token);
        }

        return new ConfirmationTokenEntity(false, "User already exists", "-1");
    }
}
