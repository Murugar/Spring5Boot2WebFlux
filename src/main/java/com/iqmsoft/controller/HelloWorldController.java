package com.iqmsoft.controller;

import org.springframework.context.annotation.Bean;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.reactive.function.server.RequestPredicates;
import org.springframework.web.reactive.function.server.RouterFunction;
import org.springframework.web.reactive.function.server.RouterFunctions;
import org.springframework.web.reactive.function.server.ServerResponse;



@RestController
public class HelloWorldController {

    @RequestMapping("/")
    public String index() {
        return "Hello World! From Spring Reactor Flux" +
                "<br />" +
                "<a href=\"test\">test</a>";
    }

    @Bean
    public RouterFunction<ServerResponse> example(TestHandler testHandler) {
        return RouterFunctions.route(
                RequestPredicates.GET("/test")
                        .and(RequestPredicates.accept(MediaType.TEXT_PLAIN)),
                testHandler::hello);
    }
   
}
