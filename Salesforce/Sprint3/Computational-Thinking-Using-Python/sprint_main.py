# Larissa Araújo Gama Alvarenga – RM 96496
# Larissa Lopes Oliveira – RM 552628
# Luna Faustino Lima – RM 552473

from sprint_Salesforce import *

def menu():
        while True:

            [agenda, cabecalho] = ler_arquivo()

            cliente = {}

            opcao = input("\nOlá! Informe a opção desejada: \n" + 
                        "1- Buscar um cliente: \n" + 
                        "2- Adicionar um cliente: \n" + 
                        "3- Editar um cliente: \n"+ 
                        "4- Deletar um cliente: \n"+ 
                        "5- Deletar todos os dados: \n"+ 
                        "6- Finalizar: \n")

            match opcao:
                case "1":
                    cliente = buscarCliente(agenda)
                    if (cliente != False):                        
                        print(cliente)
                    else:
                        print('Cliente não encontrado')
                case "2":
                    cliente = adicionar_cliente(agenda)
                    if (cliente != False):
                        agenda.append(cliente)
                        salvar_arquivo(agenda,cabecalho)
                        print(f"{cliente['NOME']}, criado com sucesso!")
                    else:
                        print('CPF já cadastrado. Não foi possível adicionar o cliente.')
                case "3":
                    cliente = buscarCliente(agenda)
                    if (cliente != False):
                        clienteEditado = editar_cliente(cliente)           
                        salvar_arquivo(agenda,cabecalho)
                        print(f"{cliente['NOME']}, editado com sucesso!")
                    else:
                        print('Cliente não encontrado')
                case "4":
                    cliente = buscarCliente(agenda)
                    if (cliente != False):
                        certeza = input(f"\nDigite 1 para confirmar exclusão de:  {cliente['NOME']} \n")
                        if certeza == "1":                
                            agenda.remove(cliente)       
                            salvar_arquivo(agenda,cabecalho)
                            print(f"{cliente['NOME']}, removido com sucesso!")
                    else:
                        print('Cliente não encontrado')
                case "5":
                    
                    certeza = input(f"\nDigite 1 para confirmar exclusão de TODOS os dados: \n")
                    if certeza == "1":                
                        agenda = []     
                        salvar_arquivo(agenda,cabecalho)
                        print(f"Dados deletados com sucesso!")
                case "6":
                    print('\nObrigado, volte sempre!')
                    break                              


if __name__ == "__main__":
    menu()