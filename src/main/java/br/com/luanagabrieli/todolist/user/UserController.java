package br.com.luanagabrieli.todolist.user;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import at.favre.lib.crypto.bcrypt.BCrypt;

@RestController
@RequestMapping("/users")
public class UserController {
    @Autowired
    private IUserRepository userRepository;

    @PostMapping("/create")
    public ResponseEntity create(@RequestBody UserModel userModel) {
        var verificaUsername = userRepository.findByUsername(userModel.getUsername());

        if(verificaUsername != null) {
            // mensagem de erro
            // retornar o status code

            // ResponseEntity é uma classe que já trás as respostas HTTP prontas, como status code, headers e body
            // dentro do status pode passar o código diretamente ou utilizar o HttpStatus. Se clicar nele é possível consultar os status disponíveis
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Usuário já existe");
        }

        // Hash da senha utilizando a biblioteca BCrypt
        // Pega a senha, transorma em um array de char ['S', 'e', 'n', 'h', 'a'],gera o hash com 12 rounds de complexidade (o quanto deve trabalhar para calcular o hash) e retorna o hash em string. O hash é armazenado no banco de dados, não a senha original.
        var passwordHashed = BCrypt.withDefaults().hashToString(12, userModel.getPassword().toCharArray());
        userModel.setPassword(passwordHashed);

        var userCreated = this.userRepository.save(userModel);
        return ResponseEntity.status(HttpStatus.OK).body(userCreated);
    }
}
