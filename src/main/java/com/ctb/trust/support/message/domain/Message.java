package com.ctb.trust.support.message.domain;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

/**
 * Created by izeye on 16. 6. 4..
 */
@Data
@Entity
public class Message {

	@Id
	@GeneratedValue
	private Long id;

	private String body;
	
}
