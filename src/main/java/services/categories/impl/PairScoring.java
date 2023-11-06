package services.categories.impl;

import java.util.Collections;
import java.util.List;
import java.util.Optional;

import services.categories.CategoryScoring;

public class PairScoring extends CategoryScoring  {
	/**
	 * The player scores the sum of the two highest matching dice. For example, when
	 * placed on “pair”:
	 * 
	 * 1,2,3,4,5 scores 0 
	 * 3,3,3,4,4 scores 8 (4+4) 
	 * 1,1,6,2,6 scores 12 (6+6)
	 * 3,3,3,4,1 scores 6 (3+3) 
	 * 3,3,3,3,1 scores 6 (3+3)
	 */
	@Override
	public int calculateScore(List<Integer> listDice) {
		// Le dé le plus élevé présent au moins deux fois.
		Optional<Integer> highestDicePresentTwice = listDice.stream()
				 		  .distinct()
						 .filter(d -> Collections.frequency(listDice, d) >= 2)
						 .sorted(Collections.reverseOrder())
						 .findFirst();
		
		if(highestDicePresentTwice.isPresent()) {
			return highestDicePresentTwice.get() * 2;
		}
		
		return 0;
	}

}
