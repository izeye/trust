package com.ctb.trust.core.web;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

/**
 * Created by izeye on 16. 6. 3..
 */
@Controller
public class HomeController {
	
	@GetMapping("/")
	public String index(Model model) {
		return "redirect:restaurants";
	}
	
}
