package ru.emamontov.HttpApiInterface.entities;

public enum ResponseStatus {

    OK(0,"OK"),
    BAD_REQUERST(1, "Bad request"),
    USER_ALREADY_EXIST(2, "User already exist"),
    BAD_TOKEN (3, "Bad token"),
    USER_NOT_EXIST(4, "User not exist"),
    WRONG_PASSWORD(5, "Wrong password!"),
    USER_NOT_VERIFIED(6, "User not verified");

    private final int value;
    private final String reasonPhrase;

    ResponseStatus(int value, String reasonPhrase) {
        this.value = value;
        this.reasonPhrase = reasonPhrase;
    }

    public int value() {
        return value;
    }

    public String getReasonPhrase() {
        return reasonPhrase;
    }
}
