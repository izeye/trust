package com.ctb.trust.core.restaurant.service;

import com.ctb.trust.core.restaurant.domain.Landmark;
import com.ctb.trust.core.restaurant.repository.LandmarkRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by izeye on 16. 6. 9..
 */
@Service
public class DefaultLandmarkService implements LandmarkService {
	
	@Autowired
	LandmarkRepository landmarkRepository;
	
	@Override
	public Landmark findByName(String name) {
		return this.landmarkRepository.findByName(name);
	}

	@Override
	public void add(Landmark landmark) {
		this.landmarkRepository.save(landmark);
	}
	
}
