package com.semicolon.ToDoApplication.dtos;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class ToDodto {
    private String taskName;
    private String priority;
    private String status;
    private LocalDate dueDate;
    private String notes;

//    public ToDodto() {
//    }
//
//    public ToDodto(
//                String taskName,
//                String priority,
//                String status,
//                LocalDate dueDate,
//                String notes) {
//        this.taskName = taskName;
//        this.priority = priority;
//        this.status = status;
//        this.dueDate = dueDate;
//        this.notes = notes;
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
//    public String getStatus() {
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

}

//
//
//
