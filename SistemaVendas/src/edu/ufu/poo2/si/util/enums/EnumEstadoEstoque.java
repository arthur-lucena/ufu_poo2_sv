package edu.ufu.poo2.si.util.enums;

public enum EnumEstadoEstoque {
    EmEstoque,
    EMFalta,
    EmPreVenda;

    public static EnumEstadoEstoque getNivel(Integer numero) {
        for (EnumEstadoEstoque factory : values()) {
            if (numero.equals(factory.ordinal())) {
                return factory;
            }
        }

        return null;
    }
}
