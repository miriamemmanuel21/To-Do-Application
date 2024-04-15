package com.semicolon.ToDoApplication.Service;

import com.semicolon.ToDoApplication.Entity.ToDo;
import com.semicolon.ToDoApplication.dtos.ToDodto;

import java.util.List;

public interface ToDoService {
    String addNewToDo(ToDodto toDo);

    List<ToDo> getToDos();

    String deleteToDo(Long toDoid);


    ToDo updateToDo(Long toDoid, ToDodto Status);
}

