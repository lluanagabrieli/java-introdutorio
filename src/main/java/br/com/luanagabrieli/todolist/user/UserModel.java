package br.com.luanagabrieli.todolist.user;

public class UserModel {
    // Quando eu não coloco o modificador, ele é considerado public, mas só é acessível dentro do mesmo pacote
    //quanto é private, só é acessível dentro da própria classe
    private String username;
    private String name;
    private String password;

    // Getters e Setters
    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
