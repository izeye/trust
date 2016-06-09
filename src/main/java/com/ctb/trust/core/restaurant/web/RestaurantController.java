package com.ctb.trust.core.restaurant.web;

import com.ctb.trust.core.restaurant.domain.Landmark;
import com.ctb.trust.core.restaurant.domain.Restaurant;
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
	public String add() {
		return "restaurants/add";
	}

	@PostMapping("/add")
	public String add(@RequestParam String name, @RequestParam String landmarks) {
		Restaurant restaurant = new Restaurant();
		restaurant.setName(name);

		Set<Landmark> landmarkSet = getLandmarkSet(landmarks);
		restaurant.setLandmarks(landmarkSet);
		
		this.restaurantService.add(restaurant);
		return "redirect:list";
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

}
