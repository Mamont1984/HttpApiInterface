package ru.emamontov.HttpApiInterface.services;

import ru.emamontov.HttpApiInterface.entities.Entity;

public interface RegistrationService extends Service {

    public Entity register(String email, String password);
}
