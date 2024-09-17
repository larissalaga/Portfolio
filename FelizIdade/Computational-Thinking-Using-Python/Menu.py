from pseudocodigo_python import*

def menu(): #Lari Aráujo
    """Função principal de menu que irá chamar as outras funções do código, variaveis para armazenar funções"""
    while True:
      print("\nOlá, Bem vindo ao FelizIdade!")
      prox = input("Digite: \n1 - Para encerrar \n2 - Continuar")
      if prox == "1":
        encerrar()
      dados = função_cadastro()
      print(f"Os dados de seu cadastro são: {dados}")
      perguntas_iniciais(dados["cpf"])
      
      (media_mental, media_fisica) = mediadassaudes(dados["cpf"])
      print(f"\n{dados['nome']}, aqui está o relatório do seu estado de saúde baseado nas suas últimas respostas:")
      print(f"Média da saúde mental: {media_mental}")
      print(f"Média da saúde física: {media_fisica}")

      recomendar_especialista(media_mental, media_fisica)

if __name__ == "__main__":
  menu()

