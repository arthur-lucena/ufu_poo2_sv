package edu.ufu.poo2.si.model;

import java.math.BigDecimal;

public class ItemPedido {

	private Long codigoPedido;
	
	private Long codigoProduto;

    private BigDecimal valor;
    
    private int desconto;

    private int quantidade;

    public Long getCodigoPedido() {
		return codigoPedido;
	}

	public void setCodigoPedido(Long codigoPedido) {
		this.codigoPedido = codigoPedido;
	}

	public Long getCodigoProduto() {
		return codigoProduto;
	}

	public void setCodigoProduto(Long codigoProduto) {
		this.codigoProduto = codigoProduto;
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

	@Override
	public String toString() {
		return "ItemPedido [codigoPedido=" + codigoPedido + ", codigoProduto=" + codigoProduto + ", valor=" + valor
				+ ", quantidade=" + quantidade +", desconto="+ desconto+"%"+"]";
	}
}
