 // interface: é um contrato que define um conjunto de métodos que uma classe deve implementar
package br.com.luanagabrieli.todolist.user;

import java.util.UUID;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IUserRepository extends JpaRepository <UserModel, UUID> { 
    UserModel findByUsername(String username);
}
