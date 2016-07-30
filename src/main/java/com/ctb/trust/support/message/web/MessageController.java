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

package com.ctb.trust.support.message.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import lombok.extern.slf4j.Slf4j;

import com.ctb.trust.support.message.domain.Message;
import com.ctb.trust.support.message.service.MessageService;

/**
 * Controller for messages.
 *
 * @author Johnny Lim
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
