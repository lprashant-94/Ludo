package com.lprashant.ludo.track;

import com.lprashant.ludo.Knight;
import com.lprashant.ludo.Player;

public class InsideHomePlace extends LinkablePlace implements Place {

	Player player;
	public InsideHomePlace(Player player) {
		this.player = player;
	}

	@Override
	public boolean canMove(Knight knight, Integer steps) {
		return steps == 6;
	}

	@Override
	public void move(Knight knight, Integer steps) {
		if (canMove(knight, steps)) {
			this.nextPlace.move(knight, 0); // 6 steps will be consumed inside home only.
		}
	}

}
