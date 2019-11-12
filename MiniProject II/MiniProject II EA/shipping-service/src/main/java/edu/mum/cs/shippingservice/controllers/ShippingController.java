package edu.mum.cs.shippingservice.controllers;


import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ShippingController {

    @GetMapping("/ship")
    public String shipProduct(){
        return "Your Product has been Shipped!";
    }
}
