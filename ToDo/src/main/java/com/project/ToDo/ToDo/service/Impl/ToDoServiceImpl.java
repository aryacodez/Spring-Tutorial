package com.project.ToDo.ToDo.service.Impl;

import com.project.ToDo.ToDo.dto.ToDoDto;
import com.project.ToDo.ToDo.entity.ToDo;
import com.project.ToDo.ToDo.exception.ResourceNotFoundExeption;
import com.project.ToDo.ToDo.repository.ToDoRepository;
import com.project.ToDo.ToDo.service.ToDoService;
import lombok.AllArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class ToDoServiceImpl implements ToDoService {

    private ToDoRepository toDoRepository;
    private ModelMapper modelMapper;
    @Override
    public ToDoDto add(ToDoDto toDoDto) {
        //convert tododto into todojpa entity
        ToDo todo = modelMapper.map(toDoDto,ToDo.class);
        ToDo saved = toDoRepository.save(todo);

        //Jpa to Dto
        ToDoDto savedDto = modelMapper.map(saved,ToDoDto.class);
        return savedDto;
    }

    @Override
    public ToDoDto getById(Long id) {
        ToDo todo = toDoRepository.findById(id).orElseThrow(
                ()-> new ResourceNotFoundExeption("Data not found "+id)
        );
        return modelMapper.map(todo,ToDoDto.class);
    }

    @Override
    public List<ToDoDto> getAll() {
        List<ToDo> todos = toDoRepository.findAll();
        return todos.stream().map((todo)->modelMapper.map(todo,ToDoDto.class)).collect(Collectors.toList());
    }

    @Override
    public ToDoDto updateToDo(ToDoDto toDoDto, Long id) {
        ToDo toDo = toDoRepository.findById(id).orElseThrow(
                ()->new ResourceNotFoundExeption("Todo not found with id: "+id)
        );
        toDo.setTitle(toDoDto.getTitle());
        toDo.setDescription(toDoDto.getDescription());
        toDo.setCompleted(toDoDto.isCompleted());
        ToDo updated = toDoRepository.save(toDo);

        return modelMapper.map(updated, ToDoDto.class);
    }

    @Override
    public void deleteToDo(Long id) {
        ToDo toDo = toDoRepository.findById(id).orElseThrow(
                ()->new ResourceNotFoundExeption("Todo not found with id: "+id)
        );

        toDoRepository.deleteById(id);
    }

    @Override
    public ToDoDto completeToDo(Long id) {
        ToDo toDo = toDoRepository.findById(id).orElseThrow(
                ()->new ResourceNotFoundExeption("Todo not found with id: "+id)
        );

        toDo.setCompleted(Boolean.TRUE);

        ToDo updated = toDoRepository.save(toDo);
        return modelMapper.map(updated, ToDoDto.class);
    }

    @Override
    public ToDoDto incompleteToDo(Long id) {
        ToDo toDo = toDoRepository.findById(id).orElseThrow(
                ()->new ResourceNotFoundExeption("Todo not found with id: "+id)
        );
        toDo.setCompleted(Boolean.FALSE);
        ToDo updated = toDoRepository.save(toDo);
        return modelMapper.map(updated, ToDoDto.class);
    }
}
