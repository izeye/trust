package com.ctb.trust.core.repository;

import com.ctb.trust.core.restaurant.domain.FoodType;
import com.ctb.trust.core.restaurant.domain.Landmark;
import com.ctb.trust.core.restaurant.domain.MenuItem;
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

		Set<Landmark> landmarks = getLandmarks();
		restaurant.setLandmarks(landmarks);

		Set<MenuItem> menu = getMenu();
		restaurant.setMenu(menu);
		
		this.restaurantRepository.save(restaurant);

		Restaurant found = this.restaurantRepository.findOne(restaurant.getId());
		System.out.println(found);
		assertThat(found).isEqualTo(restaurant);
	}

	private Set<Landmark> getLandmarks() {
		Set<Landmark> landmarks = new HashSet<>();
		Landmark landmark1 = new Landmark();
		landmark1.setName("정자역");
		Landmark landmark2 = new Landmark();
		landmark2.setName("그린팩토리");
		landmarks.add(landmark1);
		landmarks.add(landmark2);
		return landmarks;
	}

	private Set<MenuItem> getMenu() {
		Set<MenuItem> menu = new HashSet<>();
		FoodType foodType = new FoodType();
		foodType.setName("함박 스테이크");
		MenuItem menuItem = new MenuItem();
		menuItem.setName("램버그스테이크");
		menuItem.setFoodType(foodType);
		menuItem.setPrice(10000);
		menu.add(menuItem);
		return menu;
	}

}
