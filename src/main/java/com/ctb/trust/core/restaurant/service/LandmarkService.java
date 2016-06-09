package com.ctb.trust.core.restaurant.service;

import com.ctb.trust.core.restaurant.domain.Landmark;

/**
 * Created by izeye on 16. 6. 9..
 */
public interface LandmarkService {
	
	Landmark findByName(String name);
	
	void add(Landmark landmark);
	
}
