package br.com.luanagabrieli.todolist.filter;

import java.io.IOException;
import java.util.Base64;

import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@Component // faz o gerenciamento da classe pelo Spring, permitindo que ela seja injetada em outros componentes da aplicação
// o servlet é a base para aplicações web em Java, sendo responsável por receber as requisições HTTP e enviar as respostas HTTP

// Toda requisição vai passar pelo filtro antes de chegar no controller, permitindo que você execute alguma ação antes de processar a requisição

// Filter: é mais genérico e pode ser usado fora do Spring, precisando controlar mais detalhes
// public class FilterTaskAuth implements Filter {

//     @Override
//     public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
//         throws IOException, ServletException {
//         // Executar alguma ação

//             System.out.println("Chegou no filtro");
//             chain.doFilter(request, response); // Passa a requisição para o próximo filtro ou servlet
//         }
    
// }

// OncePerRequestFilter: mais específico para o Spring, facilitando o controle
public class FilterTaskAuth extends OncePerRequestFilter {

    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain)
        throws ServletException, IOException {
            // Executar alguma ação
            System.out.println("Chegou no filtro");

            // Pegar a autenticação (usuario e senha)
            var authorization = request.getHeader("Authorization"); // Pega o header da requisição. Exemplo: Basic dXNlcjasdNzd29yZA==

            var authEncoded = authorization.substring("Basic".length()).trim(); // Pega o usuario e senha do header, removendo a palavra "Basic" e os espaços em branco. Exemplo: dXNlcjasdNzd29yZA==

            byte[] authDecoded = Base64.getDecoder().decode(authEncoded); // Decodifica o usuario e senha do header. Exemplo: [B@1a2b3c4d5e6f7g8h9i0j]

            var authString = new String(authDecoded); // Converte o array de bytes para String. Exemplo: user:password

            String[] credentials = authString.split(":"); // Separa o usuario e senha pelo caractere ":" Exemplo: [user, password]
            String username = credentials[0]; // Pega o usuario no indice 0 do array
            String password = credentials[1]; // Pega a senha no indice 1 do array


            // Validar usuario

            // Validar senha

            // Segue viagem
            filterChain.doFilter(request, response); // Passa a requisição para o próximo filtro ou servlet
        }
}
