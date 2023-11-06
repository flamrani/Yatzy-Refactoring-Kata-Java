package models;

import java.util.Map;

import enums.CategoriesEnum;

import java.util.HashMap;
import java.util.List;

public record Roll (List<Integer> dices, Map<CategoriesEnum, Integer> scoreByCategory) {
	
	public Roll(List<Integer> dices) {
		this(dices, new HashMap<CategoriesEnum, Integer>());
		
	}

}
