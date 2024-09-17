package br.com.salesfoce.beans;

public class ClientePf extends Cliente {

	private String cpf;
	private String profissao;
	private String escolaridade;
	private String dtNascimento;
	private String sexo;

	public ClientePf() {
		super();
	}

	public ClientePf(int codigo, String nome, Endereco endereco, Contato contato, Produto produto, String cpf,
			String profissao, String escolaridade, String dtNascimento, String sexo) {
		super(codigo, nome, endereco, contato, produto);
		this.cpf = cpf;
		this.profissao = profissao;
		this.escolaridade = escolaridade;
		this.dtNascimento = dtNascimento;
		this.sexo = sexo;
	}

	public String getCpf() {
		return cpf;
	}

	public void setCpf(String cpf) {
		this.cpf = cpf;
	}

	public String getProfissao() {
		return profissao;
	}

	public void setProfissao(String profissao) {
		this.profissao = profissao;
	}

	public String getEscolaridade() {
		return escolaridade;
	}

	public void setEscolaridade(String escolaridade) {
		this.escolaridade = escolaridade;
	}

	public String getDtNascimento() {
		return dtNascimento;
	}

	public void setDtNascimento(String dtNascimento) {
		this.dtNascimento = dtNascimento;
	}

	public String getSexo() {
		return sexo;
	}

	public void setSexo(String sexo) {
		this.sexo = sexo;
	}

}
