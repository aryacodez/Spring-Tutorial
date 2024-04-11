package com.project.ToDo.ToDo.controller;

import com.project.ToDo.ToDo.dto.ToDoDto;
import com.project.ToDo.ToDo.service.ToDoService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@AllArgsConstructor
@RequestMapping("/api/v1/todo")
public class ToDoController {

    private ToDoService toDoService;

    @PreAuthorize("hasRole('ADMIN')")
    @PostMapping("/create")
    public ResponseEntity<ToDoDto> addToDo(@RequestBody ToDoDto toDoDto){
        ToDoDto savedDto = toDoService.add(toDoDto);
        return new ResponseEntity<>(savedDto, HttpStatus.CREATED);
    }

    @PreAuthorize("hasAnyRole('ADMIN','USER')")
    @GetMapping("/{id}")
    public ResponseEntity<ToDoDto> getToDo(@PathVariable Long id){
        ToDoDto toDoDto = toDoService.getById(id);
        return ResponseEntity.ok(toDoDto);
    }

    @PreAuthorize("hasAnyRole('ADMIN','USER')")
    @GetMapping("/all")
    public ResponseEntity<List<ToDoDto>> getAll(){
        List<ToDoDto> todos = toDoService.getAll();
        return ResponseEntity.ok(todos);
    }

    @PreAuthorize("hasRole('ADMIN')")
    @PutMapping("/update/{id}")
    public ResponseEntity<ToDoDto> updatedToDo(@RequestBody ToDoDto toDoDto,@PathVariable Long id){
        ToDoDto updatedData = toDoService.updateToDo(toDoDto,id);
        return ResponseEntity.ok(updatedData);
    }

    @PreAuthorize("hasRole('ADMIN')")
    @DeleteMapping("/delete/{id}")
    public ResponseEntity<String> delete(@PathVariable("id") Long iid){
        toDoService.deleteToDo(iid);
        return ResponseEntity.ok("Deleted Successfully");
    }

    @PreAuthorize("hasAnyRole('ADMIN','USER')")
    @PatchMapping("/completed/{id}")
    public ResponseEntity<ToDoDto> completed(@PathVariable Long id){
        ToDoDto updated = toDoService.completeToDo(id);
        return ResponseEntity.ok(updated);
    }

    @PreAuthorize("hasAnyRole('ADMIN','USER')")
    @PatchMapping("/incomplete/{id}")
    public ResponseEntity<ToDoDto> incomplete(@PathVariable Long id){
        ToDoDto toDoDto = toDoService.incompleteToDo(id);
        return ResponseEntity.ok(toDoDto);
    }

}
