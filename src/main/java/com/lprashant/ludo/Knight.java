package com.lprashant.ludo;

import java.lang.reflect.Type;

import com.google.common.base.MoreObjects;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonSerializationContext;
import com.google.gson.JsonSerializer;
import com.lprashant.ludo.track.Place;

public class Knight {

	private Place curPlace;
	private Player player;
	private Integer index;

	public Knight(Integer index, Place insideHomePlace, Player player) {
		this.index = index;
		curPlace = insideHomePlace;
		this.player = player;
	}

	public Place getCurPlace() {
		return curPlace;
	}

	public void setPlace(Place nextPlace) {
		curPlace = nextPlace;
	}

	public boolean canMove(Integer steps) {
		return curPlace.canMove(this, steps);
	}

	public void move(Integer steps) {
		curPlace.move(this, steps);
	}

	public Player getPlayer() {
		return player;
	}

	@Override
	public String toString() {
		return MoreObjects.toStringHelper(getClass()).add("Player", player.getName()).add("Index", index)
				.add("CurrentPosition", curPlace.getPosition()).toString();
	}
	
	public static class KnightSerializer implements JsonSerializer<Knight>{

		@Override
		public JsonElement serialize(Knight src, Type typeOfSrc, JsonSerializationContext context) {
			JsonObject obj = new JsonObject();
			
			obj.addProperty("Index", src.index);
			obj.addProperty("Color", src.getPlayer().getColor().toString());
			obj.addProperty("X", src.getCurPlace().getPosition().getBoardX());
			obj.addProperty("Y", src.getCurPlace().getPosition().getBoardY());
			
			return obj;
		}
		
	}
	
}
