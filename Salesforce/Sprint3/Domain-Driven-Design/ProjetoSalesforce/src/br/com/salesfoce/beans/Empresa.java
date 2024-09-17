package br.com.salesfoce.beans;

public class Empresa extends Contato {

	// atributos

	private String razaoSoc;
	private String nomeFant;
	private String cnpj;
	private String seg;
	private Endereco endereco;
	private Produto produto;

	public Empresa() {
		super();
	}

	public Empresa(String telefone, String email, String razaoSoc, String nomeFant, String cnpj, String seg,
			Endereco endereco, Produto produto) {
		super(telefone, email);
		this.razaoSoc = razaoSoc;
		this.nomeFant = nomeFant;
		this.cnpj = cnpj;
		this.seg = seg;
		this.endereco = endereco;
		this.produto = produto;
	}

	public String getRazaoSoc() {
		return razaoSoc;
	}

	public void setRazaoSoc(String razaoSoc) {
		this.razaoSoc = razaoSoc;
	}

	public String getNomeFant() {
		return nomeFant;
	}

	public void setNomeFant(String nomeFant) {
		this.nomeFant = nomeFant;
	}

	public String getCnpj() {
		return cnpj;
	}

	public void setCnpj(String cnpj) {
		this.cnpj = cnpj;
	}

	public String getSeg() {
		return seg;
	}

	public void setSeg(String seg) {
		this.seg = seg;
	}

	public Endereco getEndereco() {
		return endereco;
	}

	public void setEndereco(Endereco endereco) {
		this.endereco = endereco;
	}

	public Produto getProduto() {
		return produto;
	}

	public void setProduto(Produto produto) {
		this.produto = produto;
	}

}
