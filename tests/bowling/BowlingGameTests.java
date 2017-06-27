package bowling;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class BowlingGameTests {
	
	Game game = new Game();
	
	@Test
	public void gutterGame() throws Exception {
		rollMany(20, 0);
		assertEquals(0, game.score());
	}

	@Test
	public void allOnes() throws Exception {
		rollMany(20, 1);
		assertEquals(20, game.score());
	}
	
	private void rollMany(int n, int pins) {
		for(int i=0; i<n; i++) {
			game.roll(pins);
		}
	}
}
