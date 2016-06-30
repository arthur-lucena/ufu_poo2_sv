package edu.ufu.poo2.si.util.enums;

public enum EnumNivelVendedor {
    Prata(new VendedorPrata()),
    Ouro(new VendedorOuro()),
    Prata.setSucessor(Ouro);
    
    private NivelVendedor nivelVendedor;
    
    
    public EnumNivelVendedor (NivelVendedor nivelVendedor){
        this.nivelVendedor = nivelVendedor;

    }

    public static EnumNivelVendedor getNivel(Integer numero) {
        for (EnumNivelVendedor factory : values()) {
            if (numero.equals(factory.ordinal())) {
                return factory;
            }
        }

        return null;
    }
    
    
}
