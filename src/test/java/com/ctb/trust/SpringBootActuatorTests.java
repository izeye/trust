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

package com.ctb.trust;

import java.util.Map;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.context.embedded.LocalServerPort;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit4.SpringRunner;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * Created by izeye on 16. 6. 13..
 */
@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class SpringBootActuatorTests {
	
	@Value("${security.user.name}")
	String username;
	
	@Value("${security.user.password}")
	String password;
	
	@LocalServerPort
	int port;

	TestRestTemplate restTemplate;
	
	@Before
	public void setUp() {
		this.restTemplate = new TestRestTemplate(this.username, this.password);
	}
	
	@Test
	public void test() {
		String url = "http://localhost:{port}/management/health";
		
		ResponseEntity<Map<String, Object>> response = this.restTemplate.exchange(
				url, HttpMethod.GET, null, new ParameterizedTypeReference<Map<String, Object>>() {
				}, this.port);
		System.out.println(response);
		
		Map<String, Object> health = response.getBody();
		assertThat(health.get("status")).isEqualTo("UP");
	}
	
}
