package br.com.salesforce.main;

import java.util.ArrayList;
import java.util.List;

import javax.swing.JOptionPane;

import br.com.salesfoce.beans.Empresa;
import br.com.salesfoce.beans.Endereco;
import br.com.salesfoce.beans.Produto;
import br.com.salesfoce.beans.Representante;

public class Menu {
	
	static String texto (String j) {
		return JOptionPane.showInputDialog(j);
	}
	
	static int inteiro (String j) {
		return Integer.parseInt(JOptionPane.showInputDialog(j));
	}
	
	static double real (String j) {
		return Double.parseDouble(JOptionPane.showInputDialog(j));
	}

	public static void main(String[] args) {
		
		List<Representante> listaRepresentante = new ArrayList<Representante>();
		List<Empresa> listaEmpresa = new ArrayList<Empresa>();
		List<Endereco> listaEndereco = new ArrayList<Endereco>();
		List<Produto> listaProduto = new ArrayList<Produto>();
		
		Representante objRepresentante;
		Empresa objEmpresa;
		Endereco objEndereco;
		Produto objProduto;
		
		String opcao;
		
		while(true) {
			opcao = JOptionPane.showInputDialog("Digite uma opção: \n1 - Adicionar um cliente \n2 - Sair");
			
			switch(opcao) {
				case "1":
					do {
					objRepresentante = new Representante();
					objRepresentante.setNome(texto("Digite o nome do Representante"));
					objRepresentante.setCpf(texto("Digite o CPF do Representante"));
					objRepresentante.setTelefone(texto("Digite o telefone do Representante"));
					objRepresentante.setEmail(texto("Digite o e-mail do Representante"));
					listaRepresentante.add(objRepresentante);
					
					objEmpresa = new Empresa();
					objEmpresa.setRazaoSoc(texto("Digite a Razão Social da Empresa"));
					objEmpresa.setNomeFant(texto("Digite o Nome Fantasia da Empresa"));
					objEmpresa.setCnpj(texto("Digite o CNPJ da Empresa"));
					objEmpresa.setSeg(texto("Digite o Segmento da Empresa"));
					objEmpresa.setTelefone(texto("Digite o telefone da Empresa"));
					objEmpresa.setEmail(texto("Digite o e-mail da Empresa"));
					listaEmpresa.add(objEmpresa);
					
					objEndereco = new Endereco();
					objEndereco.setLogradouro(texto("Digite o logradouro"));
					objEndereco.setNumero(inteiro("Digite o número"));
					objEndereco.setComplemento(texto("Digite o complemento"));
					objEndereco.setBairro(texto("Digite o bairro"));
					objEndereco.setCidade(texto("Digite a cidade"));
					objEndereco.setEstado(texto("Digite o estado"));
					objEndereco.setCep(texto("Digite o CEP"));
					objEndereco.setPais(texto("Digite o país"));
					listaEndereco.add(objEndereco);
					
					objProduto = new Produto();
					objProduto.setCodigo(inteiro("Digite o código do Produto"));
					objProduto.setTipo(texto("Digite o tipo do Produto"));
					objProduto.setPlano(texto("Digite o plano do Produto"));
					objProduto.setPreco(real("Digite o preço"));
					listaProduto.add(objProduto);
					}while(JOptionPane.showConfirmDialog(null, "Adicionar outro cadastro?", "CADASTRO DE CLIENTES", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE)==0);
				
					for(Representante representante : listaRepresentante) {
						
						System.out.println("\n\nINFORMAÇÕES REPRESENTANTE\n\n" + 
								"Nome: " + representante.getNome() + 
								"\nCPF: " + representante.getCpf() + 
								"\nTelefone: " + representante.getTelefone() + 
								"\nE-mail: " + representante.getEmail()
								);
					}
					
					for(Empresa empresa : listaEmpresa) {
						
						System.out.println("\n\nINFORMAÇÕES EMPRESA\n\n" + 
								"Razão Social: " + empresa.getRazaoSoc() + 
								"\nNome Fantasia: " + empresa.getNomeFant() + 
								"\nCNPJ: " + empresa.getCnpj() + 
								"\nTelefone: " + empresa.getTelefone() + 
								"\nE-mail: " + empresa.getEmail()
								);
						
					}
					
					for(Endereco endereco : listaEndereco) {
						
						System.out.println("\n\nENDEREÇO DA EMPRESA\n\n" + 
								"Logradouro: " + endereco.getLogradouro() + 
								"\nNúmero: " + endereco.getNumero() + 
								"\nComplemento: " + endereco.getComplemento() + 
								"\nBairro: " + endereco.getBairro() + 
								"\nCidade: " + endereco.getCidade() + 
								"\nEstado: " + endereco.getEstado() + 
								"\nCEP: " + endereco.getCep() + 
								"\nPaís: " + endereco.getPais()
								);
						
					}
					
					for(Produto produto : listaProduto) {
						
						System.out.println("\n\nINFORMAÇÕES DO PRODUTO\n\n" + 
								"Código: " + produto.getCodigo() + 
								"\nTipo: " + produto.getTipo() + 
								"\nPlano: " + produto.getPlano() + 
								"\nPreço: " + produto.getPreco()
								);
						
					}
				case "2":
					JOptionPane.showMessageDialog(null, "Saindo do programa");
					System.exit(0);
				default:
					JOptionPane.showMessageDialog(null, "Digite 1 ou 2");
				
					
						
			}
		}
		

	}

}
