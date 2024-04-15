package br.com.salesfoce.beans;

public class Contato {

	private int id;
	private String telCelular;
	private String telFixo;
	private String email;

	public Contato() {
		super();
	}

	public Contato(int id, String telCelular, String telFixo, String email) {
		super();
		this.id = id;
		this.telCelular = telCelular;
		this.telFixo = telFixo;
		this.email = email;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getTelCelular() {
		return telCelular;
	}

	public void setTelCelular(String telCelular) {
		this.telCelular = telCelular;
	}

	public String getTelFixo() {
		return telFixo;
	}

	public void setTelFixo(String telFixo) {
		this.telFixo = telFixo;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

}
