package services.categories;

import java.util.Collections;
import java.util.List;
import java.util.Optional;

public abstract class CategoryScoring {
	
	public abstract int calculateScore(List<Integer> listDice);
	
	public int OnesToSixesCalculateScore(List<Integer> listDice, int numberToCount) {
		int sum = 0;
		sum = listDice.stream().filter(d -> d == Integer.valueOf(numberToCount)).reduce(0, Integer::sum);
		
		return sum;
	}
	
	public int XNumberOfAKindCalculateScore(List<Integer> listDice, int numberOfTimes) {
		// Le premier dé présent au moins numberOfTimes fois.
		Optional<Integer> dicePresentXTimes = listDice.stream()
				 .filter(d -> Collections.frequency(listDice, d) >= numberOfTimes)
				 .findFirst();
		if(dicePresentXTimes.isPresent()) {
			return dicePresentXTimes.get() * numberOfTimes;
		}
		return 0;
	}
	
	
	public int straightScoring(List<Integer> listDice, int lowerBound, int upperBound) {
		int sum = 0;
		// Number of dice in range [lowerBound,upperBound] and present only once
		long count = listDice.stream()
				 .filter(d -> Collections.frequency(listDice, d) == 1 && d >= lowerBound && d <= upperBound)
				 .count();
		if ( count == 5 ) {
			sum = listDice.stream().reduce(0, Integer::sum);
		}
		return sum;
	}

}
