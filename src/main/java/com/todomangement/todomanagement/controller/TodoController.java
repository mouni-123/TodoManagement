package com.todomangement.todomanagement.controller;

import org.springframework.web.bind.annotation.RestController;

import com.todomangement.todomanagement.dto.Tododto;
import com.todomangement.todomanagement.service.TodoService;

import lombok.AllArgsConstructor;

import java.util.List;

//import org.hibernate.annotations.Parameter;
//import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
//import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
//import org.springframework.web.bind.annotation.RequestParam;

@CrossOrigin("*")
@RestController
@RequestMapping("api/todo")
@AllArgsConstructor
public class TodoController {
    private TodoService todoService;
    @PostMapping("add")
    public ResponseEntity<Tododto> addTodo(@RequestBody Tododto tododto) {
        
        Tododto tododtos = todoService.addTodo(tododto);
        //todoService.addTodo(tododto);
        return new ResponseEntity<>(tododtos,HttpStatus.CREATED);
       //return new ResponseEntity<>("success",HttpStatus.CREATED);
    }
    @GetMapping("{id}")
    public ResponseEntity<Tododto> getTodo(@PathVariable("id") int id){
        Tododto tododto = todoService.getTodo(id);
        
        return new ResponseEntity<>(tododto,HttpStatus.OK);

    }
   @GetMapping()
   public ResponseEntity<List<Tododto>> getTodoAll()
   {
    List<Tododto> tododtos = todoService.getTodoAll();
    return new ResponseEntity<>(tododtos,HttpStatus.OK);
   }
   @PutMapping("update/{id}")
   public ResponseEntity<Tododto> updateTodo(@PathVariable("id") int id,@RequestBody Tododto tododto)
   {
    Tododto uptododto = todoService.updateTodo(id,tododto);
      return new ResponseEntity<>(uptododto,HttpStatus.OK);
   }
   @DeleteMapping("delete/{id}")
   public ResponseEntity<String>updateTodo(@PathVariable("id") int id)
   {
    todoService.deleteTodo(id);
    return new ResponseEntity<>("Deleted Successfully",HttpStatus.OK);
   }
   @PatchMapping("{id}/complete")
   public ResponseEntity<String>completeTodo(@PathVariable("id") int id)
   {
    todoService.completeTodo(id);
    return new ResponseEntity<>("set to complete",HttpStatus.OK);
   }
   @PatchMapping("{id}/incomplete")
   public ResponseEntity<String>incompleteTodo(@PathVariable("id") int id)
   {
    todoService.IncompleteTodo(id);
    return new ResponseEntity<>("set to Incomplete",HttpStatus.OK);
   }

    
}
