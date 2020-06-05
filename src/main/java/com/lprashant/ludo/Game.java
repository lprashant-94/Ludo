package com.lprashant.ludo;

import java.util.List;

import com.lprashant.ludo.track.Track;

public class Game {

	List<Player> players;
	Track track;
	Dice dice;

	public Game(Dice dice) {
		players = Player.getPlayersSet();
		track = new Track(players);

		this.dice = dice;
	}

	public void start() {
		System.out.println("Game started");
		for (int i = 0; i < 10000; i++) {
			Player curPlayer = players.get(i%4); // FIXME hardcoding
			Integer steps = dice.roll();
			System.out.println(curPlayer + "Taking " + steps);
			for (Knight k : curPlayer.getKnights()) {
				if (k.canMove(steps)) {
					System.out.println("Do you want to move Knight " + k + "?");
					if (true) {
						k.move(steps);
						break;
					}
				}
			}
		}
		System.out.println("Game ended");
	}

}
