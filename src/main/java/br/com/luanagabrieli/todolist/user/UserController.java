package br.com.luanagabrieli.todolist.user;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

// O nome da classe precisa ser o mesmo do arquivo
// Modificadores de acesso: public, private, protected

@RestController
@RequestMapping("/users")
public class UserController {

    @PostMapping("/create")
    public void create(@RequestBody UserModel userModel) {
        System.out.println(userModel.getName());
    }
}
