package ru.emamontov.HttpApiInterface.services;

public interface EncryptionService {
    public String encrypt(String str);
    public String generateToken();
}
