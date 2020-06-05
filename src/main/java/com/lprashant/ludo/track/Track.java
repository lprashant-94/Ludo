package com.lprashant.ludo.track;

import java.util.List;
import java.util.Map;

import com.google.common.collect.Maps;
import com.lprashant.ludo.Player;

public class Track {
	Map<Player, Player> nextPlayerMap = Maps.newHashMap();

	public Track(List<Player> players) {

		nextPlayerMap.put(players.get(0), players.get(1));
		nextPlayerMap.put(players.get(1), players.get(2));
		nextPlayerMap.put(players.get(2), players.get(3));
		nextPlayerMap.put(players.get(3), players.get(0));

		for (Player player : players) {

			HomePlace homePlace = player.getHomePlace();

			LinkablePlace lastPlace = homePlace;
			for (int i = 0; i < 7; i++) {
				SingleKnightPlace place = new SingleKnightPlace();
				lastPlace.setNext(place);
				lastPlace = place;
			}

			SafePlace safePlace = new SafePlace();
			lastPlace.setNext(safePlace);
			lastPlace = safePlace;

			for (int i = 0; i < 2; i++) {
				SingleKnightPlace place = new SingleKnightPlace();
				lastPlace.setNext(place);
				lastPlace = place;
			}

			Player nextPlayer = nextPlayerMap.get(player);
			PrivateEntryPlace privateEntryPlace = new PrivateEntryPlace(nextPlayer);
			lastPlace.setNext(privateEntryPlace);

			PrivatePlace privatePlace = new PrivatePlace(nextPlayer);
			privateEntryPlace.setPrivatePlace(privatePlace);
			lastPlace = privatePlace;

			for (int i = 0; i < 4; i++) {
				PrivatePlace place = new PrivatePlace(nextPlayer);
				lastPlace.setNext(place);
				lastPlace = place;
			}

			EndPlace endPlace = new EndPlace(nextPlayer);
			lastPlace.setNext(endPlace);

			SingleKnightPlace place = new SingleKnightPlace();
			privateEntryPlace.setNext(place);
			place.setNext(nextPlayer.getHomePlace());
		}
	}

}
