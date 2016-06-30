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

    public void setDesconto(int desconto) {
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
		return "ItemPedido [codigoPedido=" + codigoPedido + ", valor=" + valor + ", desconto=" + desconto
				+ ", quantidade=" + quantidade + ", produto=" + produto + "]";
	}
}
