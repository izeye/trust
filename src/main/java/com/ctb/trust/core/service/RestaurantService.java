package com.ctb.trust.core.service;

import com.ctb.trust.core.domain.Restaurant;

import java.util.List;

/**
 * Created by izeye on 16. 6. 3..
 */
public interface RestaurantService {
	
	List<Restaurant> findAll();
	
	void add(Restaurant restaurant);
	
}
