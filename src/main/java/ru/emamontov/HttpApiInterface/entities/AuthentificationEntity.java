package ru.emamontov.HttpApiInterface.entities;

public class AuthentificationEntity extends Entity {

    private final boolean success;
    private final String message;
    private final User user;

    public AuthentificationEntity(boolean success, String message, User user) {
        this.success = success;
        this.message = message;
        this.user = user;
    }

    public boolean isSuccess() {
        return success;
    }

    public String getMessage() {
        return message;
    }

    public User getUser() {
        return user;
    }
}
