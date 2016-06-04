package com.ctb.trust.core.restaurant.web;

import com.ctb.trust.core.restaurant.domain.Restaurant;
import com.ctb.trust.core.restaurant.service.RestaurantService;
import com.ctb.trust.support.message.domain.Message;
import com.ctb.trust.support.message.service.MessageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

/**
 * Created by izeye on 16. 6. 4..
 */
@Controller
@RequestMapping(path = "/restaurants")
public class RestaurantController {

	@Autowired
	private RestaurantService restaurantService;
	
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
	public String add(Restaurant restaurant) {
		this.restaurantService.add(restaurant);
		return "redirect:list";
	}
	
}
