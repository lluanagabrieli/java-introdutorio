# Camadas

1. Repository
2. Controller
3. Model

## 1. Repository

Responsável pelo acesso aos dados no banco de dados.

Nele, criamos interfaces que podem estender o JpaRepository,
que fornece diversos métodos prontos, como findById, findAll,
save e delete, sem a necessidade de implementá-los manualmente.

Também podemos criar métodos personalizados, como findByUsername,
e o Spring Data JPA gera sua implementação automaticamente.

## 2. Controller

Responsável por receber e responder às requisições HTTP.

Nele ficam os endpoints (GET, POST, PUT, DELETE, etc.), além
do recebimento e encaminhamento dos dados da requisição.

Em uma arquitetura mais completa, o Controller normalmente
chama uma camada Service, que contém as regras de negócio,
e o Service utiliza o Repository para acessar o banco.

## 3. Model

Representa a estrutura dos dados da aplicação.

Possui os atributos do objeto e, quando utilizado com JPA,
pode representar uma entidade/tabela do banco de dados.

---

# Incrementos

1. Errors
2. Filter
3. Utils

## 1. Errors

Responsável pelo tratamento centralizado das exceções da aplicação.

Permite interceptar erros e retornar respostas padronizadas
e mais amigáveis para o cliente, evitando a exposição de
detalhes técnicos.

## 2. Filter

É executado antes do processamento normal da requisição,
permitindo realizar ações antes que ela chegue ao Controller.

No projeto, o Filter:

- Verifica a rota atual;
- Obtém o Authorization do Header;
- Trata o conteúdo do Authorization;
- Remove o prefixo de autenticação;
- Decodifica as credenciais;
- Separa username e password;
- Busca o usuário no banco através do findByUsername;
- Verifica se o usuário existe;
- Valida a senha;
- Se a autenticação for válida, adiciona o userId na request;
- Caso contrário, retorna um erro.

## 3. Utils

Contém métodos utilitários que podem ser reutilizados
em diferentes partes da aplicação.

Atualmente, possui um método utilizado para atualizações
parciais de objetos, identificando os campos nulos do objeto
recebido e mantendo nesses campos os valores que já existem
no objeto original.