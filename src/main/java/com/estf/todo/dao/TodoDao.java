package com.estf.todo.dao;

import java.util.List;

import com.estf.todo.beans.Todo;

public interface TodoDao {
	public Todo insert(Todo todo);
	public Todo update(Todo todo);
	public Todo delete(Todo todo);
	public Todo get(int id);
	public List<Todo> getAll();

}
