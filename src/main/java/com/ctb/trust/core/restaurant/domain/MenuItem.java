package com.ctb.trust.core.restaurant.domain;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

/**
 * Created by izeye on 16. 6. 9..
 */
@Data
@Entity
public class MenuItem {

	@Id
	@GeneratedValue
	private Long id;

	private String name;
	
	@ManyToOne
	private FoodType foodType;
	
	// TODO: Support multiple currencies. Let's assume won for now.
	private Integer price;
	
	private RatingScore ratingScore;
	
}
