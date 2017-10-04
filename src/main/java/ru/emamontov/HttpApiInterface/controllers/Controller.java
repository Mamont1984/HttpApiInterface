package ru.emamontov.HttpApiInterface.controllers;

import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ru.emamontov.HttpApiInterface.entities.*;
import ru.emamontov.HttpApiInterface.services.AuthenticationService;
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
    AuthenticationService authenticationService;


    @RequestMapping(value = "/register", method = RequestMethod.POST)
    public HttpEntity register(@RequestBody String string){

        ObjectMapper mapper = new ObjectMapper();
        mapper.configure(JsonParser.Feature.ALLOW_UNQUOTED_FIELD_NAMES, true);

        RegistrationEntity registrationEntity;
        try {
            registrationEntity = mapper.readValue(string, RegistrationEntity.class);
        } catch (IOException e) {
            return new ResponseEntity(new ErrorEntity(false, "Bad request", "1"), HttpStatus.BAD_REQUEST);
        }

        Entity entity = registrationService.register(registrationEntity.getEmail(), registrationEntity.getPassword());

        return new ResponseEntity(entity, entity.isSuccess() ? HttpStatus.OK : HttpStatus.BAD_REQUEST);
    }

    @RequestMapping(value = "/confirm", method = RequestMethod.POST)
    public HttpEntity confirm(@RequestBody String string) {

        ObjectMapper mapper = new ObjectMapper();
        mapper.configure(JsonParser.Feature.ALLOW_UNQUOTED_FIELD_NAMES, true);

        TokenEntity tokenEntity;
        try {
            tokenEntity = mapper.readValue(string, TokenEntity.class);
        } catch (IOException e) {
           return new ResponseEntity(new ErrorEntity(false, "Bad request", "1"), HttpStatus.BAD_REQUEST);
        }
        Entity entity = confirmationService.confirm(tokenEntity);

        return new ResponseEntity(entity, entity.isSuccess() ? HttpStatus.OK : HttpStatus.BAD_REQUEST);
    }

    @RequestMapping(value = "/login", method = RequestMethod.POST)
    public HttpEntity login(@RequestBody String string) {

        ObjectMapper mapper = new ObjectMapper();
        mapper.configure(JsonParser.Feature.ALLOW_UNQUOTED_FIELD_NAMES, true);

        RegistrationEntity registrationEntity;
        try {
            registrationEntity = mapper.readValue(string, RegistrationEntity.class);
        } catch (IOException  e) {
            return new ResponseEntity( new ErrorEntity(false, "Bad request", "1"), HttpStatus.BAD_REQUEST);
        }

        Entity entity = authenticationService.login(registrationEntity.getEmail(), registrationEntity.getPassword());

        return new ResponseEntity(entity, entity.isSuccess() ? HttpStatus.OK : HttpStatus.BAD_REQUEST);
    }
}
