package com.lprashant.ludo.track;

import com.lprashant.ludo.Knight;
import com.lprashant.ludo.Player;

public class EndPlace extends LinkablePlace implements Place {

	Player player;

	public EndPlace(Player player) {
		this.player = player;
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

}
