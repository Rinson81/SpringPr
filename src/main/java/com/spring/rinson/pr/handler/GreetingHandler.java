package com.spring.rinson.pr.handler;

import com.spring.rinson.pr.model.Greeting;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Component;
import org.springframework.web.reactive.function.BodyInserters;
import org.springframework.web.reactive.function.server.ServerRequest;
import org.springframework.web.reactive.function.server.ServerResponse;
import reactor.core.publisher.Mono;

@Component
public class GreetingHandler {
	private Mono<ServerResponse> hello(ServerRequest serverRequest){
		return ServerResponse.ok().contentType(MediaType.APPLICATION_JSON)
				.body(BodyInserters.fromValue(new Greeting("Hello, Spring!")));
	};
}