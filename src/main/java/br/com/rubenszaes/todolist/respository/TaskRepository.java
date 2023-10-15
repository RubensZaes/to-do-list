package br.com.rubenszaes.todolist.respository;

import br.com.rubenszaes.todolist.model.TaskModel;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface TaskRepository extends JpaRepository<TaskModel, UUID> {
}
