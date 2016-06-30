package edu.ufu.poo2.si.util.estadoEstoque;

import edu.ufu.poo2.si.api.EstadoEstoque;
import edu.ufu.poo2.si.util.enums.EnumEstadoEstoque;

public class EmEstoque extends EstadoEstoque {
	
	public void adicionar(int quantidade) {
        estoque.setQuantidade(estoque.getQuantidade() + quantidade); 
        System.out.println("Quantidade Incrementada: " + quantidade);
        this.verificarEstado();
    }
    
    public void faturar(int quantidade) {
    	estoque.setQuantidade(estoque.getQuantidade() - quantidade); 
        System.out.println("Quantidade Faturada : " + quantidade);
        this.verificarEstado();
    }

    public void verificarEstado(){
        if(estoque.getQuantidade() < 0){
             estoque.setEstadoEstoque(EnumEstadoEstoque.EmFalta);
        } 
    }
}
