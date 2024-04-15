package br.com.salesfoce.beans;

public class Produto {

	private int id;
	private int codigo;
	private String nome;
	private String prazoLicensa;
	private double valorProduto;

	public Produto() {
		super();
	}

	public Produto(int id, int codigo, String nome, String prazoLicensa, double valorProduto) {
		super();
		this.id = id;
		this.codigo = codigo;
		this.nome = nome;
		this.prazoLicensa = prazoLicensa;
		this.valorProduto = valorProduto;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getCodigo() {
		return codigo;
	}

	public void setCodigo(int codigo) {
		this.codigo = codigo;
	}

	public String getPrazoLicensa() {
		return prazoLicensa;
	}

	public void setPrazoLicensa(String prazoLicensa) {
		this.prazoLicensa = prazoLicensa;
	}

	public double getValorProduto() {
		return valorProduto;
	}

	public void setValorProduto(double valorProduto) {
		this.valorProduto = valorProduto;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

}
