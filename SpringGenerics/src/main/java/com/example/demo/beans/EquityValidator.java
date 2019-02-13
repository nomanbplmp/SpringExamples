package com.example.demo.beans;

import org.springframework.stereotype.Component;

@Component
@Register
@InstrumentMeta(Equity.class)
public class EquityValidator implements Validator{

	@Override
	public Boolean validate(Instrument s) {
		System.out.println("Inside Equity Validator");
		return null;
	}

}
