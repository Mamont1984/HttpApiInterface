package ru.emamontov.HttpApiInterface.services.impl;

import org.springframework.beans.factory.annotation.Autowired;
import ru.emamontov.HttpApiInterface.repositories.UsersRepository;
import ru.emamontov.HttpApiInterface.services.RegistrationService;
import ru.emamontov.HttpApiInterface.entities.User;

public class RegistrationServiceImpl implements RegistrationService {
    @Autowired
    UsersRepository usersRepository;

    @Override
    public User register(String email, String password) {
        return usersRepository.addUser(email, password);
    }
}
