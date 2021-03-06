/*
 * Copyright 2012 the original author or authors.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      https://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package org.springframework.data.gemfire.examples;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.ImportResource;
import org.springframework.data.gemfire.repository.config.EnableGemfireRepositories;

/**
 * Spring JavaConfig configuration class to setup a Spring container and infrastructure components.
 * 
 * @author Oliver Gierke
 * @author David Turanski
 */
@Configuration
@ImportResource("classpath:cache-config.xml")
@EnableGemfireRepositories
public class ApplicationConfig {
	
	@Bean CustomerService customerService() {
		return new CustomerService();
	}
	
	@Bean OrderService orderService() {
		return new OrderService();
	}
	
	@Bean ProductService productService() {
		return new ProductService();
	}
	
	@Bean OrderExample orderExample() {
		return new OrderExample(customerService(), productService(), orderService());
	}
}
