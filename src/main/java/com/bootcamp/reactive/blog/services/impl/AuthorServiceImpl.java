package com.bootcamp.reactive.blog.services.impl;

import com.bootcamp.reactive.blog.entities.Author;
import com.bootcamp.reactive.blog.repositories.AuthorRepository;
import com.bootcamp.reactive.blog.services.AuthorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Service
public class AuthorServiceImpl implements AuthorService {

    @Autowired
    private AuthorRepository authorRepository;

    @Override
    public Mono<Author> findById(String id) {
        return this.authorRepository.findById(id);
    }

    @Override
    public Flux<Author> findAll() {
        return this.authorRepository.findAll();
    }

    @Override
    public Mono<Author> save(Author author) {
        return this.authorRepository.save(author);
    }

    @Override
    public Mono<Void> delete(String id) {
        return this.authorRepository.findById(id)
                .flatMap(author-> this.authorRepository.delete(author));
    }
}