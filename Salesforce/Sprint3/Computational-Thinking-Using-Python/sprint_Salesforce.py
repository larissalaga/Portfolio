import csv
import re
import sys

caminhoArquivo = 'Python/FakeName.csv'
camposArquivo = ['CPF','NOME','SOBRENOME','IDADE','GENERO','EMAIL','TELEFONE','CIDADE','ESTADO','PAÍS','CARGO','EMPRESA']

def criar_arquivo():  
    try:
        with open(caminhoArquivo, 'w', encoding='utf-8', newline='') as arquivo_csv:
            fieldnames = camposArquivo
            writer = csv.DictWriter(arquivo_csv, fieldnames=fieldnames)
            writer.writeheader()
    except:
        print("Ops... Não foi possível salvar o arquivo.")

def ler_arquivo():
    agenda = []
    try:
        with open(caminhoArquivo,'r', encoding='utf-8', newline='') as arquivo_csv:
            leitor_csv = csv.DictReader(arquivo_csv)
            cabecalho = leitor_csv.fieldnames
            for linha in leitor_csv:
                agenda.append(linha)
    except:
        print("Ops... Não foi possível abrir o arquivo.")
        sys.exit()
    return([agenda, cabecalho])

def salvar_arquivo(agenda, cabecalho):
    try:
        print(agenda) 
        print(cabecalho) 
        with open(caminhoArquivo, 'w', encoding='utf-8', newline='') as csvfile:
            fieldnames = cabecalho
            writer = csv.DictWriter(csvfile, fieldnames=fieldnames)     
            writer.writeheader()
            for cliente in agenda:
                writer.writerow(cliente)
    except:
        print("Ops... Não foi possível salvar o arquivo.")

def buscarCliente(agenda):
        cliente = {}
        nome_cpf = input("Deseja buscar por: \n"+
                        "1-Nome \n" +
                        "2-CPF: \n")     
        try:
            if nome_cpf == "1":
                nome_buscado = input("Digite o nome a ser buscado: \n")
                cliente = ler_cliente_nome(agenda, nome_buscado)
            elif nome_cpf == "2":
                cpf_buscado = input("Digite o CPF a ser buscado: \n")       
                while cpf_valido(cpf_buscado) == False:
                    cpf_buscado = (input("\nCPF inválido, digite novamente: \n"))
                cliente = ler_cliente_cpf(agenda, cpf_buscado)                                    
        except:
            print("Opção invalida")
        finally: 
            if (cliente):
                return(cliente)
            else:
                return False
                    
def ler_cliente_nome(agenda, nome_buscado):    
    for cliente in agenda:
        if cliente['NOME'].lower() == nome_buscado.lower() :
            return(cliente)
    return(False)

def ler_cliente_cpf(agenda, cpf_buscado):    
    for cliente in agenda:                
        if cpf_limpo(cliente['CPF']) == cpf_limpo(cpf_buscado):
            return(cliente)
    return(False)

def cpf_limpo(cpf):
    return(re.sub('[^0-9]+', '', cpf))

def cpf_valido(cpf):
    return(len(cpf_limpo(cpf)) == 11)

def email_valido(email):    
    return(re.match(r"^\S+@\S+\.\S+$", email) != None)

def telefone_limpo(telefone):
    return(re.sub('[^0-9]+', '', telefone))

def telefone_valido(telefone):
    return(len(telefone_limpo(telefone)) == 11 or len(telefone_limpo(telefone))== 13)

def adicionar_cliente(agenda):
    novo_cpf = (input("Informe o CPF do cliente que deseja adicionar: \n"))
    while cpf_valido(novo_cpf) == False:
        novo_cpf = (input("\nCPF inválido, digite novamente: \n"))
    if (ler_cliente_cpf(agenda, novo_cpf)):
        return(False)
    else:
        cliente = {}
        cliente['CPF'] = novo_cpf
        cliente['NOME'] = input("Informe o primeiro nome: \n")
        cliente['SOBRENOME'] = input("Informe o sobrenome: \n")
        while True:
            try:
                cliente['IDADE'] = int(input("Informe a idade: \n"))
                break
            except: 
                print("\nIdade inválida, digite somente números.")
        cliente['GENERO'] = input("Informe o genero: \n")
        cliente['EMAIL'] = input("Informe o email: \n")
        while email_valido(cliente['EMAIL']) == False:
            cliente['EMAIL'] = input("\nEmail inválido, digite novamente:  \n")
        cliente['TELEFONE'] = input("Informe o telefone, com DDD: ex: 5531998765432 ou 31998765432\n")
        while telefone_valido(cliente['TELEFONE']) == False:
            cliente['TELEFONE'] = input("\nTelefone inválido, digite novamente:  \n")
        cliente['CIDADE'] = input("Informe a Cidade: \n")
        cliente['ESTADO'] = input("Informe o Estado: \n")
        cliente['PAÍS'] = input("Informe o País: \n")
        cliente['CARGO'] = input("Informe o cargo: \n")
        cliente['EMPRESA'] = input("Informe o nome da Empresa: \n")        
        return(cliente)

def editar_cliente(cliente):
    cliente['NOME'] = input("Informe o novo primeiro nome: \n")
    cliente['SOBRENOME'] = input("Informe o novo sobrenome: \n")
    while True:
        try:
            cliente['IDADE'] = int(input("Informe a idade: \n"))
            break
        except: 
            print("\nIdade inválida, digite somente números.")
    cliente['GENERO'] = input("Informe o genero: \n")
    cliente['EMAIL'] = input("Informe o novo email: \n")
    while email_valido(cliente['EMAIL']) == False:
        cliente['EMAIL'] = input("\nEmail inválido, digite novamente:  \n")
    cliente['TELEFONE'] = input("Informe o novo telefone, com DDD: ex: 5531998765432 ou 31998765432\n")
    while telefone_valido(cliente['TELEFONE']) == False:
        cliente['TELEFONE'] = input("\nTelefone inválido, digite novamente:  \n")
    cliente['CIDADE'] = input("Informe a nova Cidade: \n")
    cliente['ESTADO'] = input("Informe o novo Estado: \n")
    cliente['PAÍS'] = input("Informe o novo País: \n")
    cliente['CARGO'] = input("Informe o novo cargo: \n")
    cliente['EMPRESA'] = input("Informe o novo nome da Empresa: \n")  
    return(cliente)

def deletar_cliente(agenda, cliente):
    agenda.remove(cliente)
    return(agenda)

def deletar_dados(agenda):

    return()
