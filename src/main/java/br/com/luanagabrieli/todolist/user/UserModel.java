package br.com.luanagabrieli.todolist.user;

import java.time.LocalDateTime;
import java.util.UUID;

import org.hibernate.annotations.CreationTimestamp;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import lombok.Data;

@Data
@Entity(name="tb_users")
public class UserModel {
    @Column(unique = true)
    private String username;
    private String name;
    private String password;

    @GeneratedValue(generator = "UUID")
    @Id
    private UUID id;

    @CreationTimestamp
    private LocalDateTime createdAt;
}
