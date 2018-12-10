

CREATE TABLE tb_veiculo (
	id_vei INT(11) NOT NULL AUTO_INCREMENT,
	nome_vei VARCHAR(50) NOT NULL,
	capacidade_vei DOUBLE NOT NULL,
	PRIMARY KEY(id_vei)
);

CREATE TABLE tb_carro (
	id_car INT(11) NOT NULL AUTO_INCREMENT,
	marca_car VARCHAR(50) NOT NULL,
	modelo_car VARCHAR(50) NOT NULL,
	ano_lanc_car INT(4) NOT NULL,
	ano_enc_car INT(4) NOT NULL,
	estado_conserv_car VARCHAR(30) NOT NULL,
	id_vei INT(11) NOT NULL,
	PRIMARY KEY(id_car),
	FOREIGN KEY tb_carro(id_vei) REFERENCES tb_veiculo(id_vei)
);	

SELECT * FROM tb_carro INNER JOIN tb_veiculo ON tb_carro.id_vei = tb_veiculo.id_vei;
