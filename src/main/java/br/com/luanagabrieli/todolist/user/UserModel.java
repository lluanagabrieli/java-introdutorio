package br.com.luanagabrieli.todolist.user;

import lombok.Data;

// Insere getters automaticamente para todos os atributos
//@Getter

// Insere getters e setters automaticamente para todos os atributos, não precisa mais escrever manualmente
@Data
public class UserModel {
    // Quando eu não coloco o modificador, ele é considerado public, mas só é acessível dentro do mesmo pacote
    //quanto é private, só é acessível dentro da própria classe
    private String username;
    private String name;
    private String password;
}
