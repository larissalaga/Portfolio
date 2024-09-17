package br.com.global.beans;

public class ContatoPJ {

	private String email;
	private String tel;
	private Empresa empresa;

	public ContatoPJ() {
		super();
	}

	public ContatoPJ(String email, String tel, Empresa empresa) {
		super();
		this.email = email;
		this.tel = tel;
		this.setEmpresa(empresa);
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

	public Empresa getEmpresa() {
		return empresa;
	}

	public void setEmpresa(Empresa empresa) {
		this.empresa = empresa;
	}

}
