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
	
	@Test
	public void canRollSpare() throws Exception {
		rollSpare();	
		game.roll(3);	
		rollMany(17, 0);
		assertEquals(16, game.score());
	}
	
	@Test
	public void canRollStrike() throws Exception {
		rollStrike();
		game.roll(5);	
		game.roll(3);	
		rollMany(16, 0);
		assertEquals(26, game.score());
	}
	
	@Test
	public void perfectGame() throws Exception {
		rollMany(12, 10);
		
		assertEquals(300, game.score());
	}
	
	private void rollStrike() {
		game.roll(10);
	}
	
	private void rollMany(int n, int pins) {
		for(int i=0; i<n; i++) {
			game.roll(pins);
		}
	}
	
	private void rollSpare() {
		game.roll(5);
		game.roll(5);
	}
}
