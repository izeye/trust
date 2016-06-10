package com.ctb.trust.core.restaurant.domain;

import lombok.Data;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import java.util.Set;

/**
 * Created by izeye on 16. 6. 3..
 */
@Data
@Entity
public class Restaurant {
	
	@Id
	@GeneratedValue
	private Long id;
	
	@Column(unique = true)
	private String name;
	
	@ManyToMany
	private Set<Landmark> landmarks;
	
	@OneToMany(cascade = CascadeType.ALL)
	private Set<MenuItem> menu;
	
	private RatingScore ratingScore;
	
}
