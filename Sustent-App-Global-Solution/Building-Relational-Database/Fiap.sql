/*
DROP TABLE T_SGDR_PLASTICO_USUARIO;
DROP TABLE T_SGDR_PLASTICO_COOPERATIVA;
DROP TABLE T_SGDR_USUARIO;
DROP TABLE T_SGDR_CATADOR;
DROP TABLE T_SGDR_COOPERATIVA;
DROP TABLE T_SGDR_ENDERECO;
DROP TABLE T_SGDR_TIPOS_PLASTICO;
DROP SEQUENCE SEQ_USUARIO;
DROP SEQUENCE SEQ_CATADOR;
DROP SEQUENCE SEQ_COOPERATIVA;
DROP SEQUENCE SEQ_ENDERECO;
DROP SEQUENCE SEQ_TIPOS_PLASTICO;
*/
--_____________________________________________________________________________________________________________________________
--Tabela para Usuário

--Criando a sequence
CREATE SEQUENCE SEQ_USUARIO;

--Criando a estrutura da tabela suas constraints
CREATE TABLE T_SGDR_USUARIO (
    id_usuario INT PRIMARY KEY,
    nm_usuario VARCHAR(100) NOT NULL,
    ds_email VARCHAR(100) UNIQUE NOT NULL
);

--Inserindo 5 linhas de dados
INSERT INTO T_SGDR_USUARIO(id_usuario, nm_usuario, ds_email)
    VALUES (SEQ_USUARIO.nextval, 'Quico', 'quico@elchavo.com');
INSERT INTO T_SGDR_USUARIO(id_usuario, nm_usuario, ds_email)
    VALUES (SEQ_USUARIO.nextval, 'Chiquinha', 'chiquinha@elchavo.com');
INSERT INTO T_SGDR_USUARIO(id_usuario, nm_usuario, ds_email)
    VALUES (SEQ_USUARIO.nextval, 'Popis', 'popis@elchavo.com');
INSERT INTO T_SGDR_USUARIO(id_usuario, nm_usuario, ds_email)
    VALUES (SEQ_USUARIO.nextval, 'Chaves', 'Chaves@elchavo.com');
INSERT INTO T_SGDR_USUARIO(id_usuario, nm_usuario, ds_email)
    VALUES (SEQ_USUARIO.nextval, 'Seu Barriga', 'seubarriga@elchavo.com');

--Relatório da tabela
SELECT * FROM T_SGDR_USUARIO;
--_____________________________________________________________________________________________________________________________
--Tabela para Catador

--Criando a sequence
CREATE SEQUENCE SEQ_CATADOR;

--Criando a estrutura da tabela suas constraints
CREATE TABLE T_SGDR_CATADOR (
    id_catador INT PRIMARY KEY,
    nm_catador VARCHAR(100) NOT NULL,
    nr_telefone VARCHAR(20) NOT NULL,
    nr_raio_coleta NUMERIC NOT NULL
);

--Inserindo 5 linhas de dados
INSERT INTO T_SGDR_CATADOR (id_catador, nm_catador, nr_telefone, nr_raio_coleta)
VALUES (SEQ_CATADOR.nextval, 'Seu Madruga', '72922776644', 10);
INSERT INTO T_SGDR_CATADOR (id_catador, nm_catador, nr_telefone, nr_raio_coleta)
VALUES (SEQ_CATADOR.nextval, 'Dona Clotilde', '71966666666', 5);
INSERT INTO T_SGDR_CATADOR (id_catador, nm_catador, nr_telefone, nr_raio_coleta)
VALUES (SEQ_CATADOR.nextval, 'Jaiminho', '10911001100', 1);
INSERT INTO T_SGDR_CATADOR (id_catador, nm_catador, nr_telefone, nr_raio_coleta)
VALUES (SEQ_CATADOR.nextval, 'Dona Neves', '56947664757', 7);
INSERT INTO T_SGDR_CATADOR (id_catador, nm_catador, nr_telefone, nr_raio_coleta)
VALUES (SEQ_CATADOR.nextval, 'Professor Girafales', '3141592653', 12);

