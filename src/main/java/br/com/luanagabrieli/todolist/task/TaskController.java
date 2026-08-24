package br.com.luanagabrieli.todolist.task;

import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
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
    public ResponseEntity create(@RequestBody TaskModel taskModel, HttpServletRequest request) {
        // Pega o atributo userId do request do servlet e seta no objeto taskModel diretamente
        var userId = request.getAttribute("userId");
        taskModel.setUserId((UUID) userId);

        var currentDate = LocalDateTime.now();
        // Data atual
        // startAt
        // endAt

        // A data de término e nem de início podem ser anteriores a hoje
        if(taskModel.getStartAt().isBefore(currentDate) || taskModel.getEndAt().isBefore(currentDate)) {
            return (ResponseEntity) ResponseEntity.status(HttpStatus.BAD_REQUEST).body("A data de inicio/término deve ser maior que a data atual");
        }

        // A data de término não pode ser anterior a data de início
        if(taskModel.getEndAt().isBefore(taskModel.getStartAt())) {
            return (ResponseEntity) ResponseEntity.status(HttpStatus.BAD_REQUEST).body("A data de início deve ser antes da data de término");
        }

        var task = this.taskRepository.save(taskModel);
        
        return ResponseEntity.status(HttpStatus.OK).body(task);
    }

    @GetMapping("/")
    public List<TaskModel> list(HttpServletRequest request) {
        var userId = request.getAttribute("userId");

        var tasks = this.taskRepository.findByUserId((UUID) userId);

        return tasks;
    }

    @PutMapping("/{id}")
    public TaskModel update(@RequestBody TaskModel taskModel, @PathVariable UUID id, HttpServletRequest request) {
        // Pegar o userId
        // Setar no taskmodel
        // Salvar o novo taskModel
        var userId = request.getAttribute("userId");
        taskModel.setUserId((UUID) userId);
        // É preciso setar o id da task que vem na rota, se não outro id é gerado automaticamente
        taskModel.setId(id);

        return this.taskRepository.save(taskModel);
    }
}
