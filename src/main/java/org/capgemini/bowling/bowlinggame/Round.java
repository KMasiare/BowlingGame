package org.capgemini.bowling.bowlinggame;

import java.util.ArrayList;
import java.util.List;

public class Round {
	private Round nextRound;
	private List<Integer> rolls = new ArrayList<Integer>();

	public Round(int noOfRound) {
		nextRound = null;
	}

	public int getOneRoll() {
		if (!rolls.isEmpty())
			return rolls.get(0);
		return 0;
	}

	public int getTwoRolls() {
		if (!rolls.isEmpty() && rolls.get(0) == 10) {
			return rolls.get(0) + nextRound.getOneRoll();
		}
		if (!rolls.isEmpty() && rolls.size() == 2) {
			return rolls.get(0) + rolls.get(1);
		}
		return 0;
	}

	public void setNewRoll(int numberOfPins) {
		
		rolls.add(numberOfPins);
	}

	public void setNextRound(Round round) {
		nextRound = round;
	}

	public boolean isFinished(int no) {
		if(!rolls.isEmpty() && rolls.get(0) == 10 && no < 9)
			return true;
		else if (no == 9){
			if (rolls.size() < 3)
				return false;
			return true;
		}
		return rolls.size() == 2;
	}

	private boolean isStrike() {// w pierwszym dziesiec
		return !rolls.isEmpty() && rolls.get(0) == 10;
	}

	private boolean isSpare() {
		return !rolls.isEmpty() && rolls.size() > 1 && rolls.get(0) + rolls.get(1) == 10;
	}

	private boolean isRoundWithoutBonus() {
		return !rolls.isEmpty() && rolls.size() > 1 && rolls.get(0) + rolls.get(1) < 10;
	}

	public int countScoreOfRound() {
		if (isRoundWithoutBonus()) {
			return rolls.get(0) + rolls.get(1);
		}
		if (isStrike()) {
			if (nextRound != null) {
				return rolls.get(0) + nextRound.getTwoRolls();
			}
			return rolls.get(0);
		}
		if (isSpare()) {
			if (rolls.size() == 3) {
				return rolls.get(0) + rolls.get(1) + rolls.get(2);
			}
			return rolls.get(0) + rolls.get(1) + nextRound.getOneRoll();
		}
		return 0;

	}

	public Round getNextRound() {
		return nextRound;
	}
}
