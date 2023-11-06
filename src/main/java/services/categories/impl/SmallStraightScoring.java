package services.categories.impl;

import java.util.List;

import services.categories.CategoryScoring;

public class SmallStraightScoring extends CategoryScoring {
	/**
	 * When placed on “small straight”, if the dice read
	 * 1,2,3,4,5,
	 * the player scores 15 (the sum of all the dice).
	 */
	@Override
	public int calculateScore(List<Integer> listDice) {
		return this.straightScoring(listDice, 1, 5);
	}

}
