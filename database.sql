/*author: Otavio Souza (SamiSpy)*/

CREATE DATABASE db_caixaeletronico;

USE db_caixaeletronico;

CREATE TABLE tbl_banco(
id INTEGER UNSIGNED AUTO_INCREMENT NOT NULL,
agencia VARCHAR(8) NOT NULL,
senha VARCHAR(5) NOT NULL,
saldo DOUBLE(10,2) NOT NULL,
PRIMARY KEY(id)
);

INSERT INTO tbl_banco (agencia, senha, saldo) VALUES ('samispy','1234', 3000.58);
INSERT INTO tbl_banco (agencia, senha, saldo) VALUES ('yoda','5050', 1999.87);

SELECT * FROM tbl_banco;
