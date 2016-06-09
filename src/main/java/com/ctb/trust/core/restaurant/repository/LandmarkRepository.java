package com.ctb.trust.core.restaurant.repository;

import com.ctb.trust.core.restaurant.domain.Landmark;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Created by izeye on 16. 6. 9..
 */
public interface LandmarkRepository extends JpaRepository<Landmark, Long> {

	Landmark findByName(String name);
	
}
