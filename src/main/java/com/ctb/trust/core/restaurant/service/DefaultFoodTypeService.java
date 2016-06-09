package com.ctb.trust.core.restaurant.service;

import com.ctb.trust.core.restaurant.domain.FoodType;
import com.ctb.trust.core.restaurant.repository.FoodTypeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by izeye on 16. 6. 9..
 */
@Service
public class DefaultFoodTypeService implements FoodTypeService {
	
	@Autowired
	private FoodTypeRepository foodTypeRepository;
	
	@Override
	public FoodType findByName(String name) {
		return this.foodTypeRepository.findByName(name);
	}

	@Override
	public void add(FoodType foodType) {
		this.foodTypeRepository.save(foodType);
	}
	
}
