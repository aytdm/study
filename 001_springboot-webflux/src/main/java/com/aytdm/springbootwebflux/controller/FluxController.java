package com.aytdm.springbootwebflux.controller;

import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.util.Collections;
import java.util.Map;
import java.util.stream.Stream;

@RestController
@RequestMapping("flux")
public class FluxController {

    @GetMapping()
    Flux<String> hello() {
        return Flux.just("Hello", "world");
    }

    @GetMapping("/stream")
    Flux<Map<String, Integer>> stream() {
        Stream<Integer> stream = Stream.iterate(0, i -> i + 1);
        return Flux.fromStream(stream.limit(10)).map(i -> Collections.singletonMap("value", i));
    }

    @PostMapping("/echo")
    Mono<String> echo(@RequestBody Mono<String> body) {
        return body.map(String::toUpperCase);
    }

    @PostMapping("/stream")
    Flux<Map<String, Integer>> stream(@RequestBody Flux<Map<String, Integer>> body) {
        return body.map(m -> Collections.singletonMap("double", m.get("value") * 2));
    }
}
