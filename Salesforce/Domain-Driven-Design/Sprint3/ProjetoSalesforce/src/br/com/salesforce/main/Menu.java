package br.com.salesforce.main;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JOptionPane;

import br.com.salesfoce.beans.Cliente;
import br.com.salesfoce.beans.ClientePf;
import br.com.salesfoce.beans.ClientePj;
import br.com.salesfoce.beans.Contato;
import br.com.salesfoce.beans.Endereco;
import br.com.salesfoce.beans.Produto;
import br.com.salesforce.dao.ClienteDao;
import br.com.salesforce.dao.ClientePfDao;
import br.com.salesforce.dao.ClientePjDao;
import br.com.salesforce.dao.ContatoDao;
import br.com.salesforce.dao.EnderecoDao;
import br.com.salesforce.dao.ProdutoDao;

public class Menu {

	static String texto(String j) {
		return JOptionPane.showInputDialog(j);
	}

	static int inteiro(String j) {
		return Integer.parseInt(JOptionPane.showInputDialog(j));
	}

	static double real(String j) {
		return Double.parseDouble(JOptionPane.showInputDialog(j));
	}

	public static void main(String[] args) throws ClassNotFoundException, SQLException {

		ClienteDao clDao = new ClienteDao();
		Cliente objCl = new Cliente();

		ClientePfDao pfDao = new ClientePfDao();
		ClientePf objPf = new ClientePf();
		List<ClientePf> listaPf = (ArrayList<ClientePf>) pfDao.visualizar();
		
		ClientePjDao pjDao = new ClientePjDao();
		ClientePj objPj = new ClientePj();
		List<ClientePj> listaPj = (ArrayList<ClientePj>) pjDao.visualizar();
		
		ContatoDao contatoDao = new ContatoDao();
		Contato objContato = new Contato();
		List<Contato> listaContato = (ArrayList<Contato>) contatoDao.visualizar();
		
		EnderecoDao enderecoDao = new EnderecoDao();
		Endereco objEndereco = new Endereco();
		List<Endereco> listaEndereco = (ArrayList<Endereco>) enderecoDao.visualizar();
		
		ProdutoDao produtoDao = new ProdutoDao();
		Produto objProduto = new Produto();
		List<Produto> listaProduto = (ArrayList<Produto>) produtoDao.visualizar();

		String opcao1;
		String opcao1_2;

		while (true) {
			opcao1 = JOptionPane.showInputDialog("Digite uma opção: \n1 - Cadastrar cliente \n2 - Cadastrar contato \n3 - Cadastrar endereço \n4 - Cadastrar produto \n5 - Visualizar todos os cadastros \n6 - Sair");

			switch (opcao1) {
			case "1":

				opcao1_2 = JOptionPane.showInputDialog("Digite uma opção: \n1 - Cliente PF \n2 - Cliente PJ \n3 - Sair");
				switch (opcao1_2) {
				case "1":
					do {
						
						objCl.setCodigo(inteiro("Digite o código de cadastro desse cliente"));
						objCl.setNome(texto("Digite o nome desse cliente"));
						clDao.inserir(objCl);
						
						objPf.setCpf(texto("Informe o CPF do cliente"));
						objPf.setProfissao(texto("Informe a profissão"));
						objPf.setEscolaridade(texto("Informe a escolaridade"));
						objPf.setDtNascimento(texto("Informe a data de nascimento"));
						objPf.setSexo(texto("Digite o sexo"));
						objPf.setCodigo(objCl.getCodigo());

						JOptionPane.showMessageDialog(null, pfDao.inserir(objPf));
						
					} while (JOptionPane.showConfirmDialog(null, "Adicionar outro cadastro de Cliente PF?", "CADASTRO DE CLIENTE PF",
							JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE) == 0);
					System.exit(0);
				
				case "2":
					do {
						
						objCl.setCodigo(inteiro("Digite o código de cadastro desse cliente"));
						objCl.setNome(texto("Digite o nome fantasia desse cliente"));
						clDao.inserir(objCl);
						
						objPj.setCnpj(texto("Digite o CNPJ do cliente"));
						objPj.setRazaoSocial(texto("Digite a razão social"));
						objPj.setQtFuncionarios(inteiro("Digite a quantidade de funcionários da empresa"));
						objPj.setCodigo(objCl.getCodigo());
						
						JOptionPane.showMessageDialog(null, pjDao.inserir(objPj));
						
					} while (JOptionPane.showConfirmDialog(null, "Adicionar outro cadastro de Cliente PJ?", "CADASTRO DE CLIENTE PJ",
							JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE) == 0);
					System.exit(0);
				}
			case "2":
				do {
					
					objCl.setCodigo(inteiro("Digite o código do cliente que receberá o cadastro de contato"));
					
					objContato.setTelCelular(texto("Digite o telefone celular"));
					objContato.setTelFixo(texto("Digite o telefone fixo"));
					objContato.setEmail(texto("Digite o e-mail"));
					objContato.setId(objCl.getCodigo());
					
					JOptionPane.showMessageDialog(null, contatoDao.inserir(objContato));
					
				} while (JOptionPane.showConfirmDialog(null, "Adicionar outro cadastro de Contato?", "CADASTRO DE CONTATO",
						JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE) == 0);
				System.exit(0);
				
			case "3":
				do {
					
					objCl.setCodigo(inteiro("Digite o código do cliente que receberá esse cadastro de endereço"));
					
					objEndereco.setCep(texto("Digite o CEP"));
					objEndereco.setLogradouro(texto("Digite o logradouro"));
					objEndereco.setNum(inteiro("Digite o número"));
					objEndereco.setComplemento(texto("Digite o complemento"));
					objEndereco.setCidade(texto("Digite a cidade"));
					objEndereco.setEstado(texto("Digite o estado"));
					objEndereco.setPais(texto("Digite o país"));
					objEndereco.setId(objCl.getCodigo());
					
					JOptionPane.showMessageDialog(null, enderecoDao.inserir(objEndereco));
					
				} while (JOptionPane.showConfirmDialog(null, "Adicionar outro cadastro de Endereço?", "CADASTRO DE ENDEREÇO",
						JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE) == 0);
				System.exit(0);
			
			case "4":
				do {
					
					objCl.setCodigo(inteiro("Digite o código do cliente que receberá esse cadastro de produto"));
					
					objProduto.setCodigo(inteiro("Digite o código do produto"));
					objProduto.setNome(texto("Digite o nome do produto"));
					objProduto.setPrazoLicensa(texto("Digite o prazo da licensa"));
					objProduto.setValorProduto(real("Digite o valor"));
					objProduto.setId(objCl.getCodigo());
					
					JOptionPane.showMessageDialog(null, produtoDao.inserir(objProduto));
					
				} while (JOptionPane.showConfirmDialog(null, "Adicionar outro cadastro de Produto?", "CADASTRO DE PRODUTO",
						JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE) == 0);
				System.exit(0);
				
			case "5":
				if(listaPf != null) {
					System.out.println("CLIENTES PF\n");
					for (ClientePf pf : listaPf) {
						System.out.println(pf.getCodigo() + " " + pf.getCpf() + " " + pf.getProfissao() + " " + pf.getEscolaridade() + " " + pf.getDtNascimento() + " " + pf.getSexo());
					}
				}
				
				if(listaPj != null) {
					System.out.println("\nCLIENTES PJ\n");
					for (ClientePj pj : listaPj) {
						System.out.println(pj.getCodigo() + " " + pj.getCnpj() + " " + pj.getRazaoSocial() + " " + pj.getQtFuncionarios());
					}
				}
				
				if(listaContato != null) {
					System.out.println("\nCONTATOS\n");
					for (Contato contato : listaContato) {
						System.out.println(contato.getId() + " " + contato.getTelCelular() + " " + contato.getTelFixo() + " " + contato.getEmail());
					}
				}
				
				if(listaEndereco != null) {
					System.out.println("\nENDEREÇOS\n");
					for (Endereco endereco : listaEndereco) {
						System.out.println(endereco.getId() + " " + endereco.getCep() + " " + endereco.getLogradouro() + " " + endereco.getNum() + " " + endereco.getComplemento() + " " + endereco.getCidade() + " " + endereco.getEstado() + " " + endereco.getPais());
					}
				}
				
				if(listaProduto != null) {
					System.out.println("\nPRODUTOS\n");
					for (Produto produto : listaProduto) {
<<<<<<< HEAD
						System.out.println(produto.getId() + " " + produto.getCodigo() + " " + produto.getNome() + " " +  produto.getPrazoLicensa() + " " + produto.getValorProduto());
=======
						System.out.println(produto.getId() + " " + produto.getCodigo() + " " + produto.getNome() + " " + produto.getPrazoLicensa() + " " + produto.getValorProduto());
>>>>>>> 111cf37b99bd13fb651bd743873d1a52f099e873
					}
				}
				
				System.exit(0);
			case "6":
				JOptionPane.showMessageDialog(null, "Saindo do programa");
				System.exit(0);
			default:
				System.out.println("Digite um dos números informados no menu");

			}
		}

	}

}
