package br.com.loja.DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.faces.bean.ApplicationScoped;

import br.com.loja.domain.Fornecedor;










public class FornecedorDAO {
	
	
	

	public void salvar(String nome, String contato, String telefone) throws ClassNotFoundException, SQLException {

		try {
			
			String sql = "INSERT INTO fornecedor (nome, contato, telefone) VALUES ('"+nome+"', '"+contato+"', '"+telefone+"')";
			
			//Buscando a conexão da classe tipo "factory"
			//Gravando o comando SQL
			Connection con = Conexao.conectar();
			PreparedStatement pstmt = con.prepareStatement(sql);
			
			//Executando o comando SQL
			pstmt.executeUpdate();
			
			//System.out.println("Execução: "+pstmt.executeUpdate());
			

		}catch (Exception e) {
			
			e.printStackTrace();
			
		}

	}
	

	
	//Read
	public ArrayList<Fornecedor> consultar() {
		String sql = "SELECT * FROM fornecedor";
		//Imprimir um array associativo
		ArrayList<Fornecedor> rows = new ArrayList<Fornecedor>();
		
		try {
			
			Connection con = Conexao.conectar();
			
			PreparedStatement pstmt = con.prepareStatement(sql);
			
			ResultSet rs = pstmt.executeQuery(sql);
			
			while(rs.next()) {
				Fornecedor fornecedorEncontrado = new Fornecedor();
				 
				
				int idfornecedor 	= rs.getInt("idfornecedor");
				String nome			= rs.getString("nome");
				String contato 		= rs.getString("contato");
				String telefone 	= rs.getString("telefone");
				
				//Verificação dos dados
				fornecedorEncontrado.setIdFornecedor(idfornecedor);
				fornecedorEncontrado.setNomeFornecedor(nome);
				fornecedorEncontrado.setContatoFornecedor(contato);
				fornecedorEncontrado.setTelefoneFornecedor(telefone);
				
				rows.add(fornecedorEncontrado);
				
				//Debug
				
				System.out.println("Linha:  "+rows);
				System.out.println("Dados: "+idfornecedor+" "+nome+" "+contato+" "+telefone);
			}
			
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return rows;
		
		
	}

	//Update
	public void editar(String id, String nome, String contato, String telefone) {
		
		StringBuilder comando = new StringBuilder();
		
		comando.append("UPDATE fornecedor ");
		comando.append("SET ");
		
		if(nome	!=	null) 		{	comando.append("nome = '"+nome+"', ");		}
		if(contato	!=	null)	{	comando.append("contato = '"+contato+"', ");	}
		if(telefone	!=	null)	{	comando.append("telefone = '"+telefone+"' ");}
		
		comando.append("WHERE idfornecedor = "+id);
		
		String sql = comando.toString();
		sql = sql.replace(", WHERE", "  WHERE");
		
		//Verificação de resultado
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
	public void excluir(String contato) {
		
		String sql = "DELETE FROM fornecedor WHERE contato = "+contato;
		
		Connection con;
		try {
			
			
			con = Conexao.conectar();
			PreparedStatement pstmt = con.prepareStatement(sql);
			
			pstmt.executeUpdate();
			
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		
	}
	


	
}
