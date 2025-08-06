package com.example.todoapi.model;

public class Todo {
	
	private int id;
	private String task;
	private boolean completed;
	
	// constructors 
	// constructor with and without arguments
	
	public Todo() {
		
	}
		
	public Todo(int id, String task, boolean completed) {
		super();
		this.id = id;
		this.task = task;
		this.completed = completed;
	}
		
	// getters and setters
	
	public int getId() {
		return id;
	}


	public void setId(int id) {
		this.id = id;
	}
	public String getTask() {
		return task;
	}
	public void setTask(String task) {
		this.task = task;
	}
	public boolean isCompleted() {
		return completed;
	}
	public void setCompleted(boolean completed) {
		this.completed = completed;
	}
	
	
	
	

}
