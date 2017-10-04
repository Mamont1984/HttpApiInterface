package ru.emamontov.HttpApiInterface.entities;

public class RegistrationEntity extends Entity {

    private String email;
    private String password;

    public RegistrationEntity(boolean success) {
        super(success);
    }

    public String getEmail() {
        return email;
    }

    public String getPassword() {
        return password;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
