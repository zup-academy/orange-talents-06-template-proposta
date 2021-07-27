CREATE TABLE biometria(
	id BIGINT(20) PRIMARY KEY AUTO_INCREMENT,
	codigo_proposta BIGINT(20),
	biometria VARCHAR(200) NOT NULL,
	criacao datetime not null
) ENGINE=InnoDB DEFAULT charset=utf8;

ALTER TABLE `biometria` ADD CONSTRAINT `fk_codigo_cartao` FOREIGN KEY ( `codigo_proposta` ) 
REFERENCES `proposta` ( `id` );


