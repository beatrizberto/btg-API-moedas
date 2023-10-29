# API de Compra de Moedas

Este é um projeto que implementa uma API que gera uma ordem de compra das moedas estrangeiras USD (dólar) e EUR (euro). A API permite que os clientes criem contas e solicitem ordens de compra dessas moedas.

## API Externa de Cotação de Moedas

Este projeto consome uma API externa para obter cotações de moedas estrangeiras. A API externa usada é a [Awesome API de Economia](https://economia.awesomeapi.com.br/). Ela fornece cotações em tempo real para várias moedas, incluindo o dólar (USD) e o euro (EUR). A aplicação realiza chamadas apropriadas a esta API para obter cotações atualizadas das moedas.

### URLs da API externa:

- [Cotação do Dólar (USD)](https://economia.awesomeapi.com.br/USD/)
- [Cotação do Euro (EUR)](https://economia.awesomeapi.com.br/EUR/)

## Requisitos

- Java SDK 17 ou superior
- Maven
- Dependências do Maven (gerenciadas pelo arquivo `pom.xml`)

## Dependências

- [Spring Boot](https://spring.io/projects/spring-boot): Framework para criação de aplicativos Java.
- [Spring Boot Starter Data JPA](https://spring.io/guides/gs/accessing-data-jpa/): Starter para integração com o Spring Data JPA.
- [Spring Boot Starter Web](https://spring.io/guides/gs/spring-boot/): Starter para criação de aplicativos da web com o Spring Boot.
- [Lombok](https://projectlombok.org/): Biblioteca para reduzir a verbosidade do código Java.
- [H2 Database](https://www.h2database.com/html/main.html): Banco de dados em memória para desenvolvimento e teste.

## Executando o Projeto

Clone o repositório do projeto.

Abra o projeto em sua IDE.

Execute a aplicação Spring Boot.

Acesse a API através dos endpoints definidos para realizar operações CRUD e criar ordens de compra.

#Endpoints

POST /cliente: Cria um novo cliente.

GET /cliente/cpf/{cpf}: Obtém informações do cliente com base no CPF.

GET /cliente/id/{id}: Obtém informações do cliente com base no Id.

PUT /cliente/id/{id}: Atualiza informações do cliente existente.

DELETE /cliente/id/{id}: Exclui um cliente existente.

POST /ordens-compra: Cria uma nova ordem de compra de moeda estrangeira.

GET /ordens-compra/{id}: Obtém informações do cliente com base no ID.

PUT /ordens-compra/{id}: Atualiza informações de uma ordem de compra.

DELETE /ordens-compra/{id}: Cancela uma ordem de compra existente.

## Protótipo de Tela

[Confira o protótipo de tela do projeto](https://www.figma.com/proto/CDe7zjO19vEQkhBEoW4jEN/Untitled?type=design&node-id=3-2&t=q8tCrvRvqS9LRfJ2-0&scaling=min-zoom&page-id=0%3A1&starting-point-node-id=3%3A2)


## Participantes

- Beatriz Berto
- Bruna Torres
- Fernanda Soares
- Jessica Alves
- Jessica Lima
- Luciana Oliveira

## Gerenciamento de Projeto

Acompanhamos o progresso deste projeto utilizando o Trello.
[Trello - Quadro do Projeto](https://trello.com/b/n9V90o5R/projeto-api-moedas-m%C3%B3dulo-iv)



