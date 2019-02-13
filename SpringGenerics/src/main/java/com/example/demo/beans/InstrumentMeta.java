package com.example.demo.beans;

import static java.lang.annotation.ElementType.TYPE;
import static java.lang.annotation.RetentionPolicy.RUNTIME;

import java.lang.annotation.Retention;
import java.lang.annotation.Target;

@Retention(RUNTIME)
@Target(TYPE)
public @interface InstrumentMeta {

	Class<? extends Instrument> value();
	String type() default "test"; 
	
}
