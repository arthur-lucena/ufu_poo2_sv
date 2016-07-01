package edu.ufu.poo2.si.util.enums;

public enum EnumFormaPagamento {
    Boleto(FormaPagamentoBoleto()),
    Cartao((FormaPagamentoCartao()),
    Dinheiro((FormaPagamentoDinheiro());
    
    private FormaPagamento formaPagamento;
    
    EnumFormaPagamento (FormaPagamento formaPagamento) {
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
}
