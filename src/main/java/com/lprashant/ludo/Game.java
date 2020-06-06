package com.lprashant.ludo;

import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

import com.google.common.collect.Lists;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.lprashant.ludo.track.EndPlace;
import com.lprashant.ludo.track.Track;

public class Game {

	List<Player> players;
	Track track;
	Dice dice;
	Scanner sc;

	public Game(Dice dice) {
		players = Player.getPlayersSet();
		track = new Track(players);

		this.dice = dice;
		sc = new Scanner(System.in);
	}

	public String getJsonState() {
		
		Gson gson = new GsonBuilder().registerTypeAdapter(Knight.class, new Knight.KnightSerializer()).create();
		
		List<Knight> knights = Lists.newArrayList();
		players.stream().forEach(p -> knights.addAll(p.getKnights()));

		return gson.toJson(knights);
	}
	
	
	public void start() {
		System.out.println("Game started");
		for (int i = 0; i < 100; i++) {
			Player curPlayer = players.get(i % 4);
			Integer steps = dice.roll();
			System.out.println(curPlayer + "Taking " + steps);
			List<Knight> allowedKnights = getAllowedKnights(curPlayer, steps);

			if (allowedKnights.size() > 0) {
				int choice = 0;
				while (choice < 1 || choice > allowedKnights.size()) {
					System.out.println("Select index of knight to move " + allowedKnights);
					choice = sc.nextInt();
				}

				allowedKnights.get(choice - 1).move(steps);
			} else if (curPlayer.getKnights().stream().allMatch(k -> k.getCurPlace() instanceof EndPlace)) {
				System.out.println(curPlayer + " is winner");
				return;
			}
		}
		System.out.println("Game ended");
	}

	public List<Knight> getAllowedKnights(Player curPlayer, Integer steps) {
		return curPlayer.getKnights().stream().filter(k -> k.canMove(steps))
				.collect(Collectors.toList());
	}

}
