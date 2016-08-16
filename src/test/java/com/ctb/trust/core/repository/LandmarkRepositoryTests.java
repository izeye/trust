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

package com.ctb.trust.core.repository;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.junit4.SpringRunner;

import org.junit.Test;
import org.junit.runner.RunWith;

import com.ctb.trust.core.restaurant.domain.Landmark;
import com.ctb.trust.core.restaurant.repository.LandmarkRepository;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * Tests for landmark repository.
 *
 * @author Johnny Lim
 */
@RunWith(SpringRunner.class)
@DataJpaTest
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
public class LandmarkRepositoryTests {

	@Autowired
	private LandmarkRepository landmarkRepository;

	@Test
	@Transactional
	public void testFindByOrderByName() {
		Landmark landmark1 = new Landmark();
		landmark1.setName("Seoul");
		Landmark landmark2 = new Landmark();
		landmark2.setName("London");
		this.landmarkRepository.save(landmark1);
		this.landmarkRepository.save(landmark2);

		List<Landmark> landmarks = this.landmarkRepository.findByOrderByName();
		assertThat(landmarks).containsExactly(landmark2, landmark1);
	}

}
