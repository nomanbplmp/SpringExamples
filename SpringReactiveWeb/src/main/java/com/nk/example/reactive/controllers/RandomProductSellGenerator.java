package com.nk.example.reactive.controllers;

import java.util.Date;
import java.util.Random;

public class RandomProductSellGenerator {
private static String[] sellDescs = "loot,low discount,heavy discount".split(",");
	
	public static Offer generate() {
		return new Offer(sellDescs[new Random().nextInt(sellDescs.length)],new Date(),
				  new Date(),"prodct sku #" + (new Random().nextInt(1000)));
	}
	
}
