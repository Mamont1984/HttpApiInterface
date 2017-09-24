package ru.emamontov.HttpApiInterface.entities;

import java.util.Date;

public class User {
    private final int id;
    private final String email;
    private final Date created;
    private final String hashedPassword;

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
