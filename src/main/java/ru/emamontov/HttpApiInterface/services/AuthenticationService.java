package ru.emamontov.HttpApiInterface.services;

import ru.emamontov.HttpApiInterface.entities.Entity;

public interface AuthenticationService extends Service {
    public Entity login(String email, String password);
}
