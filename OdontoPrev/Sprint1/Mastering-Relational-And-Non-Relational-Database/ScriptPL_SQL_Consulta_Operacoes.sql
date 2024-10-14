--Inner Join entre as tabelas T_OPBD_PACIENTE E T_OPBD_PLANO, utilizando també GROUP BY E ORDER BY.

SET SERVEROUTPUT ON;

BEGIN
    FOR lin IN(
        SELECT pl.nm_plano, COUNT(distinct p.nr_cpf) AS total_pacientes
        FROM T_OPBD_PACIENTE p
        INNER JOIN T_OPBD_PLANO pl ON p.id_plano = pl.id_plano
        GROUP BY pl.nm_plano
        ORDER BY pl.nm_plano
    ) LOOP
        DBMS_OUTPUT.PUT_LINE('Plano: ' || lin.nm_plano || ', Total de pacientes no plano: ' || lin.total_pacientes);
    END LOOP;
END;

--------------------------------------------------------------------------------------------------------------------------------
--Left Join entre as tabelas T_OPBD_PACIENTE E T_OPBD_EXTRATO_PONTOS, utilizando també GROUP BY E ORDER BY.

BEGIN
    FOR linha IN (
        SELECT p.nm_paciente, p.nr_cpf, p.ds_email, NVL(SUM(e.nr_numero_pontos), 0) AS total_pontos 
        FROM T_OPBD_PACIENTE p 
        LEFT JOIN T_OPBD_EXTRATO_PONTOS e ON p.id_paciente = e.id_paciente
        GROUP BY p.nr_cpf, p.nm_paciente, p.ds_email
        ORDER BY p.nm_paciente        
    ) LOOP
        DBMS_OUTPUT.PUT_LINE('Paciente: ' || linha.nm_paciente || ', CPF: ' || linha.nr_cpf ||', E-mail: ' || linha.ds_email ||'. Total pontos: ' || linha.total_pontos );
    END LOOP;
END;

--------------------------------------------------------------------------------------------------------------------------------
--Right Join entre as tabelas T_OPBD_PERGUNTAS E T_OPBD_RESPOSTAS, utilizando també GROUP BY E ORDER BY.

BEGIN
    FOR ques IN (
        SELECT p.ds_pergunta, NVL(r.ds_resposta, 'Em branco') AS ds_resposta, COUNT(*) AS numero_respostas
        FROM T_OPBD_RESPOSTAS r
        RIGHT JOIN T_OPBD_PERGUNTAS p ON p.id_pergunta = r.id_pergunta
        GROUP BY p.ds_pergunta, r.ds_resposta
        ORDER BY p.ds_pergunta, r.ds_resposta
    
    )LOOP
        DBMS_OUTPUT.PUT_LINE('Pergunta: ' || ques.ds_pergunta || 'Resposta: ' || ques.ds_resposta || ', Total Respostas: ' || ques.numero_respostas);
    END LOOP;
END;

--------------------------------------------------------------------------------------------------------------------------------
--Estruturas de Decisão e Operações DML em Blocos Anônimos 
--Busca o paciente por cpf, retorna o id e deleta valores duplicados

SELECT * FROM T_OPBD_PACIENTE;

DECLARE
    cpf NUMBER;
    paciente_encontrado BOOLEAN := FALSE;
    
    CURSOR pacientesDuplicados IS
    SELECT ID_PACIENTE, NM_PACIENTE
    FROM T_OPBD_PACIENTE
    WHERE NR_CPF = cpf
    ORDER BY ID_PACIENTE
    OFFSET 1 ROWS;
BEGIN
    cpf := '01478786315';
    FOR pac IN pacientesDuplicados LOOP
        paciente_encontrado := TRUE;
        DELETE FROM T_OPBD_PACIENTE WHERE ID_PACIENTE = pac.ID_PACIENTE;
        DBMS_OUTPUT.PUT_LINE('Deletada duplicata do paciente: ' || pac.NM_PACIENTE || ', (id ' || pac.ID_PACIENTE || ')');
    END LOOP;
    IF NOT paciente_encontrado THEN
        DBMS_OUTPUT.PUT_LINE('CPF não encontrado: ' || cpf);
    END IF;
EXCEPTION
    WHEN OTHERS THEN
        DBMS_OUTPUT.PUT_LINE('ERRRO...');
END;
--------------------------------------------------------------------------------------------------------------------------------
--Baseado no CPF pega o id e altera no nome do paciente

DECLARE
    cpf NUMBER;
    novo_nome VARCHAR(60);
    id_pac NUMBER;
    paciente_encontrado BOOLEAN := FALSE;

    CURSOR pacientes IS
    SELECT ID_PACIENTE, NM_PACIENTE FROM T_OPBD_PACIENTE
    WHERE NR_CPF = cpf;
BEGIN
    cpf := '86523014563';
    novo_nome := 'Beto';
    FOR pac IN pacientes LOOP
        paciente_encontrado := TRUE;
        id_pac := pac.id_paciente;
        UPDATE T_OPBD_PACIENTE SET nm_paciente = novo_nome WHERE id_paciente = id_pac;
        DBMS_OUTPUT.PUT_LINE('Alterado nome de paciente ' || pac.id_paciente || ' de ' || pac.nm_paciente || ' para ' || novo_nome);
    END LOOP;
    IF NOT paciente_encontrado THEN
        DBMS_OUTPUT.PUT_LINE('CPF não encontrado: ' || cpf);
    END IF;
EXCEPTION
    WHEN others THEN
        DBMS_OUTPUT.PUT_LINE('ERRO');
END;
    
