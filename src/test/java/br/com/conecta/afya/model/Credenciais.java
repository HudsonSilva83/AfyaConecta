package br.com.conecta.afya.model;

import br.com.conecta.afya.security.CriptexFrw;

public class Credenciais {

	String login;
	String password;

	public String getLogin() {

		return login;

	}

	public String getPassword() {

		return password;

	}
	
	
	public void setLogin(String login) {
		this.login = login;
	}
	public void setPassword(String password) {
		
		
		this.password = CriptexFrw.decrypt(password);
		
		
		//this.password = password;
	}

	@Override
	public String toString() {

		return "Credenciais{" + "login=" + login + ", password=" + password + '}';

	}

}
