package com.ctb.trust;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.context.embedded.LocalServerPort;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Map;

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
