package services.categories.impl;

import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

import services.categories.CategoryScoring;

public class TwoPairsScoring extends CategoryScoring  {
	/**
	 * If there are two pairs of dice with the same number, the player scores the
	 * sum of these dice. For example, when placed on “two pairs”: 
	 * 1,1,2,3,3 scores 8 (1+1+3+3) 
	 * 1,1,2,3,4 scores 0 
	 * 1,1,2,2,2 scores 6 (1+1+2+2) 
	 * 3,3,3,3,1 scores 0
	 * 
	 */
	@Override
	public int calculateScore(List<Integer> listDice) {
		// Les dés présents au moins deux fois.
		Set<Integer> dicePresentTwice = listDice.stream()
						 .filter(d -> Collections.frequency(listDice, d) >= 2)
						 .collect(Collectors.toSet());
		// Si deux pairs de dés :
		if(dicePresentTwice.size() == 2) {
			int sumDicesPresentsTwice =  dicePresentTwice.stream().reduce(0, Integer::sum);
			return sumDicesPresentsTwice * 2;
		}
		return 0;
	}

}
