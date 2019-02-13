package com.example.demo;

import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.example.demo.beans.Equity;
import com.example.demo.beans.Instrument;
import com.example.demo.beans.InstrumentValidator;
import com.example.demo.beans.Registry;
import com.example.demo.beans.Swap;


@SpringBootApplication
@Configuration
public class SpringGenricsApplication {

	public static void main(String[] args) {
		
		ApplicationContext context = new  AnnotationConfigApplicationContext(SpringGenricsApplication.class);
		
		InstrumentValidator v =	context.getBean(InstrumentValidator.class);
		
		Instrument swap = new Swap();
		Instrument equity = new Equity();
		
		v.validate(swap);
		v.validate(equity);
	}
	
	
	
	
	@Bean
	public Registry registry() {
		return new Registry();
	}
	
	@Bean
	public InstrumentValidator instrumentValidator() {
		return new InstrumentValidator();
	}
}

