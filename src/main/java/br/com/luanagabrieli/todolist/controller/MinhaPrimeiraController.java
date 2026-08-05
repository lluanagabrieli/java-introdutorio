package br.com.luanagabrieli.todolist.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("primeiraRota")
// http://localhost:8080/primeiraRota
public class MinhaPrimeiraController {

    // Modificadores
    // Public: significa que o método é acessível de qualquer lugar do código. 
    // Private: significa que o método só é acessível dentro da própria classe. 
    // Protected: significa que o método é acessível dentro do mesmo pacote e subclasses. 
    // Default (sem modificador): significa que o método é acessível apenas dentro do mesmo pacote.

    // Tipo de retorno: é o tipo de dado que o método retorna. Pode ser um tipo primitivo (int, double, boolean, etc.) ou um tipo de objeto (String, List, etc.). Se o método não retorna nenhum valor, o tipo de retorno é void.

    // Nome do método: é o nome que você dá ao método. Deve ser um nome descritivo que indique o que o método faz. O nome do método deve começar com uma letra minúscula e seguir a convenção camelCase.

    // Parâmetros: são os valores que você passa para o método. Eles são definidos entre parênteses após o nome do método. Cada parâmetro deve ter um nome e um tipo. Se o método não recebe nenhum parâmetro, os parênteses ficam vazios.

    /* MÉTODOS DE ACESSO DO HTTP
        GET - Buscar uma informação
        POST - Adicionar um dado/informação
        PUT - Alterar um dado/informação
        DELETE - Remover um dado/informação
        PATCH - Atualizar parcialmente um dado/informação
    */

    // Método (Funcionalidade) de uma classe
    @GetMapping("")
    public String primeiraMensagem() {
        return "Olá, esta é a minha primeira mensagem!";
    }
}
