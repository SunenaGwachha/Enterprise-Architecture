package edu.mum.cs.paypalservice.controllers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class PaypalController {


    @GetMapping("/paypal")
    public String getPaypal(){
        return "OK, Transaction Succesful On Paypal";
    }
}
