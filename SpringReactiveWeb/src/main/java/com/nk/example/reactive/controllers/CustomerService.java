package com.nk.example.reactive.controllers;

import org.springframework.stereotype.Service;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Service
class CustomerService {

		
    public Mono<Customer> byId(String id) {
          return Mono.just(new Customer("noman",id));
    }

    public Flux<Customer> all() {
    	return Flux.range(1,10).map((i)->new Customer(i.toString(),"noman"));
    }
}

@Data
@NoArgsConstructor
@RequiredArgsConstructor
@AllArgsConstructor
class Customer {

	private String id;
    @NonNull
    private String name;
}
