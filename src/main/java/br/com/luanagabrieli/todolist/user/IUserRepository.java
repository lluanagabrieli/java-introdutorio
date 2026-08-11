 // interface: é um contrato que define um conjunto de métodos que uma classe deve implementar
package br.com.luanagabrieli.todolist.user;

import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;


// <> o primeiro parâmetro é a classe que representa a entidade, o segundo parâmetro é o tipo do id da entidade
// // JpaRepository já possui métodos prontos para salvar, buscar, deletar e atualizar no banco de dados
public interface IUserRepository extends JpaRepository <UserModel, UUID> { 
    UserModel findByUsername(String username);
}
