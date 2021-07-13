package br.com.loja.domain;

public class Fornecedor {
	private int idFornecedor;
	private String nomeFornecedor;
	private String contatoFornecedor;
	private String telefoneFornecedor;
	
	private Fornecedor fornecedor;
	
	public int getIdFornecedor() {
		return idFornecedor;
	}
	
	public void setIdFornecedor(int idFornecedor) {
		this.idFornecedor = idFornecedor;
	}
	
	public String getNomeFornecedor() {
		return nomeFornecedor;
	}
	
	public void setNomeFornecedor(String nomeFornecedor) {
		this.nomeFornecedor = nomeFornecedor;
	}
	
	public String getContatoFornecedor() {
		return contatoFornecedor;
	}
	
	public void setContatoFornecedor(String contatoFornecedor) {
		this.contatoFornecedor = contatoFornecedor;
	}
	public String getTelefoneFornecedor() {
		return telefoneFornecedor;
	}
	
	public void setTelefoneFornecedor(String telefoneFornecedor) {
		this.telefoneFornecedor = telefoneFornecedor;
	}

	/**
	 * @return the fornecedor
	 */
	public Fornecedor getFornecedor() {
		return fornecedor;
	}

	/**
	 * @param fornecedor the fornecedor to set
	 */
	public void setFornecedor(Fornecedor fornecedor) {
		this.fornecedor = fornecedor;
	}
	
}

