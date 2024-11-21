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