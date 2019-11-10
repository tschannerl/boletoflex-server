# BoletoflexServer

Projeto utiliza o [Spring Boot](https://spring.io/projects/spring-boot) version 2.1.1, com Banco de Dados H2database.
No Spring está sendo utilizando JPA como Repositorio dos modelos. Utilizando o Banco de Dados H2 por ser standalone (dados em memoria). Utilizando pacote de segurança deixando o acesso aos endpoints do REST com autenticação básica.


## Implantando o Server utilizado GRADLE no Ubuntu 18.04
Executar os camandos:

### Instalando o java 8 (processo somente se não tiver o java)
`sudo apt install openjdk-8-jdk`

### Baixando do repositorio GITHUB o projeto Server
`git clone https://github.com/tschannerl/boletoflex-server.git`
`cd boletoflex-server`

### Baixando, Instalando e Construindo a aplicação com o GRADLE
`./gradlew clean build`

## Execução do server SPRING BOOT com o Java
`java -jar build/libs/boletoflex-server-1.0-SNAPSHOT.jar`

# Detalhes do Server Spring Boot
Utiliza requisições aos endpoints com credenciais básica de autenticação (usuário: admin, senha: Boletoflex!).
Contem uma tabela de usuário, que ao subir a aplicação cria um usuário "admin" com senha "123" que será usado pela aplicação Client.
O bando de dados H2 está limitado a memória, ou seja, os dados serão persistidos e permanentes somente na etapa de execução do Server, após reiniciar os dados serão apagados.
As imagens são gravadas no Banco de Dados.
