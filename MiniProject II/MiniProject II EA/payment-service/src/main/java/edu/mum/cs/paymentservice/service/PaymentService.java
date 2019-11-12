package edu.mum.cs.paymentservice.service;


import edu.mum.cs.paymentservice.model.Payment;
import edu.mum.cs.paymentservice.respository.PaymentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PaymentService implements CommandLineRunner {

    @Autowired
    private PaymentRepository paymentRepository;

    public List<Payment> getPaymentOptions(){
        return paymentRepository.findAll();
    }

    @Override
    public void run(String... args) throws Exception {
        paymentRepository.save(new Payment("BANK"));
        paymentRepository.save(new Payment("CREDITCARD"));
        paymentRepository.save(new Payment("PAYPAL"));
    }
}
