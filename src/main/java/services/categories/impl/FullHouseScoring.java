package services.categories.impl;

import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Optional;
import java.util.function.Function;
import java.util.stream.Collectors;

import services.categories.CategoryScoring;

public class FullHouseScoring extends CategoryScoring {

	
	/**
	 * 
	 * If the dice are two of a kind and three of a kind, the player scores the sum
	 * of all the dice. For example, when placed on “full house”:
	 *  1,1,2,2,2 scores 8 (1+1+2+2+2) 
	 *  2,2,3,3,4 scores 0 
	 *  4,4,4,4,4 scores 0
	 */
	@Override
	public int calculateScore(List<Integer> listDice) {
		Map<Integer, Long> mapDiceCounting = listDice.stream().collect(Collectors.groupingBy(Function.identity(), Collectors.counting()));
		Optional<Entry<Integer, Long>>  twoOfAKindEntry = mapDiceCounting.entrySet().stream().filter(entry -> entry.getValue() == 2).findAny();
		Optional<Entry<Integer, Long>>  threeOfAKindEntry = mapDiceCounting.entrySet().stream().filter(entry -> entry.getValue() == 3).findAny();
		
		if(twoOfAKindEntry.isPresent() && threeOfAKindEntry.isPresent()) {
			int twoOfAKindDice = twoOfAKindEntry.get().getKey();
			int threeOfAKindDice = threeOfAKindEntry.get().getKey();
			 return (twoOfAKindDice * 2) + (threeOfAKindDice * 3);
		}
	    return 0;

	}

}
