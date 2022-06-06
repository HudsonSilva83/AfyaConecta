package br.com.conecta.afyapersist;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class TesteBanco {

	public static void main(String[] args) {

		String url = "jdbc:mysql://mysqlafyaeua.mysql.database.azure.com:3306/test";
		String user = "user_conectadev@mysqlafyaeua";
		String password = "5?SWuTx%";

		try {
			
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection conn = DriverManager.getConnection(url, user, password);
			System.out.println("Conectou mannn!!" + url);

		} catch (ClassNotFoundException e) {

			e.printStackTrace();

		} catch (SQLException t) {

			t.printStackTrace();
		}

	}

}
