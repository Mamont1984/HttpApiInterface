package ru.emamontov.HttpApiInterface.services.impl;

import org.springframework.stereotype.Service;
import ru.emamontov.HttpApiInterface.services.EncryptionService;

import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Base64;
import java.util.Random;

@Service
public class EncryptionServiceImpl implements EncryptionService {

    Random random = new Random();

    @Override
    public String encrypt(String str) {
        MessageDigest digest = null;
        try {
            digest = MessageDigest.getInstance("SHA-256");
        } catch (NoSuchAlgorithmException e) {
            //todo
        }
        byte[] hash = digest.digest(str.getBytes(StandardCharsets.UTF_8));
        String encoded = Base64.getEncoder().encodeToString(hash);
        return encoded;
    }

    @Override
    public String generateToken() {
        return String.valueOf(random.nextInt(100000) + 100000);
    }
}
