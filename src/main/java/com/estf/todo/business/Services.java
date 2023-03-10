package com.estf.todo.business;

import java.util.List;

import com.estf.todo.beans.Todo;

public interface Services {

	public Todo addTodo(Todo todo);
	public Todo updateTodo(Todo todo);
	public Todo deleteTodo(Todo todo);
	public Todo getTodo(int id);
	public List<Todo> getAllTodos();
}
