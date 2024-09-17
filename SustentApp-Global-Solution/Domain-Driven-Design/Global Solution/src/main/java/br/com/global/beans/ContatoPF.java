package br.com.global.beans;

public class ContatoPF {

	private String email;
	private String tel;
	private Representante representante;

	public ContatoPF() {
		super();
	}

	public ContatoPF(String email, String tel, Representante representante) {
		super();
		this.email = email;
		this.tel = tel;
		this.representante = representante;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getTel() {
		return tel;
	}

	public void setTel(String tel) {
		this.tel = tel;
	}

	public Representante getRepresentante() {
		return representante;
	}

	public void setRepresentante(Representante representante) {
		this.representante = representante;
	}

}
