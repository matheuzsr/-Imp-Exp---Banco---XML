create database airtaxi;
use airtaxi;

CREATE TABLE Endereco(
idEndereco INTEGER NOT NULL auto_increment, 
Logradouro VARCHAR(100), 
Cep INTEGER, 
Numero INTEGER, 
Cidade VARCHAR(30), 
UF CHAR(2), 
CONSTRAINT pkEndereco PRIMARY KEY (idEndereco)
 );
 
 create table Pessoa(
 idPessoa int not null auto_increment,
 nome varchar(45),
 RG int,
 CPF int,
 idEndereco int,
 constraint pkPessoa primary key (idPessoa),
 constraint fkPessoa_Endereco foreign key (idEndereco)
 references Endereco (idEndereco)
 );
 
 create table Telefone(
 idTelefone int not null auto_increment,
 numero int(11),
 tipo varchar(10),
 idPessoa int,
 constraint pkTelefone primary key (idTelefone),
 constraint fkPessoa_Telefone foreign key (idPessoa)
 references Pessoa (idPessoa)
 );
 
 create table Cliente(
 idCliente int not null,
 constraint pkCliente primary key (idCliente),
 constraint fkPessoa_CLiente foreign key (idCliente)
 references Pessoa (idPessoa)
 );
 
 create table Funcionario(
 idFuncionario int not null,
 salario float,
 constraint pkFuncionario primary key (idFuncionario),
 constraint fkPessoa_Funcionario foreign key (idFuncionario)
 references Pessoa (idPessoa)
 );
 
 create table Piloto(
 idPiloto int not null,
 breve int,
 constraint pkPiloto primary key (idPiloto),
 constraint fkPessoa_Funcionario_Piloto foreign key (idPiloto)
 references Funcionario (idFuncionario)
 );
 
 create table Vendedor(
 idVendedor int not null,
 constraint pkVendedor primary key (idVendedor),
 constraint fkPessoa_Funcionario_Vendedor foreign key (idVendedor)
 references Funcionario (idFuncionario)
 ); 
 
 create table Agendamento(
 idAgendamento integer not null auto_increment,
 valor float,
 dataAg date,
 hora time,
 idVendedor integer,
 idCliente integer,
 constraint pkAgendamento primary key (idAgendamento),
 constraint fkVendedor_Agendamento foreign key (idVendedor)
 references Vendedor (idVendedor),
 constraint fkCliente_Agendamento foreign key (idCliente)
 references Cliente (idCliente)
 
 
 create table Aeronave(
 idAeronave int not null auto_increment,
 modelo varchar(30),
 autonomia time,
 capCombustivel float,
 velocidade float,
 numChassi varchar(30),
 tipo VARCHAR(30),
 constraint pkAeronave primary key (idAeronave) 
 );
 
 create table Voo(
 idVoo integer not null auto_increment,
 dataPartida date,
 dataChegada date,
 horaPartida time,
 horaChegada time,
 AeroDestino varchar(30),
 AeroOrigem varchar(30),
 idPiloto integer,
 idAgendamento integer,
 idAeronave integer,
 constraint pkVoo primary key (idVoo),
 constraint fkPiloto_Voo foreign key (idPiloto)
 references Piloto (idPiloto),
 constraint fkAgendamento_Voo foreign key (idAgendamento)
 references Agendamento (idAgendamento),
 constraint fkAeronave foreign key (idAeronave)
 references Aeronave (idAeronave)
 );

CREATE TABLE Endereco(
    IdEndereco INTEGER NOT NULL AUTO_INCREMENT,
    Logradouro VARCHAR(100),
    Cep        INTEGER,
    Numero     INTEGER,
    Cidade     VARCHAR(30),
    UF         CHAR(2),
    CONSTRAINT pkEndereco PRIMARY KEY (IdEndereco)

);
CREATE TABLE Pessoa(
    IdPessoa INTEGER NOT NULL AUTO_INCREMENT,
    Nome VARCHAR(100),
    Rg        INTEGER,
    Cpf     VARCHAR(15),
    IdEndereco     INTEGER,
    CONSTRAINT pkPessoa PRIMARY KEY (IdPessoa),
    CONSTRAINT fkPessoaEndereco FOREIGN KEY (IdEndereco) REFERENCES Endereco(IdEndereco)
);




INSERT INTO Endereco (IdEndereco,`Logradouro`, Cep, `Numero`, `Cidade`, `UF`) VALUES
                      (1,"Rua Benjamin Barros", 29500000,63,"Alegre","ES");
					  
INSERT INTO Endereco (IdEndereco,`Logradouro`, Cep, `Numero`, `Cidade`, `UF`) VALUES
                      (2,"Rua Dr Jose Vieira Tatagiba", 29500000,103,"Alegre","ES");
INSERT INTO Endereco (IdEndereco,`Logradouro`, Cep, `Numero`, `Cidade`, `UF`) VALUES
                      (4,"Rua da Lama", 29000000,1,"Vitoria","ES");
INSERT INTO Endereco (IdEndereco,`Logradouro`, Cep, `Numero`, `Cidade`, `UF`) VALUES
                      (5,"Rua Felicio Alcure", 29500000,43,"Alegre","ES");
					  

INSERT INTO Pessoa (`IdPessoa`,Nome,Rg,Cpf,IdEndereco) VALUES
                      (1,"Isabela C Fonseca",11111,"123456",1);

INSERT INTO Pessoa (`IdPessoa`,Nome,Rg,Cpf,IdEndereco) VALUES
                      (2,"Matheus Rocha",22222,"23456",2);
					  				  
INSERT INTO Pessoa (IdPessoa,Nome,Rg,Cpf,IdEndereco) VALUES
                      (4,"Joao da Silva",4444,"123456",3);

INSERT INTO Pessoa (IdPessoa,Nome,Rg,Cpf,IdEndereco) VALUES
                      (5,"Pedro Rocha",4444,"123456",3);
					  
INSERT INTO Pessoa (IdPessoa,Nome,Rg,Cpf,IdEndereco) VALUES
                      (6,"Savio da Silva",4444,"123456",3);

INSERT INTO Pessoa (IdPessoa,Nome,Rg,Cpf,IdEndereco) VALUES
                      (7,"Sebastiao José",4444,"123456",1);
					  

-------------------------------------------------POVOAMENTO-------------------------------------------------
INSERT INTO `Endereco` (`Logradouro`,`Cep`,`Numero`,`Cidade`,`UF`) VALUES ("926-1403 Ultricies St.",5537,20,"Abaetetuba","PA"),("P.O. Box 118, 7854 Pellentesque St.",4740,70,"São José","PR"),("P.O. Box 731, 7155 Porttitor St.",8024,27,"Jundiaí","SP"),("Ap #503-4784 Faucibus. St.",4821,91,"Diadema","SP"),("P.O. Box 984, 8697 Turpis Rd.",6282,61,"Balsas","MA");
INSERT INTO `Endereco` (`Logradouro`,`Cep`,`Numero`,`Cidade`,`UF`) VALUES ("312-1178 Semper St.",5381,36,"Criciúma","SC"),("390-9042 Semper St.",5664,61,"Petrolina","PE"),("Ap #999-3098 Quisque St.",8743,74,"Camaçari","BA"),("P.O. Box 924, 4245 Imperdiet Rd.",7519,33,"Juiz de Fora","MG"),("Ap #401-9650 Neque. St.",8162,34,"Diadema","SP");
INSERT INTO `Endereco` (`Logradouro`,`Cep`,`Numero`,`Cidade`,`UF`) VALUES ("P.O. Box 418, 9990 Aliquam Avenue",7378,27,"Rio Grande","RS"),("P.O. Box 300, 4028 Eget Avenue",8704,100,"Ipatinga","MG"),("Ap #793-488 At Ave",8752,93,"Crato","CE"),("Ap #388-1788 Nulla Avenue",6437,12,"Santa Luzia","MG"),("P.O. Box 418, 7949 Sit St.",6896,73,"Duque de Caxias","RJ");
INSERT INTO `Endereco` (`Logradouro`,`Cep`,`Numero`,`Cidade`,`UF`) VALUES ("P.O. Box 651, 6224 At Road",7197,39,"Montes Claros","MG"),("P.O. Box 332, 6284 Habitant Rd.",7404,34,"Carapicuíba","P"),("8800 Aliquam Av.",7245,65,"São João de Meriti","RJ"),("Ap #929-7395 Integer Rd.",7545,25,"Niterói","Rio de Janeiro"),("Ap #491-3193 Non St.",8582,10,"São Luís","MA");
INSERT INTO `Endereco` (`Logradouro`,`Cep`,`Numero`,`Cidade`,`UF`) VALUES ("220-6968 Integer Street",8514,22,"Maringá","PR"),("Ap #321-5581 Taciti Street",4861,45,"Diadema","SP"),("P.O. Box 870, 1959 Risus. Av.",8505,24,"Paranaguá","PR"),("P.O. Box 633, 8391 A, Street",5618,3,"Lauro de Freitas","BA"),("874-3890 Sociis Ave",6577,19,"Guarulhos","SP");					  
	
---------------------------------------------------------------------------------------------------------------
	
INSERT INTO `Pessoa` (`Nome`,`Rg`,`IdEndereco`) VALUES ("Andrew E. Church","16301202 1477",1),("Ulysses P. Buckner","16720524 2386",2),("Megan L. Camacho","16340627 2363",3),("Ursula Z. Jenkins","16630901 5656",4),("Venus K. Burnett","16240706 6212",5),("Pamela I. Sanford","16341122 7196",6),("Jescie O. Patrick","16561024 7818",7),("Cyrus O. Caldwell","16820204 3736",8),("Calvin P. Long","16900416 7749",9),("Ryder X. Saunders","16850111 7116",10);
INSERT INTO `Pessoa` (`Nome`,`Rg`,`IdEndereco`) VALUES ("Gannon V. Mcneil","16730624 0719",11),("Mufutau B. Frazier","16270210 7570",12),("Colin U. Macias","16880522 7462",13),("Wallace K. Cross","16140608 1941",14),("Alfreda U. Sullivan","16870620 5922",15),("Kaye L. Hopkins","16480315 3958",16),("Ray L. Gates","16060812 3824",17),("Yuli M. Griffith","16790806 4533",18),("Jaden D. Levy","16840213 2214",19),("Mohammad A. Dunlap","16630807 4399",20);
INSERT INTO `Pessoa` (`Nome`,`Rg`,`IdEndereco`) VALUES ("Mariam N. Keith","16131030 4546",21),("Adrian R. Ayers","16670927 7963",22),("Ulla S. Deleon","16590307 0513",23),("Grace T. Hendrix","16490820 0415",24),("Miranda V. Hobbs","16750419 6465",25),("Arthur W. Elliott","16440814 8056",26),("Colin J. Mosley","16230203 2988",27),("Elvis P. Knapp","16190209 6385",28),("Allistair P. Rios","16790415 6614",29),("Tyrone Q. Johnston","16350814 3124",30);
INSERT INTO `Pessoa` (`Nome`,`Rg`,`IdEndereco`) VALUES ("Alec S. Hart","16091017 7476",31),("Steel I. Pate","16920314 9142",32),("Aquila W. Golden","16971103 1295",33),("Ebony C. Calderon","16331130 9144",34),("Oliver L. Sosa","16400421 1449",35),("Damian K. Dominguez","16890425 3930",36),("Adam Z. Coffey","16960108 4511",37),("Claudia P. Adams","16280921 6795",38),("Amir C. Mayo","16160406 3014",39),("Kaitlin Z. Bishop","16960730 8625",40);
INSERT INTO `Pessoa` (`Nome`,`Rg`,`IdEndereco`) VALUES ("Keegan L. Rios","16631017 2033",41),("Salvador R. Delgado","16060230 7613",42),("Edan C. Gill","16460721 4964",43),("Cheryl F. Keller","16151101 7764",44),("Burton R. Rich","16920715 6929",45),("Stephen K. Beach","16750812 6575",46),("Rina U. Ellis","16590814 3067",47),("Marah G. Hill","16781130 3481",48),("Amos S. Stark","16271021 4533",49),("Noble V. Patton","16990829 8111",50);
INSERT INTO `Pessoa` (`Nome`,`Rg`,`IdEndereco`) VALUES ("Nathan C. Ross","16251122 5514",51),("Harlan D. Gilbert","16990416 2238",52),("Whitney G. Tate","16310724 9421",53),("Kessie D. Hansen","16780410 4003",54),("Indigo X. Mcfadden","16161015 5754",55),("Basil J. Walls","16941228 0738",56),("Kuame Z. Jones","16690204 7809",57),("Noah V. Wolfe","16730225 0266",58),("Cameron O. Fleming","16530503 7169",59),("Ian Y. Simpson","16080506 2130",60);
INSERT INTO `Pessoa` (`Nome`,`Rg`,`IdEndereco`) VALUES ("Jemima T. Melton","16711205 3991",61),("Katelyn P. Medina","16570201 0835",62),("Winter T. Boyer","16080416 5983",63),("Hilel E. Bryant","16181228 8338",64),("Carlos K. Greer","16200330 5154",65),("Cecilia P. Dotson","16680605 7664",66),("Lucas U. Terry","16170527 6424",67),("Leslie T. Turner","16891120 4355",68),("Jena G. Morrison","16920801 1545",69),("Jelani I. Pacheco","16310822 6543",70);
INSERT INTO `Pessoa` (`Nome`,`Rg`,`IdEndereco`) VALUES ("Xandra D. Hahn","16720213 2895",71),("Sopoline J. Dominguez","16740304 8536",72),("Quintessa Q. Waller","16621216 3114",73),("Stephen F. Brennan","16290314 9389",74),("Malik R. Sweet","16381110 1421",75),("Scott Z. Nicholson","16130406 7620",76),("Haviva L. House","16160727 8817",77),("Graham P. Burt","16670213 1605",78),("Ryan B. Mitchell","16181007 3344",79),("Judah E. Burke","16030415 8819",80);
INSERT INTO `Pessoa` (`Nome`,`Rg`,`IdEndereco`) VALUES ("Miranda Z. Price","16390814 7667",81),("Elizabeth A. Bush","16020807 8923",82),("Germane M. Webster","16950606 1838",83),("Hoyt G. Castillo","16550820 8203",84),("Armand Z. Cervantes","16670816 7397",85),("Holmes I. Winters","16391112 3234",86),("Tamara Y. Delgado","16151228 6228",87),("Melvin I. Owen","16820516 8704",88),("Melyssa P. Guerra","16801007 5201",89),("Brian H. Hyde","16380226 7389",90);
INSERT INTO `Pessoa` (`Nome`,`Rg`,`IdEndereco`) VALUES ("Cameron X. Estrada","16940922 6900",91),("Buffy U. Webster","16781101 4690",92),("Sara T. Potts","16730524 5560",93),("Declan Z. Eaton","16130503 6541",94),("Reed Y. Hayes","16140918 9253",95),("Ingrid C. Whitfield","16830621 6014",96),("Quintessa H. Reid","16630907 9181",97),("Micah X. Morse","16170922 9635",98),("Raven Q. Pace","16641207 7304",99),("Kristen R. Bradford","16300223 7356",100);

---------------------------------------------------------------------------------------------------------------

INSERT INTO Aeronave (IdAeronave,Modelo,Autonomia, capCombustivel, Velocidade, numChassi,Tipo) VALUES (1,'Boeing 707','10:00:00',300,815,'1FVXAJ0074','Jato');
INSERT INTO Aeronave (IdAeronave,Modelo,Autonomia, capCombustivel, Velocidade, numChassi,Tipo) VALUES (2,"ATR-72","04:00:00",100,150,"1G6AE5S4H4HN","Turbo-Helices");
INSERT INTO Aeronave (IdAeronave,Modelo,Autonomia, capCombustivel, Velocidade, numChassi,Tipo) VALUES (3,'Boeing 707','10:00:00',300,815,'1FVXAJ0074','Jato');
INSERT INTO Aeronave (IdAeronave,Modelo,Autonomia, capCombustivel, Velocidade, numChassi,Tipo) VALUES (4,"ATR-72","04:00:00",100,150,"1G6AE5S4H4HN","Turbo-Helices");
---------------------------------------------------------------------------------------------------------------
INSERT INTO Cliente (IdCliente) VALUES (1);
INSERT INTO Cliente (IdCliente) VALUES (2);
INSERT INTO Cliente (IdCliente) VALUES (3);
INSERT INTO Cliente (IdCliente) VALUES (4);
INSERT INTO Cliente (IdCliente) VALUES (5);
INSERT INTO Cliente (IdCliente) VALUES (6);
--------------------------------------------------------
INSERT INTO Funcionario (IdFuncionario,salario) VALUES (10,2000);
INSERT INTO Funcionario (IdFuncionario,salario) VALUES (11,2000);
INSERT INTO Funcionario (IdFuncionario,salario) VALUES (12,2000);
INSERT INTO Funcionario (IdFuncionario,salario) VALUES (13,2000);
INSERT INTO Funcionario (IdFuncionario,salario) VALUES (14,2000);

INSERT INTO Funcionario (IdFuncionario,salario) VALUES (15,5000);
INSERT INTO Funcionario (IdFuncionario,salario) VALUES (16,5000);
INSERT INTO Funcionario (IdFuncionario,salario) VALUES (17,5000);
INSERT INTO Funcionario (IdFuncionario,salario) VALUES (18,5000);
INSERT INTO Funcionario (IdFuncionario,salario) VALUES (19,5000);
---------------------------------------------------------------------------------------------------------------
INSERT INTO Vendedor (IdVendedor) VALUES (10);
INSERT INTO Vendedor (IdVendedor) VALUES (11);
INSERT INTO Vendedor (IdVendedor) VALUES (12);
INSERT INTO Vendedor (IdVendedor) VALUES (10);
INSERT INTO Vendedor (IdVendedor) VALUES (14);
----------------------------------------------------------
INSERT INTO Piloto (IdPiloto,breve) VALUES (15,2121212);
INSERT INTO Piloto (IdPiloto,breve) VALUES (16,243434);
INSERT INTO Piloto (IdPiloto,breve) VALUES (17,767676);
INSERT INTO Piloto (IdPiloto,breve) VALUES (18,344343);
INSERT INTO Piloto (IdPiloto,breve) VALUES (19,787878);

