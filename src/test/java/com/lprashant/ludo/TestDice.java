package com.lprashant.ludo;

public class TestDice extends Dice {

	int[] arr = new int[] { 6, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1 };

	int index = 0;

	@Override
	Integer roll() {
		return arr[index++ % arr.length];
	}

}
