package edu.mum.cs.paymentservice.respository;


import edu.mum.cs.paymentservice.model.Payment;
import org.springframework.boot.CommandLineRunner;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PaymentRepository extends JpaRepository<Payment, Long> {

}
