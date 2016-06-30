package edu.ufu.poo2.si.util.estadoEstoque;

import edu.ufu.poo2.si.api.EstadoEstoque;
import edu.ufu.poo2.si.util.enums.EnumEstadoEstoque;
import edu.ufu.poo2.si.util.exceptions.ValidacaoException;

public class EmFalta extends EstadoEstoque {

	public void adicionar(int quantidade) {
		estoque.setQuantidade(estoque.getQuantidade() + quantidade);
		System.out.println("Quantidade Incrementada: " + quantidade);
		this.verificarEstado();
	}

	public void faturar(int quantidade) throws ValidacaoException {
		throw new ValidacaoException("O produto está em falta no estoque!");
	}

	public void verificarEstado() {
		if (estoque.getQuantidade() > 0) {
			estoque.setEstadoEstoque(EnumEstadoEstoque.EmEstoque);
		}
	}
}
