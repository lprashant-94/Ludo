package com.lprashant.ludo.track;

import com.google.common.base.MoreObjects;

public class Position {
	public enum COLOR {
		GREEN, RED, BLUE, YELLOW
	}

	int x;
	int y;
	COLOR color;

	int boardX, boardY;

	Position(COLOR color, int x, int y) {
		this.x = x - 8; // Set (8,8) to be center (0,0) so that everything can rotate around it.
		this.y = y - 8;
		this.color = color;
		calculate();
	}

	private void calculate() {
		switch (color) {
		case GREEN:
			boardX = x;
			boardY = y;
			break;
		case RED:
			boardX = -y;
			boardY = -x;
			break;
		case BLUE:
			boardX = x;
			boardY = -y;
			break;
		case YELLOW:
			boardX = -y;
			boardY = x;
			break;
		}
	}

	public int getBoardX() {
		return boardX + 8;
	}

	public int getBoardY() {
		return boardY + 8;
	}

	int getX() {
		return x;
	}

	int getY() {
		return y;
	}

	@Override
	public String toString() {
		return MoreObjects.toStringHelper(getClass()).add("boardX", getBoardX()).add("boardY", getBoardY()).toString();
	}

}
