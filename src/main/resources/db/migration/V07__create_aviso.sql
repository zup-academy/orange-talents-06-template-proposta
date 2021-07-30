CREATE TABLE aviso(
	id BIGINT(20) PRIMARY KEY AUTO_INCREMENT,
	codigo_proposta BIGINT(20),
	user VARCHAR(200),
	ip VARCHAR(200),
	criacao datetime not null
) ENGINE=InnoDB DEFAULT charset=utf8;

ALTER TABLE `bloqueio` ADD CONSTRAINT `fk_codigo_cartao_aviso` FOREIGN KEY ( `codigo_proposta` ) 
REFERENCES `proposta` ( `id` );