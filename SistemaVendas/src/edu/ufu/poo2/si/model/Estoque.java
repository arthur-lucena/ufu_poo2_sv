package edu.ufu.poo2.si.model;

import edu.ufu.poo2.si.util.enums.EnumEstadoEstoque;

public class Estoque {

	private Long codigoEstoque;
	
    private Integer quantidade;

    private Integer quantidadeReservada;

    private EnumEstadoEstoque estadoEstoque;

    public Long getCodigoEstoque() {
		return codigoEstoque;
	}

	public void setCodigoEstoque(Long codigoEstoque) {
		this.codigoEstoque = codigoEstoque;
	}

	public Integer getQuantidade() {
        return quantidade;
    }

    public void setQuantidade(Integer quantidade) {
        this.quantidade = quantidade;
    }

    public Integer getQuantidadeReservada() {
        return quantidadeReservada;
    }

    public void setQuantidadeReservada(Integer quantidadeReservada) {
        this.quantidadeReservada = quantidadeReservada;
    }

    public EnumEstadoEstoque getEstadoEstoque() {
        return estadoEstoque;
    }

    public void setEstadoEstoque(EnumEstadoEstoque estadoEstoque) {
        this.estadoEstoque = estadoEstoque;
    }
}
