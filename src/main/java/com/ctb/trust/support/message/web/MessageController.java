package com.ctb.trust.support.message.web;

import com.ctb.trust.support.message.domain.Message;
import com.ctb.trust.support.message.service.MessageService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Created by izeye on 16. 6. 4..
 */
@Controller
@RequestMapping(path = "/messages")
@Slf4j
public class MessageController {

	@Autowired
	private MessageService messageService;

	@GetMapping("/add")
	public String add() {
		return "messages/add";
	}

	@PostMapping("/add")
	public String add(Message message) {
		log.info("Message: {}", message);
		
		this.messageService.add(message);
		return "redirect:/";
	}
	
}
