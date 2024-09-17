# Larissa Araújo Gama Alvarenga – RM 96496
# Larissa Lopes Oliveira – RM 552628
# Luna Faustino Lima – RM 552473

from challenge_auxiliar import *

def menu():
  while True:
    print("\n\nOlá, bem vindo à Salesforce!")
    dados = obter_dados()
    print(f"Oi, seus dados são: {dados}")
    criar_cadastro(dados)    
    listar_produtos(dados)
    contato(dados)    
    while (True):
      prox = input("Digite: \n1 - Para encerrar \n2 - Para voltar ao menu \n3 - Para novo cadastro\n")
      if prox == "1":
        encerrar()
      elif prox == "2":
        listar_produtos(dados)
      elif prox == "3": 
        break
      else:
        opcao_invalida()

if __name__ == "__main__":
    menu()