package br.com.loja.DAO;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Conexao {
	
	public static final String usuario = "root";
	public static final String senha = "root";
	public static final String url = "localhost:3306/lojadb";
	public static final String connector = "jdbc:mysql";
	

	public static Connection conectar() throws SQLException, ClassNotFoundException {
		
		Connection conexao = null;
		Class.forName("com.mysql.cj.jdbc.Driver");
		conexao = DriverManager.getConnection(connector+"://"+url,usuario,senha);
		
		return conexao;
		
		
	}
}
