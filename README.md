# Energia Rural API

## Descrição do Projeto

A **Energia Rural API** é uma aplicação desenvolvida para calcular e armazenar dados sobre consumo e retorno financeiro de sistemas fotovoltaicos voltados para propriedades rurais. Este projeto foi desenvolvido como parte da disciplina **Java Advanced**, utilizando **Spring Boot**, **Hibernate**, **REST API** e conectando-se a um banco de dados **Oracle**.

---

## Funcionalidades Principais

- **Cadastro de Usuários:** Gerenciamento de usuários do sistema (CRUD).
- **Simulações de Consumo:** Inserção e cálculo de consumo médio de energia elétrica com base em informações fornecidas.
- **Histórico de Simulações:** Listagem e exclusão de cálculos anteriores para facilitar a gestão.
- **Integração com Swagger:** Documentação da API para facilitar o uso por desenvolvedores.

---

## Tecnologias Utilizadas

- **Java 17 ou Superior**
- **Spring Boot 3.3.5**
- **Hibernate/JPA**
- **Banco de Dados Oracle**
- **Swagger/OpenAPI**
- **Postman** para testes manuais

---

## Estrutura do Projeto

O projeto segue a arquitetura padrão MVC:

- `Entities`: Contém as classes de modelo do sistema, como **Usuario** e **Simulacao**, com mapeamento JPA.
- `Controllers`: Controladores REST para lidar com requisições HTTP.
- `Services`: Contém a lógica de negócios.
- `Repositories`: Camada de acesso a dados, implementada com Spring Data JPA.
- `Migrations`: Configurações e scripts de migração para o banco de dados.
- `Resources`: Configurações de aplicação, como o arquivo `application.properties`.

---

## Imagens do Sistema

### Tela Inicial
![appbemvindo.png](images%2Fappbemvindo.png)

### Tela de Login
![applogin.png](images%2Fapplogin.png)

### Tela de Inserção de Dados
![appinserirdados.png](images%2Fappinserirdados.png)

### Tela de Histórico de Cálculos
![apphistorico.png](images%2Fapphistorico.png)

### Tela de Editar Dados
![appeditardados.png](images%2Fappeditardados.png)

---

## Configuração do Projeto

1. **Clone o repositório:**

   ```bash
   
   git clone https://github.com/luizalec7/energia-rural-api.git

2. **Configuração do application.properties:**

Comentar o código do deploy quando iniciar a api local, e comentar o local quando realizar o deploy:


![img.png](img.png)

## Link do DEPLOY

    https://energia-rural-api.onrender.com

1. **Como testar:**

Com o postman, testar todos os Posts e Gets:

## Resumo dos Endpoints

| Endpoint        | Método | Descrição                          |
|-----------------|--------|------------------------------------|
| `/usuarios`     | GET    | Lista todos os usuários (se houver). |
| `/usuarios`     | POST   | Cria um novo usuário.              |
| `/paineis`      | GET    | Lista todos os painéis.            |
| `/paineis`      | POST   | Cria um novo painel.               |
| `/localizacoes` | GET    | Lista todas as localizações.       |
| `/localizacoes` | POST   | Cria uma nova localização.         |
| `/simulacoes`   | POST   | Cria uma nova simulação.           |

## Link do Vídeo demonstrativo do projeto Energia Rural API

https://www.youtube.com/watch?v=z6nGSC68r04