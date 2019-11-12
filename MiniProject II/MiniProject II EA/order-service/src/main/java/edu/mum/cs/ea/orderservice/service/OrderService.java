package edu.mum.cs.ea.orderservice.service;


import edu.mum.cs.ea.orderservice.model.Orders;
import edu.mum.cs.ea.orderservice.respository.OrderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Service;

@Service
public class OrderService {

    @Autowired
    OrderRepository orderRepository;

    public Orders saveOrder(Orders order){
        return  orderRepository.save(order);
    }

}
