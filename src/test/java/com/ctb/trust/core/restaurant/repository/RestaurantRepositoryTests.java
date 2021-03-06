/*
 * Copyright 2016 the original author or authors.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.ctb.trust.core.restaurant.repository;

import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.data.domain.Sort;
import org.springframework.test.context.junit4.SpringRunner;

import org.junit.Test;
import org.junit.runner.RunWith;

import com.ctb.trust.core.restaurant.domain.FoodType;
import com.ctb.trust.core.restaurant.domain.Landmark;
import com.ctb.trust.core.restaurant.domain.MenuItem;
import com.ctb.trust.core.restaurant.domain.RatingScore;
import com.ctb.trust.core.restaurant.domain.Restaurant;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * Tests for restaurant repository.
 *
 * @author Johnny Lim
 */
@RunWith(SpringRunner.class)
@DataJpaTest
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
public class RestaurantRepositoryTests {

	private static final Sort SORT_BY_RATING_SCORE_DESC =
			new Sort(Sort.Direction.DESC, "ratingScore");

	@Autowired
	private RestaurantRepository restaurantRepository;

	@Autowired
	private LandmarkRepository landmarkRepository;

	@Autowired
	private FoodTypeRepository foodTypeRepository;

	@Test
	public void test() {
		Restaurant restaurant = createRestaurant();

		Restaurant found = this.restaurantRepository.findOne(restaurant.getId());
		System.out.println(found);
		assertThat(found).isEqualTo(restaurant);
	}

	private Restaurant createRestaurant() {
		Restaurant restaurant = new Restaurant();
		restaurant.setName("화로양");

		Set<Landmark> landmarks = getLandmarks();
		restaurant.setLandmarks(landmarks);

		Set<MenuItem> menu = getMenu();
		restaurant.setMenu(menu);
		restaurant.setRatingScore(RatingScore.GOOD);

		this.restaurantRepository.save(restaurant);
		return restaurant;
	}

	@Test
	public void testFindAll() {
		this.restaurantRepository.findAll(SORT_BY_RATING_SCORE_DESC).forEach(System.out::println);
	}

	@Test
	public void testFindByLandmarks() {
		createRestaurant();

		Landmark landmark = this.landmarkRepository.findByName("정자역");
		List<Restaurant> restaurants = this.restaurantRepository.findByLandmarks(
				Collections.singletonList(landmark), SORT_BY_RATING_SCORE_DESC);
		restaurants.forEach(System.out::println);
	}

	private Set<Landmark> getLandmarks() {
		Landmark landmark1 = createLandmark("정자역");
		Landmark landmark2 = createLandmark("그린팩토리");

		Set<Landmark> landmarks = new HashSet<>();
		landmarks.add(landmark1);
		landmarks.add(landmark2);
		return landmarks;
	}

	private Landmark createLandmark(String landmarkName) {
		Landmark landmark1 = new Landmark();
		landmark1.setName(landmarkName);
		this.landmarkRepository.save(landmark1);
		return landmark1;
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
