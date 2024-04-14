package com.semicolon.ToDoApplication.Service;

import com.semicolon.ToDoApplication.Repository.ToDoRepository;
import com.semicolon.ToDoApplication.Entity.ToDo;
import com.semicolon.ToDoApplication.dtos.ToDodto;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ToDoServiceImpl  implements ToDoService{
private final ModelMapper modelMapper;
    private final ToDoRepository toDoRepository;

    public ToDoServiceImpl(ModelMapper modelMapper, ToDoRepository toDoRepository) {
        this.modelMapper = modelMapper;
        this.toDoRepository = toDoRepository;
    }

    public List<ToDo> getToDos() {
        return toDoRepository.findAll();

    }

    @Override
    public String deleteToDo(Long toDoid) {
        boolean exists = toDoRepository.existsById(toDoid);
        if (!exists) {
            throw new IllegalStateException("toDo with id" + toDoid + " dose not exists");
        }
        toDoRepository.deleteById(toDoid);

    return "To-Do delete successfully";
    }

    public String addNewToDo(ToDodto toDodto) {
        Optional<ToDo> toDoOptional;
        toDoOptional = toDoRepository.findToDoByTaskName(toDodto.getTaskName());
        if (toDoOptional.isPresent()) {
            throw new IllegalStateException("taskName already exist");
        }

        ToDo todo = modelMapper.map(toDodto, ToDo.class);


        toDoRepository.save(todo);
return "To-Do added successfully";
    }
}

