package br.com.global.beans;

public class CadastroPJ {

	private String cnpj;
	private String nomeFant;
	private String email;
	private String cep;

	public CadastroPJ() {
		super();
	}

	public CadastroPJ(String cnpj, String nomeFant, String email, String cep) {
		super();
		this.cnpj = cnpj;
		this.nomeFant = nomeFant;
		this.email = email;
		this.cep = cep;
	}

	public String getCnpj() {
		return cnpj;
	}

	public void setCnpj(String cnpj) {
		this.cnpj = cnpj;
	}

	public String getNomeFant() {
		return nomeFant;
	}

	public void setNomeFant(String nomeFant) {
		this.nomeFant = nomeFant;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getCep() {
		return cep;
	}

	public void setCep(String cep) {
		this.cep = cep;
	}

}
