package br.com.hapvida.beans;

public class Paciente extends Contato {
	private String cpf;
	private String nascimento;
	private String rg;
	public Paciente() {
		super();
	}
	public Paciente(String nome, String cep, String logradouro, int numero, String bairro, String estado, String cidade,
			String pais, int telefone, String email, String cpf, String nascimento, String rg) {
		super(nome, cep, logradouro, numero, bairro, estado, cidade, pais, telefone, email);
		this.cpf = cpf;
		this.nascimento = nascimento;
		this.rg = rg;
	}
	public String getCpf() {
		return cpf;
	}
	public void setCpf(String cpf) {
		this.cpf = cpf;
	}
	public String getNascimento() {
		return nascimento;
	}
	public void setNascimento(String nascimento) {
		this.nascimento = nascimento;
	}
	public String getRg() {
		return rg;
	}
	public void setRg(String rg) {
		this.rg = rg;
	}
	
}
