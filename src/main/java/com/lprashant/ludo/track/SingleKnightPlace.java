package com.lprashant.ludo.track;

import com.google.common.base.MoreObjects;
import com.lprashant.ludo.Knight;

public class SingleKnightPlace extends LinkablePlace implements Place {

	Knight presentKnight;
	String name;
	Position position;

	SingleKnightPlace(String name, Position position) {
		this.name = name;
		this.position = position;
	}

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

	@Override
	public String toString() {
		return MoreObjects.toStringHelper(getClass()).add("NearPlayer", name).add("position", position).toString();
	}

	@Override
	public Position getPosition() {
		return position;
	}
}
