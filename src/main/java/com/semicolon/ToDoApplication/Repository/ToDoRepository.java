package com.semicolon.ToDoApplication.Repository;

import com.semicolon.ToDoApplication.Entity.ToDo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import java.util.Optional;

@Repository
public interface ToDoRepository extends JpaRepository<ToDo, Long> {
    @Query ("SELECT s FROM ToDo s WHERE s.taskName = ?1")
    Optional<ToDo> findToDoByTaskName(String taskName);

}
