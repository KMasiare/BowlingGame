package org.capgemini.bowling.bowlinggame;

public class BowlingGame {
	

	public static void main(String[] args) {
		BowlingGameResultCalc bgrc = new BowlingGameResultCalc();
		int rolls[] = {10, 9, 1, 5, 5, 7, 2, 10, 10, 10, 9, 0, 8, 2, 9, 1, 10};
		
		for (int i = 0; i < rolls.length; i++) {
			bgrc.roll(rolls[i]);
		}
		System.out.println(bgrc.score());
		

	}

}
