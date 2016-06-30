package edu.ufu.poo2.si.api;

import edu.ufu.poo2.si.model.Estoque;

public abstract class  EstadoEstoque {
    
    private Estoque estoque;

    
    public EstadoEstoque(Estoque estoque){
        this.estoque = estoque;
    }
    
    public Estoque getEstoque() {
        return estadoEstoque;
    }

    public void setEstoque(Estoque estoque) {
        this.estoque = estoque;
    }
    
    abstract void verificarEstado();
    
    abstract void adicionar(int quantidade);
    
    abstract void faturar(int quantidade);

    abstract void reservar(int quantidade);
    
    

}
