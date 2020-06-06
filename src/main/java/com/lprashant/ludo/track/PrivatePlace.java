package com.lprashant.ludo.track;

import com.google.common.base.MoreObjects;
import com.lprashant.ludo.Knight;
import com.lprashant.ludo.Player;

public class PrivatePlace extends SingleKnightPlace implements Place {

	Player player;
	Integer index;

	public PrivatePlace(Player player, Integer index) {
		super(player.getName(), new Position(player.getColor(), index + 2, 8));
		this.player = player;
		this.index = index;
	}

	@Override
	public boolean canMove(Knight knight, Integer steps) {
		return knight.getPlayer().equals(player) && super.canMove(knight, steps);
	}

	@Override
	public void move(Knight knight, Integer steps) {
		if (knight.getPlayer().equals(player) && canMove(knight, steps)) {
			super.move(knight, steps);
		}

	}

	@Override
	public String toString() {
		return MoreObjects.toStringHelper(getClass()).add("Player", player.getName()).toString();
	}
}
