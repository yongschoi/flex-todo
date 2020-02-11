package yongs.temp.service;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;
import yongs.temp.model.Todo;

public interface ITodo {
	Mono<Todo> create(Todo e); 
    Mono<Todo> findById(Long id);
    Flux<Todo> findByTitle(String title);
    Flux<Todo> findAll();
    Mono<Todo> update(Todo e);
    Mono<Void> delete(Long id);
}
