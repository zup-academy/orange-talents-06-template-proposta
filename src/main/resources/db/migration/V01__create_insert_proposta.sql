CREATE TABLE proposta(
	id BIGINT(20) PRIMARY KEY AUTO_INCREMENT,
	documento VARCHAR(14) NOT NULL,
	email VARCHAR(50) NOT NULL,
    nome VARCHAR(50) NOT NULL, 
    endereco VARCHAR(150) NOT NULL,
    salario float(10,2) NOT NULL
) ENGINE=InnoDB DEFAULT charset=utf8;

INSERT INTO proposta (documento, email, nome, endereco,salario) 
Values('12345678901234', 'usuario01@zup.com.br', 'usuario proposta 01', 'endereco usuario 01', 100.01);

INSERT INTO proposta (documento, email, nome, endereco,salario) 
Values('123456789012', 'usuario02@zup.com.br', 'usuario proposta 02', 'endereco usuario 02', 200.01);