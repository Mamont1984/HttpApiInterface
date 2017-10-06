package ru.emamontov.HttpApiInterface.services.impl;

import org.springframework.stereotype.Service;
import ru.emamontov.HttpApiInterface.services.EncryptionService;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
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
                e.printStackTrace();

                //todo
            }

            final byte[] bytes = digest.digest(str.getBytes());

            final StringBuilder hexString = new StringBuilder();
            for (final byte b : bytes) {
                String hex = Integer.toHexString(0xff & b);
                if (hex.length() == 1) {
                    hexString.append('0');
                }
                hexString.append(hex);
            }

            return hexString.toString();
    }

    @Override
    public String generateToken() {
        return String.valueOf(random.nextInt(100000) + 100000);
    }
}
