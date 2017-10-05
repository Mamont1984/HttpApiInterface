package ru.emamontov.HttpApiInterface.entities;

public class AuthenticationEntity extends Entity {

    private String message;
    private User user;

    public AuthenticationEntity() {
        super();
    }

    public AuthenticationEntity(boolean success, ResponseStatus responseStatus, User user) {
        super(success);
        this.message = responseStatus.getReasonPhrase();
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
