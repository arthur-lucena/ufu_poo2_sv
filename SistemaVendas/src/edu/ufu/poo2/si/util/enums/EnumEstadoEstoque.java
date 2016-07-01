package edu.ufu.poo2.si.util.enums;

import edu.ufu.poo2.si.api.EstadoEstoque;
import edu.ufu.poo2.si.model.Estoque;
import edu.ufu.poo2.si.util.estadoEstoque.EmEstoque;
import edu.ufu.poo2.si.util.estadoEstoque.EmFalta;
import edu.ufu.poo2.si.util.estadoEstoque.EmPreVenda;

public enum EnumEstadoEstoque {
    EmEstoque(new EmEstoque(), "Em Estoque"),
    EmFalta(new EmFalta(), "Em Falta"),
    EmPreVenda(new EmPreVenda(), "Em Pré-Venda");
	
	private EstadoEstoque estadoEstoque;
    private String nomeEstado;
    
    EnumEstadoEstoque (EstadoEstoque estadoEstoque, String nomeEstado) {
    	this.estadoEstoque = estadoEstoque;
        this.nomeEstado = nomeEstado;
    }

    public static EnumEstadoEstoque getEstadoEstoque(Integer numero) {
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

    @Override
    public String toString() {
        return nomeEstado;
    }
}
