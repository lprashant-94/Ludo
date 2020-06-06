package com.lprashant.ludo.track;

import com.google.common.base.MoreObjects;
import com.lprashant.ludo.Knight;

public class SafePlace extends LinkablePlace implements Place {

	String name;
	Position position;

	SafePlace(String name, Position position) {
		this.name = name;
		this.position = position;
	}

	SafePlace() {
	}

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

	@Override
	public String toString() {
		return MoreObjects.toStringHelper(getClass()).add("NearPlayer", name).toString();
	}

	@Override
	public Position getPosition() {
		return position;
	}
}
