package br.com.luanagabrieli.todolist.user;

import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import br.com.luanagabrieli.todolist.user.IUserRepository;
import br.com.luanagabrieli.todolist.user.UserModel;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.PathVariable;


// O nome da classe precisa ser o mesmo do arquivo
// Modificadores de acesso: public, private, protected

@RestController
@RequestMapping("/users")
public class UserController {

    // chamando a interface IUserRepository para poder usar os métodos que ela possui, como o save() que salva no banco de dados
    @Autowired // injeta a dependência do IUserRepository, ou seja, cria uma instância da interface para poder usar os métodos que ela possui
    private IUserRepository userRepository;

    @PostMapping("/create")
    public UserModel create(@RequestBody UserModel userModel) {
        var userCreated = this.userRepository.save(userModel); // salva o usuário no banco de dados
        return userCreated; // retorna o usuário criado
    }
}
