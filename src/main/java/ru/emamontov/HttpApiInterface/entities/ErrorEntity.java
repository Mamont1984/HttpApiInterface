package ru.emamontov.HttpApiInterface.entities;

public class ErrorEntity extends Entity {

    private final String message;
    private final String error;

    public ErrorEntity(boolean success, String message, String error) {
        super(success);
        this.message = message;
        this.error = error;
    }

    public boolean isSuccess() {
        return success;
    }

    public String getMessage() {
        return message;
    }

    public String getError() {
        return error;
    }
}
