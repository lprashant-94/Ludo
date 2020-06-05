package com.lprashant.ludo;

import static org.junit.Assert.assertTrue;

import java.util.List;

import org.junit.Test;

import com.lprashant.ludo.track.EndPlace;
import com.lprashant.ludo.track.Track;

import junit.framework.TestCase;

/**
 * Unit test for simple App.
 */
public class AppTest extends TestCase {
	List<Player> players;
	Track track;

	@Override
	protected void setUp() {
		players = Player.getPlayersSet();
		track = new Track(players); // TODO Weird setup dependency between player and track
	}

	@Override
	protected void tearDown() throws Exception {
		players = null;
		track = null;
	}

	@Test
	public void testTrack() {
		System.out.println("Hello World!");

		Player player = players.get(0);

		Knight knight = player.getKnights().get(0);
		knight.move(6);

		while (knight.canMove(1)) {
			System.out.println(knight + " can move next? " + knight.canMove(1));
			knight.move(1);
		}
		assertTrue("Knight Reached to EndPlace", knight.getCurPlace() instanceof EndPlace);
		assertTrue(true);
	}

	@Test
	public void testRandomDice() {
		System.out.println("Hello World!");

		Player player = players.get(0);

		Dice d = new Dice();

		Knight knight = player.getKnights().get(0);
//		knight.move(6);

		int counter = 0;
		while (!(knight.getCurPlace() instanceof EndPlace)) {
			counter++;
			int steps = d.roll();
			System.out.println(knight + " can move next with steps " + steps + "? " + knight.canMove(steps));
			if (knight.canMove(steps)) {
				knight.move(steps);
			}
		}
		System.out.println("Steps required to reach at end " + counter);
		assertTrue("Knight Reached to EndPlace", knight.getCurPlace() instanceof EndPlace);
		assertTrue(true);
	}

}
