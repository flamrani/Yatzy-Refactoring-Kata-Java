package enums;
public enum CategoriesEnum {
	
	CHANCE("CHANCE"),
	YATZY("YATZY"),
	ONES("ONES"),
	TWOS("TWOS"),
	THREES("THREES"),
	FOURS("FOURS"),
	FIVES("FIVES"),
	SIXES("SIXES"),
	PAIR("PAIR"),
	TWO_PAIRS("TWO_PAIRS"),
	THREE_OF_A_KIND("THREE_OF_A_KIND"),
	FOUR_OF_A_KIND("FOUR_OF_A_KIND"),
	SMALL_STRAIGHT("SMALL_STRAIGHT"),
	LARGE_STRAIGHT("LARGE_STRAIGHT"),
	FULL_HOUSE("FULL_HOUSE");

    private final String category;

	CategoriesEnum(String category) {
		this.category = category;
	}

	public String getCategory() {
		return category;
	}
	
}
