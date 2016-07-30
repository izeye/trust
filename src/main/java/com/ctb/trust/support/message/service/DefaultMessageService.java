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

package com.ctb.trust.support.message.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import com.ctb.trust.support.message.domain.Message;
import com.ctb.trust.support.message.repository.MessageRepository;

/**
 * Default service for messages.
 *
 * @author Johnny Lim
 */
@Service
public class DefaultMessageService implements MessageService {

	private static final Sort ID_DESC = new Sort(Sort.Direction.DESC, "id");

	@Autowired
	private MessageRepository messageRepository;

	@Override
	public List<Message> findAllInReverseOrder() {
		return this.messageRepository.findAll(ID_DESC);
	}

	@Override
	public void add(Message message) {
		this.messageRepository.save(message);
	}

}
