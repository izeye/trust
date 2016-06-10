package com.ctb.trust.core.repository;

import com.ctb.trust.core.restaurant.domain.FoodType;
import com.ctb.trust.core.restaurant.domain.Landmark;
import com.ctb.trust.core.restaurant.domain.MenuItem;
import com.ctb.trust.core.restaurant.domain.RatingScore;
import com.ctb.trust.core.restaurant.domain.Restaurant;
import com.ctb.trust.core.restaurant.repository.FoodTypeRepository;
import com.ctb.trust.core.restaurant.repository.LandmarkRepository;
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
	
	@Autowired
	LandmarkRepository landmarkRepository;
	
	@Autowired
	FoodTypeRepository foodTypeRepository;
	
	@Test
	public void test() {
		Restaurant restaurant = new Restaurant();
		restaurant.setName("화로양");

		Set<Landmark> landmarks = getLandmarks();
		restaurant.setLandmarks(landmarks);

		Set<MenuItem> menu = getMenu();
		restaurant.setMenu(menu);
		restaurant.setRatingScore(RatingScore.GOOD);
		
		this.restaurantRepository.save(restaurant);

		Restaurant found = this.restaurantRepository.findOne(restaurant.getId());
		System.out.println(found);
		assertThat(found).isEqualTo(restaurant);
	}

	private Set<Landmark> getLandmarks() {
		Landmark landmark1 = new Landmark();
		landmark1.setName("정자역");
		Landmark landmark2 = new Landmark();
		landmark2.setName("그린팩토리");
		this.landmarkRepository.save(landmark1);
		this.landmarkRepository.save(landmark2);

		Set<Landmark> landmarks = new HashSet<>();
		landmarks.add(landmark1);
		landmarks.add(landmark2);
		return landmarks;
	}

	private Set<MenuItem> getMenu() {
		FoodType foodType1 = new FoodType();
		foodType1.setName("함박 스테이크");
		this.foodTypeRepository.save(foodType1);
		
		MenuItem menuItem1 = new MenuItem();
		menuItem1.setName("램버그스테이크");
		menuItem1.setFoodType(foodType1);
		menuItem1.setPrice(10000);
		menuItem1.setRatingScore(RatingScore.GOOD);
		
		Set<MenuItem> menu = new HashSet<>();
		menu.add(menuItem1);
		return menu;
	}

}
