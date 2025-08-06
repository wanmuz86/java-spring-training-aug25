package com.example.todoapi.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.todoapi.model.Todo;

@RestController
@RequestMapping("/api/todos") // All the url will starts with /api/todos
public class TodoController {
	
	// Store the todo inside an ArrayList - in memory
	private List<Todo> todos = new ArrayList<>();
	
	// Keep track of the last id of the todo
	private int currentId= 1;
	
	
	// Create
	// @PostMapping - This will be called using the method POST (/api/todos)
	// @RequestBody - This method expect user to send data
	
	@PostMapping
	public Todo create(@RequestBody Todo todo) {
		// Set the id to the updated ID
		todo.setId(currentId++);
		// Add todo inside the List
		todos.add(todo);
		// User will retrieve the new todo with the ID
		return todo;
	}
	
	// Read
	
	// Get all todos
	// GetMapping - Use GET method to call this API (/api/todos)
	@GetMapping 
	public List<Todo> getAllTodos(){
		return todos;
	}
	
	// GET By Id - Challenge for you to do 
	
	
	// UPDATE (pg:114)
	@PutMapping("/{id}")
	public String updateTodo(@PathVariable int id, @RequestBody Todo updatedTodo) {
		for (Todo todo:todos) {
			if (todo.getId() == id) {
				todo.setTask(updatedTodo.getTask());
				todo.setCompleted(updatedTodo.isCompleted());
				return "Todo Updated";
			}
		}
		return "Todo not found";
	}
	
	
	
	// Delete (pg: 111)
	// @DeleteMapping - Use DELETE method to call the API
	// @PathVariable - The parameters/variable that is passed through the url
	// eg: /todos/1 <- 1 here is the PathVariable
	// Think of the scenario where the url is /hotels/1/rooms/2
	@DeleteMapping("/{id}")
	public String deleteTodo(@PathVariable int id) {
		// lambda expression 
		// for each of the items in todos array,
		// check, if the id is the same as the passed id, remove it
		// true -> if something is nothing is removed, false , if nothing is removed 
		boolean removed = todos.removeIf(todo -> todo.getId()==id);
		
		// ternary operatory
		// if true I will return "Todo deleted" else "Todo not found"
		return removed ? "Todo deleted" : "Todo not found";
	}
	
	

}
