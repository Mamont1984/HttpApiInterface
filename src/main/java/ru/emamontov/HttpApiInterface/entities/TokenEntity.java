package ru.emamontov.HttpApiInterface.entities;

public class TokenEntity extends Entity {

    private String token;

    public TokenEntity() {
        super();
    }

    public TokenEntity(boolean success) {
        super(success);
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }
}
