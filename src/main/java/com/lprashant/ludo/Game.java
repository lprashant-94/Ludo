package com.lprashant.ludo;

import java.util.List;

import com.google.common.collect.Lists;
import com.lprashant.ludo.track.Track;

public class Game {

	List<Player> players;
	Track track;
	Dice dice;

	public Game() {
		players = Lists.newArrayList(new Player("player - 1"), new Player("player - 2"), new Player("player - 3"),
				new Player("player - 4"));
		track = new Track(players);
		
		dice = new Dice();
		
		for ( int i=0;i< 100;i++) {
			Player curPlayer = players.get(i%4);
			Integer steps = dice.roll();
			for(Knight k: curPlayer.getKnights()) {
				if( k.canMove(steps)) {
					System.out.println("Do you want to move Knight " + k + "?");
					if(true) {
						k.move(steps);
						break;
					}
				}
			}
		}
	}

}
