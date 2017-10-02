package ru.emamontov.HttpApiInterface.controllers;

import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import ru.emamontov.HttpApiInterface.entities.*;
import ru.emamontov.HttpApiInterface.services.AuthentificationService;
import ru.emamontov.HttpApiInterface.services.ConfirmationService;
import ru.emamontov.HttpApiInterface.services.RegistrationService;

import java.io.IOException;

@RestController
public class Controller {

    @Autowired
    RegistrationService registrationService;
    @Autowired
    ConfirmationService confirmationService;
    @Autowired
    AuthentificationService authentificationService;


    @RequestMapping(value = "/register", method = RequestMethod.POST)
    public Entity register(@RequestBody String string){

        ObjectMapper mapper = new ObjectMapper();
        mapper.configure(JsonParser.Feature.ALLOW_UNQUOTED_FIELD_NAMES, true);

        RegistrationEntity registrationEntity = null;
        try {
            registrationEntity = mapper.readValue(string, RegistrationEntity.class);
        } catch (IOException e) {
            return new ErrorEntity(false, "Bad request", "1");
        }
        return registrationService.register(registrationEntity.getEmail(), registrationEntity.getPassword());
    }

    @RequestMapping(value = "/confirm", method = RequestMethod.POST)
    public Entity confirm(@RequestBody String string) {

        ObjectMapper mapper = new ObjectMapper();
        mapper.configure(JsonParser.Feature.ALLOW_UNQUOTED_FIELD_NAMES, true);

        TokenEntity tokenEntity = null;
        try {
            tokenEntity = mapper.readValue(string, TokenEntity.class);
        } catch (IOException e) {
            e.printStackTrace();
           return new ErrorEntity(false, "Bad request", "1");
        }
        return confirmationService.confirm(tokenEntity);
    }

    @RequestMapping(value = "/login", method = RequestMethod.POST)
    public Entity login(@RequestBody String string) {

        ObjectMapper mapper = new ObjectMapper();
        mapper.configure(JsonParser.Feature.ALLOW_UNQUOTED_FIELD_NAMES, true);

        RegistrationEntity registrationEntity = null;
        try {
            registrationEntity = mapper.readValue(string, RegistrationEntity.class);
        } catch (IOException e) {
            e.printStackTrace();
            return new ErrorEntity(false, "Bad request", "1");
        }
        return authentificationService.login(registrationEntity.getEmail(), registrationEntity.getPassword());
    }
}
