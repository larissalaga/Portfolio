--NOME: Larissa Araújo Gama	RM:964996
--NOME: Larissa Lopes Oliveira	RM:552628
--NOME: Luna Faustino Lima	RM:552473

DROP TABLE T_SGDD_CLIENTE;
DROP TABLE T_SGDD_CLIENTE_FUNCIONARIO;
DROP TABLE T_SGDD_CLIENTE_PF;
DROP TABLE T_SGDD_CLIENTE_PJ;
DROP TABLE T_SGDD_CONTATO;
DROP TABLE T_SGDD_ENDERECO;
DROP TABLE T_SGDD_FUNC_PROD;
DROP TABLE T_SGDD_FUNC_SALESFORCE;
DROP TABLE T_SGDD_SERVICO_PRODUTO;
DROP TABLE T_CLIENTE_PRODUTO;


--Cria o banco de dados
CREATE DATABASE SGDD;
--Seleciona o banco de dados
USE SGDD;
--Cria a tabela cliente
CREATE TABLE T_SGDD_CLIENTE(
    cod_cliente INTEGER PRIMARY KEY,
    nm_cliente  VARCHAR2(50 CHAR) NOT NULL
);

--Cria a tabela de produtos e serviços
CREATE TABLE T_SGDD_SERVICO_PRODUTO(
    id_codigo_produto   INTEGER PRIMARY KEY,
    ds_produto_servico  VARCHAR2(1000 CHAR) NOT NULL,
    dt_duracao_prazo_licensa    DATE NOT NULL,
    vl_unitario_projeto NUMBER NOT NULL,
    nm_produto_servico  VARCHAR2(30 CHAR) NOT NULL,
    ind_tipo    CHAR(1 CHAR) NOT NULL CHECK (ind_tipo IN ('P','S')),
    st_disponibilidade  CHAR(3) NOT NULL CHECK(st_disponibilidade IN ('DIS','IND'))
);

/*Na coluna tipo as letras significam:
P-produto
S-serviço

Na coluna de disponibilidade as siglas significam:
DIS-Disponivel
IND- Indisponivel*/

--Cria a tabela de funcionário da Salesforce
CREATE TABLE T_SGDD_FUNC_SALESFORCE(
    id_funcio   INTEGER PRIMARY KEY,
    nm_funcionario  VARCHAR2(50 CHAR) NOT NULL,
    num_idade   INTEGER,
    ind_funcao  VARCHAR2(50 CHAR),
    dt_admissao DATE NOT NULL 
);
--Cria a tabela de contato
CREATE TABLE T_SGDD_CONTATO(
    nm_telefone_celular VARCHAR2(14 CHAR) NOT NULL,
    nm_telefone_fixo_fax    VARCHAR2(13 CHAR),
    email   VARCHAR2(70 CHAR) NOT NULL,
    fk_cod_cliente  INTEGER NOT NULL,
    FOREIGN KEY (fk_cod_cliente) REFERENCES T_SGDD_CLIENTE(cod_cliente)
);
--Cria a tabela filha de cliente pessoa júridica
CREATE TABLE T_SGDD_CLIENTE_PJ (
    cnpj_cliente    CHAR(17 CHAR) PRIMARY KEY,
    nm_razao_social VARCHAR2(100 CHAR),
    ind_setor_responsavel   VARCHAR2(50 CHAR),
    qt_funcionario_empresa  CHAR(25) CHECK (qt_funcionario_empresa IN ('1-50 funcionários','51-300 funcionários','301-1,000 funcionários','1,001-2,000 funcionários','+2,000 funcionários')),
    fk_cod_cliente  INTEGER NOT NULL,
    FOREIGN KEY (fk_cod_cliente) REFERENCES T_SGDD_CLIENTE(cod_cliente)
);
--cria a tabela filha de cliente pessoa fisica
CREATE TABLE T_SGDD_CLIENTE_PF(
    cpf_cliente VARCHAR2(14 CHAR) PRIMARY KEY,
    ind_profissao   VARCHAR2(100 CHAR) NOT NULL,
    ind_dt_nascimento  DATE NOT NULL,
    ind_sexo    CHAR(2 CHAR) CHECK (ind_sexo IN ('F','M','NA')),
    ind_escolaridade    CHAR(3) NOT NULL CHECK(ind_escolaridade IN ('AN','EFC','EFI','EMC','EMI','ET','ESC','ESI','PGC','PGI')),
    fk_cod_cliente  INTEGER NOT NULL,
    FOREIGN KEY (fk_cod_cliente) REFERENCES T_SGDD_CLIENTE(cod_cliente)
);


    
ALTER TABLE T_SGDD_CLIENTE_PJ
    MODIFY cnpj_cliente VARCHAR(18 CHAR);

