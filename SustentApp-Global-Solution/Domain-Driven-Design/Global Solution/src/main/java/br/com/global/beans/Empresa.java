package br.com.global.beans;

public class Empresa {

	private String nomeFant;
	private String razaoSoc;
	private String cnpj;
	private Representante representante;

	public Empresa() {
		super();
	}

	public Empresa(String nomeFant, String razaoSoc, String cnpj, Representante representante) {
		super();
		this.nomeFant = nomeFant;
		this.razaoSoc = razaoSoc;
		this.cnpj = cnpj;
		this.representante = representante;
	}

	public String getNomeFant() {
		return nomeFant;
	}

	public void setNomeFant(String nomeFant) {
		this.nomeFant = nomeFant;
	}

	public String getRazaoSoc() {
		return razaoSoc;
	}

	public void setRazaoSoc(String razaoSoc) {
		this.razaoSoc = razaoSoc;
	}

	public String getCnpj() {
		return cnpj;
	}

	public void setCnpj(String cnpj) {
		this.cnpj = cnpj;
	}

	public Representante getRepresentante() {
		return representante;
	}

	public void setRepresentante(Representante representante) {
		this.representante = representante;
	}

}
