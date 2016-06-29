package edu.ufu.poo2.si.util;

public enum EnumFormaPagamento {
	Boleto,
	Cartao,
	Dinheiro;
	
    public static EnumFormaPagamento getFormaPagamento(Integer numero) {
	   for (EnumFormaPagamento factory : values()) {
	      if (numero.equals(factory.ordinal())) {
	         return factory;
	      }
	   }
	   
	   return null;
    } 
}
