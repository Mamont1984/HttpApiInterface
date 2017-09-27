package ru.emamontov.HttpApiInterface.services;

import ru.emamontov.HttpApiInterface.entities.ConfirmationTokenEntity;

public interface RegistrationService extends Service {

    public ConfirmationTokenEntity register(String email, String password);
}
