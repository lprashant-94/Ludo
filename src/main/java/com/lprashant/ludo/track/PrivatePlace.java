package com.lprashant.ludo.track;

import com.lprashant.ludo.Knight;
import com.lprashant.ludo.Player;

public class PrivatePlace extends SingleKnightPlace implements Place {

	Player player;
	
	public PrivatePlace(Player player) {
		this.player = player;
	}

	@Override
	public boolean canMove(Knight knight, Integer steps) {
		return knight.getPlayer().equals(player) && super.canMove(knight, steps);
	}

	@Override
	public void move(Knight knight, Integer steps) {
		if(knight.getPlayer().equals(player) && canMove(knight, steps)) {
			super.move(knight, steps);
		}
		
	}

}
