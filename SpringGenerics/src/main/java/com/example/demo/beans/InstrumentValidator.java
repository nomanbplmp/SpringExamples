package com.example.demo.beans;

import org.springframework.beans.factory.annotation.Autowired;

public class InstrumentValidator implements Validator{

	@Autowired
	private Registry registry;
	
	@Override
	public Boolean validate(Instrument i) {
		registry.validator(i).validate(i);
		return null;
	}

	

	
	
}
