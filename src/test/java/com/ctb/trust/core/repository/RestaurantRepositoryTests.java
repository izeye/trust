package com.ctb.trust.core.repository;

import com.ctb.trust.core.restaurant.domain.Landmark;
import com.ctb.trust.core.restaurant.domain.Restaurant;
import com.ctb.trust.core.restaurant.repository.RestaurantRepository;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.HashSet;
import java.util.Set;

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
		restaurant.setName("화로양");
		
		Set<Landmark> landmarks = new HashSet<>();
		Landmark landmark1 = new Landmark();
		landmark1.setName("정자역");
		Landmark landmark2 = new Landmark();
		landmark2.setName("그린팩토리");
		landmarks.add(landmark1);
		landmarks.add(landmark2);
		restaurant.setLandmarks(landmarks);
		
		this.restaurantRepository.save(restaurant);

		Restaurant found = this.restaurantRepository.findOne(restaurant.getId());
		System.out.println(found);
		assertThat(found).isEqualTo(restaurant);
	}
	
}
