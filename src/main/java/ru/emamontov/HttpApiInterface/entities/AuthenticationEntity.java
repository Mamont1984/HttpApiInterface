package ru.emamontov.HttpApiInterface.entities;

public class AuthenticationEntity extends Entity {

    private String message;
    private User user;

    public AuthenticationEntity() {
        super();
    }

    public AuthenticationEntity(boolean success, String message, User user) {
        super(success);
        this.message = message;
        this.user = user;
    }

    public AuthenticationEntity(boolean success, ResponseStatus error, User user) {
        super(success);
        this.message = error.getReasonPhrase();
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
