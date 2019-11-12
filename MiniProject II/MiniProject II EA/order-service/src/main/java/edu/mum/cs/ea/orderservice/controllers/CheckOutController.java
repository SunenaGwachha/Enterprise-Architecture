package edu.mum.cs.ea.orderservice.controllers;


import edu.mum.cs.ea.orderservice.model.Payment;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
@RequestMapping("/checkout")
public class CheckOutController {

//    @Autowired
//    private RestTemplate restTemplate;
//
//    @Bean
//    public RestTemplate restTemplate(RestTemplateBuilder restTemplateBuilder){
//        return restTemplateBuilder.build();
//    }
//


//    @GetMapping("/")
//    public String getPaymentOption(){
//        return restTemplate.getForObject("http://localhost:8091/payments/all", String.class);
//    }


}
