package com.project.ToDo.ToDo.controller;

import com.project.ToDo.ToDo.dto.ToDoDto;
import com.project.ToDo.ToDo.service.ToDoService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@AllArgsConstructor
@RequestMapping("/api/v1/todo")
public class ToDoController {

    private ToDoService toDoService;

    @PostMapping("/create")
    public ResponseEntity<ToDoDto> addToDo(@RequestBody ToDoDto toDoDto){
        ToDoDto savedDto = toDoService.add(toDoDto);
        return new ResponseEntity<>(savedDto, HttpStatus.CREATED);
    }

    @GetMapping("/{id}")
    public ResponseEntity<ToDoDto> getToDo(@PathVariable Long id){
        ToDoDto toDoDto = toDoService.getById(id);
        return ResponseEntity.ok(toDoDto);
    }

    @GetMapping("/all")
    public ResponseEntity<List<ToDoDto>> getAll(){
        List<ToDoDto> todos = toDoService.getAll();
        return ResponseEntity.ok(todos);
    }

}
