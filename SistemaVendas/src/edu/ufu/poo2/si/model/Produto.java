package edu.ufu.poo2.si.model;

import java.math.BigDecimal;

public class Produto {

	private Long codigoProduto;
	
    private String nomeProduto;

    private BigDecimal preco;

    private Estoque estoque;
    
    public Produto() {}
    
    public Produto(Produto produto) {
    	codigoProduto = produto.codigoProduto;
    	nomeProduto = produto.nomeProduto;
    	preco = produto.preco;
    	estoque = new Estoque(produto.estoque);
    }
    
    public Long getCodigoProduto() {
		return codigoProduto;
	}

	public void setCodigoProduto(Long codigoProduto) {
		this.codigoProduto = codigoProduto;
	}

	public String getNomeProduto() {
        return nomeProduto;
    }

    public void setNomeProduto(String nomeProduto) {
        this.nomeProduto = nomeProduto;
    }

    public BigDecimal getPreco() {
        return preco;
    }

    public void setPreco(BigDecimal preco) {
        this.preco = preco;
    }

    public Estoque getEstoque() {
        return estoque;
    }

    public void setEstoque(Estoque estoque) {
        this.estoque = estoque;
    }

	@Override
	public String toString() {
		return nomeProduto;
	}
}
