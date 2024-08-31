<div markdown="1">

# Leitor de CSV com CRUD

<br>
Arthur Correa - Desenvolvedor Fullstack
<br><br>

[![LinkedIn](https://img.shields.io/badge/LinkedIn-000?style=for-the-badge&logo=linkedin&logoColor=0E76A8)](https://www.linkedin.com/in/arthurcorream/)
[![Instagram](https://img.shields.io/badge/Instagram-000?style=for-the-badge&logo=instagram)](https://www.instagram.com/arthurcoorrea/)

Ver: 0.0.1 - Last update: 31/08/2024

<br>

</div>

<div markdown="1">

# Sobre

O Projeto consiste em um leitor de arquivos csv separado por ponto e virgula com Java. O código faz a leitura do arquivo svc indicado e faz o envio para o banco de dados MySQL, os dados do arquivo csv são inseridos no banco sem repetição e sao atualizados conforme a tabela é atualizada, seja adição ou exclusão de itens. Foi adicionado um teste para verificação da quantidade de colunas do arquivo CSV, pois o código está indicado para fazer a leitura de somente 2 colunas.

<br>

# Preview:

[Video da utilização](./preview.mp4)

<br>

Tecnologias Utilizadas:
---------
- Java
- Hibernate
- JPA
- JUnit
- Mysql
- Mockito
---------

Instalação
---------
- É necessário o Netbeans 22 ou uma IDE equivalente
- É necessário o JDK 22
- É necessário Mysql 5.7.17 e a utilização de um webpack para rodar o banco localmente
- Abra o projeto "teste-enity" em sua IDE, inicie server Mysql e rode a aplicação.

### Credenciais do Banco
~~~

user: root
senha:

*sem senha

~~~
---------

Nomenclatura de commits
---------
- docs: apenas mudanças de documentação;
- feat: uma nova funcionalidade;
- fix: a correção de um bug;
- perf: mudança de código focada em melhorar performance;
- refactor: mudança de código que não adiciona uma funcionalidade e também não corrigi um bug;
- style: mudanças no código que não afetam seu significado (espaço em branco, formatação, ponto e vírgula, etc);
- test: adicionar ou corrigir testes.
---------
