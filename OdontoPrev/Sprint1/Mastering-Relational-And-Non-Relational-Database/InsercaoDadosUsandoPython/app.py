from queue import Full
from key import USER, PASS 
import oracledb

dsn = oracledb.makedsn('oracle.fiap.com.br', 1521, service_name='orcl')
connection = oracledb.connect(user=USER, password=PASS, dsn=dsn)


cursor = connection.cursor()

listaPlanos = [
    ("ODP001", 'Básico'),
    ("ODP002", 'Intermediário'),
    ("ODP003", 'Premium'),
    ("ODP004", 'Empresarial'),
    ("ODP005", 'Familiar'),
    ("ODP006", 'Executivo'),
    ("ODP007", 'Estudante'),
    ("ODP008", 'Infantil'),
    ("ODP009", 'Senior'),
    ("ODP010", 'Master')
]

listaDentistas = [
    ('Dr. Otto Canino', 'CRO312544', 'otto.canino@gmail.com', '31932158752', '12345678901'),
    ('Dr. Ben Dente', 'CR245565', 'ben.dente@gmail.com', '62901985212', '55963214586'),
    ('Dr. Álvaro Canal', 'CR52865', 'alvaro.canal@gmail.com', '11999855776', '55698756324'),
    ('Dra. Marina Molar', 'CR986422', 'marina.molar@gmail.com', '11933255774', '745203698'),
    ('Dr. Ali Vramento', 'CR098964', 'ali.vramento@gmail.com', '45988552211', '99632566871'),
    ('Dra. Aparecida do Sorriso', 'CRO99001', 'aparecida.sorriso@gmail.com', '84966665786', '85321456852'),
    ('Dra. Isa Carie', 'CR856934', 'isa.carie@gmail.com', '11955863320', '63211458624'),
    ('Dra. Clara Mente', 'CR125863', 'clara.mente@gmail.com', '3394563325', '20453065830'),
    ('Dr. Cláudio Gengiva', 'CRO88990', 'claudio.gengiva@gmail.com', '2733755886', '55532569852'),
    ('Dra. Sonia Brilho', 'CR203587', 'sonia.brilho@gmail.com', '63977523258', '96307485630')
]

listaPacientes = [
    ('Beto Mal Hálito', '06/02-1990', '86523014563', 'M', '27965563215', 'beto.halito@gmail.com', 1),
    ('Branca Dente', '31/10/1987', '03251478563', 'F', '11975853524', 'branca.dente@gmail.com', 2),
    ('Geni giva', '18/01/1995', '18207586322', 'F', '31963254785', 'geni.giva@gmail.com', 3),
    ('João Tártaro', '06/02/1992', '98547523045', 'M', '35932100586', 'joao.tartaro@gmail.com', 4),
    ('Carie Alves', '25/11/1983', '69854752365', 'N', '45932014563', 'carie.alves@gmail.com', 5),
    ('Sara Dente', '20/08/1991', '01478786315', 'N', '54946852335', 'sara.dente@gmail.com', 6),
    ('Ligia Dor', '30/06/1988', '55075625864', 'F', '11985652545', 'ligia.dor@gmail.com', 7),
    ('Ryan Quebrado', '01/09/1990', '75321589635', 'N', '25975254562', 'ryan.quebrado@gmail.com', 8),
    ('Ronaldo Banguela', '22/03/1994', '75201458632', 'M', '11998547565', 'ronaldo.banguela@gmail.com', 5),
    ('Josefina Quebra Queixo', '09/03/1985', '75420145863', 'F', '32963254777', 'josefina.quebra.queixo@gmail.com', 10)
]

listaPerguntas = [
            'Você é fumante?',
            'Você ja visitou um dentista esse ano?',
            'Você sente dor ao mastigar?',
            'Você já fez limpeza dentária esse ano?',
            'Você já escovou os dentes hoje?',
            'Você tem algum problema de gengiva?',
            'Você ja fez tratamento de canal?',
            'Você usa fio dental regularmente?',
            'Você já extraiu algum dente?',
            'Você masca chicletes com frequência?'
        ]

listaExtratoPontos = [
            ('25/05/2022', 100, 'Respondeu a pergunta'),
            ('13/12/2019', 150, 'Resgatou pontos'),
            ('05/05/2024', 200, 'Respondeu a pergunta'),
            ('03/02/2024', 250, 'Enviou Raio X'),
            ('09/07/2022', 300, 'Fez uma limpeza'),
            ('28/04/2021', 350, 'Fez uma avaliação'),
            ('07/07/2023', 400, 'Resgatou pontos'),
            ('19/11/2023', 450, 'Respondeu a pergunta'),
            ('27/06/2022', 500, 'Fez uma limpeza'),
            ('22/07/2020', 550, 'Enviou Raio X')
        ]

