package services;
import enums.CategoriesEnum;
import factories.YatzyCategoriesFactory;
import models.Roll;
import services.categories.CategoryScoring;

public class YatzyService {
	private YatzyCategoriesFactory yatzyCategoriesFactory;
	
	public YatzyService() {
		this.yatzyCategoriesFactory = new YatzyCategoriesFactory();
	}

	
	
	public int calculateScore(Roll roll, CategoriesEnum categoryEnum) {
		try {
			CategoryScoring categoryScoring = this.yatzyCategoriesFactory.createCategoryScoring(categoryEnum);
			int score = categoryScoring.calculateScore(roll.dices());
			roll.scoreByCategory().put(categoryEnum, score);
			return score;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return 0;
	}


	

}
