package com.lprashant.ludo.track;

import com.lprashant.ludo.Player;

public class HomePlace extends SafePlace implements Place {

	Player player;
	
	public HomePlace(Player player) {
		this.player = player;
	}

}
