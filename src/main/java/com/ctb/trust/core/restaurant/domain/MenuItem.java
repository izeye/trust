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

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

import lombok.Data;

/**
 * Menu item served by a restaurant.
 *
 * @author Johnny Lim
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
