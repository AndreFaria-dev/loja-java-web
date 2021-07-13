package br.com.loja.DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashMap;

public class ClienteDAO {
	
	//Create
	public void inserir(String nome, String contato) {
		
		try {
			String sql = "INSERT INTO cliente(nome, contato) VALUES ('"+nome+"','"+contato+"')";
			
			Connection con = Conexao.conectar();
			
			PreparedStatement pstmt = con.prepareStatement(sql);
			
			pstmt.executeUpdate();
			
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
	}
	
	//Read
	public void ler() {
		
		String sql = "SELECT * FROM cliente";
		//Imprimir um array associativo
		HashMap<String, String> dados = new HashMap<String, String>();
		
		try {
			Connection con = Conexao.conectar();
			PreparedStatement pstmt = con.prepareStatement(sql);
			ResultSet rs = pstmt.executeQuery(sql);
			
			while(rs.next()) {
				String idcliente	= rs.getString("idcliente");
				String nome			= rs.getString("nome");
				String contato 		= rs.getString("Contato");
				
				dados.put("ID: ",idcliente);
				dados.put("Nome: ", nome);
				dados.put("Contato: ", contato);
				
				System.out.println(dados);
			}
			
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	//Update
	public void editar(String id, String nome, String contato) {
		
		StringBuilder comando = new StringBuilder();
		
		//Construindo o comando update
		comando.append("UPDATE cliente SET ");
		if(nome 	!= null)	{	comando.append("nome = '"+nome+"', ");	}
		if(contato 	!= null)	{	comando.append("contato = '"+nome+"' ");	}
		comando.append("WHERE idcliente = "+id);
		
		String sql = comando.toString().replace(", WHERE", " WHERE");
		
		System.out.println(sql);
		
		try {
			
			Connection con = Conexao.conectar();
			PreparedStatement pstmt = con.prepareStatement(sql);
			pstmt.executeUpdate();
			
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	//Delete
	public void excluir() {
		
	}

}
