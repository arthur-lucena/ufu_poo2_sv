package edu.ufu.poo2.si.model;

import edu.ufu.poo2.si.api.EstadoEstoque;

public class Estoque {

    private int quantidade;

    private int quantidadeReservada;

    private EstadoEstoque estadoEstoque;

    public int getQuantidade() {
        return quantidade;
    }

    public void setQuantidade(int quantidade) {
        this.quantidade = quantidade;
    }

    public int getQuantidadeReservada() {
        return quantidadeReservada;
    }

    public void setQuantidadeReservada(int quantidadeReservada) {
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
