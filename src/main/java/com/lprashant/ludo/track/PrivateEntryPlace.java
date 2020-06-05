package com.lprashant.ludo.track;

import com.google.common.base.MoreObjects;
import com.lprashant.ludo.Knight;
import com.lprashant.ludo.Player;

public class PrivateEntryPlace extends SingleKnightPlace implements Place {

	Player player;
	Place privateNext;

	public PrivateEntryPlace(Player player) {
		this.player = player;
	}

	@Override
	public boolean canMove(Knight knight, Integer steps) {
		if (steps > 0 && knight.getPlayer().equals(player)) {
			return privateNext.canMove(knight, steps - 1);
		}
		return super.canMove(knight, steps);
	}

	@Override
	public void move(Knight knight, Integer steps) {
		if (steps > 0 && knight.getPlayer().equals(player)) {
			privateNext.move(knight, steps - 1);
		} else {
			super.move(knight, steps);
		}
	}

	public void setPrivatePlace(Place privatePlace) {
		this.privateNext = privatePlace;
	}


	@Override
	public String toString() {
		return MoreObjects.toStringHelper(getClass()).add("Player", player.getName()).toString();
	}
}
