package ru.emamontov.HttpApiInterface.services.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.emamontov.HttpApiInterface.entities.*;
import ru.emamontov.HttpApiInterface.repositories.UsersRepository;
import ru.emamontov.HttpApiInterface.services.RegistrationService;

@Service
public class RegistrationServiceImpl implements RegistrationService {

    @Autowired
    UsersRepository usersRepository;

    @Override
    public Entity register(String email, String password) {

        String token = usersRepository.addUser(email, password);

        if (token != null) {
            return new ConfirmationTokenEntity(true, ResponseStatus.OK, token);
        }

        return new ErrorEntity(false, ResponseStatus.USER_ALREADY_EXIST);
    }
}
