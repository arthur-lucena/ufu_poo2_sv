package edu.ufu.poo2.si.util.formaPagamento;

import edu.ufu.poo2.si.api.FormaPagamento;

public class FormaPagamentoBoleto implements FormaPagamento {

    public void receber() {
        System.out.println("Forma de Pagamento: Boleto");
        System.out.println("Prazo: 28 dias");
        System.out.println("Banco: Monopolis SA");
    }

}
