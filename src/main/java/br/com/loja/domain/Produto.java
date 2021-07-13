package br.com.loja.domain;

public class Produto {
	private int idProduto;
	private String tituloProduto;
	private String descricaoProduto;
	private	double precoProduto;
	private int quantidadeProduto;
	/**
	 * @return the idProduto
	 */
	public int getIdProduto() {
		return idProduto;
	}
	/**
	 * @param idProduto the idProduto to set
	 */
	public void setIdProduto(int idProduto) {
		this.idProduto = idProduto;
	}
	/**
	 * @return the tituloProduto
	 */
	public String getTituloProduto() {
		return tituloProduto;
	}
	/**
	 * @param tituloProduto the tituloProduto to set
	 */
	public void setTituloProduto(String tituloProduto) {
		this.tituloProduto = tituloProduto;
	}
	/**
	 * @return the descricaoProduto
	 */
	public String getDescricaoProduto() {
		return descricaoProduto;
	}
	/**
	 * @param descricaoProduto the descricaoProduto to set
	 */
	public void setDescricaoProduto(String descricaoProduto) {
		this.descricaoProduto = descricaoProduto;
	}
	/**
	 * @return the precoProduto
	 */
	public double getPrecoProduto() {
		return precoProduto;
	}
	/**
	 * @param precoProduto the precoProduto to set
	 */
	public void setPrecoProduto(double precoProduto) {
		this.precoProduto = precoProduto;
	}
	/**
	 * @return the quantidadeProduto
	 */
	public int getQuantidadeProduto() {
		return quantidadeProduto;
	}
	/**
	 * @param quantidadeProduto the quantidadeProduto to set
	 */
	public void setQuantidadeProduto(int quantidadeProduto) {
		this.quantidadeProduto = quantidadeProduto;
	}
}
