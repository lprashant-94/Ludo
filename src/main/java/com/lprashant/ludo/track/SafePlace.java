package com.lprashant.ludo.track;

import com.lprashant.ludo.Knight;

public class SafePlace extends LinkablePlace implements Place {

	@Override
	public boolean canMove(Knight knight, Integer steps) {
		return steps == 0 || nextPlace.canMove(knight, steps - 1);
	}

	@Override
	public void move(Knight knight, Integer steps) {
		if (steps == 0) {
			knight.setPlace(this);
		} else if (canMove(knight, steps)) {
			nextPlace.move(knight, steps - 1);
		}
	}

}
