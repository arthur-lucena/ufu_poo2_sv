package edu.ufu.poo2.si.util.formaPagamento;

import edu.ufu.poo2.si.api.FormaPagamento;

public class FormaPagamentoCartao implements FormaPagamento {

    public void receber() {
        System.out.println("Forma de Pagamento: Cartao");
        System.out.println("Debito");
        System.out.println("Bandeira Credit");
    }

}
