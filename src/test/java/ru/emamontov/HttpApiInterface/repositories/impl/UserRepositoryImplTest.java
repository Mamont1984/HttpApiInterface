package ru.emamontov.HttpApiInterface.repositories.impl;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import ru.emamontov.HttpApiInterface.Application;
import ru.emamontov.HttpApiInterface.repositories.UsersRepository;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = {Application.class})
public class UserRepositoryImplTest extends Assert {

    @Autowired
    UsersRepository usersRepository;

    @Test
    public void testAddingUser() {

        String email = "test@test.local";
        String password = "password";

        String token1 = usersRepository.addUser(email, password);
        String token2 = usersRepository.addUser(email, password);

        assertNotNull(token1);
        assertNull(token2);
    }
}
