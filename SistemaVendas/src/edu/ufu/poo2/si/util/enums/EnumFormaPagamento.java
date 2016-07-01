package edu.ufu.poo2.si.util.enums;

import edu.ufu.poo2.si.api.FormaPagamento;
import edu.ufu.poo2.si.util.formaPagamento.FormaPagamentoBoleto;
import edu.ufu.poo2.si.util.formaPagamento.FormaPagamentoCartao;
import edu.ufu.poo2.si.util.formaPagamento.FormaPagamentoDinheiro;

public enum EnumFormaPagamento {
	Boleto(new FormaPagamentoBoleto()), Cartao(new FormaPagamentoCartao()), Dinheiro(new FormaPagamentoDinheiro());

	private FormaPagamento formaPagamento;

	EnumFormaPagamento(FormaPagamento formaPagamento) {
		this.formaPagamento = formaPagamento;
	}

	public static EnumFormaPagamento getFormaPagamento(Integer numero) {
		for (EnumFormaPagamento factory : values()) {
			if (numero.equals(factory.ordinal())) {
				return factory;
			}
		}

		return null;
	}
	
	public FormaPagamento getClassFormaPagamento() {
		return formaPagamento;
	}
}
