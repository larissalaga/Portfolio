package br.com.hapvida.beans;

public class Medico extends Contato {
	private int crm;
	private String especialidade;
	private String nascimento;
	private String rg;
	private String cpf;
	public Medico() {
		super();
	}
	public Medico(String nome, String cep, String logradouro, int numero, String bairro, String estado, String cidade,
			String pais, int telefone, String email, int crm, String especialidade, String nascimento, String rg,
			String cpf) {
		super(nome, cep, logradouro, numero, bairro, estado, cidade, pais, telefone, email);
		this.crm = crm;
		this.especialidade = especialidade;
		this.nascimento = nascimento;
		this.rg = rg;
		this.cpf = cpf;
	}
	public int getCrm() {
		return crm;
	}
	public void setCrm(int crm) {
		this.crm = crm;
	}
	public String getEspecialidade() {
		return especialidade;
	}
	public void setEspecialidade(String especialidade) {
		this.especialidade = especialidade;
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
	public String getCpf() {
		return cpf;
	}
	public void setCpf(String cpf) {
		this.cpf = cpf;
	}
	//Uso do override
	@Override
	public void setNome(String nome) {
		Nome = "Dr. " + nome;
	}
	
}
