package com.bootcamp.reactive.blog.services;

import com.bootcamp.reactive.blog.entities.Author;
import com.bootcamp.reactive.blog.entities.Blog;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public interface AuthorService {
    Mono<Author> findById(String id);
    Flux<Author> findAll();
    Mono<Author> save(Author author);
    Mono<Void> delete(String id);
    Flux<Author> findByEmail(String email);
}
