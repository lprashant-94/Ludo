package com.lprashant.ludo.track;


public class Position {
	public enum COLOR {
		GREEN,
		RED,
		BLUE,
		YELLOW
	}
	int x;
	int y;
	COLOR color;
	
	Position(COLOR color, int x, int y) {
		this.x =x ;
		this.y = y;
		this.color = color;
	}
	
	int getBoardX() {
		return x;
	}
	
	int getBoardY() {
		return y;
	}
	
	int getX() {
		return x;
	}
	
	int getY() {
		return y;
	}
}
