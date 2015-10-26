package org.capgemini.bowling.bowlinggame;

import static org.junit.Assert.*;

import org.junit.Test;

public class BowlingGameResultCalcTest {

	@Test
	public void shouldReturnSixWhenScoreIsSix() {
		// given
		BowlingGameResultCalc bgrc = new BowlingGameResultCalc();
		//when
		bgrc.roll(6);
		//then
//		assertEquals(Integer.valueOf(6), bgrc.score());
	}

	@Test
	public void shouldBeFourteenPointsIfScoredSevenAndSeven() {
		// given
		BowlingGameResultCalc bgrc = new BowlingGameResultCalc();
		// when
		bgrc.roll(4);
		bgrc.roll(3);
		bgrc.roll(7);
		bgrc.roll(0);
		// then
//		assertEquals(Integer.valueOf(14), bgrc.score());
	}
	
	@Test
	public void shouldBeThirtyFiveIfWasTenNineOneAndFive() {
		// given
		BowlingGameResultCalc bgrc = new BowlingGameResultCalc();
		// when
		bgrc.roll(10);
		bgrc.roll(9);
		bgrc.roll(1);
		bgrc.roll(5);
		// then
//		assertEquals(Integer.valueOf(35), bgrc.score());
	}
}
