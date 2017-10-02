package ru.emamontov.HttpApiInterface.services.impl;

import org.springframework.stereotype.Service;
import ru.emamontov.HttpApiInterface.services.EncryptionService;

import java.util.Random;

@Service
public class EncryptionServiceImpl implements EncryptionService {

    Random random = new Random();

    @Override
    public String encrypt(String str) {
        return new String("12345");
    }

    @Override
    public String generateToken() {
        return String.valueOf(random.nextInt(100000) + 100000);
    }
}
