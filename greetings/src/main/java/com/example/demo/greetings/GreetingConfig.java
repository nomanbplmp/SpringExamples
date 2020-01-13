package com.example.demo.greetings;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.integration.channel.PublishSubscribeChannel;
import org.springframework.messaging.MessageChannel;

@Configuration
public class GreetingConfig {

    @Bean()
    public MessageChannel broadCastChannel(){
        return new PublishSubscribeChannel();
    }


}
