# Larissa Araújo Gama Alvarenga – RM 96496
# Larissa Lopes Oliveira – RM 552628
# Luna Faustino Lima – RM 552473

import sys
agenda = {}

def obter_dados():
  print("\n_Primeiro faremos seu cadastro!\n")
  contato = {}
  contato["nome"] = input("Por favor, digite seu nome: \n")  
  if continuar_cadastro(contato) == True:  
    contato["email"] = input("Informe seu e-mail corporativo: \n")
    contato["cargo"] = input("Agora, digite seu cargo: \n")
    contato["empresa"] = input("Informe o nome da empresa: \n")
    contato["telefone"] = input("Informe o telefone para contato: \n")
    contato["num_funcionarios"] = ""  
    while (contato["num_funcionarios"] not in ["1","2","3","4","5","6"]):
        contato["num_funcionarios"] = input("Informe a quantidade de funcionários: \n 1 - de 1 a 50 funcionários.\n 2 - de 51 a 300 funcionários.\n 3 - de 301 a 1000 funcionários.\n 4 - de 1001 a 2000 funcionários. \n 5 - acima de 2001 funcionários. \n 0 - Encerrar aplicação\n")
        if contato["num_funcionarios"] == "0":
          encerrar()
    return contato
  else: 
    return agenda[contato["nome"]]

def continuar_cadastro(contato):
  if contato["nome"] in agenda:
    edit = input("Encontramos seu cadastro. \n Digite 1 para editá-lo ou 2 para prosseguir.\n")
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
  print("\nTemos o produto Pequenas Empresas, com os seguintes planos: \n1 - Starter \n2 - Sales Professional \n3 - Service Professional \n4 - Marketing Cloud Account Engagement \n5 - Para ver a lista completa de produros \n0 - Encerrar\n")
  op = input("Digite a opção desejada.")
  if op == "1":
    print("\nStarter - O pacote simples de CRM com marketing, vendas e serviços para equipes pequenas. \nCusto estimado: $ 25 (USD/usuário/mês)")
  elif op == "2":
    print("\nSales Professional - Solução completa de vendas para equipes de qualquer tamanho. \nCusto estimado: $ 80 (USD/usuário/mês)")
  elif op =="3":
    print("\nService Professional - Solução completa de atendimento ao cliente para equipes de qualquer tamanho. \nCusto estimado: $ 80 (USD/usuário/mês)")
  elif op == "4":
    print("\nMarketing Cloud Account Engagement - Conjunto de ferramentas de automação de marketing para equipes de qualquer tamanho.\nCusto estimado: $ 1.250 (USD/usuário/mês)")
  elif op == "5":
    menu_completo()
  elif op == "0":
    encerrar()
  else:
    opcao_invalida()
    menu_pequenas_empresas()

def menu_completo():
  print("\nEsses são os nossos produtos, selecione sobre qual deseja saber mais:")
  produto = input("1 - Customer 360 \n2 - Sales Cloud \n3 - Service Coud \n4 - Pequenas empresas \n0 - Encerrar \n")
  if produto == "1":
    print("\nO Customer 360 é a nossa suíte de produtos e serviços que ajuda 98% dos clientes a alcançar ou superar suas metas de ROI. Alcance o sucesso agora, com o CRM Nº 1 do mundo.\n")
  elif produto == "2":
    planos_sales_cloud()
  elif produto == "3":
    planos_service_cloud()
  elif produto == "4":
    menu_pequenas_empresas()
  elif produto == "0":
    encerrar()
  else:
    opcao_invalida()
    menu_completo()

def planos_sales_cloud():
  op = input("\nDigite o plano do Sales Coud, sobre o qual deseja saber mais: \n1 - Starter \n2 - Sales Professional \n3 - Enterprise \n4 - Unlimited \n0 - Encerrar \n")
  if op == "1":
    print("\nStarter - Ferramentas de vendas e atendimento ao cliente em um app. \nCusto estimado: $ 25 (USD/usuário/mês)")
  elif op == "2":
    print("\nSales Professional - Solução de vendas completa para equipes de qualquer tamanho. \nCusto estimado: $ 80 (USD/usuário/mês)")
  elif op =="3":
    print("\nEnterprise - CRM de vendas altamente personalizável para o seu negócio. \nCusto estimado: $ 165 (USD/usuário/mês)")
  elif op == "4":
    print("\nUnlimited - A plataforma definitiva para seu crescimento.\nCusto estimado: $ 330 (USD/usuário/mês)")
  elif op == "0":
    encerrar()
  else:
    opcao_invalida()
    planos_sales_cloud()

def planos_service_cloud():
  op = input("\nDigite o plano do Service Coud, sobre o qual deseja saber mais: \n1 - Starter \n2 - Sales Professional \n3 - Enterprise \n4 - Unlimited \n0 - Encerrar \n")
  if op == "1":
    print("\nStarter - O pacote simples de CRM com marketing, vendas e serviços para equipes pequenas. \nCusto estimado: $ 25 (USD/usuário/mês)")
  elif op == "2":
    print("\nProfessional - Solução completa de atendimento ao cliente para equipes de qualquer tamanho. \nCusto estimado: $ 80 (USD/usuário/mês)")
  elif op =="3":
    print("\nEnterprise - CRM personalizável para atendimento abrangente. \nCusto estimado: $ 165 (USD/usuário/mês)")
  elif op == "4":
    print("\nUnlimited - Recursos ilimitados de CRM.\nCusto estimado: $ 330 (USD/usuário/mês)")
  elif op == "0":
    encerrar()
  else:
    opcao_invalida()
    planos_service_cloud()

def opcao_invalida():
  print("A opção digitada é invalida.")  

def contato(dados):
  print(f"\nPara saber mais ligue: 0800 891 1887, ou aguarde nosso contato através do e-mail {dados['email']}\n")

def encerrar():
  print("A Salesforce agradece!")
  sys.exit(0)
 