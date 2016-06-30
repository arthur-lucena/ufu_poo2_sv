package edu.ufu.poo2.si.model;

import edu.ufu.poo2.si.api.EstadoEstoque;

public class Estoque {

	private Long codigoEstoque;
	
    private Integer quantidade;

    private Integer quantidadeReservada;

    private EstadoEstoque estadoEstoque;

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

    public EstadoEstoque getEstadoEstoque() {
        return estadoEstoque;
    }

    public void setEstadoEstoque(EstadoEstoque estadoEstoque) {
        this.estadoEstoque = estadoEstoque;
    }
    
    public adicionar(int quantidade){
        estadoEstoque.incrementar(quantidade);
    }
    
    public faturar(int quantidade){
        estadoEstoque.faturar(quantidade);
    }
    
     public reservar(int quantidade){
        estadoEstoque.reservar(quantidade);
    }
}
