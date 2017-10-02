package ru.emamontov.HttpApiInterface.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;

import java.util.Date;

public class User {
    private final int id;
    private final String email;
    private final Date created;
    @JsonIgnore
    private String hashedPassword;
    @JsonIgnore
    private boolean verified = false;

    public User(int id, String email, String hashedPassword) {
        this.id = id;
        this.email = email;
        this.created = new Date();
        this.hashedPassword = hashedPassword;
    }

    public int getId() {
        return id;
    }

    public String getEmail() {
        return email;
    }

    public Date getCreated() {
        return created;
    }

    public String getHashedPassword() {
        return hashedPassword;
    }

    public void setHashedPassword(String hashedPassword) {
        this.hashedPassword = hashedPassword;
    }

    public boolean isVerified() {
        return verified;
    }

    public void setVerified() {
        this.verified = true;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        User user = (User) o;

        return email.equals(user.email);
    }

    @Override
    public int hashCode() {
        return email.hashCode();
    }
}
