package br.com.luanagabrieli.todolist.user;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/users")
public class UserController {
    @Autowired
    private IUserRepository userRepository;

    @PostMapping("/create")
    public UserModel create(@RequestBody UserModel userModel) {
        var verificaUsername = userRepository.findByUsername(userModel.getUsername());
        System.out.println(verificaUsername);

        if(verificaUsername != null) {
            System.out.println("Username já existe");
            return null;
        }

        var userCreated = this.userRepository.save(userModel);
        return userCreated;
    }
}
