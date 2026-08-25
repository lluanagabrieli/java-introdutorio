package br.com.luanagabrieli.todolist.task;

import java.time.LocalDateTime;
import java.util.UUID;

import org.hibernate.annotations.CreationTimestamp;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import lombok.Data;

/***
     * ID
     * Usuário (ID_USUARIO)
     * Descrição
     * Título
     * Data de Início
     * Data de Término
     * Prioridade
     * 
*/

@Data
@Entity(name = "tb_tasks")
public class TaskModel {

    @Id
    @GeneratedValue(generator = "UUID")
    private UUID id;

    private String description;

    @Column(length = 50)
    private String title;
    
    private LocalDateTime startAt;
    private LocalDateTime endAt;
    private String priority;
    private UUID userId;

    @CreationTimestamp
    private LocalDateTime createdAt;

    // Se deixar somente dessa forma, retorna um bad request com uma mensagem no terminal: Resolved [org.springframework.http.converter.HttpMessageNotReadableException: JSON parse error: O campo título deve conter no máximo 50 caracteres]

    // Para retornar o erro de forma customizada para o usuário, foi criado uma classe na pasta errors para tratar essas excessões
    public void setTitle(String title) throws Exception {
        if(title.length() > 50) {
            throw new Exception("O campo título deve conter no máximo 50 caracteres");
        }

        this.title = title;
    }
}
