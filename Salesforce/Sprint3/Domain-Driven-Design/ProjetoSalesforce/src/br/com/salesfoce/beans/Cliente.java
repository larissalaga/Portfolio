package br.com.salesfoce.beans;

public class Cliente {

	private int codigo;
	private String nome;
	private Endereco endereco;
	private Contato contato;
	private Produto produto;

	public Cliente() {
		super();
	}

	public Cliente(int codigo, String nome, Endereco endereco, Contato contato, Produto produto) {
		super();
		this.codigo = codigo;
		this.nome = nome;
		this.endereco = endereco;
		this.contato = contato;
		this.produto = produto;
	}

	public int getCodigo() {
		return codigo;
	}

	public void setCodigo(int codigo) {
		this.codigo = codigo;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public Endereco getEndereco() {
		return endereco;
	}

	public void setEndereco(Endereco endereco) {
		this.endereco = endereco;
	}

	public Contato getContato() {
		return contato;
	}

	public void setContato(Contato contato) {
		this.contato = contato;
	}

	public Produto getProduto() {
		return produto;
	}

	public void setProduto(Produto produto) {
		this.produto = produto;
	}

}
