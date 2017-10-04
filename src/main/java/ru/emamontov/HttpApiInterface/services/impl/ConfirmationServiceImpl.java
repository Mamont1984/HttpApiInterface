package ru.emamontov.HttpApiInterface.services.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.emamontov.HttpApiInterface.entities.*;
import ru.emamontov.HttpApiInterface.repositories.UsersRepository;
import ru.emamontov.HttpApiInterface.services.ConfirmationService;

@Service
public class ConfirmationServiceImpl implements ConfirmationService {

    @Autowired
    UsersRepository usersRepository;

    @Override
    public Entity confirm(TokenEntity tokenEntity) {

        User user = usersRepository.confirmUser(tokenEntity.getToken());
        if (user != null) {
            return new AuthenticationEntity(true, "User confirmed!", user);
        }
        return new ErrorEntity(false, ResponseStatus.BAD_TOKEN);
    }
}
