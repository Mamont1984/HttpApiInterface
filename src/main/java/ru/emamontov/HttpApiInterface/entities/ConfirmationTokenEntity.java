package ru.emamontov.HttpApiInterface.entities;

public class ConfirmationTokenEntity extends Entity {

    private String message;
    private String token;

    public ConfirmationTokenEntity() {
        super();
    }

    public ConfirmationTokenEntity(boolean success, ResponseStatus responseStatus, String token) {
        super(success);
        this.message = responseStatus.getReasonPhrase();
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
