package ru.emamontov.HttpApiInterface.entities;

public class AuthentificationEntity extends Entity {

    private final boolean success;
    private final String message;
    private final User user;

    public AuthentificationEntity(boolean success, String message) {
        this.success = success;
        this.message = message;
        this.user = new User((int) (Math.random()*10), "email@email.ru", "password");
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
