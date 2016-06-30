package edu.ufu.poo2.si.util.estadoEstoque;

import edu.ufu.poo2.si.api.EstadoEstoque;
import edu.ufu.poo2.si.util.enums.EnumEstadoEstoque;
import edu.ufu.poo2.si.util.exceptions.ValidacaoException;

public class EmPreVenda extends EstadoEstoque {

	public void adicionar(int quantidade) {
		if (quantidade > estoque.getQuantidadeReservada()) {
			System.out.println("Quantidade descontanda unidades da prevenda: " + estoque.getQuantidadeReservada());
			quantidade = quantidade - estoque.getQuantidadeReservada();
			estoque.setQuantidadeReservada(0);
			
			System.out.println("Quantidade Incrementada: " + quantidade);
			estoque.setQuantidade(estoque.getQuantidade() + quantidade);
		} else {
			System.out.println("Quantidade Descontada da Reserva: " + quantidade);
			estoque.setQuantidadeReservada(estoque.getQuantidadeReservada() - quantidade);
		}

		this.verificarEstado();
	}

	public void faturar(int quantidade) throws ValidacaoException {
		estoque.setQuantidadeReservada(estoque.getQuantidadeReservada() + quantidade);
		System.out.println("O produto faturado em prevenda");
		this.verificarEstado();
	}

	public void verificarEstado() {
		if (estoque.getQuantidade() > 0) {
			estoque.setEstadoEstoque(EnumEstadoEstoque.EmEstoque);
		}
	}
}