/* Na coluna de escolaridade as siglas significam:
AN-analfabeto
EFC- Ensino Fundamental Completo
EFI- Ensino Fundamental Incompleto
EMC - Ensino Médio Completo
EMI - Ensino Médico Incompleto
ET - Ensino Técnico
ESC- Ensino Superior Completo
ESI- Ensino Superior Incompleto
PGC- Pós Graduação Completo
PGI- Pós Graduação Incompleto*/

/*Na coluna de sexo as letras e siglas significam:
F-Femnino
M-Masculino
NA-Não informado
*/
--cria a tabela de endereço
CREATE TABLE T_SGDD_ENDERECO(
    num_cep_codigo_postal   VARCHAR2(9 CHAR) PRIMARY KEY,
    nm_pais VARCHAR2(30 CHAR),
    nm_cidade   VARCHAR2(50 CHAR),
    nm_logradouro   VARCHAR2(70 CHAR),
    num_predio_casa INTEGER,
    uf_estado_provincia CHAR(2 CHAR) CHECK(uf_estado_provincia IN ('RO','AC','AM','RR','PA','AP','TO','MA','PI','CE',
    'RN','PB','PE','AL','SE','BA','MG','ES','RJ','SP','PR','SC','RS','MS','MT','GO','DF','OT')),
    fk_cod_cliente  INTEGER NOT NULL,
    FOREIGN KEY (fk_cod_cliente) REFERENCES T_SGDD_CLIENTE(cod_cliente)
);

/*Na coluna uf do estado as siglas significam:
Rondônia-RO
Acre-AC
Amazonas-AM
Roraima	-RR
Pará-PA
Amapá-AP
Tocantins-TO
Maranhão-MA
Piauí-PI
Ceará-CE
Rio Grande do Norte-RN
Paraíba-PB
Pernambuco-PE
Alagoas-AL
Sergipe-SE
Bahia-BA
Minas Gerais-MG
Espírito Santo-ES
Rio de Janeiro-RJ
São Paulo-SP
Paraná-PR
Santa Catarina-SC
Rio Grande do Sul-RS
Mato Grosso do Sul-MS
Mato Grosso-MT
Goiás-GO
Distrito Federal-DF
OT-Outro
*/
--cria a tabela de relacionamento entre cliente e produto
CREATE TABLE T_SGDD_CLIENTE_PRODUTO (
    fk_cod_cliente  INTEGER NOT NULL,  
    fk_id_codigo_produto    INTEGER NOT NULL,
    FOREIGN KEY (fk_cod_cliente) REFERENCES T_SGDD_CLIENTE(cod_cliente),
    FOREIGN KEY (fk_id_codigo_produto) REFERENCES T_SGDD_SERVICO_PRODUTO(id_codigo_produto)
);
--cria a tabela de relacionamento entre cliente e funcionario
CREATE TABLE T_SGDD_CLIENTE_FUNCIONARIO(
    fk_cod_cliente  INTEGER NOT NULL,
    fk_id_funcio    INTEGER NOT NULL,
    FOREIGN KEY (fk_cod_cliente) REFERENCES T_SGDD_CLIENTE(cod_cliente),
    FOREIGN KEY (fk_id_funcio) REFERENCES T_SGDD_FUNC_SALESFORCE(id_funcio)
);
--cria a tabela de relacionamento entre funcionario e produto
CREATE TABLE T_SGDD_FUNC_PROD ( 
    fk_id_funcio    INTEGER NOT NULL,
    FOREIGN KEY (fk_id_funcio) REFERENCES T_SGDD_FUNC_SALESFORCE(id_funcio),
    fk_id_codigo_produto    INTEGER NOT NULL,
    FOREIGN KEY (fk_id_codigo_produto) REFERENCES T_SGDD_SERVICO_PRODUTO(id_codigo_produto)
);

