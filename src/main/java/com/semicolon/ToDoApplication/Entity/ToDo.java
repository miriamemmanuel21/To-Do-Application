package com.semicolon.ToDoApplication.Entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "todo-list")
public class ToDo {
    @Id
    @SequenceGenerator(
            name = "todo_sequence",
            sequenceName = "todo_sequence",
            allocationSize = 1
    )
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "todo_sequence"
    )
    private Long id;
    private String taskName;
    private String priority;
    private String status;
    private LocalDate dueDate;
    private String notes;

//    public ToDo() {
//    }
//
//    public ToDo(Long id,
//            String taskName,
//                String priority,
//                String status,
//                LocalDate dueDate,
//                String notes) {
//        this.id = id;
//        this.taskName = taskName;
//        this.priority = priority;
//        this.status = status;
//        this.dueDate = dueDate;
//        this.notes = notes;
//    }
//
//    public Long getId() {
//        return id;
//    }
//
//    public void setId(Long id) {
//        this.id = id;
//    }
//
//    public  String getTaskName() {
//        return taskName;
//    }
//
//    public void setTaskName(String taskName) {
//        this.taskName = taskName;
//    }
//
//    public String getPriority() {
//        return priority;
//    }
//
//    public void setPriority(String priority) {
//        this.priority = priority;
//    }
//
//    public String isStatus() {
//        return status;
//    }
//
//    public void setStatus(String status) {
//        this.status = status;
//    }
//
//    public LocalDate getDueDate() {
//        return dueDate;
//    }
//
//    public void setDueDate(LocalDate dueDate) {
//        this.dueDate = dueDate;
//    }
//
//    public String getNotes() {
//        return notes;
//    }
//
//    public void setNotes(String notes) {
//        this.notes = notes;
//    }
//
//    @Override
//    public String toString() {
//        return "ToDoList{" +
//                "Id='" + id + '\''+
//                "taskName='" + taskName + '\'' +
//                ", priority=" + priority +
//                ", status=" + status +
//                ", dueDate=" + dueDate +
//                ", notes='" + notes + '\'' +
//                '}';
//    }
}