--Relatório da tabela
SELECT * FROM T_SGDR_CATADOR;
--_____________________________________________________________________________________________________________________________
--Tabela para Catador

--Criando a sequence
CREATE SEQUENCE SEQ_COOPERATIVA;

--Criando a estrutura da tabela suas constraints
CREATE TABLE T_SGDR_COOPERATIVA (
    id_cooperativa INT PRIMARY KEY,
    nm_cooperativa VARCHAR(100) NOT NULL,
    nr_telefone VARCHAR(20) NOT NULL
);

--Inserindo 5 linhas de dados
INSERT INTO T_SGDR_COOPERATIVA (id_cooperativa, nm_cooperativa, nr_telefone)
VALUES (SEQ_COOPERATIVA.nextval, 'Barril', '7172145566');
INSERT INTO T_SGDR_COOPERATIVA (id_cooperativa, nm_cooperativa, nr_telefone)
VALUES (SEQ_COOPERATIVA.nextval, 'Tamarindo', '52966553344');
INSERT INTO T_SGDR_COOPERATIVA (id_cooperativa, nm_cooperativa, nr_telefone)
VALUES (SEQ_COOPERATIVA.nextval, 'Bola Quadrada', '1033664488');
INSERT INTO T_SGDR_COOPERATIVA (id_cooperativa, nm_cooperativa, nr_telefone)
VALUES (SEQ_COOPERATIVA.nextval, 'Foi sem querer querendo', '1466777755');
INSERT INTO T_SGDR_COOPERATIVA (id_cooperativa, nm_cooperativa, nr_telefone)
VALUES (SEQ_COOPERATIVA.nextval, 'Você não vai com a minha cara', '88944558844');

--Relatório da tabela
SELECT * FROM T_SGDR_COOPERATIVA;
--_____________________________________________________________________________________________________________________________
--Tabela para Cooperativa

--Criando a sequence
CREATE SEQUENCE SEQ_ENDERECO;

--Criando a estrutura da tabela suas constraints
CREATE TABLE T_SGDR_ENDERECO (
    id_endereco INT PRIMARY KEY,
    nr_cep VARCHAR(10) NOT NULL,
    nm_pais VARCHAR(50) NOT NULL,
    nm_estado VARCHAR(50) NOT NULL,
    nm_cidade VARCHAR(50) NOT NULL,
    nm_logradouro VARCHAR(100) NOT NULL,
    nr_logradouro INT NOT NULL,
    ds_complemento VARCHAR(100)
);

--Inserindo 5 linhas de dados
INSERT INTO T_SGDR_ENDERECO (id_endereco, nr_cep, nm_pais, nm_estado, nm_cidade, nm_logradouro, nr_logradouro, ds_complemento)
VALUES (SEQ_ENDERECO.nextval, '12345-678', 'Brasil', 'SP', 'Tangamandápio', 'Vila do Chaves', 14, NULL);
INSERT INTO T_SGDR_ENDERECO (id_endereco, nr_cep, nm_pais, nm_estado, nm_cidade, nm_logradouro, nr_logradouro, ds_complemento)
VALUES (SEQ_ENDERECO.nextval, '12345-678', 'Brasil', 'SP', 'Tangamandápio', 'Vila do Chaves', 71, 'Casa da  bruxa');
INSERT INTO T_SGDR_ENDERECO (id_endereco, nr_cep, nm_pais, nm_estado, nm_cidade, nm_logradouro, nr_logradouro, ds_complemento)
VALUES (SEQ_ENDERECO.nextval, '12345-678', 'Brasil', 'SP', 'Tangamandápio', 'Vila do Chaves', 72, 'Em frente ao barril');
INSERT INTO T_SGDR_ENDERECO (id_endereco, nr_cep, nm_pais, nm_estado, nm_cidade, nm_logradouro, nr_logradouro, ds_complemento)
VALUES (SEQ_ENDERECO.nextval, '12345-678', 'Brasil', 'SP', 'Tangamandápio', 'Travessa do Chapolin', 8, 'Perto da venda de refrescos');
INSERT INTO T_SGDR_ENDERECO (id_endereco, nr_cep, nm_pais, nm_estado, nm_cidade, nm_logradouro, nr_logradouro, ds_complemento)
VALUES (SEQ_ENDERECO.nextval, '12345-678', 'Brasil', 'SP', 'Tangamandápio', 'Travessa do Chapolin', 26, NULL);

