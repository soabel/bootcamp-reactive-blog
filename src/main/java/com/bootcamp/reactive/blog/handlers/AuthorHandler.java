package com.bootcamp.reactive.blog.handlers;

import com.bootcamp.reactive.blog.entities.Author;
import com.bootcamp.reactive.blog.services.AuthorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.reactive.function.server.ServerRequest;
import org.springframework.web.reactive.function.server.ServerResponse;
import reactor.core.publisher.Mono;

import static org.springframework.http.MediaType.APPLICATION_JSON;

@Component
public class AuthorHandler {

    @Autowired
    private AuthorService authorService;

    public Mono<ServerResponse> findAll(ServerRequest request){
        return ServerResponse.ok()
                .contentType(APPLICATION_JSON)
                .body(authorService.findAll(), Author.class);
    }

    public Mono<ServerResponse> save(ServerRequest request){

        var authorInput= request.bodyToMono(Author.class);

        return authorInput
                .flatMap(a-> authorService.save(a))
                .flatMap(a-> ServerResponse
                        .ok()
                        .contentType(APPLICATION_JSON)
                        .body(Mono.just(a), Author.class));

    }

}
