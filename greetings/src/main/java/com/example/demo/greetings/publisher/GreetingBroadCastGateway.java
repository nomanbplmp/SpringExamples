package com.example.demo.greetings.publisher;

import org.springframework.integration.annotation.MessagingGateway;
import org.springframework.stereotype.Component;

@Component
@GreetingBroadCastChannel
public interface GreetingBroadCastGateway {
    public void broadCast(String greet) ;


}
