package br.com.luanagabrieli.todolist.filter;

import java.io.IOException;

import org.springframework.stereotype.Component;

import jakarta.servlet.Filter;
import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.ServletRequest;
import jakarta.servlet.ServletResponse;

@Component // faz o gerenciamento da classe pelo Spring, permitindo que ela seja injetada em outros componentes da aplicação
// o servlet é a base para aplicações web em Java, sendo responsável por receber as requisições HTTP e enviar as respostas HTTP

// Toda requisição vai passar pelo filtro antes de chegar no controller, permitindo que você execute alguma ação antes de processar a requisição
public class FilterTaskAuth implements Filter {

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
        throws IOException, ServletException {
        // Executar alguma ação

            System.out.println("Chegou no filtro");
            chain.doFilter(request, response); // Passa a requisição para o próximo filtro ou servlet
        }
    
}
