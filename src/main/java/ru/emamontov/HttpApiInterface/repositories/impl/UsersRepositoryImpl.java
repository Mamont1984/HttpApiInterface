package ru.emamontov.HttpApiInterface.repositories.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import ru.emamontov.HttpApiInterface.repositories.UsersRepository;
import ru.emamontov.HttpApiInterface.entities.User;
import ru.emamontov.HttpApiInterface.services.EncryptionService;

import java.util.HashMap;
import java.util.Hashtable;
import java.util.Map;

@Repository
public class UsersRepositoryImpl implements UsersRepository {

    @Autowired
    EncryptionService encryptionService;

    private int id = 1;
    private Map<String, User> users = new Hashtable<>();
    private Map<String, User> tokens = new Hashtable<>();

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
    public User getUser(String email) {
        return users.get(email);
    }

    @Override
    public User confirmUser(String token) {
        if (tokens.containsKey(token)) {
            User user = tokens.remove(token);
            user.setVerified();
            return user;
        }
        return null;
    }
}
