package com.example.demo.beans;

import org.springframework.stereotype.Component;

@Component
@InstrumentMeta(Swap.class)
public class SwapValidator implements Validator{

	@Override
	public Boolean validate(Instrument s) {
		System.out.println("Inside Swap Validator");
		return null;
	}

}
