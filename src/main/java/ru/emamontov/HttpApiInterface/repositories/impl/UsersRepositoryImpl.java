package ru.emamontov.HttpApiInterface.repositories.impl;

import ru.emamontov.HttpApiInterface.repositories.UsersRepository;
import ru.emamontov.HttpApiInterface.entities.User;

import java.util.HashMap;
import java.util.Map;

public class UsersRepositoryImpl implements UsersRepository {

    Map<String, User> users = new HashMap<>(); // HashMap подходит для многопоточности?

    @Override
    public User addUser(String email, String password) {
        User user = new User(users.size() + 1, email, password);
        return users.putIfAbsent(user.getEmail(), user);
    }

    @Override
    public User getUser(User user) {
        return users.get(user);
    }

    @Override
    public void removeUser(User user) {
        users.remove(user);
    }
}
