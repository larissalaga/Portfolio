package br.com.salesfoce.beans;

public class Empresa {

	// atributos

	private String razaoSoc;
	private String nomeFant;
	private String cnpj;
	private String telefone;
	private String email;
	private String seg;
	private Endereco endereco;

	// construtor cheio

	public Empresa(String razaoSoc, String nomeFant, String cnpj, String telefone, String email, String seg) {
		super();
		this.razaoSoc = razaoSoc;
		this.nomeFant = nomeFant;
		this.cnpj = cnpj;
		this.telefone = telefone;
		this.email = email;
		this.seg = seg;
	}

	// construtor vazio

	public Empresa() {
		super();
	}

	// gets e sets

	public String getRazaoSoc() {
		return razaoSoc;
	}

	public String getNomeFant() {
		return nomeFant;
	}

	public String getCnpj() {
		return cnpj;
	}

	public String getTelefone() {
		return telefone;
	}

	public String getSeg() {
		return seg;
	}

	public Endereco getEndereco() {
		return endereco;
	}

	public void setRazaoSoc(String razaoSoc) {
		this.razaoSoc = razaoSoc;
	}

	public void setNomeFant(String nomeFant) {
		this.nomeFant = nomeFant;
	}

	public void setCnpj(String cnpj) {
		this.cnpj = cnpj;
	}

	public void setTelefone(String telefone) {
		this.telefone = telefone;
	}

	public void setSeg(String seg) {
		this.seg = seg;
	}

	public void setEndereco(Endereco endereco) {
		this.endereco = endereco;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

}
