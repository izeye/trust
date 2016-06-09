package com.ctb.trust.core.restaurant.service;

import com.ctb.trust.core.restaurant.domain.FoodType;

/**
 * Created by izeye on 16. 6. 9..
 */
public interface FoodTypeService {

	FoodType findByName(String name);

	void add(FoodType foodType);
	
}
