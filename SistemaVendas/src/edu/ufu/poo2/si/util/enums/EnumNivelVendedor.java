package edu.ufu.poo2.si.util.enums;

import edu.ufu.poo2.si.api.NivelVendedor;
import edu.ufu.poo2.si.model.Estoque;
import edu.ufu.poo2.si.util.nivelVendedor.VendedorOuro;
import edu.ufu.poo2.si.util.nivelVendedor.VendedorPlatina;
import edu.ufu.poo2.si.util.nivelVendedor.VendedorPrata;

public enum EnumNivelVendedor {
    Prata(new VendedorPrata()),
    Ouro(new VendedorOuro()),
    Platina(new VendedorPlatina());
    
    private NivelVendedor nivelVendedor;
    
    EnumNivelVendedor (NivelVendedor nivelVendedor){
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
    
    public NivelVendedor getCommandClass(Estoque estoque) {
    	return nivelVendedor;
    }
}
