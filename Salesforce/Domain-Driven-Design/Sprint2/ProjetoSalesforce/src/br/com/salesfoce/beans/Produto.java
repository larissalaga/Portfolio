package br.com.salesfoce.beans;

public class Produto {

	// atributos

	private int codigo;
	private String tipo;
	private String plano;
	private double preco;

	public Produto() {
		super();
	}

	public Produto(int codigo, String tipo, String plano, double preco) {
		super();
		this.codigo = codigo;
		this.tipo = tipo;
		this.plano = plano;
		this.preco = preco;
	}

	public int getCodigo() {
		return codigo;
	}

	public void setCodigo(int codigo) {
		this.codigo = codigo;
	}

	public String getTipo() {
		return tipo;
	}

	public void setTipo(String tipo) {
		this.tipo = tipo;
	}

	public String getPlano() {
		return plano;
	}

	public void setPlano(String plano) {
		this.plano = plano;
	}

	public double getPreco() {
		return preco;
	}

	public void setPreco(double preco) {
		this.preco = preco;
	}

}
