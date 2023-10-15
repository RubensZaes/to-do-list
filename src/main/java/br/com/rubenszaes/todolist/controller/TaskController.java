package br.com.rubenszaes.todolist.controller;

import br.com.rubenszaes.todolist.model.TaskModel;
import br.com.rubenszaes.todolist.respository.TaskRepository;
import io.swagger.v3.oas.annotations.Operation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/tasks")
public class TaskController {

    @Autowired
    private TaskRepository taskRepository;
    @Operation(tags = "Tasks", summary = "Criar nova task.")
    @PostMapping()
    public TaskModel create(@RequestBody TaskModel taskModel){
        var task = taskRepository.save(taskModel);
        return task;
    }
}
