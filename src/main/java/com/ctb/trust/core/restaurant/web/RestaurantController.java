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

package com.ctb.trust.core.restaurant.web;

import com.ctb.trust.core.restaurant.domain.FoodType;
import com.ctb.trust.core.restaurant.domain.Landmark;
import com.ctb.trust.core.restaurant.domain.MenuItem;
import com.ctb.trust.core.restaurant.domain.RatingScore;
import com.ctb.trust.core.restaurant.domain.Restaurant;
import com.ctb.trust.core.restaurant.service.FoodTypeService;
import com.ctb.trust.core.restaurant.service.LandmarkService;
import com.ctb.trust.core.restaurant.service.RestaurantService;
import com.ctb.trust.support.message.domain.Message;
import com.ctb.trust.support.message.service.MessageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * Created by izeye on 16. 6. 4..
 */
@Controller
@RequestMapping(path = "/restaurants")
public class RestaurantController {

	@Autowired
	private RestaurantService restaurantService;
	
	@Autowired
	private LandmarkService landmarkService;
	
	@Autowired
	private FoodTypeService foodTypeService;
	
	@Autowired
	private MessageService messageService;

	@GetMapping(path = {"", "/", "/list"})
	public String index(Model model) {
		List<Restaurant> restaurants = this.restaurantService.findAll();
		List<Message> messages = this.messageService.findAllInReverseOrder();
		model.addAttribute("restaurants", restaurants);
		model.addAttribute("messages", messages);
		return "index";
	}

	@GetMapping("/add")
	public String add(Model model) {
		model.addAttribute("ratingScores", RatingScore.values());
		return "restaurants/add";
	}

	@PostMapping("/add")
	public String add(
			@RequestParam String name,
			@RequestParam String landmarks,
			@RequestParam RatingScore rating,
			@RequestParam String menuItem1Name,
			@RequestParam String menuItem1FoodTypeName,
			@RequestParam Integer menuItem1Price,
			@RequestParam RatingScore menuItem1Rating) {
		Restaurant restaurant = new Restaurant();
		restaurant.setName(name);

		Set<Landmark> landmarkSet = getLandmarkSet(landmarks);
		restaurant.setLandmarks(landmarkSet);
		restaurant.setRatingScore(rating);

		Set<MenuItem> menu = new HashSet<>();
		MenuItem menuItem1 = new MenuItem();
		menuItem1.setName(menuItem1Name);
		
		FoodType menuItem1FoodType = getFoodType(menuItem1FoodTypeName);
		menuItem1.setFoodType(menuItem1FoodType);
		menuItem1.setPrice(menuItem1Price);
		menuItem1.setRatingScore(menuItem1Rating);
		menu.add(menuItem1);
		restaurant.setMenu(menu);
		
		this.restaurantService.save(restaurant);
		return "redirect:list";
	}
	
	@GetMapping("/menus/add")
	public String addMenu(Model model) {
		List<Restaurant> restaurants = this.restaurantService.findAll();
		model.addAttribute("restaurants", restaurants);
		model.addAttribute("ratingScores", RatingScore.values());
		return "restaurants/menus/add";
	}
	
	@PostMapping("/menus/add")
	public String addMenu(
			@RequestParam long restaurantId,
			@RequestParam String menuItemName,
			@RequestParam String menuItemFoodTypeName,
			@RequestParam Integer menuItemPrice,
			@RequestParam RatingScore menuItemRating) {
		Restaurant restaurant = this.restaurantService.findById(restaurantId);
		
		MenuItem menuItem = new MenuItem();
		menuItem.setName(menuItemName);

		FoodType menuItemFoodType = getFoodType(menuItemFoodTypeName);
		menuItem.setFoodType(menuItemFoodType);
		menuItem.setPrice(menuItemPrice);
		menuItem.setRatingScore(menuItemRating);
		restaurant.getMenu().add(menuItem);

		this.restaurantService.save(restaurant);
		return "redirect:/restaurants/list";
	}

	private Set<Landmark> getLandmarkSet(String landmarks) {
		Set<Landmark> landmarkSet = new HashSet<>();
		Set<String> landmarkNames = StringUtils.commaDelimitedListToSet(landmarks);
		for (String landmarkName : landmarkNames) {
			Landmark landmark = this.landmarkService.findByName(landmarkName);
			if (landmark == null) {
				landmark = new Landmark();
				landmark.setName(landmarkName);
				this.landmarkService.add(landmark);
			}
			landmarkSet.add(landmark);
		}
		return landmarkSet;
	}

	private FoodType getFoodType(String foodTypeName) {
		FoodType foodType = this.foodTypeService.findByName(foodTypeName);
		if (foodType == null) {
			foodType = new FoodType();
			foodType.setName(foodTypeName);
			this.foodTypeService.add(foodType);
		}
		return foodType;
	}

}
