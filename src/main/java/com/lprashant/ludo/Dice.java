package com.lprashant.ludo;

import java.util.Random;

public class Dice {
	Random r = new Random();
	
	Integer roll() {
		return r.nextInt(5) + 1;
	}
	
}
