package com.ctb.trust.core.restaurant.service;

import com.ctb.trust.core.restaurant.domain.Restaurant;

import java.util.List;

/**
 * Created by izeye on 16. 6. 3..
 */
public interface RestaurantService {
	
	List<Restaurant> findAll();
	
	Restaurant findById(long id);
	
	void save(Restaurant restaurant);
	
}
