package ru.emamontov.HttpApiInterface.services;

import ru.emamontov.HttpApiInterface.entities.User;

public interface RegistrationService extends Service {

    public User register(String email, String password);
}
