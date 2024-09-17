package br.com.salesfoce.beans;

public class Contato {

	// atributos

	private String telefone;
	private String email;

	public Contato() {
		super();
	}

	public Contato(String telefone, String email) {
		super();
		this.telefone = telefone;
		this.email = email;
	}

	public String getTelefone() {
		return telefone;
	}

	public void setTelefone(String telefone) {
		this.telefone = telefone;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email.toLowerCase();
	}

}
