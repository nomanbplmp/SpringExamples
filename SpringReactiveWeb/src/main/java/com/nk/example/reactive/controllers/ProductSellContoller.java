package com.nk.example.reactive.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@CrossOrigin(origins = "http://localhost:8080")
@RestController
@RequestMapping("/products/")
class ProductSellContoller {

	
@Autowired
ProductSellService productSellService;


	
	@GetMapping("/sells")
	public Mono<List<Offer>> getAllSells(){
		
		return productSellService.getAllSells();
	}
	
	@GetMapping("/{id}")
	public Mono<Offer> getProductSellInfo(@PathVariable Integer id){
	return productSellService.findById(id);	
	}

	
	@GetMapping(value="/sells/notify", produces=MediaType.TEXT_EVENT_STREAM_VALUE)
	public Flux<Offer> streamProductSellInfo(){
	  return productSellService.streamProductSellInfo();
	}
	
	
}
