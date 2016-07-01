package edu.ufu.poo2.si.util.formaPagamento;

import edu.ufu.poo2.si.api.FormaPagamento;

public class FormaPagamentoBoleto implements FormaPagamento {

	public String receber() {
		String msg ="Forma de Pagamento: Boleto\n"
				+ "Prazo: 28 dias\n"
				+ "Banco: Monopolis SA\n";
				
		return msg;
	}

}
