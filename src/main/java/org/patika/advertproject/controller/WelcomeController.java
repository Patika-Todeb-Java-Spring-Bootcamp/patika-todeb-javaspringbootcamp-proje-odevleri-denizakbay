package org.patika.advertproject.controller;

import org.patika.advertproject.model.ResponseModel;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class WelcomeController {


    @GetMapping("/welcome")
    public ResponseEntity welcome(){
        String welcome ="Welcome to Advert Project";

        ResponseModel responseModel = new ResponseModel();
        responseModel.setWelcomeMessage(welcome);

        return ResponseEntity.ok(responseModel);
    }

}
