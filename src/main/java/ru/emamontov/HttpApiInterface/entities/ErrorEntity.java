package ru.emamontov.HttpApiInterface.entities;

public class ErrorEntity extends Entity {

    private final String message;
    private final int error;

    public ErrorEntity(boolean success, String message, int error) {
        super(success);
        this.message = message;
        this.error = error;
    }

    public ErrorEntity(boolean success, ResponseStatus error) {
        super(success);
        this.message = error.getReasonPhrase();
        this.error = error.value();
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
