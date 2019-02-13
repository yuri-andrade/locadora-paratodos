[![Build Status](https://travis-ci.com/yuri-andrade/locadora-paratodos.svg?branch=master)](https://travis-ci.com/yuri-andrade/locadora-paratodos)
[![Quality Gate Status](https://sonarcloud.io/api/project_badges/measure?project=yuri-andrade_locadora-paratodos&metric=alert_status)](https://sonarcloud.io/dashboard?id=yuri-andrade_locadora-paratodos)
[![Maintainability Rating](https://sonarcloud.io/api/project_badges/measure?project=yuri-andrade_locadora-paratodos&metric=sqale_rating)](https://sonarcloud.io/dashboard?id=yuri-andrade_locadora-paratodos)

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

Postman Authorization conf:

Type OAuth 2.0
Grant Type
Password Credentials: Password Credentials

Access Token URL: http://localhost:8080/oauth/token

- Username: admin
- Password: admin

- Client ID: desafio
- Client Secret: desafio
- Scope: password

- Client Authentication: Send as Basic Auth header

<h4> Banco de dados: </h4>
Banco de dados utilizado foi o H2, para facilitar o processo de desenvolvimento, os registros iniciais de filmes já são importados automaticamente no start da aplicação.


