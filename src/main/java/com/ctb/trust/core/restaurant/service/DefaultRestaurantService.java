package com.ctb.trust.core.restaurant.service;

import com.ctb.trust.core.restaurant.domain.Restaurant;
import com.ctb.trust.core.restaurant.repository.RestaurantRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by izeye on 16. 6. 3..
 */
@Service
public class DefaultRestaurantService implements RestaurantService {
	
	@Autowired
	private RestaurantRepository restaurantRepository;
	
	@Override
	public List<Restaurant> findAll() {
		return this.restaurantRepository.findAll();
	}

	@Override
	public Restaurant findById(long id) {
		return this.restaurantRepository.findOne(id);
	}

	@Override
	public void save(Restaurant restaurant) {
		this.restaurantRepository.save(restaurant);
	}
	
}
