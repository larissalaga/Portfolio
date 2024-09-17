package br.com.salesfoce.beans;

public class Representante extends Contato {

	private String nome;
	private String cpf;
	private Empresa empresa;

	public Representante() {
		super();
	}

	public Representante(String telefone, String email, String nome, String cpf, Empresa empresa) {
		super(telefone, email);
		this.nome = nome;
		this.cpf = cpf;
		this.empresa = empresa;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getCpf() {
		return cpf;
	}

	public void setCpf(String cpf) {
		this.cpf = cpf;
	}

	public Empresa getEmpresa() {
		return empresa;
	}

	public void setEmpresa(Empresa empresa) {
		this.empresa = empresa;
	}

}
