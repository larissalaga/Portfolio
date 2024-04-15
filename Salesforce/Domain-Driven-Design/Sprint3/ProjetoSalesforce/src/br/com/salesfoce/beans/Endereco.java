package br.com.salesfoce.beans;

public class Endereco {

	private int id;
	private String cep;
	private String logradouro;
	private int num;
	private String complemento;
	private String cidade;
	private String estado;
	private String pais;

	public Endereco() {
		super();
	}

	public Endereco(int id, String cep, String logradouro, int num, String complemento, String cidade, String estado,
			String pais) {
		super();
		this.id = id;
		this.cep = cep;
		this.logradouro = logradouro;
		this.num = num;
		this.complemento = complemento;
		this.cidade = cidade;
		this.estado = estado;
		this.pais = pais;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getCep() {
		return cep;
	}

	public void setCep(String cep) {
		this.cep = cep;
	}

	public String getLogradouro() {
		return logradouro;
	}

	public void setLogradouro(String logradouro) {
		this.logradouro = logradouro;
	}

	public int getNum() {
		return num;
	}

	public void setNum(int num) {
		this.num = num;
	}

	public String getComplemento() {
		return complemento;
	}

	public void setComplemento(String complemento) {
		this.complemento = complemento;
	}

	public String getCidade() {
		return cidade;
	}

	public void setCidade(String cidade) {
		this.cidade = cidade;
	}

	public String getEstado() {
		return estado;
	}

	public void setEstado(String estado) {
		this.estado = estado;
	}

	public String getPais() {
		return pais;
	}

	public void setPais(String pais) {
		this.pais = pais;
	}

}
