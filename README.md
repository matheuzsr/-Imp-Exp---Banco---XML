**Introdução**

Este trabalho é a especificação de um banco de dado para gerenciamento de uma empresa de
táxi aéreo com o objetivo de realizar controle centralizado sobre dados de clientes,
agendamento de voo, funcionários e aeronaves.

**Expectativas do sistema**

O software terá as seguintes funções:

* Cadastro de pessoa (cliente, funcionário);
* Cadastro de aeronaves;
* Agendamento do voo;
*  Check-in do voo;

O sistema é destinado para clientes, que pode já está cadastrado no sistema ou caso não
esteja o ator(vendedor) poderá realizar um novo cadastro no ato de agendamento do voo. No
cadastro de uma pessoa no banco de dados do sistema deve conter nome, RG, CPF, endereço
(Logradouro, CEP, Número), telefone(s) (Celular(es), Residencial ou Comercial), se essa pessoa
for um funcionário também deve ser registrado o salário, se esse funcionário for um piloto
deve ainda ser registrado o seu respectivo Brevê (documento que dá ao seu titular a
permissão para pilotar).
O sistema ainda permite o cadastro de aeronaves registrando o modelo, autonomia,
capacidade, velocidade, número de chassi e tipo. Quando um cliente negocia com um
vendedor é gerado um agendamento do voo que contém protocolo, valor, horário do
agendamento, data e nome do cliente e o vendedor que fez o agendamento.
O Check-in do voo é realizado quando de fato o voo acontece com um piloto que pilotar uma
aeronave, com o data, horário (em que o voo partiu) e aeroporto de origem e destino.

**MANUAL**

PARA INSERIR, ALTERAR E EXCLUIR DO BANCO BASTA ALTERAR AS TAGS NO 
ARQUIVO XML DENOMINADO "AirTaxi.xml" Deve também ser alterado o caminho do arquivo na classe XmlToBanco

1.Para inserir um novo "Objeto"
  1.1 Tag status = "I" e id= 0.

2.Para alterar um "Objeto"
  2.1 Tag status = "A" e o id 
      correspondente deve ser informado.

2.Para excluir um "Objeto"
  2.1 Tag status = "E" e o id 
      correspondente deve ser informado.	  
	
