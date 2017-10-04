package ru.emamontov.HttpApiInterface.entities;

public class AuthenticationEntity extends Entity {

    private final String message;
    private final User user;

    public AuthenticationEntity(boolean success, String message, User user) {
        super(success);
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