--Relatório da tabela
SELECT * FROM T_SGDR_ENDERECO;
--_____________________________________________________________________________________________________________________________
--Tabela para Tipos de Plástico

--Criando a sequence
CREATE SEQUENCE SEQ_TIPOS_PLASTICO;

--Criando a estrutura da tabela suas constraints
CREATE TABLE T_SGDR_TIPOS_PLASTICO (
    id_plastico INT PRIMARY KEY,
    ds_tipo_plastico VARCHAR(50) NOT NULL,
    nr_classificacao INT NOT NULL,
    ds_instrucao_reciclagem LONG VARCHAR NOT NULL
);

--Inserindo 5 linhas de dados
INSERT INTO T_SGDR_TIPOS_PLASTICO (id_plastico, ds_tipo_plastico, nr_classificacao, ds_instrucao_reciclagem)
VALUES (SEQ_TIPOS_PLASTICO.nextval, 'PET', 1, 'Reciclar em local específico');
INSERT INTO T_SGDR_TIPOS_PLASTICO (id_plastico, ds_tipo_plastico, nr_classificacao, ds_instrucao_reciclagem)
VALUES (SEQ_TIPOS_PLASTICO.nextval, 'HDPE', 2, 'Lavar antes de reciclar');
INSERT INTO T_SGDR_TIPOS_PLASTICO (id_plastico, ds_tipo_plastico, nr_classificacao, ds_instrucao_reciclagem)
VALUES (SEQ_TIPOS_PLASTICO.nextval, 'PVC', 3, 'Lavar antes de reciclar');
INSERT INTO T_SGDR_TIPOS_PLASTICO (id_plastico, ds_tipo_plastico, nr_classificacao, ds_instrucao_reciclagem)
VALUES (SEQ_TIPOS_PLASTICO.nextval, 'PELD', 4, 'Reciclar em local específico');
INSERT INTO T_SGDR_TIPOS_PLASTICO (id_plastico, ds_tipo_plastico, nr_classificacao, ds_instrucao_reciclagem)
VALUES (SEQ_TIPOS_PLASTICO.nextval, 'PP', 5, 'Separar por cor');

--Relatório da tabela
SELECT * FROM T_SGDR_TIPOS_PLASTICO;
--_____________________________________________________________________________________________________________________________
--Tabela de relacionamento - Plastico / Usuário

--Criando a estrutura da tabela suas constraints
CREATE TABLE T_SGDR_PLASTICO_USUARIO (
    id_usuario INT,
    id_plastico INT,
    data_cadastro DATE,
    FOREIGN KEY (id_usuario) REFERENCES T_SGDR_USUARIO(id_usuario),
    FOREIGN KEY (id_plastico) REFERENCES T_SGDR_TIPOS_PLASTICO(id_plastico)
);

--Inserindo 5 linhas de dados
INSERT INTO T_SGDR_PLASTICO_USUARIO (id_usuario, id_plastico, data_cadastro)
VALUES (1, 1, TO_DATE('25/02/2016', 'DD/MM/YYYY'));
INSERT INTO T_SGDR_PLASTICO_USUARIO (id_usuario, id_plastico, data_cadastro)
VALUES (2, 2, TO_DATE('08/04/2022', 'DD/MM/YYYY'));
INSERT INTO T_SGDR_PLASTICO_USUARIO (id_usuario, id_plastico, data_cadastro)
VALUES (3, 3, TO_DATE('07/12/2010', 'DD/MM/YYYY'));
INSERT INTO T_SGDR_PLASTICO_USUARIO (id_usuario, id_plastico, data_cadastro)
VALUES (4, 4, TO_DATE('08/02/2024', 'DD/MM/YYYY'));
INSERT INTO T_SGDR_PLASTICO_USUARIO (id_usuario, id_plastico, data_cadastro)
VALUES (5, 5, TO_DATE('01/01/2023', 'DD/MM/YYYY'));

