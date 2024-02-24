package com.project.ToDo.ToDo.service;

import com.project.ToDo.ToDo.dto.ToDoDto;

import java.util.List;

public interface ToDoService {
    ToDoDto add(ToDoDto toDoDto);
    ToDoDto getById(Long id);

    List<ToDoDto> getAll();

    ToDoDto updateToDo(ToDoDto toDoDto,Long id);

    void deleteToDo(Long id);

    ToDoDto completeToDo(Long id);

    ToDoDto incompleteToDo(Long id);

}
