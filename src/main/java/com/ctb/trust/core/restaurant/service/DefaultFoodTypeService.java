/*
 * Copyright 2016 the original author or authors.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

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
