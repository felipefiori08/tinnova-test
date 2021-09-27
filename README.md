# tinnova-test
Uma série de 5 exercícios para o processo seletivo da Tinnova.


## Descrição do Projeto
Este projeto foi desenvolvido em Java 11, com o framework SpringBoot. Os quatro primeiros exercícios são feitos em classes e foi disponibilizado uma classe com método main para testar e rodar as soluções desenvolvidas. O último exercício é composto por uma API Rest com persistência utilizando JPA e H2 (banco em memória), seguindo os padrões de boas práticas para as chamadas HTTP. Ainda para este exercício o front end é em Vue e também, com uma classe de testes dos métdos utilizados.

# Getting Started
- Para rodar este projeto, você precisará ter instalado o Java 11 bem como a variável de ambiente configurada. 
- Como o banco de dados H2 opera em memória, é necessário informar em qual diretório da sua máquina você irá alocar este recurso. Para isso, acesse tinnova-test/src/resources/application.properties e altere a linha 1 spring.datasource.url, informando jdbc:h2:file:seuDiretorio
- Para gerenciar as dependêcias o projeto conta com o Maven (3.8.1) que deverá ser instalado na máquina. Ao importar, antes de rodar é necessário executar o comando mvn clean install no diretório do projeto
- Para rodar a aplicação para o exercício 5, o próprio spring boot já conta com um servidor tomcat que pode ser executado do próprio projeto sem maiores configurações. No VSCode, na aba Explorer, basta ir na aba Maven -> teste -> Plugins -> spring-boot -> running

# Estrutura do Projeto
- A estrutura de código do projeto se encontra na pasta src
- A pasta main contém todos os arquivos de código enquanto a pasta test contém a classe de teste desenvolvida para o exerício 5
- Na pasta main, para os exerícios de 1 a 4, o código está no diretório exercises, e na pasta runner há uma classe que implementa cada uma das classes de exercícios.
- Para o exerício 5, os códigos para a API e modelagem do banco estão no diretório cars, cada um com sua respectiva pasta (api, model)
- O fron etnd fica em main/resources/static. As libs auxiliares (axios, vue, bootstrap, bootstrap-vue e jquery) são situadas ali, bem como os componentes que exibem cada parte da interface. Pelo Vue ser injetado diretamente na jsp, não é necessário qualquer instalação.

# Rodando o Projeto
- Para os exercícios de 1 a 4, será necessário rodar a classe ExerciciosExecutados.java (src/main/java/com/runner). Como a classe possui um método main, qualquer IDE será capaz de executar, mostrando uma série de impressões na tela do console.
- Para o exercício 5, após rodar o projeto no servidor local, é possível observar a interface desenvolvida na porta padrão http://localhost:8080/. Ao acessar este endereço, o projeto redirecionará para a index.jsp que contem as funcionalidades do exerício 5.

# Rodando os testes
- A classe de teste VeiculoJPAUnitTest.java fica localizada em src/test/java/com. Para executá-la, você deverá inserir no console o comando mvn test para que os testes sejam passados e validados.