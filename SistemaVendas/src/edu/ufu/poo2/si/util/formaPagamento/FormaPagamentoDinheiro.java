package edu.ufu.poo2.si.util.formaPagamento;

import edu.ufu.poo2.si.api.FormaPagamento;

public class FormaPagamentoDinheiro implements FormaPagamento {

    public String receber() {
    	String msg = "Forma de Pagamento: Dinheiro\n";
        return msg;
    }

}
