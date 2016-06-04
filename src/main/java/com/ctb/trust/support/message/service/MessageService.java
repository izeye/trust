package com.ctb.trust.support.message.service;

import com.ctb.trust.support.message.domain.Message;

import java.util.List;

/**
 * Created by izeye on 16. 6. 4..
 */
public interface MessageService {

	List<Message> findAllInReverseOrder();

	void add(Message message);
	
}
