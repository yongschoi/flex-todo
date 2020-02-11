package yongs.temp.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;
import yongs.temp.model.Todo;
import yongs.temp.service.TodoService;

@RestController
@RequestMapping("/todo")
public class TodoController {
	private Logger logger = LoggerFactory.getLogger(TodoController.class);
	@Autowired
    private TodoService service;
    
    @PostMapping("/create") /* Postman 프로그램으로 실행 */
    @ResponseStatus(HttpStatus.CREATED)
    public Mono<Todo> create(@RequestBody Todo e) {
    	logger.debug("flex-demo|TodoController|create()");
        return service.create(e);
    }
    
    @GetMapping("/id/{id}")
    public ResponseEntity<Mono<Todo>> findById(@PathVariable("id") Long id) {
    	logger.debug("flex-todo|TodoController|findById({})", id);
    	Mono<Todo> e = service.findById(id);
        HttpStatus status = e != null ? HttpStatus.OK : HttpStatus.NOT_FOUND;
        return new ResponseEntity<Mono<Todo>>(e, status);
    }
 
    @GetMapping("/title/{title}")
    public Flux<Todo> findByTitle(@PathVariable("title") String title) {
    	logger.debug("flex-todo|TodoController|findByTitle({})", title);
        return service.findByTitle(title);
    }
    
    @PutMapping("/update")
    @ResponseStatus(HttpStatus.OK)
    public Mono<Todo> update(@RequestBody Todo e) {
    	logger.debug("flex-todo|TodoController|update()");    	    	
        return service.update(e);
    }
 
    @DeleteMapping("/delete/{id}")
    @ResponseStatus(HttpStatus.OK)
    public Mono<Void> delete(@PathVariable("id") Long id) {
    	logger.debug("flex-todo|TodoController|delete({})", id);      	
        return service.delete(id);
    }

    @GetMapping("/all")
    public Flux<Todo> findAll() {
    	logger.debug("flex-todo|TodoController|findAll()");    	
        Flux<Todo> emps = service.findAll();
        return emps;
    }
}
