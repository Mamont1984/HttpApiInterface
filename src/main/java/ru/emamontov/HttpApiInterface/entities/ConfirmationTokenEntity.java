package ru.emamontov.HttpApiInterface.entities;

public class ConfirmationTokenEntity extends Entity {

    private final boolean success;
    private final String message;
    private final String token;

    public ConfirmationTokenEntity(boolean success, String message, String token) {
        this.success = success;
        this.message = message;
        this.token = token;
    }

    public boolean getSuccess() {
        return success;
    }

    public String getMessage() {
        return message;
    }

    public String getToken() {
        return token;
    }
}
