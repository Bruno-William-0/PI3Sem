package pi.Model;

/**
 * 
 * @author Caio
 */
public class ListaProduto {
	protected int codPedido;
	protected int codProduto;
	protected int quantidade;
	
	public ListaProduto() {
		this.codPedido = -1;
		this.quantidade = 0;
	}
	public ListaProduto(int codPedido, int codProduto, int quantidade) {
		this.codPedido = codPedido;
		this.codProduto = codProduto;
		this.quantidade = quantidade;
	}
	public ListaProduto(int codProduto, int quantidade) {
		this.codProduto = codProduto;
		this.quantidade = quantidade;
	}
	public void setCodPedido(int cod) {
		this.codProduto = cod;
	}
}
