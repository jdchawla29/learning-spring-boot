package com.github.jdchawla29.gateway;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import reactor.core.publisher.Mono;

@RestController
public class Controller {
    
    @RequestMapping("/orderFallBack")
    public Mono<String> orderFallback(){
        return Mono.just("Service taking too long to respond. Try again later.");
    }
    @RequestMapping("/paymentFallBack")
    public Mono<String> paymentFallback(){
        return Mono.just("Service taking too long to respond. Try again later.");
    }
}
