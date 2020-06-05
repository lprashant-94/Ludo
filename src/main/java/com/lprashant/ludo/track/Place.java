package com.lprashant.ludo.track;

import com.lprashant.ludo.Knight;

public interface Place {
	
	boolean canMove(Knight knight, Integer steps);

	void move(Knight knight, Integer steps);

}
