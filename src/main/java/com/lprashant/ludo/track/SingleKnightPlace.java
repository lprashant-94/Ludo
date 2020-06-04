package com.lprashant.ludo.track;

import com.lprashant.ludo.Knight;

public class SingleKnightPlace extends LinkablePlace implements Place {

	Knight presentKnight;
	Place nextPlace;

	@Override
	public boolean canMove(Knight knight, Integer steps) {
		return ((steps == 0 && isAvailable(knight)) || canMove(knight, steps - 1));
	}

	private boolean isAvailable(Knight knight) {
		return presentKnight == null || presentKnight.getPlayer().equals(knight.getPlayer());
	}

	@Override
	public void move(Knight knight, Integer steps) {
		if (knight == presentKnight && steps > 0) {
			presentKnight = null;
		} else if (steps == 0) {
			if (presentKnight != null) {
				presentKnight.setPlace(presentKnight.getPlayer().getInsideHomePlace());
				System.out.println(knight + " killed " + presentKnight);
			}
			presentKnight = knight;
			presentKnight.setPlace(this);
		}

		if (steps != 0) {
			this.nextPlace.move(knight, steps - 1);
		}

	}

}
