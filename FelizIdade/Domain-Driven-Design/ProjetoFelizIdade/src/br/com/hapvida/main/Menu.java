package br.com.hapvida.main;

import java.util.ArrayList;
import java.util.List;

import javax.swing.JOptionPane;

import br.com.hapvida.beans.Medico;
import br.com.hapvida.beans.Paciente;

public class Menu {
	//String
	static String texto (String j) {
		return JOptionPane.showInputDialog(j);
	}
	//Int
	static int inteiro (String j) {
		return Integer.parseInt(JOptionPane.showInputDialog(j));
	}
	//Double
	static double real (String j) {
		return Double.parseDouble(JOptionPane.showInputDialog(j));
	}
	static double mediaBemEstar(int[] sg) {
		double media = 0;
		for(int i : sg) {
			media += i;
		}
		media = media/sg.length;
		return media;
				
		
	}
	
	private static void Mensagem(String mensagem, String titulo) {
		JOptionPane.showMessageDialog(null, mensagem, titulo,JOptionPane.INFORMATION_MESSAGE);
	}	
	
	// Uso de sobrecarga
	private static Paciente novoCadastro(Paciente objPaciente, int nrPaciente) {
		objPaciente = new Paciente();
		//Retiramos essas informações para deixar o código mais intuitivo
		//objPaciente.setCep(texto("Digite seu CEP: "));
		//objPaciente.setLogradouro(texto("Digite sua rua: "));
		//objPaciente.setNumero(inteiro("Digite o número:"));
		//objPaciente.setBairro(texto("Digite seu Bairro: "));
		//objPaciente.setEstado(texto("Digite seu Estado: "));
		//objPaciente.setCidade(texto("Digite sua Cidade: "));
		//objPaciente.setPais(texto("Digite seu País: "));
		//objPaciente.setRg(texto("Digite o RG:"));
		objPaciente.setNome(texto("Digite o nome do paciente: "));
		objPaciente.setCpf(texto("Digite seu CPF:"));
		objPaciente.setNascimento(texto("Digite a data de nascimento:"));
		objPaciente.setEmail(texto("Digite seu Email: "));
		objPaciente.setTelefone(inteiro("Digite seu telefone: "));
		Mensagem(("Paciente nr " + nrPaciente + "\nDADOS DO PACIENTE: " +
				"\nNome: " + objPaciente.getNome() +
				"\nCPF: " + objPaciente.getCpf() + 
				"\nNascimento: " + objPaciente.getNascimento() +
				"\nE-mail: " + objPaciente.getEmail() +
				"\nTelefone: " + objPaciente.getTelefone() +
				"\nCPF: " + objPaciente.getCpf()
				),"Novo Paciente");
		return objPaciente;
	}
	
	// Uso de sobrecarga
	private static Medico novoCadastro(Medico objMedico, int nrMedico) {
		objMedico = new Medico();
		//Retiramos essas informações para deixar o código mais intuitivo
		//objMedico.setCep(texto("Digite seu CEP: "));
		//objMedico.setLogradouro(texto("Digite sua rua: "));
		//objMedico.setNumero(inteiro("Digite o número:"));
		//objMedico.setBairro(texto("Digite seu Bairro: "));
		//objMedico.setEstado(texto("Digite seu Estado: "));
		//objMedico.setCidade(texto("Digite sua Cidade: "));
		//objMedico.setPais(texto("Digite seu País: "));
		//objMedico.setNascimento(texto("Digite a data de nascimento:"));
		//objMedico.setRg(texto("Digite o RG:"));
		objMedico.setNome(texto("Digite o nome do médico: "));
		objMedico.setCrm(inteiro("Digite o número do Registro médico:"));
		objMedico.setEspecialidade(texto("Digite a especialidade:"));
		objMedico.setEmail(texto("Digite o Email: "));
		objMedico.setTelefone(inteiro("Digite seu telefone: "));		
		objMedico.setCpf(texto("Digite o CPF:"));
		Mensagem(("Médico nr " + nrMedico + "\n\nDADOS DO MÉDICO: " +
				"\nNome: " + objMedico.getNome() +
				"\nCRM: " + objMedico.getCrm() + 
				"\nEspecialidade: " + objMedico.getEspecialidade() +
				"\nE-mail: " + objMedico.getEmail() +
				"\nTelefone: " + objMedico.getTelefone() +
				"\nCPF: " + objMedico.getCpf()
				),"Novo médico");
		return objMedico;
	}

