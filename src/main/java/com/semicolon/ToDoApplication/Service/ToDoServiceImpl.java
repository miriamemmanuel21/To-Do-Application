package com.semicolon.ToDoApplication.Service;

import com.semicolon.ToDoApplication.Repository.ToDoRepository;
import com.semicolon.ToDoApplication.Entity.ToDo;
import com.semicolon.ToDoApplication.dtos.ToDodto;
import jakarta.transaction.Transactional;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;
import java.util.Objects;
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

    @Override
    public String deleteToDo(Long toDoid) {
        boolean exists = toDoRepository.existsById(toDoid);
        if (!exists) {
            throw new IllegalStateException("toDo with id" + toDoid + " dose not exists");
        }
        toDoRepository.deleteById(toDoid);

    return "To-Do delete successfully";
    }

    @Transactional
    public ToDo updateToDo(Long toDoId, ToDodto toDodto) {
        ToDo  toDo = toDoRepository.findById(toDoId)
                .orElseThrow(() -> new IllegalStateException(
                        "toDo with id " + toDoId + " dose not exist"));

        if (toDodto.getTaskName() != null &&
                !toDodto.getTaskName().isEmpty() &&
                !Objects.equals(toDo.getTaskName(), toDodto.getTaskName())) {
            toDo.setTaskName(toDodto.getTaskName());
        }
        if (toDodto.getStatus() != null &&
                !toDodto.getStatus().isEmpty() &&
                !Objects.equals(toDo.getStatus(), toDodto.getStatus())) {
            toDo.setStatus(toDodto.getStatus());
        }
        if (toDodto.getPriority() != null &&
                !toDodto.getPriority().isEmpty() &&
                !Objects.equals(toDo.getPriority(), toDodto.getPriority())) {
            toDo.setPriority(toDodto.getPriority());
        }
        if (toDodto.getNotes() != null &&
                !toDodto.getNotes().isEmpty() &&
                !Objects.equals(toDo.getPriority(), toDodto.getNotes())) {
            toDo.setNotes(toDodto.getNotes());
        }
        if (toDodto.getDueDate() != null &&
                !toDo.getDueDate().isEqual(toDodto.getDueDate())) {
            toDo.setDueDate(toDodto.getDueDate());
        }

        return toDo;
    }


    }



