package com.lprashant.ludo;

import com.lprashant.ludo.track.Place;

public class Knight {

	Place curPlace;
	Player player;

	public Knight(Place insideHomePlace, Player player) {
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
		// TODO Auto-generated method stub
		return player;
	}
}
