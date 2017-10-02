package ru.emamontov.HttpApiInterface.repositories.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import ru.emamontov.HttpApiInterface.repositories.UsersRepository;
import ru.emamontov.HttpApiInterface.entities.User;
import ru.emamontov.HttpApiInterface.services.EncryptionService;

import java.util.HashMap;
import java.util.Map;

@Repository
public class UsersRepositoryImpl implements UsersRepository {

    @Autowired
    EncryptionService encryptionService;

    private int id = 1;
    private Map<String, User> users = new HashMap<>(); // HashMap не подходит для многопоточности.
    private Map<String, User> tokens = new HashMap<>();// HashMap не подходит для многопоточности.

    @Override
    public String addUser(String email, String password) {
        User user = new User(id++, email, encryptionService.encrypt(password));
        String token = null;
        if (!users.containsKey(email)) {
            users.put(email, user);
            token = encryptionService.generateToken();
            tokens.put(token, user);
        }
        return token;
    }

    @Override
    public User getUser(String email, String password) {
        return users.get(email);
    }
}
