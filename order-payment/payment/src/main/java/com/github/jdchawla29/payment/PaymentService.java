package com.github.jdchawla29.payment;

import java.util.Random;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PaymentService {
    
    @Autowired
    private PaymentRepository repository;

    public Payment doPayment(Payment payment){
        payment.setPaymentStatus(paymentProcessing());
        payment.setTransactionId(UUID.randomUUID().toString());
        return repository.save(payment);
    }

    public String paymentProcessing(){
        // Should be a 3rd party payment gateway api
        return new Random().nextBoolean()?"success":"fail";
    }

    public Payment findPaymentByOrderId(int orderId) {
        return repository.findByOrderId(orderId);
    }
}
