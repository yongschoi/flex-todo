package yongs.temp.dao;

import org.springframework.data.mongodb.repository.Query;
import org.springframework.data.mongodb.repository.ReactiveMongoRepository;

import reactor.core.publisher.Flux;
import yongs.temp.model.Todo;


public interface TodoRepository extends ReactiveMongoRepository<Todo, Long> {
	@Query("{ 'title': ?0 }")
	Flux<Todo> findByTitle(final String title);
}