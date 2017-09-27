package ru.emamontov.HttpApiInterface.repositories.impl;

import org.springframework.beans.factory.annotation.Autowired;
import ru.emamontov.HttpApiInterface.repositories.UsersRepository;
import ru.emamontov.HttpApiInterface.entities.User;
import ru.emamontov.HttpApiInterface.services.PasswordEncryptionService;

import java.util.HashMap;
import java.util.Map;

public class UsersRepositoryImpl implements UsersRepository {

    PasswordEncryptionService passwordEncryptionService;

    public UsersRepositoryImpl(PasswordEncryptionService passwordEncryptionService) {
        this.passwordEncryptionService = passwordEncryptionService;
    }

    private int id = 1;
    private Map<String, User> users = new HashMap<>(); // HashMap подходит для многопоточности?

    @Override
    public User addUser(String email, String password) {
        User user = new User(id++, email, passwordEncryptionService.encrypt());
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
