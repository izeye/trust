package com.ctb.trust.support.message.service;

import com.ctb.trust.support.message.domain.Message;
import com.ctb.trust.support.message.repository.MessageRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by izeye on 16. 6. 4..
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
