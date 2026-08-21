package br.com.luanagabrieli.todolist.task;

import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import jakarta.servlet.http.HttpServletRequest;

@RestController
@RequestMapping("/tasks")
public class TaskController {

    // Outra forma de injetar um controller através do constructor
    // private final ITaskRepository taskRepository;

    // public TaskController(ITaskRepository taskRepository) {
    //     this.taskRepository = taskRepository;
    // }

    @Autowired
    private ITaskRepository taskRepository;

   @PostMapping("/")
    public TaskModel create(@RequestBody TaskModel taskModel, HttpServletRequest request) {
        // Pega o atributo userId do request do servlet e seta no objeto taskModel diretamente
        taskModel.setUserId((UUID)request.getAttribute("userId"));

        var task = this.taskRepository.save(taskModel);
        return task;
    }
}
