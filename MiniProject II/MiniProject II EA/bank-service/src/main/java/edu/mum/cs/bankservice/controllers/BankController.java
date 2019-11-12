package edu.mum.cs.bankservice.controllers;


import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class BankController {

    @GetMapping("/bank")
    public String getBank(){
        return "OK, Transaction Successfull on Bank!";
    }
}