--Insert tabela cliente
INSERT INTO T_SGDD_CLIENTE (cod_cliente, nm_cliente) VALUES (1, 'João Silva');
INSERT INTO T_SGDD_CLIENTE (cod_cliente, nm_cliente) VALUES (2, 'Maria Oliveira');
INSERT INTO T_SGDD_CLIENTE (cod_cliente, nm_cliente) VALUES (3, 'Pedro Santos');
INSERT INTO T_SGDD_CLIENTE (cod_cliente, nm_cliente) VALUES (4, 'Ana Costa');
INSERT INTO T_SGDD_CLIENTE (cod_cliente, nm_cliente) VALUES (5, 'Luiza Pereira');
INSERT INTO T_SGDD_CLIENTE (cod_cliente, nm_cliente) VALUES (6, 'Carlos Almeida');
INSERT INTO T_SGDD_CLIENTE (cod_cliente, nm_cliente) VALUES (7, 'Ana Pereira');
INSERT INTO T_SGDD_CLIENTE (cod_cliente, nm_cliente) VALUES (8, 'Bruno Silva');
INSERT INTO T_SGDD_CLIENTE (cod_cliente, nm_cliente) VALUES (9, 'Claudia Souza');
INSERT INTO T_SGDD_CLIENTE (cod_cliente, nm_cliente) VALUES (10, 'Diego Fernandes');
INSERT INTO T_SGDD_CLIENTE (cod_cliente, nm_cliente) VALUES (11, 'Eliana Costa');


--Insert na tabela de serviços e produtos
INSERT INTO T_SGDD_SERVICO_PRODUTO (id_codigo_produto, ds_produto_servico, dt_duracao_prazo_licensa, vl_unitario_projeto, nm_produto_servico, ind_tipo, st_disponibilidade) 
VALUES (1, 'Sales Cloud - CRM para vendas e gestão de contatos', TO_DATE('2024-05-16', 'YYYY-MM-DD'), 1000.00, 'Sales Cloud', 'S', 'DIS');

INSERT INTO T_SGDD_SERVICO_PRODUTO (id_codigo_produto, ds_produto_servico, dt_duracao_prazo_licensa, vl_unitario_projeto, nm_produto_servico, ind_tipo, st_disponibilidade) 
VALUES (2, 'Service Cloud - CRM para atendimento e suporte', TO_DATE('2024-05-16', 'YYYY-MM-DD'), 1200.00, 'Service Cloud', 'S', 'DIS');

INSERT INTO T_SGDD_SERVICO_PRODUTO (id_codigo_produto, ds_produto_servico, dt_duracao_prazo_licensa, vl_unitario_projeto, nm_produto_servico, ind_tipo, st_disponibilidade) 
VALUES (3, 'Marketing Cloud - Automação de marketing e e-mail', TO_DATE('2024-05-16', 'YYYY-MM-DD'), 1500.00, 'Marketing Cloud', 'S', 'DIS');

INSERT INTO T_SGDD_SERVICO_PRODUTO (id_codigo_produto, ds_produto_servico, dt_duracao_prazo_licensa, vl_unitario_projeto, nm_produto_servico, ind_tipo, st_disponibilidade) 
VALUES (4, 'Commerce Cloud - Plataforma de comércio eletrônico', TO_DATE('2024-05-16', 'YYYY-MM-DD'), 2000.00, 'Commerce Cloud', 'S', 'DIS');

INSERT INTO T_SGDD_SERVICO_PRODUTO (id_codigo_produto, ds_produto_servico, dt_duracao_prazo_licensa, vl_unitario_projeto, nm_produto_servico, ind_tipo, st_disponibilidade) 
VALUES (5, 'Salesforce Inbox - E-mail e agenda integrados ao CRM', TO_DATE('2024-05-16', 'YYYY-MM-DD'), 500.00, 'Salesforce Inbox', 'P', 'DIS');

INSERT INTO T_SGDD_SERVICO_PRODUTO (id_codigo_produto, ds_produto_servico, dt_duracao_prazo_licensa, vl_unitario_projeto, nm_produto_servico, ind_tipo, st_disponibilidade) 
VALUES (6, 'Salesforce Einstein - Inteligência artificial para CRM', TO_DATE('2024-05-16', 'YYYY-MM-DD'), 2500.00, 'Salesforce Einstein', 'P', 'DIS');

--Inserts na tabela de cliente pf
INSERT INTO T_SGDD_CLIENTE_PF (cpf_cliente, ind_profissao, ind_dt_nascimento, ind_sexo, ind_escolaridade, fk_cod_cliente) 
VALUES ('123.456.789-10', 'Engenheiro de Software', TO_DATE('1990-03-15', 'YYYY-MM-DD'), 'M', 'EMI', 1);

