package org.capgemini.bowling.bowlinggame;

public class BowlingGameResultCalc implements BowlingGameResultCalculator {
	Round firstRound;
	Round currentRound;
	int noOfFinishedRounds = 0;

	public BowlingGameResultCalc() {
		currentRound = new Round(1);
		firstRound = currentRound;
	}

	public void roll(int numberOfPins) {
		if (!currentRound.isFinished(noOfFinishedRounds)) {
			currentRound.setNewRoll(numberOfPins);
		} else {
			Round round = new Round(noOfFinishedRounds + 1);
			currentRound.setNextRound(round);
			currentRound = round;
			currentRound.setNewRoll(numberOfPins);
			noOfFinishedRounds ++;
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
		if(noOfFinishedRounds == 10 && currentRound.isFinished(noOfFinishedRounds))
			return true;
		return false;
	}

}
