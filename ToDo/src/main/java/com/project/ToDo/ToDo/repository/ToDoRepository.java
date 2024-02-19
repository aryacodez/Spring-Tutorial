package com.project.ToDo.ToDo.repository;

import com.project.ToDo.ToDo.entity.ToDo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ToDoRepository extends JpaRepository<ToDo,Long> {
}
