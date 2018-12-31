package com.aytdm.springbootwebflux;

import com.aytdm.springbootwebflux.controller.RouterHandler;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.web.reactive.function.server.RouterFunction;
import org.springframework.web.reactive.function.server.ServerResponse;

@SpringBootApplication
public class SpringbootWebfluxApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringbootWebfluxApplication.class, args);
	}

	@Bean
	RouterFunction<ServerResponse> routes(RouterHandler routerHandler) {
		return routerHandler.routes();
	}
}
