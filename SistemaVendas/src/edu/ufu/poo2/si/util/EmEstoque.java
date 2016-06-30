package edu.ufu.poo2.si.util;

import edu.ufu.poo2.si.api.EstadoEstoque;
import edu.ufu.poo2.si.model.Estoque;

public class EmEstoque extends EstadoEstoque {

    public EmEstoque(Estoque estoque){
        super(estoque);
    }
    
    public void adicionar(int quantidade) {
        this.getEstoque().setQuantidade(getEstoque().setQuantidade() + quantidade); 
        System.out.println("Quantidade Incrementada: " + quantidade);
        this.verificarEstado();
    }
    
    public void faturar(int quantidade) {
        this.getEstoque().setQuantidade(getEstoque().setQuantidade() - quantidade); 
        System.out.println("Quantidade Faturada : " + quantidade);
        this.verificarEstado();
    }

    public void reservar(int quantidade) {
        System.out.println("O produto possui estoque!");
    }

    public void verificarEstado(){
        if(this.getEstoque.getQuantidade < 0){
             this.getEstoque.setEstadoEstoque(new EmFalta(this.getEstoque());
        } 
    }
    
}