	public static void main(String[] args) {
		// 
		List<Paciente> listaPacientes = new ArrayList<Paciente>();
		List<Medico> listaMedicos = new ArrayList<Medico>();

		Paciente objPaciente = new Paciente();
		Medico objMedico = new Medico();

		String opcao = null;

		while (opcao != "4") {
			opcao = JOptionPane.showInputDialog("Digite: " +
					"\n1 - Cadastrar novo médico." +
					"\n2 - Cadastrar novo paciente" +
					"\n3 - Iniciar Check-in de bem estar." + 
					"\n4 - Encerrar.");
			

			switch(opcao) {
			case "1":
				do {	
					listaMedicos.add(novoCadastro(objMedico,(listaMedicos.size()+1)));
				} while(JOptionPane.showConfirmDialog(null, "Criar novo cadastro?", "CADASTRO", JOptionPane.YES_NO_OPTION,JOptionPane.QUESTION_MESSAGE)==0);
				for (Medico m : listaMedicos) {
					System.out.println("\n\nDADOS DO MÉDICO: " +
							"\nNome: " + m.getNome() +
							"\nCRM: " + m.getCrm() + 
							"\nEspecialidade: " + m.getEspecialidade() +
							"\nE-mail: " + m.getEmail() +
							"\nTelefone: " + m.getTelefone() +
							"\nCPF: " + m.getCpf()
							);
				}
				break;
				
			case "2":
				do {					
					listaPacientes.add(novoCadastro(objPaciente, (listaPacientes.size()+1)));
				} while(JOptionPane.showConfirmDialog(null, "Criar novo cadastro?", "CADASTRO", JOptionPane.YES_NO_OPTION,JOptionPane.QUESTION_MESSAGE)==0);
				for (Paciente p : listaPacientes) {
					System.out.println("\n\nDADOS DO PACIENTE: " +
							"\nNome: " + p.getNome() +
							"\nCPF: " + p.getCpf() + 
							"\nNascimento: " + p.getNascimento() +
							"\nE-mail: " + p.getEmail() +
							"\nTelefone: " + p.getTelefone() +
							"\nCPF: " + p.getCpf()
							);
				}
				break;
				
			case "3":
				int[] saudeGeral = new int[8];
				do {
					objPaciente = new Paciente();
					objPaciente.setNome(texto("Digite o nome do paciente: "));
					objPaciente.setCpf(texto("Digite seu CPF:"));
					System.out.println("\nVamos iniciar o seu check in de saude diário! ");
					saudeGeral[0] = inteiro("Como você avalia sua qualidade de sono? (0 - Muito ruim / 5 - Excelente)");		
					saudeGeral[1] = inteiro("Em uma escala de 0 a 5, quão estressado você se sente atualmente? (0 - Extremamente estressado / 5 - Sem estresse)");	
					saudeGeral[2] = inteiro("Como você classificaria seu nível de ansiedade hoje? (0 - Muito alta / 5 - Nenhuma ansiedade)");	
					saudeGeral[3] = inteiro("Quão satisfeito você está com seu nível geral de saúde mental? (0 - Muito insatisfeito / 5 - Extremamente satisfeito)");	
					saudeGeral[4] = inteiro("Qual é o seu nível de dor física hoje? (0 - Dor insuportável / 5 - Nenhuma dor)");	
					saudeGeral[5] = inteiro("Quão saudável é a sua dieta atualmente? (0 - Muito pouco saudável / 5 - Extremamente saudável)");	
					saudeGeral[6] = inteiro("Qual é o seu nível de energia e vitalidade no momento? (0 - Muito baixo / 5 - Excelente)");	
					saudeGeral[7] = inteiro("Como você se sente em relação à sua saúde física atual? (0 - Muito ruim / 5 - Excelente)");	
	
	
				} while(JOptionPane.showConfirmDialog(null, "Criar refazer Check-in?", "CHECK-IN", JOptionPane.YES_NO_OPTION,JOptionPane.QUESTION_MESSAGE)==0);
				double md = mediaBemEstar(saudeGeral);
				JOptionPane.showMessageDialog(null, "A média dos valores da sua saúde é de: " + md, "RELATÓRIO BEM ESTAR", JOptionPane.INFORMATION_MESSAGE);
				//System.out.println("\n\nA média dos valores da sua saúde é de: " + md);
				
				if (md >=3) {
					Mensagem(objPaciente.getNome() + ", seu estado geral está bom! Continue assim!", "RESULTADO");

				}
				else if (md <3) {
					JOptionPane.showMessageDialog(null, (objPaciente.getNome() + ", com base em suas respostas recomendamos que procure seu médico."), "RESULTADO", JOptionPane.WARNING_MESSAGE);

				}

				break;
								
				case "4":
			
				return ;
			}

		}

	}

}
