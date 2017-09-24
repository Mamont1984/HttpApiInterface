package ru.emamontov.HttpApiInterface.repositories;

import ru.emamontov.HttpApiInterface.entities.User;

public interface UsersRepository {

    public User addUser(String email, String password);
    public User getUser(User user);
    public void removeUser(User user);
}
