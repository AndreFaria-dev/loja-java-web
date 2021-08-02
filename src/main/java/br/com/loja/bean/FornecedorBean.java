package br.com.loja.bean;

import br.com.loja.DAO.FornecedorDAO;
import br.com.loja.domain.Fornecedor;

import java.util.ArrayList;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.model.ListDataModel;

@ManagedBean(name = "MBfornecedor")
@ViewScoped

public class FornecedorBean {

	private String nome;
	private String contato;
	private String telefone;

	ListDataModel<Fornecedor> Itens;

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getContato() {
		return contato;
	}

	public void setContato(String contato) {
		this.contato = contato;
	}

	public String getTelefone() {
		return telefone;
	}

	public void setTelefone(String telefone) {
		this.telefone = telefone;
	}

	public ListDataModel<Fornecedor> getItens() {
		return Itens;
	}

	public void setItens(ListDataModel<Fornecedor> itens) {
		Itens = itens;
	}

	@PostConstruct
	public void gerarLista() {

		FornecedorDAO dao = new FornecedorDAO();

		
		ArrayList<Fornecedor> lista = dao.consultar();
		
		//Conversão de ArrayLista para ListDataModel
		Itens = new ListDataModel<Fornecedor>(lista);
		
		

	}
}
