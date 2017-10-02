package ru.emamontov.HttpApiInterface.repositories;

import ru.emamontov.HttpApiInterface.entities.User;

public interface UsersRepository {

    public String addUser(String email, String password);
    public User getUser(String email, String password);
}
