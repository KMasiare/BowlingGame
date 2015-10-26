package org.capgemini.bowling.bowlinggame;

public class BowlingGameResultCalc implements BowlingGameResultCalculator {
	Round firstRound;
	Round currentRound;

	public BowlingGameResultCalc() {
		currentRound = new Round(1);
		firstRound = currentRound;
	}

	public void roll(int numberOfPins) {
		if (!currentRound.isFinished()) {
			currentRound.setNewRoll(numberOfPins);
		} else {
			Round round = new Round(currentRound.getNoOfRound() + 1);
			currentRound.setNextRound(round);
			currentRound = round;
			currentRound.setNewRoll(numberOfPins);
		}
	}

	public int score() {
		Round round = firstRound;
		int score = 0;
		while(round != null) {
			score += round.countScoreOfRound();
			round = round.getNextRound();
		}
		return score;
	}

	public boolean isFinished() {
		if(currentRound.getNoOfRound() == 10 && currentRound.isFinished())
			return true;
		return false;
	}

}
