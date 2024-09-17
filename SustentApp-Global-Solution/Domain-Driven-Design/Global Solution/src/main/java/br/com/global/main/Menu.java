package br.com.global.main;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JOptionPane;

import br.com.global.beans.ContatoPF;
import br.com.global.beans.ContatoPJ;
import br.com.global.beans.Empresa;
import br.com.global.beans.Produto;
import br.com.global.beans.Representante;
import br.com.global.dao.ContatoPfDao;
import br.com.global.dao.ContatoPjDao;
import br.com.global.dao.EmpresaDao;
import br.com.global.dao.EnderecoDao;
import br.com.global.dao.ProdutoDao;
import br.com.global.dao.RepresentanteDao;
import br.com.global.models.Endereco;
import br.com.global.services.ViaCepService;

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

		RepresentanteDao repDao = new RepresentanteDao();
		Representante rep = new Representante();
		List<Representante> listaRep = (ArrayList<Representante>) repDao.visualizar();

		EmpresaDao empDao = new EmpresaDao();
		Empresa emp = new Empresa();
		List<Empresa> listaEmp = (ArrayList<Empresa>) empDao.visualizar();

		ContatoPfDao contPfDao = new ContatoPfDao();
		ContatoPF contPf = new ContatoPF();
		List<ContatoPF> listaContPf = (ArrayList<ContatoPF>) contPfDao.visualizar();

		ContatoPjDao contPjDao = new ContatoPjDao();
		ContatoPJ contPj = new ContatoPJ();
		List<ContatoPJ> listaContPj = (ArrayList<ContatoPJ>) contPjDao.visualizar();

		ProdutoDao proDao = new ProdutoDao();
		Produto pro = new Produto();
		List<Produto> listaPro = (ArrayList<Produto>) proDao.visualizar();

		EnderecoDao endDao = new EnderecoDao();
		Endereco end = new Endereco();
		List<Endereco> listaEnd = (ArrayList<Endereco>) endDao.visualizar();

		String opcao1;
		String opcao2;

		while (true) {
			opcao1 = JOptionPane.showInputDialog(
					"Digite uma opção: \n1- Cadastrar representante \n2- Cadastrar empresa \n3- Cadastrar contato \n4- Cadastrar produto \n5- Cadastrar endereço \n6- Visualizar cadastros \n7- Sair");

			switch (opcao1) {
			case "1":
				do {

					rep.setCpf(texto("Digite o CPF do representante"));
					rep.setNome(texto("Digite o nome do representante"));

					JOptionPane.showMessageDialog(null, repDao.inserir(rep));

				} while (JOptionPane.showConfirmDialog(null, "Gostaria de adicionar outro representante?",
						"CADASTRO DE REPRESENTANTES", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE) == 0);
				System.exit(0);

			case "2":
				do {

					rep.setCpf(texto("Digite o CPF do representante dessa empresa"));

					emp.setCnpj(texto("Digite o CNPJ da Empresa"));
					emp.setNomeFant(texto("Digite o nome fantasia da empresa"));
					emp.setRazaoSoc(texto("Digite a razão social da empresa"));
					emp.setRepresentante(rep);

					JOptionPane.showMessageDialog(null, empDao.inserir(emp));

				} while (JOptionPane.showConfirmDialog(null, "Gostaria de adicionar outra empresa?",
						"CADASTRO DE EMPRESAS", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE) == 0);
				System.exit(0);

			case "3":

				opcao2 = JOptionPane.showInputDialog(
						"Digite uma opção: \n1 - Contato de representante \n2 - Contato da empresa \n3 - Sair");
				switch (opcao2) {
				case "1":
					do {

						rep.setCpf(texto("Digite o CPF do representante desse contato"));

						contPf.setEmail(texto("Digite o e-mail do representante"));
						contPf.setTel(texto("Digite o número de contato do representante"));
						contPf.setRepresentante(rep);

						JOptionPane.showMessageDialog(null, contPfDao.inserir(contPf));

					} while (JOptionPane.showConfirmDialog(null,
							"Gostaria de adicionar outro contato de representante?", "CADASTRO DE CONTATOS",
							JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE) == 0);
					System.exit(0);

				case "2":

					do {

						emp.setCnpj(texto("Digite o CNPJ da empresa desse contato"));

						contPj.setEmail(texto("Digite o e-mail da empresa"));
						contPj.setTel(texto("Digite o número de contato da empresa"));
						contPj.setEmpresa(emp);

						JOptionPane.showMessageDialog(null, contPjDao.inserir(contPj));

					} while (JOptionPane.showConfirmDialog(null, "Gostaria de adicionar outro contato de empresa?",
							"CADASTRO DE CONTATOS", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE) == 0);
					System.exit(0);

				case "3":
					JOptionPane.showMessageDialog(null, "Saindo do programa");
					System.exit(0);

				default:
					JOptionPane.showMessageDialog(null, "Digite 1, 2 ou 3");
				}

			case "4":

				do {

					emp.setCnpj(texto("Digite o CNPJ da empresa desse produto"));

					pro.setTipo(texto("Digite os tipos de produtos que a empresa recicla"));
					pro.setQuantidade(real("Digite o máximo de quilos/toneladas que a empresa recicla"));
					pro.setReciclagem(texto("Digite os tipos de reciclagem que a empresa faz"));
					pro.setEmpresa(emp);

					JOptionPane.showMessageDialog(null, proDao.inserir(pro));

				} while (JOptionPane.showConfirmDialog(null, "Gostaria de adicionar outro produto?",
						"CADASTRO DE PRODUTOS", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE) == 0);

				System.exit(0);

			case "5":

				do {

					ViaCepService viaCep = new ViaCepService();

					emp.setCnpj(texto("Digite o CNPJ da empresa desse endereço"));
					String cep = texto("Digite o CEP do endereço");
					Endereco endereco = viaCep.getEndereco(cep);

					end.setCep(endereco.getCep());
					end.setLogradouro(endereco.getLogradouro());
					end.setNum(inteiro("Digite o número do endereço"));
					end.setComplemento(texto("Digite o complemento do endereço"));
					end.setBairro(endereco.getBairro());
					end.setLocalidade(endereco.getLocalidade());
					end.setUf(endereco.getUf());
					end.setEmpresa(emp);

					JOptionPane.showMessageDialog(null, endDao.inserir(end));

				} while (JOptionPane.showConfirmDialog(null, "Gostaria de adicionar outro endereço?",
						"CADASTRO DE ENDEREÇOS", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE) == 0);
				System.exit(0);

			case "6":
				if (listaRep != null) {
					System.out.println("REPRESENTANTES\n");
					for (Representante representante : listaRep) {
						System.out.println(representante.getCpf() + " " + representante.getNome());
					}

				}
				
				if (listaEmp != null) {
					System.out.println("\nEMPRESAS\n");
					for (Empresa empresa : listaEmp) {
						System.out.println(empresa.getCnpj() + " " + empresa.getNomeFant() + " " + empresa.getRazaoSoc());
					}

				}
				
				if (listaContPf != null) {
					System.out.println("\nCONTATOS DE REPRESENTANTES\n");
					for (ContatoPF contatoPF : listaContPf) {
						System.out.println(contatoPF.getEmail() + " " + contatoPF.getTel());
					}

				}
				
				if (listaContPj != null) {
					System.out.println("\nCONTATOS DE EMPRESAS\n");
					for (ContatoPJ contatoPJ : listaContPj) {
						System.out.println(contatoPJ.getEmail() + " " + contatoPJ.getTel());
					}

				}
				
				if (listaPro != null) {
					System.out.println("\nPRODUTOS\n");
					for (Produto produto : listaPro) {
						System.out.println(produto.getTipo() + " " + produto.getQuantidade() + " " + produto.getReciclagem());
					}

				}
				
				if (listaEnd != null) {
					System.out.println("\nENDEREÇOS\n");
					for (Endereco endereco : listaEnd) {
						System.out.println(endereco.getCep() + " " + endereco.getLogradouro() + " " + endereco.getNum() + " " + endereco.getComplemento() + " " + endereco.getBairro() + " " + endereco.getLocalidade() + " " + endereco.getUf());
					}

				}
				System.exit(0);
			
			case "7":
				JOptionPane.showMessageDialog(null, "Saindo do programa");
				System.exit(0);

			default:
				JOptionPane.showMessageDialog(null, "Digite uma opção válida");
			}
		}

	}

}
