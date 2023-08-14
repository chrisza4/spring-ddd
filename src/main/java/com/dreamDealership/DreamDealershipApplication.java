package com.dreamDealership;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.dreamDealership.domain.EventBus;

@SpringBootApplication
public class DreamDealershipApplication {

	public static void main(String[] args) {
		var context = SpringApplication.run(DreamDealershipApplication.class, args);

		// Setup
		var bus = context.getBean(EventBus.class);
		var warehouseEventHandler = context.getBean(com.dreamDealership.domain.warehouse.EventHandler.class);
		bus.subscribe(warehouseEventHandler);
	}

}
