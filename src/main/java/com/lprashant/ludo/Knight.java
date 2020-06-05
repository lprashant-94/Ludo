package com.lprashant.ludo;

import com.google.common.base.MoreObjects;
import com.lprashant.ludo.track.Place;

public class Knight {

	Place curPlace;
	Player player;
	Integer index;

	public Knight(Integer index, Place insideHomePlace, Player player) {
		this.index = index;
		curPlace = insideHomePlace;
		this.player = player;
	}

	public Place getCurPlace() {
		return curPlace;
	}

	public void setPlace(Place nextPlace) {
		curPlace = nextPlace;
	}

	public boolean canMove(Integer steps) {
		return curPlace.canMove(this, steps);
	}

	public void move(Integer steps) {
		curPlace.move(this, steps);
	}

	public Player getPlayer() {
		return player;
	}

	@Override
	public String toString() {
		return MoreObjects.toStringHelper(getClass()).add("Player", player.getName()).add("Index", index)
				.add("CurrentPlace", curPlace).toString();
	}
}
