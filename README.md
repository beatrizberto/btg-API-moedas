# btg-API-moedas

Realize a implementação de uma API que gera uma ordem de compra das moedas estrangeiras USD (dólar) e EUR (euro).

Para que o cliente realize a compra, primeiro ele deve se cadastrar no sistema informando o nome, cpf, data de nascimento, estado civil e sexo. Para tanto, um microsserviço de cadastro deve ser criado, gerando um id de cliente ao final de um processamento bem sucedido. Também deverá ser criado um endpoint de consulta do cliente pelo seu cpf.

Após efetuar o cadastro, o cliente pode registrar a ordem de compra, que consiste em informar seu cpf, o tipo de moeda (USD ou EUR), o valor em moeda estrangeira e o número da agência (4 dígitos) que ocorrerá a retirada.

Também deverá ser criada uma API para calcular a cotação da moeda, a qual deve chamar a API externa https://economia.awesomeapi.com.br/ informando a sigla da moeda desejada (https://economia.awesomeapi.com.br/USD/ ou https://economia.awesomeapi.com.br/EUR/).. "‌")

Se o cliente tentar comprar outra moeda que não USD ou EUR, deverá ser lançada uma exceção.

A API irá calcular o valor total com base na cotação da moeda multiplicada pelo valor desejado de compra. Ao final de uma requisição bem sucedida, deverá ser retornado o request body abaixo:

Response 201

{
"id_compra": 1,
"id_cliente": 1,
"cpf_cliente": "43488428095",
"dataSolicitacao": "2021-08-27T16:11:23.866",
"tipo_moeda": "EUR",
"valor_moeda_estrangeira": 100.0,
"valor_cotacao": 6.5857,
"valor_total_operacao": 658.57,
"numero_agencia_retirada": "7057"
}

A escolha do banco de dados é livre, ficando a seu critério a utilização de banco de dados em memória ou algum outro SGBD. Utilize os conceitos de arquitetura, SOLID e Design Patterns apresentados no módulo.

Considere utilizar ferramentas de gerenciamento apresentadas no módulo, como Kanban e controle por Sprints.

doc da api: API de Cotações
