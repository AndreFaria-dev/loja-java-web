package br.com.loja.bin;

import java.sql.SQLException;
import java.util.ArrayList;

import br.com.loja.DAO.ProdutoDAO;
import br.com.loja.domain.Fornecedor;
import br.com.loja.domain.Produto;
//import java.util.Scanner;





public class TesteDados {
	

	public static void main(String[] args) throws ClassNotFoundException, SQLException {
		
		
		System.out.println("TESTE DE EXECUÇÃO BANCO DE DADOS");
		
		ProdutoDAO pdao = new ProdutoDAO();
		//Produto p = new Produto();
		
		pdao.consultar();
		


	}

}
