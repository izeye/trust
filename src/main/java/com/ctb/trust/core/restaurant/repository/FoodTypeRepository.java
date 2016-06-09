package com.ctb.trust.core.restaurant.repository;

import com.ctb.trust.core.restaurant.domain.FoodType;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Created by izeye on 16. 6. 9..
 */
public interface FoodTypeRepository extends JpaRepository<FoodType, Long> {

	FoodType findByName(String name);
	
}
