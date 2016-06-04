package com.ctb.trust.core.restaurant.repository;

import com.ctb.trust.core.restaurant.domain.Restaurant;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Created by izeye on 16. 6. 3..
 */
public interface RestaurantRepository extends JpaRepository<Restaurant, Long> {
}
