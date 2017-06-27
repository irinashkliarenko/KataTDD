package bowling;

public class Game {

	private int[] rolls = new int[21];
	private int currentRoll;

	public int score() {
		int score = 0;
		int frameIndex = 0;
		for(int i=0; i<10; i++) {
			if(isStrike(frameIndex)) {
				score += 10 + strikeBonus(frameIndex);
				frameIndex++;
			} else if(isSpare(frameIndex)) {
				score += 10 + spareBonus(frameIndex);
				frameIndex+=2;
			} else {
				score +=sumOfAllInFrame(frameIndex);
				frameIndex+=2;
			}
		}
		return score;
	}

	public void roll(int pins) {
		rolls[currentRoll++] = pins;
	}
	
	private int strikeBonus(int frameIndex) {
		return rolls[frameIndex+1] + spareBonus(frameIndex);
	}
	
	private int spareBonus(int frameIndex) {
		return rolls[frameIndex+2];
	}
	
	private boolean isSpare(int frameIndex) {
		return sumOfAllInFrame(frameIndex) == 10;
	}
	
	private boolean isStrike(int frameIndex) {
		return rolls[frameIndex] == 10;
	}
	
	private int sumOfAllInFrame(int frameIndex) {
		return rolls[frameIndex] + rolls[frameIndex+1];
	}

}
