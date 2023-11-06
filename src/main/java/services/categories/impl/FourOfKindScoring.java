package services.categories.impl;

import java.util.List;

import services.categories.CategoryScoring;

public class FourOfKindScoring extends CategoryScoring {
	/**
	 * If there are four dice with the same number, the player scores the sum of
	 * these dice. For example, when placed on “four of a kind”: 
	 * 2,2,2,2,5 scores 8 (2+2+2+2) 
	 * 2,2,2,5,5 scores 0 
	 * 2,2,2,2,2 scores 8 (2+2+2+2)
	 */
	@Override
	public int calculateScore(List<Integer> listDice) {
		return this.XNumberOfAKindCalculateScore(listDice, 4);
	}

}
