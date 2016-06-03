package com.ctb.trust.core.web;

import com.ctb.trust.core.domain.Restaurant;
import com.ctb.trust.core.service.RestaurantService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;

/**
 * Created by izeye on 16. 6. 3..
 */
@Controller
public class HomeController {
	
	@Autowired
	private RestaurantService restaurantService;
	
	@GetMapping(path = {"/", "/list"})
	public String index(Model model) {
		List<Restaurant> restaurants = this.restaurantService.findAll();
		model.addAttribute("restaurants", restaurants);
		return "index";
	}
	
	@GetMapping("/add")
	public String add() {
		return "add";
	}
	
	@PostMapping("/add")
	public String add(Restaurant restaurant) {
		this.restaurantService.add(restaurant);
		return "redirect:list";
	}
	
}
