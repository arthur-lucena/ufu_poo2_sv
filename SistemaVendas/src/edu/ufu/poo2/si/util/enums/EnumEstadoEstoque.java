package edu.ufu.poo2.si.util.enums;

import edu.ufu.poo2.si.api.EstadoEstoque;
import edu.ufu.poo2.si.model.Estoque;
import edu.ufu.poo2.si.util.estadoEstoque.EmEstoque;
import edu.ufu.poo2.si.util.estadoEstoque.EmFalta;
import edu.ufu.poo2.si.util.estadoEstoque.EmPreVenda;

public enum EnumEstadoEstoque {
    EmEstoque(new EmEstoque()),
    EmFalta(new EmFalta()),
    EmPreVenda(new EmPreVenda());
	
	private EstadoEstoque estadoEstoque;
    
    EnumEstadoEstoque (EstadoEstoque estadoEstoque) {
    	this.estadoEstoque = estadoEstoque;
    }

    public static EnumEstadoEstoque getNivel(Integer numero) {
        for (EnumEstadoEstoque factory : values()) {
            if (numero.equals(factory.ordinal())) {
                return factory;
            }
        }

        return null;
    }
    
    public EstadoEstoque getStateClass(Estoque estoque) {
    	estadoEstoque.estoque = estoque;
    	return estadoEstoque;
    }
}
