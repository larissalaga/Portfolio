package br.com.salesforce.beans;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class Formulario {

	private String nome;
	private String email;
	private String telefone;
	private String empresa;
	private String regiao;

	public Formulario() {
		super();
	}

	public Formulario(String nome, String email, String telefone, String empresa, String regiao) {
		super();
		this.nome = nome;
		this.email = email;
		this.telefone = telefone;
		this.empresa = empresa;
		this.regiao = regiao;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getTelefone() {
		return telefone;
	}

	public void setTelefone(String telefone) {
		this.telefone = telefone;
	}

	public String getEmpresa() {
		return empresa;
	}

	public void setEmpresa(String empresa) {
		this.empresa = empresa;
	}

	public String getRegiao() {
		return regiao;
	}

	public void setRegiao(String regiao) {
		this.regiao = regiao;
	}

}
