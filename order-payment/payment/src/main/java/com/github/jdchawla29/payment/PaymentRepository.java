package com.github.jdchawla29.payment;

import org.springframework.data.jpa.repository.JpaRepository;

public interface PaymentRepository
                extends JpaRepository<Payment, Integer> {
        Payment findByOrderId(int orderId);
}
