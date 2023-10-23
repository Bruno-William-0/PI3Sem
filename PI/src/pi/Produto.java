package pi;

public class Produto {
	private int codProduto;
	private String nome;
	private double preco;
	private String descricao;
	private String tipo;
	
	//
	public Produto(int codProduto, String nome, double preco,
			String descricao, String tipo) {
		this.codProduto = codProduto;
		this.nome = nome;
		this.preco = preco;
		this.descricao = descricao;
		this.tipo = tipo;
	}
	public Produto() {}
	public String toString() {
		return "[" +codProduto+ "," +nome+ "," +preco+ "," +descricao+ "," +tipo+ "]";
	}
	//
	
	public int getCodProduto() {
		return codProduto;
	}
	public void setCodProduto(int codProduto) {
		this.codProduto = codProduto;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public double getPreco() {
		return preco;
	}
	public void setPreco(double preco) {
		this.preco = preco;
	}
	public String getDescricao() {
		return descricao;
	}
	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}
	public String getTipo() {
		return tipo;
	}
	public void setTipo(String tipo) {
		this.tipo = tipo;
	}
	
}
