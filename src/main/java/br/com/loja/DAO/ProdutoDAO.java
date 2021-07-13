package br.com.loja.DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashMap;

public class ProdutoDAO {
	
	//Inserir
	public void salvar(String titulo, String descricao, double preco, int quantidade, int fornecedor_id, int categoria_id) {
		
		StringBuilder comando = new StringBuilder();
		
		comando.append("INSERT INTO produto ");
		comando.append("(titulo, descricao, preco, quantidade, fornecedor_id, categoria_id) ");
		comando.append("VALUES ");
		comando.append("('"+titulo+"', ");
		comando.append("'"+descricao+"', ");
		comando.append(preco+", ");
		comando.append(quantidade+", ");
		comando.append(fornecedor_id+", ");
		comando.append(categoria_id+")");
		
		String sql = comando.toString();
		
		System.out.print(sql);
		
		try {
			
			
			
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
	public void consultar() {
		
		String sql = "SELECT * FROM produto";
		//Imprimir um array associativo
		HashMap<String, String> dados = new HashMap<String, String>();
		
		try {
			
			Connection con = Conexao.conectar();
			
			PreparedStatement pstmt = con.prepareStatement(sql);
			
			ResultSet rs = pstmt.executeQuery(sql);
			
			while(rs.next()) {	//Enquanto houver registro na tabela
				
				String idproduto 	=	rs.getString("idproduto");
				String titulo		=	rs.getString("titulo");
				String descricao	=	rs.getString("descricao");
				String preco		=	rs.getString("preco");
				String quantidade	=	rs.getString("quantidade");
				String fornecedor_id	=	rs.getString("fornecedor_id");
				String categoria_id		=	rs.getString("categoria_id");
				
				dados.put("id:	",idproduto);
				dados.put("titulo:",titulo);
				dados.put("descricao:",descricao);
				dados.put("preço ",preco);
				dados.put("quantidade ",quantidade);
				dados.put("id fornecedor",fornecedor_id);
				dados.put("id categoria",categoria_id);
				
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
	public void editar(int id, double preco, int qtd) {
		
		StringBuilder comando = new StringBuilder();
		
		comando.append("UPDATE produto SET ");
		if(preco != 0) comando.append("preco = "+preco+", ");
		if(qtd != 0)	comando.append("quantidade = "+qtd+", ");
		comando.append("WHERE idproduto = "+id);
		
		String sql = comando.toString().replace(", WHERE", "  WHERE");
		
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
	public static void excluir() {
		
	}

}
