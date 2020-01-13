package com.example.demo.greetings.publisher;

import org.springframework.integration.annotation.MessagingGateway;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

@Retention(RetentionPolicy.RUNTIME)
@MessagingGateway(defaultRequestChannel = "broadCastChannel")
public @interface GreetingBroadCastChannel {
}
