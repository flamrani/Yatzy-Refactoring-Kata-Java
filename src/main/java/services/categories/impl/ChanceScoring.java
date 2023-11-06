package services.categories.impl;

import java.util.List;

import services.categories.CategoryScoring;

public class ChanceScoring extends CategoryScoring {

	/**
	 * The player scores the sum of all dice, no matter what they read. For example:
	 * 1,1,3,3,6 placed on “chance” scores 14 (1+1+3+3+6)
	 * 4,5,5,6,1 placed on “chance” scores 21 (4+5+5+6+1)
	 */
	@Override
	public int calculateScore(List<Integer> listDice) {
		Integer sum = listDice.stream().reduce(0, Integer::sum);
		return sum;
	}

}
