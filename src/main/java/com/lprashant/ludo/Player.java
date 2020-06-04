package com.lprashant.ludo;

import java.util.List;

import com.google.common.collect.Lists;
import com.lprashant.ludo.track.InsideHomePlace;
import com.lprashant.ludo.track.Place;

public class Player {

	List<Knight> knights;

	public List<Knight> getKnights() {
		return knights;
	}

	String name;
	Place insideHomePlace;

	// Que: is it good practice to pass this instance to all other classes, 
	// Is there any way in oop to have reverse reference to object
	
	public Player(String name) {
		this.name = name;
		insideHomePlace = new InsideHomePlace(this);
		knights = Lists.newArrayList(new Knight(insideHomePlace, this), new Knight(insideHomePlace, this),
				new Knight(insideHomePlace, this), new Knight(insideHomePlace, this)); // Pass initial place to knight
	}

	public Place getInsideHomePlace() {
		return insideHomePlace;
	}

}
