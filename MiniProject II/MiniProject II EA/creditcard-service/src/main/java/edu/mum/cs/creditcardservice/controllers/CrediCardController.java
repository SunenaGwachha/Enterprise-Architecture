package edu.mum.cs.creditcardservice.controllers;


import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CrediCardController {


    @GetMapping("/creditcard")
    public String getCreditCard(){
        return "OK, Transaction Succesful on Credit Card!";
    }


}
