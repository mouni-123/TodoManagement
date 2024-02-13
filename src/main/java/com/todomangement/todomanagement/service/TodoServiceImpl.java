package com.todomangement.todomanagement.service;

import java.util.List;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
//import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.todomangement.todomanagement.dto.Tododto;
import com.todomangement.todomanagement.exceptions.ResourceNotFoundException;
import com.todomangement.todomanagement.model.Todo;
import com.todomangement.todomanagement.repository.TodoRepository;

import lombok.AllArgsConstructor;
@Service
@AllArgsConstructor
public class TodoServiceImpl implements TodoService{
     TodoRepository todoRepository;
     ModelMapper modelMapper;
     public Tododto addTodo(Tododto tododto)
     {
        Todo todo = modelMapper.map(tododto,Todo.class);
        todoRepository.save(todo);
        return modelMapper.map(todo,Tododto.class);

     }
     public Tododto  getTodo(int id)
     {
      Todo todo = todoRepository.findById(id).orElseThrow(()-> new ResourceNotFoundException("This id id not present"+id));
      return modelMapper.map(todo,Tododto.class);

     }
      public List<Tododto> getTodoAll()
      {
         List < Todo > todos  = todoRepository.findAll();
         //List<Tododto> tododtos = new ArrayList<Tododto>();
        // return ModelMapper.map(todos,tododtos);
         List<Tododto> tododtos = todos
  .stream()
  .map(todo -> modelMapper.map(todo, Tododto.class))
  .collect(Collectors.toList());
  return tododtos;
      }
      public Tododto updateTodo(int id,Tododto tododto){
         Todo todo =todoRepository.findById(id).orElseThrow(()-> new ResourceNotFoundException("This id id not present"+id));
         todo.setTitle(tododto.getTitle());
         todo.setDescription(tododto.getDescription());
         todo.setCompleted(tododto.isCompleted());
         todoRepository.save(todo);
         return modelMapper.map(todo,Tododto.class);

      }
    public void deleteTodo(int id)
    {
      todoRepository.deleteById(id);
       
    }
    public Tododto completeTodo(int id)
   {
      Todo todo =todoRepository.findById(id).orElseThrow(()-> new ResourceNotFoundException("This id id not present"+id));
      todo.setCompleted(true);
      todoRepository.save(todo);
      return modelMapper.map(todo,Tododto.class);

   }

   public Tododto IncompleteTodo(int id)
   {
      Todo todo =todoRepository.findById(id).orElseThrow(()-> new ResourceNotFoundException("This id id not present"+id));
      todo.setCompleted(false);
      todoRepository.save(todo);
      return modelMapper.map(todo,Tododto.class);
      
   }
}
