package edu.ufu.poo2.si.util;

import edu.ufu.poo2.si.api.EstadoEstoque;
import edu.ufu.poo2.si.model.Estoque;

public class EmPreVenda extends EstadoEstoque {

     public EmPreVenda(Estoque estoque){
        super(estoque);
    }

    public void adicionar(int quantidade) {
        this.getEstoque().setQuantidade(getEstoque().setQuantidade() + quantidade); 
        System.out.println("Quantidade Incrementada: " + quantidade);
        this.verificarEstado();
    }
    
    public void faturar(int quantidade) {
        System.out.println("O produto está em falta no estoque!Porém há como reservá-lo!");
    }

    public void reservar(int quantidade) {
        this.getEstoque().setQuantidadeReservada(getEstoque().setQuantidadeReservada + quantidade); 
        System.out.println("O produto está em falta no estoque!");
        this.verificarEstado();
    }
    
     public void verificarEstado(){
        if(this.getEstoque.getQuantidade > 0){
            this.getEstoque.setEstadoEstoque(new EmEstoque(this.getEstoque());
        }
        
    }
    
}
