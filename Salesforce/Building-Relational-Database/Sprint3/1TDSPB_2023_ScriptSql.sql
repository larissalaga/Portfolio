--NOME: Larissa Araújo Gama	RM:964996
--NOME: Larissa Lopes Oliveira	RM:552628
--NOME: Luna Faustino Lima	RM:552473

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
    cpf_cliente VARCHAR2(13 CHAR) PRIMARY KEY,
    ind_profissao   VARCHAR2(100 CHAR) NOT NULL,
    ind_dt_nascimento  DATE NOT NULL,
    ind_sexo    CHAR(2 CHAR) CHECK (ind_sexo IN ('F','M','NA')),
    ind_escolaridade    CHAR(3) NOT NULL CHECK(ind_escolaridade IN ('AN','EFC','EFI','EMC','EMI','ET','ESC','ESI','PGC','PGI')),
    fk_cod_cliente  INTEGER NOT NULL,
    FOREIGN KEY (fk_cod_cliente) REFERENCES T_SGDD_CLIENTE(cod_cliente)
);

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
CREATE TABLE T_CLIENTE_PRODUTO (
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