respostas = [
            ('Sim', '02/02/2024', 3, 1),
            ('Não', '02/02/2024', 3, 2),
            ('Sim', '02/02/2024', 3, 3),
            ('Sim', '02/02/2024', 3, 4),
            ('Não', '02/02/2024', 3, 5),
            ('Sim', '02/02/2024', 3, 6),
            ('Não', '02/02/2024', 3, 7),
            ('Sim', '02/02/2024', 3, 8),
            ('Não', '02/02/2024', 3, 9),
            ('Sim', '02/02/2024', 3, 10)
        ]

listaRaioX = [
            (None, '02/01/2024', 1),
            (None, '05/02/2024', 2),
            (None, '08/03/2024', 3),
            (None, '11/04/2024', 4),
            (None, '15/05/2024', 5),
            (None, '19/06/2024', 6),
            (None, '23/07/2024', 7),
            (None, '28/08/2024', 8),
            (None, '02/09/2024', 9),
            (None, '06/10/2024', 10)
        ]

listaAnaliseRaioX = [
        ('Cáries nos dentes superiores', '05/01/2024', 1),
        ('Infecção no dente molar', '10/02/2024', 2),
        ('Abscesso no pré-molar', '15/03/2024', 3),
        ('Perda óssea devido à periodontite', '20/04/2024', 4),
        ('Dente impactado no siso inferior', '25/05/2024', 5),
        ('Lesão óssea na mandíbula', '30/06/2024', 6),
        ('Fratura dentária no incisivo', '05/07/2024', 7),
        ('Dente supranumerário detectado no maxilar superior', '10/08/2024', 8),
        ('Cisto dentário em formação ao redor do canino', '15/09/2024', 9),
        ('Cárie radicular no molar inferior direito', '20/10/2024', 10)
    ]

listaPacienteDentista = [
            (1, 1),
            (2, 2),
            (3, 3),
            (4, 4),
            (5, 5),
            (6, 6),
            (7, 7),
            (8, 8),
            (9, 9),
            (10, 10)
        ]

try:

    for plano in listaPlanos:
        cursor.execute("INSERT INTO T_OPBD_PLANO VALUES (SEQ_T_OPBD_PLANO.NEXTVAL, :1, :2)", plano)
        connection.commit()
        print("Plano inserido com sucesso!")

    for dentista in listaDentistas:
        cursor.execute("INSERT INTO T_OPBD_DENTISTA VALUES (SEQ_T_OPBD_DENTISTA.NEXTVAL, :1, :2, :3, :4, :5)", dentista)
        connection.commit()
        print("Dentista inserido com sucesso!")

    for paciente in listaPacientes:
        cursor.execute("INSERT INTO T_OPBD_PACIENTE VALUES (SEQ_T_OPBD_PACIENTE.NEXTVAL, :1, TO_DATE(:2, 'DD/MM/YYYY'), :3, :4, :5, :6, :7)", paciente)
        connection.commit()
        print("Paciente inserido com sucesso!")
    
    for pergunta in listaPerguntas:
        cursor.execute("INSERT INTO T_OPBD_PERGUNTAS VALUES (SEQ_T_OPBD_PERGUNTAS.NEXTVAL, :1)", [pergunta])
        connection.commit()
        print("Pergunta inserida com sucesso!")
    
    for extrato in listaExtratoPontos:
        cursor.execute("INSERT INTO T_OPBD_EXTRATO_PONTOS VALUES (SEQ_T_OPBD_EXTRATO_PONTOS.NEXTVAL, TO_DATE(:1, 'DD/MM/YYYY'), :2, :3, 2)", extrato)
        connection.commit()
        print("Extrato inserido com sucesso!")
    
    for resposta in respostas:
        cursor.execute("INSERT INTO T_OPBD_RESPOSTAS VALUES (SEQ_T_OPBD_RESPOSTAS.NEXTVAL, :1, TO_DATE(:2, 'DD/MM/YYYY'), :3, :4)", resposta)
        connection.commit()
        print("Resposta inserida com sucesso!")
    
    for raioX in listaRaioX:
        cursor.execute("INSERT INTO T_OPBD_RAIO_X VALUES (SEQ_T_OPBD_RAIO_X.NEXTVAL, :1, TO_DATE(:2, 'DD/MM/YYYY'), :3)", raioX)
        connection.commit()
        print("Raio X inserido com sucesso!")
    
    for analise in listaAnaliseRaioX:
        cursor.execute("INSERT INTO T_OPBD_ANALISE_RAIO_X VALUES (SEQ_T_OPBD_ANALISE_RAIO_X.NEXTVAL, :1, TO_DATE(:2, 'DD/MM/YYYY'), :3)", analise)
        connection.commit()
        print("Análise inserida com sucesso!")
    
    for pacienteDentista in listaPacienteDentista:
        cursor.execute("INSERT INTO T_OPBD_PACIENTE_DENTISTA VALUES (:1, :2)", pacienteDentista)
        connection.commit()
        print("Paciente-Dentista inserido com sucesso!")

except oracledb.DatabaseError as e:
    error, = e.args
    print(f"Erro no banco de dados: {error.code} - {error.message}")
    connection.rollback() 
finally:
    cursor.close()
    connection.close()


