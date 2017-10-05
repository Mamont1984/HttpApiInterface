package ru.emamontov.HttpApiInterface.entities;

public class ErrorEntity extends Entity {

    private String message;
    private int error;

    public ErrorEntity() {
        super();
    }

    public ErrorEntity(boolean success, ResponseStatus responseStatus) {
        super(success);
        this.message = responseStatus.getReasonPhrase();
        this.error = responseStatus.value();
    }

    public boolean isSuccess() {
        return success;
    }

    public String getMessage() {
        return message;
    }

    public int getError() {
        return error;
    }
}
