package services.categories.impl;

import java.util.List;

import services.categories.CategoryScoring;

public class ThreeOfKindScoring extends CategoryScoring {
	/**
	 * 
	 * If there are three dice with the same number, the player scores the sum of
	 * these dice. For example, when placed on “three of a kind”: 
	 * 3,3,3,4,5 scores 9 (3+3+3) 
	 * 3,3,4,5,6 scores 0 
	 * 3,3,3,3,1 scores 9 (3+3+3)
	 */
	@Override
	public int calculateScore(List<Integer> listDice) {
		return this.XNumberOfAKindCalculateScore(listDice, 3);
	}

}
