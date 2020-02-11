package yongs.temp.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;
import yongs.temp.dao.TodoRepository;
import yongs.temp.model.Todo;

@Service
public class TodoService implements ITodo {
	private Logger logger = LoggerFactory.getLogger(TodoService.class);	

	@Autowired
    TodoRepository repo;
	
	@Override
	public Mono<Todo> create(Todo e) {
		logger.debug("flex-todo|TodoService|create()");
		return repo.save(e);
	}

	@Override
	public Mono<Todo> findById(Long id) {
		logger.debug("flex-todo|TodoService|findById({})", id);
		return repo.findById(id);
	}

	@Override
	public Flux<Todo> findByTitle(String title) {
		logger.debug("flex-todo|TodoService|findByName({})", title);
		return repo.findByTitle(title);
	}

	@Override
	public Flux<Todo> findAll() {
		logger.debug("flex-todo|TodoService|findAll()");
		return repo.findAll();
	}
	
	@Override
	public Mono<Todo> update(Todo e) {
		logger.debug("flex-todo|TodoService|update()");
		return repo.save(e);
	}

	@Override
	public Mono<Void> delete(Long id) {
		logger.debug("flex-todo|TodoService|delete({})", id);
		return repo.deleteById(id);
	}
}
