package edu.ufu.poo2.si.util.estadoEstoque;

import edu.ufu.poo2.si.api.EstadoEstoque;
import edu.ufu.poo2.si.util.enums.EnumEstadoEstoque;
import edu.ufu.poo2.si.util.exceptions.ValidacaoException;

public class EmEstoque extends EstadoEstoque {
	
	public void adicionar(int quantidade) {
        estoque.setQuantidade(estoque.getQuantidade() + quantidade); 
        System.out.println("Quantidade Incrementada: " + quantidade);
        this.verificarEstado();
    }
    
    public void faturar(int quantidade) throws ValidacaoException {
    	if (estoque.getQuantidade() >= quantidade) {
    		estoque.setQuantidade(estoque.getQuantidade() - quantidade); 
            System.out.println("Quantidade Faturada : " + quantidade);
            this.verificarEstado();
    	} else {
    		throw new ValidacaoException("Quantidade a ser faturada é maior que a disponível!"
    				+ " Quantidade em estoque:" + estoque.getQuantidade() 
    				+ ", quantidade solicidata:" + quantidade);
    	}
    }

    public void verificarEstado(){
        if(estoque.getQuantidade() <= 0){
             estoque.setEstadoEstoque(EnumEstadoEstoque.EmFalta);
        } 
    }
}
