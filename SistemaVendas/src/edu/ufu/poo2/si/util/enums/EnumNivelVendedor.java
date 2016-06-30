package edu.ufu.poo2.si.util.enums;

public enum EnumNivelVendedor {
    Prata,
    Ouro;

    public static EnumNivelVendedor getNivel(Integer numero) {
        for (EnumNivelVendedor factory : values()) {
            if (numero.equals(factory.ordinal())) {
                return factory;
            }
        }

        return null;
    }
}
