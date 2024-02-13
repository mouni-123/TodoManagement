package com.todomangement.todomanagement.service;
import java.util.List;

import com.todomangement.todomanagement.dto.Tododto;
//import com.todomangement.todomanagement.repository.TodoRepository;


public interface TodoService {
   
   public Tododto addTodo(Tododto tododto);
   public Tododto getTodo(int id);
   public Tododto updateTodo(int id,Tododto tododto);
   public List<Tododto> getTodoAll();
   public void deleteTodo(int id);
   public Tododto completeTodo(int id);
   public Tododto IncompleteTodo(int id);
   
}
