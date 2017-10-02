package ru.emamontov.HttpApiInterface.services;

import ru.emamontov.HttpApiInterface.entities.Entity;
import ru.emamontov.HttpApiInterface.entities.TokenEntity;
import ru.emamontov.HttpApiInterface.entities.User;

public interface ConfirmationService extends Service {

    public Entity confirm(TokenEntity tokenEntity);
}
