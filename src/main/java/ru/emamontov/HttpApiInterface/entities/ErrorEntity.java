package ru.emamontov.HttpApiInterface.entities;

public class ErrorEntity extends Entity {

    private final boolean success;
    private final String message;
    private final String error;

    public ErrorEntity(boolean success, String message, String error) {
        this.success = success;
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
