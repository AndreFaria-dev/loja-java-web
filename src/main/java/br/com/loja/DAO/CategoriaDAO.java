package br.com.loja.DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashMap;

public class CategoriaDAO {
	
	//Create
	public void salvar(String nomeCategoria) {
		try {
			
			String sql = "INSERT INTO categoria (nome) VALUES ('"+nomeCategoria+"')";
			
			Connection con = Conexao.conectar();
			
			PreparedStatement pstmt = con.prepareStatement(sql);
			
			pstmt.executeUpdate();
			
			//Verificação de erros
			System.out.println(sql);
			System.out.println("Execução: "+pstmt.executeUpdate());
			
			
			
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
	}
	
	//Read
	public static void consultar(String sql) {
		
		//Array associativo
		HashMap<String, String> dados = new HashMap<String, String>();

		try {
			Connection con = Conexao.conectar();
			
			PreparedStatement pstmt = con.prepareStatement(sql);
			
			ResultSet rs = pstmt.executeQuery(sql);
			
			while(rs.next()) {
				
				String idcategoria	=	rs.getString("idcategoria");
				String nome	=	rs.getString("nome");
				
				dados.put("ID: ",idcategoria);
				dados.put("Nome: ", nome);
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
	public static void atualizar(String sql) {
		try {
			Connection con = Conexao.conectar();
			PreparedStatement pstmt = con.prepareStatement(sql);
			pstmt.executeUpdate(sql);
			
			
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	//Delete
	public static void excluir(String sql) {
		try {
			Connection con = Conexao.conectar();
			PreparedStatement pstmt = con.prepareStatement(sql);
			pstmt.executeUpdate(sql);
			
			
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
