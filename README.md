<h1 align="center"> Gerenciador de Gastos API </h1>

# Resumo do projeto
O serviço é um organizador de gastos que utiliza SQL como database para salvar transações e pessoas. Como usuário, você podera salvar pessoas e vincular a elas transações, sendo do tipo Income para receita e Expense para despesas, também é possível ver o total de despesas, de gastos e o total final. Ao utilizar a aplicação, você poderá checar as rotas com a documentação gerada pelo Springdoc. (Mais informações na área de utilização).

# Endpoints

![image](https://github.com/user-attachments/assets/5bbb4e5a-195a-4d0e-8cb2-76a62a51a849)


## ✔️ Bibliotecas e tecnologias utilizadas

- ``Java 17``
- ``Spring 3.4.2``
- ``Maven``
- ``Sql``
- ``Flyway``
- ``SpringDoc``
- ``DevTools``

# Features 
1. Operação de Crud de pessoas.
2. Operação de Crud do transações.
3. Vincular uma transação a pessoa.
6. Get de valores totais das suas transações.

# Instalação
1. Faça a clonagem do projeto
2. Abra o projeto na sua IDE e faça a instalação das dependências através do Maven
3. Adicione a configuração do seu Banco de Dados SQL na application.properties, lá você deve colocar o seu usuario e senha do MySQL
4. Rode o projeto e as migrations, lá será feita as criações de tabelas e valores iniciais
5. Acesse http://localhost:8080/swagger-ui.html para ver a documentação

