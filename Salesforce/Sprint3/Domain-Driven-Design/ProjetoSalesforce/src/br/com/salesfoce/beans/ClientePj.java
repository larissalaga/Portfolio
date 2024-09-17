package br.com.salesfoce.beans;

public class ClientePj extends Cliente {

	private String cnpj;
	private String razaoSocial;
	private int qtFuncionarios;

	public ClientePj() {
		super();
	}

	public ClientePj(int codigo, String nome, Endereco endereco, Contato contato, Produto produto, String cnpj,
			String razaoSocial, int qtFuncionarios) {
		super(codigo, nome, endereco, contato, produto);
		this.cnpj = cnpj;
		this.razaoSocial = razaoSocial;
		this.qtFuncionarios = qtFuncionarios;
	}

	public String getCnpj() {
		return cnpj;
	}

	public void setCnpj(String cnpj) {
		this.cnpj = cnpj;
	}

	public String getRazaoSocial() {
		return razaoSocial;
	}

	public void setRazaoSocial(String razaoSocial) {
		this.razaoSocial = razaoSocial;
	}

	public int getQtFuncionarios() {
		return qtFuncionarios;
	}

	public void setQtFuncionarios(int qtFuncionarios) {
		this.qtFuncionarios = qtFuncionarios;
	}

}
