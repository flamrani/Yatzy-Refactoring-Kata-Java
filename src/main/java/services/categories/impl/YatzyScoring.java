package services.categories.impl;

import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

import services.categories.CategoryScoring;

public class YatzyScoring extends CategoryScoring  {
	/**
	 * If all dice have the same number, the player scores 50 points. For example:
	 * 1,1,1,1,1 placed on “yatzy” scores 50 1,1,1,2,1 placed on “yatzy” scores 0
	 */
	@Override
	public int calculateScore(List<Integer> listDice) {
		Set<Integer> distinctDice = listDice.stream().collect(Collectors.toSet());
		if (distinctDice.size() == 1) 
			return 50;
		return 0;
	}

}
