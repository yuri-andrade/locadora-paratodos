[![Build Status](https://travis-ci.com/yuri-andrade/locadora-paratodos.svg?branch=master)](https://travis-ci.com/yuri-andrade/locadora-paratodos)
[![Quality Gate Status](https://sonarcloud.io/api/project_badges/measure?project=yuri-andrade_locadora-paratodos&metric=alert_status)](https://sonarcloud.io/dashboard?id=yuri-andrade_locadora-paratodos)
[![Maintainability Rating](https://sonarcloud.io/api/project_badges/measure?project=yuri-andrade_locadora-paratodos&metric=sqale_rating)](https://sonarcloud.io/dashboard?id=yuri-andrade_locadora-paratodos)
[![Code Smells](https://sonarcloud.io/api/project_badges/measure?project=yuri-andrade_locadora-paratodos&metric=code_smells)](https://sonarcloud.io/dashboard?id=yuri-andrade_locadora-paratodos)

<h3>Acesso ao banco em memória H2</h3>

http://localhost:8080/h2-console/

<h3>Acesso à documentação da API</h3>

http://localhost:8080/swagger-ui.html
<h4> desafio: </h4>

Você irá criar um sistema de uma locadora de filmes.
- [x] O sistema deve permitir a criação de usuários (clientes).
- [x] Logon e logoff de um usuário.
- [x] Listagem de filmes disponíveis.
- [x] Locação de um filme.
- [x] Devolução de um filme.
- [x] Pesquisa de filme pelo título.
- [x] Um filme deve possuir um título e um diretor.
- [x] A locadora pode possuir múltiplas cópias de um mesmo filme.
- [x] Um usuário deve possuir um e-mail para se identificar no sistema e um nome (para
exibição) e uma password.
- [x] O sistema pode ser acessado concorrentemente por múltiplos usuários, que
competirão pela locação dos filmes.


<h4> Autenticação: </h4>
A Autenticação implementada utilizando OAuth2.

<h4>Postman Authorization conf: </h4>
Na aba Authorization do Postman defina os parâmetros:
- Type OAuth 2.0

- Grant Type: Password Credentials

- Access Token URL: http://localhost:8080/oauth/token

- Username: admin
- Password: admin

- Client ID: desafio
- Client Secret: desafio
- Scope: password

- Client Authentication: Send as Basic Auth header

Request Token

Este é o token inicial.

<h4> Banco de dados: </h4>
Banco de dados utilizado foi o H2, para facilitar o processo de desenvolvimento, os registros iniciais de filmes já são importados automaticamente no start da aplicação.

<h3>Considerações</h3>

- Poderia ter sido adicionado a biblioteca Lombok, para reduzir a quantidade de boilerplate code.

- Evoluir a quantidade e abrangência dos testes unitários

- Poderia ter sido criada uma camada Facade entre Controller e Service para transferir as conversões de entidade para domínios de entrada e saída do controller.

- A decisão de não utilizar Javadoc foi feita com base no entendimento de que o código estava limpo e legível o suficiente para entender a responsabilidade de cada método e classe do sistema. Ele poderia somar no fonte, mas no primeiro instante ele não se fez tão necessário.

- Todo o design da aplicação poderia ter sido formulado de outra forma, com uma tabela relacionando as entidades para a verificar a disponibilidade de filmes, foi o escolhido o design atual visando a facilidade e velocidade de implementação.

- O usuário padrão admin/admin é carregado em memória na aplicação, sendo uma possível brecha na segurança.

<h3>Pontos fortes</h3>

- A utilização da biblioteca ModelMapper para facilitar as conversões dos DTOs.

- Utilização do SwaggerUI para documentar a API.

- A utilização do SonarLint em conjunto com SonarCloud para garantir as métricas de qualidade do código.

- A utilização do TravisCI para integração contínua.

- Utilização da autenticação por meio do OAuth2, que é de fácil implementação.

- A escolha do banco H2 facilitou muito o processo de desenvolvimento, em conjunto com o import.sql havia a garantia de que não haveria "lixo" no banco.
