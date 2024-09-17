package br.com.global.beans;

public class Produto {

	private String tipo;
	private double quantidade;
	private String reciclagem;
	private Empresa empresa;

	public Produto() {
		super();
	}

	public Produto(String tipo, double quantidade, String reciclagem, Empresa empresa) {
		super();
		this.tipo = tipo;
		this.quantidade = quantidade;
		this.reciclagem = reciclagem;
		this.setEmpresa(empresa);
	}

	public String getTipo() {
		return tipo;
	}

	public void setTipo(String tipo) {
		this.tipo = tipo;
	}

	public double getQuantidade() {
		return quantidade;
	}

	public void setQuantidade(double quantidade) {
		this.quantidade = quantidade;
	}

	public String getReciclagem() {
		return reciclagem;
	}

	public void setReciclagem(String reciclagem) {
		this.reciclagem = reciclagem;
	}

	public Empresa getEmpresa() {
		return empresa;
	}

	public void setEmpresa(Empresa empresa) {
		this.empresa = empresa;
	}

}
