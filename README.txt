Autores: Fernanda Rosa e Henrique Xavier

Como rodar:

1) Criar um container docker para o banco de dados postgres
docker run --name <nome do container> -e POSTGRES_PASSWORD=changeme -d postgres

2) Baixar as dependências maven

3) Rodar T1Es2Application

4) Criar uma collection no Postman (importar o arquivo t1-es2.postman_collection.json)

5) Criar uma usuário

6) Fazer login e adicionar o token de resposta no header "Authorization" das demais requisicoes