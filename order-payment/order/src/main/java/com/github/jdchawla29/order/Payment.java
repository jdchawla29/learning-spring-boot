package com.github.jdchawla29.order;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Payment {
    
    private int paymentId;
    private int orderId;
    private double amount;
    private String paymentStatus;
    private String transactionId;
}
