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

package com.ctb.trust.core.restaurant.service;

import java.util.List;

import com.ctb.trust.core.restaurant.domain.Landmark;

/**
 * Service interface for landmarks.
 *
 * @author Johnny Lim
 */
public interface LandmarkService {

	List<Landmark> findAll();

	Landmark findOne(Long id);

	Landmark findByName(String name);

	void add(Landmark landmark);

}
