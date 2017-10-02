package ru.emamontov.HttpApiInterface.controllers;

import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import ru.emamontov.HttpApiInterface.entities.AuthentificationEntity;
import ru.emamontov.HttpApiInterface.entities.Entity;
import ru.emamontov.HttpApiInterface.entities.RegistrationEntity;
import ru.emamontov.HttpApiInterface.services.RegistrationService;

import java.io.IOException;

@RestController
public class Controller {

    @Autowired
    RegistrationService registrationService;

    @RequestMapping(value = "/register", method = RequestMethod.POST)
    public Entity register(@RequestBody String string){

        ObjectMapper mapper = new ObjectMapper();
        mapper.configure(JsonParser.Feature.ALLOW_UNQUOTED_FIELD_NAMES, true);

        RegistrationEntity registrationEntity = null;
        try {
            registrationEntity = mapper.readValue(string, RegistrationEntity.class);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return registrationService.register(registrationEntity.getEmail(), registrationEntity.getPassword());
    }
}
