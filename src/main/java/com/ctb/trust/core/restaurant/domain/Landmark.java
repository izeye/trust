package com.ctb.trust.core.restaurant.domain;

import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

/**
 * Created by izeye on 16. 6. 9..
 */
@Data
@Entity
public class Landmark {

	@Id
	@GeneratedValue
	private Long id;

	@Column(unique = true)
	private String name;
	
}
