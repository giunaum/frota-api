# CRUD CLIENTE API

## Objetivo

- Adaptar o layout proposto para ser responsivo, considerando mobile-first para ajudar você pode utilizar frameworks CSS (bootstrap, angular material, clarity, etc) e seguindo o guide e padrões definidos.
- Integrar os dados na tela utilizando a API criados por você no teste de backend;
- Implementar busca por placa ao clicar no icone de editar e carregar dados do veiculo;
- Implementar filtro de busca por placa do veículo e atualizar tabela;
- Implementar a lógica de paginação para carregar 10 itens por página (5 paginas o total maximo que a API retorna);
- Deve ser feito utilizando Angular 8+ e pré-processador SCSS;

## Tecnologias Utilizadas

- Java 11
- Spring Boot 2.4.1
- Spring Data MongoDB 2.4.1
- Banco noSQL MongoDB
- Swagger 3.0.0

## Configurações

O banco de dados MongoDB está configurado e apontando para um endereço sandbox SAAS.

spring.data.mongodb.uri: mongodb+srv://admin:admin@cluster0.juzu4.mongodb.net/frotaapi?retryWrites=true&w=majority

## Testar a API

A API está com o swagger configurado, basta acessar pelo navegador o endereço: *http://localhost:8080/api/frota/swagger-ui/*.

Outra alternativa para testar a API é usando o Insomnia ou Postman.

## Dificultades

A forma de testes pretendida era usar o MongoDB in memory, apesar de ter exemplos de projetos particulares que obtive sucesso, mas já é uma versão antiga. Então, devido ao tempo utilizei o Mockito, ficando o uso o MangoDB in memory para uma solução futura.
A cobertura de testes não foi completa devido ao prazo, mas ficando para uma conclusão futura.