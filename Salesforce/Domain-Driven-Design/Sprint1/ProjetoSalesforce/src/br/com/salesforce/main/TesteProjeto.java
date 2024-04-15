package br.com.salesforce.main;

import javax.swing.JOptionPane;

import br.com.salesfoce.beans.Empresa;
import br.com.salesfoce.beans.Endereco;

public class TesteProjeto {

	public static void main(String[] args) {
		// objetos

		Empresa objEmpresa = new Empresa(
				JOptionPane.showInputDialog("Digite a Razão Social da empresa"),
				JOptionPane.showInputDialog("Digite o Nome Fantasia da empresa"),
				JOptionPane.showInputDialog("Digite o CPNJ da empresa"),
				JOptionPane.showInputDialog("Digite o telefone de contato da empresa"),
				JOptionPane.showInputDialog("Digite o e-mail da empresa"),
				JOptionPane.showInputDialog("Qual o segmento da empresa?"));

		Endereco objEndereco = new Endereco(
				JOptionPane.showInputDialog("Digite o logradouro da empresa"),
				Integer.parseInt(JOptionPane.showInputDialog("Digite o número do endereço")),
				JOptionPane.showInputDialog("Digite o complemento"),
				JOptionPane.showInputDialog("Digite o bairro"), 
				JOptionPane.showInputDialog("Digite a cidade"),
				JOptionPane.showInputDialog("Digite o estado"),
				JOptionPane.showInputDialog("Digite o CEP"),
				JOptionPane.showInputDialog("Digite o país"));
		
		objEmpresa.setEndereco(objEndereco);
		
		// saida
		
		System.out.println("INFORMAÇÕES SOBRE A EMPRESA\n\n" +
							"Razão Social: " + objEmpresa.getRazaoSoc() + 
							"\nNome Fantasia: " + objEmpresa.getNomeFant() + 
							"\nCNPJ: " + objEmpresa.getCnpj() + 
							"\nTelefone: " + objEmpresa.getTelefone() + 
							"\nE-mail: " + objEmpresa.getEmail() + 
							"\nSegmento: " + objEmpresa.getSeg() +  
							"\n\nENDEREÇO DA EMPRESA\n\n" + 
							"Logradouro: " + objEmpresa.getEndereco().getLogradouro() + 
							"\nNúmero: " + objEmpresa.getEndereco().getNumero() +
							"\nComplemento: " + objEmpresa.getEndereco().getComplemento() +
							"\nBairro: " + objEmpresa.getEndereco().getBairro() + 
							"\nCidade: " + objEmpresa.getEndereco().getCidade() +
							"\nEstado: " + objEmpresa.getEndereco().getEstado() +
							"\nCEP: " + objEmpresa.getEndereco().getCep() +
							"\nPaís: " + objEmpresa.getEndereco().getPais()
							);

	}

}
