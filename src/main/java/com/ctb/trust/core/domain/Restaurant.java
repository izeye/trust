package com.ctb.trust.core.domain;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

/**
 * Created by izeye on 16. 6. 3..
 */
@Data
@Entity
public class Restaurant {
	
	@Id
	@GeneratedValue
	private Long id;
	
	private String name;
	
}
