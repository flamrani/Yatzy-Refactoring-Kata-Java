package services.categories.impl;

import java.util.List;

import services.categories.CategoryScoring;

public class FivesScoring extends CategoryScoring {
	/**
	 * The player scores the sum of the dice that reads one, two, three, four, five
	 * or six, respectively. For example: 
	 * 1,1,2,4,4 placed on “fours” scores 8 (4+4)
	 * 2,3,2,5,1 placed on “twos” scores 4 (2+2) 
	 * 3,3,3,4,5 placed on “ones” scores 0
	 */
	@Override
	public int calculateScore(List<Integer> listDice) {
		return this.OnesToSixesCalculateScore(listDice, 5);
	}

}
