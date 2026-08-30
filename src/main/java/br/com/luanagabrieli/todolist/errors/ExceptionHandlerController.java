package br.com.luanagabrieli.todolist.errors;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

// Customização dos erros de exceptions

// Toda excessão vai passar por aqui
// Vai fazer a ação da classe abaixo se a excessão for do mesmo tipo
@ControllerAdvice
public class ExceptionHandlerController {

    @ExceptionHandler(HttpMessageNotReadableException.class)
    public ResponseEntity<String> handleHttpMessageNotReadableException(HttpMessageNotReadableException exception) {
        // Deixando dessa forma, retorna a seguinte mensagem: JSON parse error: O campo título deve conter no máximo 50 caracteres
        // return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(exception.getMessage());

        // Dessa forma é retirado o JSON parse error
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(exception.getMostSpecificCause().getMessage());
    }
}
