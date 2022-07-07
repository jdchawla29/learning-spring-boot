package com.github.jdchawla29.order;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
@RefreshScope
public class OrderService {

        @Autowired
        private OrderRepository repository;

        @Autowired
        @Lazy
        RestTemplate template;

        public TransactionResponse saveOrder(TransactionRequest request) {
                Order order = request.getOrder();
                Payment payment = request.getPayment();
                payment.setOrderId(order.getId());
                payment.setAmount(order.getPrice() * order.getQty());

                // rest call
                Payment paymentResponse = template.postForObject(
                                "http://PAYMENT/payment/doPayment",
                                payment, Payment.class);

                String response = paymentResponse.getPaymentStatus()
                                .equals("success") ? "payment success" : "payment failed";

                repository.save(order);
                return new TransactionResponse(
                                order,
                                paymentResponse.getAmount(),
                                paymentResponse.getTransactionId(),
                                response);
        }
}
