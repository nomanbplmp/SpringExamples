package com.example.demo.greetings.receiver;

import org.springframework.context.annotation.Bean;
import org.springframework.integration.annotation.ServiceActivator;
import org.springframework.integration.dsl.IntegrationFlow;
import org.springframework.integration.dsl.IntegrationFlows;
import org.springframework.integration.dsl.StandardIntegrationFlow;
import org.springframework.stereotype.Component;

@Component
public class handlers {


    @ServiceActivator(inputChannel = "broadCastChannel")
    public void consumeGreet(String greeting){
        System.out.println("********** "+ greeting);
    }

    @Bean
    public IntegrationFlow consumerGreetDsl(){
        return IntegrationFlows.from("broadCastChannel")
                .log()
                .transform((s) -> "hello")
                .handle(System.out::println)
                .get();
    }
}