INSERT INTO T_SGDD_CLIENTE_PF (cpf_cliente, ind_profissao, ind_dt_nascimento, ind_sexo, ind_escolaridade, fk_cod_cliente) 
VALUES ('234.567.890-21', 'Administradora', TO_DATE('1985-07-20', 'YYYY-MM-DD'), 'F', 'ESI', 2);

INSERT INTO T_SGDD_CLIENTE_PF (cpf_cliente, ind_profissao, ind_dt_nascimento, ind_sexo, ind_escolaridade, fk_cod_cliente) 
VALUES ('345.678.901-32', 'DBA', TO_DATE('1978-11-10', 'YYYY-MM-DD'), 'M', 'PGI', 3);

--Inserts na tabela de ciente pj
INSERT INTO T_SGDD_CLIENTE_PJ (cnpj_cliente, nm_razao_social, ind_setor_responsavel, qt_funcionario_empresa, fk_cod_cliente) 
VALUES ('45.678.901/0001-23', 'Tech Solutions LTDA', 'Tecnologia da Informação', '51-300 funcionários', 4);

INSERT INTO T_SGDD_CLIENTE_PJ (cnpj_cliente, nm_razao_social, ind_setor_responsavel, qt_funcionario_empresa, fk_cod_cliente) 
VALUES ('56.789.012/0001-34', 'Legal Consultoria Empresarial S/A', 'Jurídico', '301-1,000 funcionários', 5);

INSERT INTO T_SGDD_CLIENTE_PJ (cnpj_cliente, nm_razao_social, ind_setor_responsavel, qt_funcionario_empresa, fk_cod_cliente) 
VALUES ('67.890.123/0001-45', 'Hospital São Lucas', 'Saúde', '1,001-2,000 funcionários', 6);

--Criação de views para acompanhar resultados das tabelas
SELECT * FROM T_SGDD_CLIENTE;
SELECT * FROM T_SGDD_SERVICO_PRODUTO;
SELECT * FROM T_SGDD_CLIENTE_PF;
SELECT * FROM T_SGDD_CLIENTE_PJ;

--Update na tabela cliente
UPDATE T_SGDD_CLIENTE
SET nm_cliente='Maria Cruz'
WHERE cod_cliente=2;

--Update na tabela herança de cliente pessoa física
UPDATE T_SGDD_CLIENTE_PF
SET ind_profissao='Administrador Salesforce'
WHERE fk_cod_cliente = 1;

----Update na tabela herança de cliente pessoa jurídica
UPDATE T_SGDD_CLIENTE_PJ
SET nm_razao_social='Hospital São Luccas Carlos'
WHERE fk_cod_cliente=6;


--Deletando linhas da tabela cliente
DELETE FROM T_SGDD_CLIENTE
WHERE cod_cliente=7;

DELETE FROM T_SGDD_CLIENTE
WHERE cod_cliente=9;

DELETE FROM T_SGDD_CLIENTE
WHERE cod_cliente=11;

--Relatório sobre produtos Salesforce, resto da divisão do preço por 7.
SELECT MOD(VL_UNITARIO_PROJETO, 7) FROM T_SGDD_SERVICO_PRODUTO;

--Relatório sobre clientes, Inner Join entre as tabelas clientes e cliente pessoa física
SELECT T_SGDD_CLIENTE.nm_cliente FROM T_SGDD_CLIENTE
INNER JOIN T_SGDD_CLIENTE_PF ON T_SGDD_CLIENTE.cod_cliente = T_SGDD_CLIENTE_PF.fk_cod_cliente;

--Relatório sobre clientes, apenas clientes com o código maior que 5;
SELECT nm_cliente FROM T_SGDD_CLIENTE
WHERE cod_cliente IN (SELECT cod_cliente FROM T_SGDD_CLIENTE WHERE cod_cliente > 5);

--Relatório de agrupamento entre as tabelas cliente e cliente pessoa física, 
--mostrando a quantidade de clientes que possui cada modalidade de escolaridade.
SELECT
    pf.ind_escolaridade,
    COUNT(*) AS total_clientes
FROM
    T_SGDD_CLIENTE_PF pf
JOIN
    T_SGDD_CLIENTE c ON pf.fk_cod_cliente = c.cod_cliente
GROUP BY
    pf.ind_escolaridade;
