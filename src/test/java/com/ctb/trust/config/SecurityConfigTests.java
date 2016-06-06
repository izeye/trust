package com.ctb.trust.config;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.security.web.servlet.support.csrf.CsrfRequestDataValueProcessor;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.web.servlet.support.RequestDataValueProcessor;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * Created by izeye on 16. 6. 6..
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class SecurityConfigTests {
	
	@Autowired
	RequestDataValueProcessor requestDataValueProcessor;
	
	@Test
	public void testRequestDataValueProcessor() {
		assertThat(this.requestDataValueProcessor)
				.isInstanceOf(CsrfRequestDataValueProcessor.class);
	}
	
}
