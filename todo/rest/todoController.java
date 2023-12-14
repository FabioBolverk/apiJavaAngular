package oi.github.cursofabio.todo.rest;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

import oi.github.cursofabio.todo.model.Todo;
import oi.github.cursofabio.todo.repository.todoRepository;

@RestController
@RequestMapping("/api/todos")
@CrossOrigin("http://localhost:4200")
public class todoController {
	
	@Autowired
	private todoRepository repository;
	
	@PostMapping
	public Todo save(@RequestBody Todo todo) {
		return repository.save(todo);
	}
	
	
	@GetMapping("{id}")
	public Todo getById(@PathVariable  Long id) {
		return repository.findById(id).orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND));
		
	}
	
	@GetMapping
	public List<Todo> getAll(){
		return repository.findAll();
	}
	
	@DeleteMapping("{id}")
	public void delete(@PathVariable  Long id) {
		repository.deleteById(id);
		
	}

}
