package com.ctb.trust.core.repository;

import com.ctb.trust.core.restaurant.domain.Restaurant;
import com.ctb.trust.core.restaurant.repository.RestaurantRepository;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.junit4.SpringRunner;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * Created by izeye on 16. 6. 3..
 */
@RunWith(SpringRunner.class)
@DataJpaTest
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
public class RestaurantRepositoryTests {
	
	@Autowired
	RestaurantRepository restaurantRepository;
	
	@Test
	public void test() {
		Restaurant restaurant = new Restaurant();
		this.restaurantRepository.save(restaurant);

		Restaurant found = this.restaurantRepository.findOne(restaurant.getId());
		assertThat(found).isEqualTo(restaurant);
	}
	
}
