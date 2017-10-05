package ru.emamontov.HttpApiInterface.services.impl;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import ru.emamontov.HttpApiInterface.Application;
import ru.emamontov.HttpApiInterface.services.EncryptionService;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = {Application.class})
public class EncryptionServiceImplTest extends Assert {

    @Autowired
    EncryptionService encryptionService;

    @Test
    public void testEncrypt() {

        String empty = encryptionService.encrypt(new String());
        String a = encryptionService.encrypt(new String("1"));
        String b = encryptionService.encrypt(new String("1"));
        String c = encryptionService.encrypt(new String("2"));

        assertNotNull(empty);
        assertEquals(a , b);
        assertNotEquals(a , c);
    }
}
