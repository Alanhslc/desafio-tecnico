# Tecnologias Usadas

<li>Sistema Operacional: Windows 10 - 64 bit</li> <br>
<li>Linguagem: Java 1.8 => download: https://www.java.com/pt_BR/download/manual.jsp </li> <br>
<li>Banco de dados: MongoDB Community 4.0.10 => download: https://www.mongodb.com/download-center/community </li> <br>

<li> IDE usada no desenvolvimento: Spring Tools Suite 4 => download: https://spring.io/tools <br><br> </li>
<li> Testes usados nos endpoints: Postman for Chrome Versão 5.5.4 => 
download: https://chrome.google.com/webstore/detail/postman/fhbjgbiflinjbdggehcddcbncdddomop?hl=pt-BR </li> <br>

# Frameworks
<li>Spring Boot 2.1.6.RELEASE</li> <br>
<li>Spring Security 2.1.6.RELEASE</li> <br>
<li>Java Web Token 0.9.1 (JWT)</li> <br>
<li>Swagger2 2.9.2</li> <br>


# Configuração de Ambiente

<li>Banco de Dados:</li>
Instalar o MongoDB no localhost e porta 27017 deixando as demais configurações no padrão. <br>
Executar os comandos no shell do Windows: <br>
mongod => comando para iniciar o processo do MongoDB; <br>
mongo => comando para conectar o MongoDB ao localhost; <br> <br>

<li>Aplicação:</li>
Existe mais de uma forma de iniciar a aplicação Spring Boot: <br>
1 - Importar o projeto para a IDE de preferência como projeto Maven; <br>
2 - Se a IDE for Spring Tools o projeto será identificado para inicialização na aba "Boot Dashboard"; <br>
3 - Caso contrário, iniciar o projeto pela classe DesafioTecnicoApplication como um executável;<br> <br>

<li>Documentação da API:</li>
A documentação da API foi escrita com o Swagger2. Todos os endpoints estão disponíveis para consulta pela URL: http://localhost:8080/desafio-tecnico/swagger-ui.html <br> <br>

<li>Segurança:</li>
A segurança da aplicação foi feita com o Spring Security e JWT para geração de tokens de autenticação. Para obter um token de autenticação é necessário seguir os passos: <br>
1 - URL: http://localhost:8080/desafio-tecnico/autenticar => Nesta URL é necessário informar o login e senha da API no formato JSON. As credenciais são "desafiotecnico" para usuário e "senha" para senha. Caso haja dúvidas em relação ao formato consultar a documentação do Swagger2 em http://localhost:8080/desafio-tecnico/swagger-ui.html <br>

2 - Após o primeiro passo será retornado o token de autenticação. Usar o token de autenticação no Header dos demais endpoints da API. Exemplo: <br>
Authentication: eyJhbGciOiJIUzUxMiJ9.eyJzdWIiOiJkZXNhZmlvdGVjbmljbyIsImV4cCI6MTU2MzE3ODYzMCwiaWF0IjoxNTYzMTYwNjMwfQ.GDasJNfQuLBNgTklfMsH07Tr-vIkEfdWIT78Sr3FXKVCUQ1I5pM6uZTL239rwQoVsxrS5mMUj3MGGD8K6b0Gyw <br> <br>

# Postman
Caso necessário os cenários utilizados para teste estão disponíveis na aplicação pelo arquivo "testes.postman_collection.json" na raiz do projeto. Para importar o arquivo basta clicar em "Import" no Postman e selecionar a coleção desejada.
