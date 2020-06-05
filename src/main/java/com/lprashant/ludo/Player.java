package com.lprashant.ludo;

import java.util.ArrayList;
import java.util.List;

import com.google.common.base.MoreObjects;
import com.google.common.collect.Lists;
import com.lprashant.ludo.track.HomePlace;
import com.lprashant.ludo.track.InsideHomePlace;
import com.lprashant.ludo.track.Place;

public class Player {

	List<Knight> knights;

	String name;
	InsideHomePlace insideHomePlace;
	HomePlace homePlace;

	// Que: is it good practice to pass this instance to all other classes,
	// Is there any way in oop to have reverse reference to object

	public Player(String name) {
		this.name = name;

		insideHomePlace = new InsideHomePlace(this);

		homePlace = new HomePlace(this);
		insideHomePlace.setNext(homePlace);

		knights = Lists.newArrayList(new Knight(1, insideHomePlace, this), new Knight(2, insideHomePlace, this),
				new Knight(3, insideHomePlace, this), new Knight(4, insideHomePlace, this)); // Pass initial place to
																								// knight
	}

	public static ArrayList<Player> getPlayersSet() {
		return Lists.newArrayList(new Player("RED"), new Player("GREEN"), new Player("YELLOW"), new Player("BLUE"));
	}

	public List<Knight> getKnights() {
		return knights;
	}

	public Place getInsideHomePlace() {
		return insideHomePlace;
	}

	public HomePlace getHomePlace() {
		return homePlace;
	}

	public String getName() {
		return name;
	}

	@Override
	public String toString() {
		return MoreObjects.toStringHelper(getClass()).add("Name", name).add("Knights", knights).toString();
	}
}
