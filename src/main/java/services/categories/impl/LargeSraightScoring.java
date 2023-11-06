package services.categories.impl;

import java.util.List;

import services.categories.CategoryScoring;

public class LargeSraightScoring extends CategoryScoring {

	/**
	 * 
	 * When placed on “large straight”, if the dice read
	 * 
	 * 2,3,4,5,6,
	 * 
	 * the player scores 20 (the sum of all the dice).
	 */
	@Override
	public int calculateScore(List<Integer> listDice) {
		return this.straightScoring(listDice, 2, 6);
	}

}
