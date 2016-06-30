package edu.ufu.poo2.si.model;

import java.math.BigDecimal;

public class ItemPedido {

	private Long codigoPedido;

    private BigDecimal valor;
    
    private int desconto;

    private int quantidade;
    
    private Produto produto;

    public Long getCodigoPedido() {
		return codigoPedido;
	}

	public void setCodigoPedido(Long codigoPedido) {
		this.codigoPedido = codigoPedido;
	}

	public BigDecimal getValor() {
        return valor;
    }

    public void setValor(BigDecimal valor) {
        this.valor = valor;
    }
	
	public int getDesconto() {
        return desconto;
    }

    public void setDesconto(int quantidade) {
        this.desconto = desconto;
    }
	
    public int getQuantidade() {
        return quantidade;
    }

    public void setQuantidade(int quantidade) {
        this.quantidade = quantidade;
    }

    public Produto getProduto() {
		return produto;
	}

	public void setProduto(Produto produto) {
		this.produto = produto;
	}

	@Override
	public String toString() {
<<<<<<< HEAD
		return "ItemPedido [codigoPedido=" + codigoPedido + ", codigoProduto=" + codigoProduto + ", valor=" + valor
				+ ", quantidade=" + quantidade +", desconto="+ desconto+"%"+"]";
=======
		return "ItemPedido [codigoPedido=" + codigoPedido + ", valor=" + valor + ", quantidade=" + quantidade
				+ ", produto=" + produto + "]";
>>>>>>> bf1b535b4415878f4a0459bbf0d1ef9d786cad90
	}
}
