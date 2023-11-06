package factories;

import enums.CategoriesEnum;
import exceptions.CategoryException;
import services.categories.CategoryScoring;
import services.categories.impl.ChanceScoring;
import services.categories.impl.FivesScoring;
import services.categories.impl.FourOfKindScoring;
import services.categories.impl.FoursScoring;
import services.categories.impl.FullHouseScoring;
import services.categories.impl.LargeSraightScoring;
import services.categories.impl.OnesScoring;
import services.categories.impl.PairScoring;
import services.categories.impl.SixesScoring;
import services.categories.impl.SmallStraightScoring;
import services.categories.impl.ThreeOfKindScoring;
import services.categories.impl.ThreesScoring;
import services.categories.impl.TwoPairsScoring;
import services.categories.impl.TwosScoring;
import services.categories.impl.YatzyScoring;


public class YatzyCategoriesFactory {
	
	public CategoryScoring createCategoryScoring(CategoriesEnum category) throws Exception {
		
		switch (category) {
		case CHANCE:
			return new ChanceScoring();
		case YATZY:
			return new YatzyScoring();
		case ONES:
			return new OnesScoring();
		case TWOS:
			return new TwosScoring();
		case THREES:
			return new ThreesScoring();
		case FOURS:
			return new FoursScoring();
		case FIVES:
			return new FivesScoring();
		case SIXES:
			return new SixesScoring();
		case PAIR:
			return new PairScoring();
		case TWO_PAIRS:
			return new TwoPairsScoring();
		case THREE_OF_A_KIND:
			return new ThreeOfKindScoring();
		case FOUR_OF_A_KIND:
			return new FourOfKindScoring();
		case SMALL_STRAIGHT:
			return new SmallStraightScoring();
		case LARGE_STRAIGHT:
			return new LargeSraightScoring();
		case FULL_HOUSE:
			return new FullHouseScoring();
		default:
			throw new CategoryException("NOT_IMPLEMENTED", "The provided category is not implemented");
		}
		
	}

}
