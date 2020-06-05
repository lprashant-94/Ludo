package com.lprashant.ludo.track;

import com.lprashant.ludo.Knight;

public class SingleKnightPlace extends LinkablePlace implements Place {

	Knight presentKnight;

	@Override
	public boolean canMove(Knight knight, Integer steps) {
		if (steps == 0) {
			return isAvailable(knight);
		}
		return nextPlace.canMove(knight, steps - 1);
	}

	private boolean isAvailable(Knight knight) {
		return presentKnight == null || !presentKnight.getPlayer().equals(knight.getPlayer());
	}

	@Override
	public void move(Knight knight, Integer steps) {
		if (steps == 0) {
			if (presentKnight != null) {
				System.out.println(knight + " killed " + presentKnight + " at " + this);
				presentKnight.setPlace(presentKnight.getPlayer().getInsideHomePlace());
			}
			presentKnight = knight;
			presentKnight.setPlace(this);
		} else {
			if (knight == presentKnight) {
				presentKnight = null;
			}
			this.nextPlace.move(knight, steps - 1);
		}

	}

}
