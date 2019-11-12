package edu.mum.cs.paymentservice.controllers;


import edu.mum.cs.paymentservice.model.Payment;
import edu.mum.cs.paymentservice.respository.PaymentRepository;
import edu.mum.cs.paymentservice.service.PaymentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.context.annotation.Bean;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.util.List;

@RestController
@RequestMapping("/payments")
public class GetPayments {

    private String bankResponse;
    private String creditResponse;
    private String paypalResponse;

    @Value("${CREDITCARD_SERVICE:#{null}}")
    private String creditCardService;

    @Value("${BANK_SERVICE:#{null}}")
    private String bankService;

    @Value("${PAYPAL_SERVICE:#{null}}")
    private String paypalService;

    @Autowired
    private PaymentService paymentService;

    @Autowired
    private RestTemplate restTemplate;

    @Bean
    public RestTemplate restTemplate(RestTemplateBuilder restTemplateBuilder){
        return restTemplateBuilder.build();
    }

    @GetMapping("/all")
    public List<Payment> getPaymentOptions(){

        return paymentService.getPaymentOptions();
    }

    @GetMapping("/creditcard")
    public String getCreditCard(){
        //return restTemplate.getForObject("http://localhost:8093/creditcard", String.class);

        StringBuffer sb = new StringBuffer();

        final String uri = String.format("http://%s/creditcard", creditCardService);

        String result="UNABLE TO CALL";

        try{
//            RestTemplate restTemplate = new RestTemplate();
            result = restTemplate.getForObject(uri, String.class);
        }
        catch (Exception e){
            e.printStackTrace();
        }
        finally {
            sb.append(result);
            return sb.toString();
        }

    }

    @GetMapping("/bank")
    public String getBank(){

        StringBuffer sb = new StringBuffer();

        final String uri = String.format("http://%s/bank", bankService);

        String result="UNABLE TO CALL";

        try{
//            RestTemplate restTemplate = new RestTemplate();
            result = restTemplate.getForObject(uri, String.class);
        }
        catch (Exception e){
            e.printStackTrace();
        }
        finally {
            sb.append(result);
            return sb.toString();
        }

        //return restTemplate.getForObject("http://localhost:8094/bank", String.class);
    }

    @GetMapping("/paypal")
    public String getPaypal(){

        StringBuffer sb = new StringBuffer();

        final String uri = String.format("http://%s/paypal", paypalService);

        String result="UNABLE TO CALL";

        try{
//            RestTemplate restTemplate = new RestTemplate();
            result = restTemplate.getForObject(uri, String.class);
        }
        catch (Exception e){
            e.printStackTrace();
        }
        finally {
            sb.append(result);
            return sb.toString();
        }

        //return restTemplate.getForObject("http://localhost:8092/paypal", String.class);
    }



}
