package com.lprashant.ludo.track;

import com.google.common.base.MoreObjects;
import com.lprashant.ludo.Player;

public class HomePlace extends SafePlace implements Place {

	Player player;

	public HomePlace(Player player) {
		super(player.getName(), new Position(player.getColor(), 2, 7));
		this.player = player;
	}

	@Override
	public String toString() {
		return MoreObjects.toStringHelper(getClass()).add("Player", player.getName()).toString();
	}
}
