package com.lprashant.ludo.track;

import com.google.common.base.MoreObjects;
import com.lprashant.ludo.Knight;
import com.lprashant.ludo.Player;

public class EndPlace extends LinkablePlace implements Place {

	Player player;
	Position position;

	public EndPlace(Player player) {
		this.player = player;
		position = new Position(player.getColor(), 7, 8);
	}

	@Override
	public boolean canMove(Knight knight, Integer steps) {
		return steps == 0 && knight.getPlayer().equals(player);
	}

	@Override
	public void move(Knight knight, Integer steps) {
		if (canMove(knight, steps)) {
			knight.setPlace(this);
		}
	}

	@Override
	public String toString() {
		return MoreObjects.toStringHelper(getClass()).add("Player", player.getName()).toString();
	}

	@Override
	public Position getPosition() {
		return position;
	}

}
