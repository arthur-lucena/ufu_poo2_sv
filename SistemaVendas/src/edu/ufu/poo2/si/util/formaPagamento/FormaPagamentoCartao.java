package edu.ufu.poo2.si.util.formaPagamento;

import edu.ufu.poo2.si.api.FormaPagamento;

public class FormaPagamentoCartao implements FormaPagamento {

	public String receber() {
		String msg = "Forma de Pagamento: Cartao\n" 
				+ "Debito\n";
				
		return msg;
	}

}