--Relatório da tabela
SELECT * FROM T_SGDR_PLASTICO_USUARIO;
--_____________________________________________________________________________________________________________________________
--Tabela de relacionamento - Plastico / Cooperativa

--Criando a estrutura da tabela suas constraints
CREATE TABLE T_SGDR_PLASTICO_COOPERATIVA (
    id_cooperativa INT,
    id_plastico INT,
    FOREIGN KEY (id_cooperativa) REFERENCES T_SGDR_COOPERATIVA(id_cooperativa),
    FOREIGN KEY (id_plastico) REFERENCES T_SGDR_TIPOS_PLASTICO(id_plastico)
);

--Inserindo 5 linhas de dados
INSERT INTO T_SGDR_PLASTICO_COOPERATIVA (id_cooperativa, id_plastico)
VALUES (1, 1);
INSERT INTO T_SGDR_PLASTICO_COOPERATIVA (id_cooperativa, id_plastico)
VALUES (2, 2);
INSERT INTO T_SGDR_PLASTICO_COOPERATIVA (id_cooperativa, id_plastico)
VALUES (3, 3);
INSERT INTO T_SGDR_PLASTICO_COOPERATIVA (id_cooperativa, id_plastico)
VALUES (4, 2);
INSERT INTO T_SGDR_PLASTICO_COOPERATIVA (id_cooperativa, id_plastico)
VALUES (5, 1);

--Relatório da tabela
SELECT * FROM T_SGDR_PLASTICO_COOPERATIVA;
--_____________________________________________________________________________________________________________________________
-- Relatório usando classificação crescente de dados - Retorna a tabela Usuário em ordem crescente
SELECT * FROM T_SGDR_USUARIO ORDER BY nm_usuario ASC;

/* Relatório usando betweene like - Retorna os id_endereço que estao entre os valores 2 e 4 e onde o 
nm_logradouro tem uma parte = "Chaves" */
SELECT * FROM T_SGDR_ENDERECO WHERE id_endereco BETWEEN 2 AND 4 AND nm_logradouro LIKE '%Chaves%';

-- Relatórios usando função caracter - Coloca os nm_cooperativa em letra minúscula e retorna os que forem = "bola quadrada"
SELECT * FROM T_SGDR_COOPERATIVA WHERE LOWER(nm_cooperativa) = 'bola quadrada';

-- Relatório usando função data - Retorna as data_cadastro que sao maiores que 01/01/2022
SELECT * FROM T_SGDR_PLASTICO_USUARIO WHERE data_cadastro > TO_DATE('01/01/2022', 'DD/MM/YYYY');

-- Relatório usando groupby - Agrupa os nm_logradouros iguais e conta quantos sao
SELECT nm_logradouro, COUNT(*)
FROM T_SGDR_ENDERECO
GROUP BY nm_logradouro;

/* Relatório usando junção de equivalência - Agrupa as tabelas de usuário e tipos_plastico usando a tabela plastico_usuario
como intermediaria para encontrar o realcionamento entre os ids dos usuarios e dos plasticos. 
Retorna os nm_usuario e ds_tipo_plastico */
SELECT U.nm_usuario, TP.ds_tipo_plastico
FROM T_SGDR_USUARIO U
JOIN T_SGDR_PLASTICO_USUARIO PU ON U.id_usuario = PU.id_usuario
JOIN T_SGDR_TIPOS_PLASTICO TP ON PU.id_plastico = TP.id_plastico;

/* Relatório usando junção de diferença - Retorna os plasticos que existem na tabela da esquerda (tipo_plastico) 
que não existem na tabela da direita (plastico_cooperativa)*/
SELECT tp.*
FROM T_SGDR_TIPOS_PLASTICO tp
LEFT JOIN T_SGDR_PLASTICO_COOPERATIVA pc ON tp.id_plastico = pc.id_plastico
WHERE pc.id_plastico IS NULL;
