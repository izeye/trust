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
