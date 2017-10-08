package com.nk.example.reactive.controllers;

import java.time.Duration;
import java.util.Date;
import java.util.List;
import java.util.function.Supplier;
import java.util.stream.Stream;

import org.springframework.stereotype.Service;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Service
class ProductSellService {

	public Mono<List<Offer>> getAllSells() { 
          return Flux.range(1,100).map((i)->new Offer("",new Date(),new Date(),i.toString())).collectList();
         }

	public Mono<Offer> findById(Integer id) {
		 Offer productSellInfo = new Offer("",new Date(),new Date(),id.toString());
		  return   Mono.just(productSellInfo);
		
	}
	
	public Flux<Offer> streamProductSellInfo(){
		 Flux<Long> interval =	Flux.interval(Duration.ofSeconds(1));
		 Flux<Offer> sells = Flux.fromStream(Stream.generate(new Supplier<Offer>() {

			@Override
			public Offer get() {
				return RandomProductSellGenerator.generate();
			}
		}));
		 
		  return Flux.zip(interval, sells).map((t)->t.getT2());
		}
	
}



@Data
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
class Offer {
 
	private String description;
    private Date fromdate;
    private Date todate;
    private String sku;
        
}

