package com.semicolon.ToDoApplication.Controller;

import com.semicolon.ToDoApplication.Service.ToDoService;
import com.semicolon.ToDoApplication.Service.ToDoServiceImpl;
import com.semicolon.ToDoApplication.Entity.ToDo;
import com.semicolon.ToDoApplication.dtos.ToDodto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping (path = "api/v1/ToDo")
public class ToDoController {

    private final ToDoService toDoService;

    @Autowired
    public ToDoController(ToDoServiceImpl toDoService) {
        this.toDoService = toDoService;
    }


    @GetMapping
    public List<ToDo> getToDos() {
        return toDoService.getToDos();

    }

    @PostMapping
    public String registerNewToDo(@RequestBody ToDodto toDo) {
        return toDoService.addNewToDo(toDo);
    }

    @DeleteMapping( "/{toDoId}")
    public String deleteToDo(@PathVariable Long toDoId) {
        return toDoService.deleteToDo(toDoId);
    }

    }

