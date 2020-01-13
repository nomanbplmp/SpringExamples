package com.example.demo.greetings.publisher;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class GreetingPublisher {

    @Autowired
    private GreetingBroadCastGateway greetingBroadCastGateway;

    public void broadcast(String greeting){
        greetingBroadCastGateway.broadCast(greeting);
    }


}
