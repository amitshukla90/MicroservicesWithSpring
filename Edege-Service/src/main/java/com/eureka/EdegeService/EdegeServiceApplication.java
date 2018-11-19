package com.eureka.EdegeService;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.circuitbreaker.EnableCircuitBreaker;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.netflix.zuul.EnableZuulProxy;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;

import lombok.Data;

@SpringBootApplication
@EnableFeignClients
@EnableCircuitBreaker
@EnableDiscoveryClient
@EnableZuulProxy
public class EdegeServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(EdegeServiceApplication.class, args);
	}
	
	@Data
	class Item{
		private String name;
	}
	
	@FeignClient("ITEM-CATALOG-SERVICE")
	interface ItemClient{
		@GetMapping("/items")
		String getItems();
		
	}
}
