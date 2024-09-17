# Larissa Araújo Gama Alvarenga – RM 96496
# Larissa Lopes Oliveira – RM 552628
# Luna Faustino Lima – RM 552473

agenda = {}

def obter_dados():
  print("\n_Primeiro faremos seu cadastro!\n")
  contato = {}
  contato["nome"] = input("Por favor, digite seu nome: \n")  
  if continuar_cadastro(contato) == True:  
    contato["email"] = input("Informe seu e-mail corporativo: \n")
    contato["cargo"] = input("Agora, digite seu cargo: \n")
    contato["empresa"] = input("Informe o nome da empresa: \n")    
    contato["num_funcionarios"] = input("Informe a quantidade de funcionários: \n 1 - de 1 a 50 funcionários.\n 2 - de 51 a 300 funcionários.\n 3 - de 301 a 1000 funcionários.\n 4 - de 1001 a 2000 funcionários. \n 5 - acima de 2001 funcionários.\n")
    contato["telefone"] = input("Informe o telefone para contato: \n")
    return contato
  else: 
    return agenda[contato["nome"]]

def continuar_cadastro(contato):
  if contato["nome"] in agenda:
    edit = input("Encontramos seu cadastro. \n Digite 1 para editá-lo ou 2 para prosseguir.")
    return (edit == "1")
  return True

def criar_cadastro(dados):
  agenda[dados["nome"]] = dados

def listar_produtos(dados):
  if dados["num_funcionarios"] == "1":
    menu_pequenas_empresas()
  else:
    menu_completo()

def menu_pequenas_empresas():
  print("\nTemos o produto Pequenas Empresas, com os seguintes planos: \n1 - Starter \n2 - Sales Professional \n3 - Service Professional \n4 - Marketing Cloud Account Engagement \n")
  op = input("Digite o plano desejado, ou  - 5 para ver a lista completa de produtos.")
  if op == "1":
    print("\nStarter - O pacote simples de CRM com marketing, vendas e serviços para equipes pequenas. \nCusto estimado: $ 25 (USD/usuário/mês)")
  elif op == "2":
    print("\nSales Professional - Solução completa de vendas para equipes de qualquer tamanho. \nCusto estimado: $ 80 (USD/usuário/mês)")
  elif op =="3":
    print("\nService Professional - Solução completa de atendimento ao cliente para equipes de qualquer tamanho. \nCusto estimado: $ 80 (USD/usuário/mês)")
  elif op == "4":
    print("\nMarketing Cloud Account Engagement - Conjunto de ferramentas de automação de marketing para equipes de qualquer tamanho.\nCusto estimado: $ 1.250 (USD/usuário/mês)")
  else:
    menu_completo()

def menu_completo():
  print("Esses são os nossos produtos, selecione sobre qual deseja saber mais:\n")
  produto = input("1 - Customer 360 \n2 - Sales Cloud \n3 - Service Coud \n4 - Pequenas empresas \n")
  if produto == "1":
    print("\nO Customer 360 é a nossa suíte de produtos e serviços que ajuda 98% dos clientes a alcançar ou superar suas metas de ROI. Alcance o sucesso agora, com o CRM Nº 1 do mundo.\n")
  elif produto == "2":
    planos_sales_cloud()
  elif produto == "3":
    planos_service_cloud()
  elif produto == "4":
    menu_pequenas_empresas()
  else:
    opcao_invalida()

def planos_sales_cloud():
  op = input("\nDigite o plano do Sales Coud, sobre o qual deseja saber mais: \n1 - Starter \n2 - Sales Professional \n3 - Enterprise \n4 - Unlimited \n")
  if op == "1":
    print("\nStarter - Ferramentas de vendas e atendimento ao cliente em um app. \nCusto estimado: $ 25 (USD/usuário/mês)")
  elif op == "2":
    print("\nSales Professional - Solução de vendas completa para equipes de qualquer tamanho. \nCusto estimado: $ 80 (USD/usuário/mês)")
  elif op =="3":
    print("\nEnterprise - CRM de vendas altamente personalizável para o seu negócio. \nCusto estimado: $ 165 (USD/usuário/mês)")
  elif op == "4":
    print("\nUnlimited - A plataforma definitiva para seu crescimento.\nCusto estimado: $ 330 (USD/usuário/mês)")
  else:
    opcao_invalida()

def planos_service_cloud():
  op = input("\nDigite o plano do Service Coud, sobre o qual deseja saber mais: \n1 - Starter \n2 - Sales Professional \n3 - Enterprise \n4 - Unlimited \n")
  if op == "1":
    print("\nStarter - O pacote simples de CRM com marketing, vendas e serviços para equipes pequenas. \nCusto estimado: $ 25 (USD/usuário/mês)")
  elif op == "2":
    print("\nProfessional - Solução completa de atendimento ao cliente para equipes de qualquer tamanho. \nCusto estimado: $ 80 (USD/usuário/mês)")
  elif op =="3":
    print("\nEnterprise - CRM personalizável para atendimento abrangente. \nCusto estimado: $ 165 (USD/usuário/mês)")
  elif op == "4":
    print("\nUnlimited - Recursos ilimitados de CRM.\nCusto estimado: $ 330 (USD/usuário/mês)")
  else:
    opcao_invalida()

def opcao_invalida():
  print("A opção digitada é invalida.")
  menu_completo()

def contato(dados):
  print(f"\nPara saber mais ligue: 0800 891 1887, ou aguarde nosso contato através do e-mail {dados['email']}\n")
 


def menu():
  while True:
    print("Olá, bem vindo à Salesforce!")
    dados = obter_dados() 
    print(f"Oi, seus dados são: {dados}")
    criar_cadastro(dados)
    listar_produtos(dados)
    contato(dados)
    prox = input("Digite: \n1 - Para encerrar \n2 - Para voltar ao menu \n3 - Para novo cadastro\n")
    if prox == "1":
      print("A Salesforce agradece!")
      break
    elif prox == "2":
      menu_completo()

if __name__ == "__main__":
    menu()