package br.com.luanagabrieli.todolist.user;

import java.time.LocalDateTime;
import java.util.UUID;

import org.hibernate.annotations.CreationTimestamp;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import lombok.Data;

// Insere getters automaticamente para todos os atributos
//@Getter

// Insere getters e setters automaticamente para todos os atributos, não precisa mais escrever manualmente
@Data
@Entity(name="tb_users") // Nome da tabela no banco de dados. Foi inserido o "tb_" para diferenciar das tabelas do H2. Quando falamos em entidade estamos nos referindo a uma classe que representa uma tabela no banco de dados.
public class UserModel {
    // Quando eu não coloco o modificador, ele é considerado public, mas só é acessível dentro do mesmo pacote
    //quanto é private, só é acessível dentro da própria classe
    private String username;
    private String name;
    private String password;

    @GeneratedValue(generator = "UUID") // Gera um valor automaticamente para o id, no caso um UUID
    @Id // Chave primária da tabela. A importação do Id é do jakarta.persistence.Id.
    private UUID id;

    @CreationTimestamp // Insere a data e hora atual automaticamente quando o registro é criado
    private LocalDateTime createdAt;
}
