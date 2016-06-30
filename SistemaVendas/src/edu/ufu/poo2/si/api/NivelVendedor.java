package edu.ufu.poo2.si.api;

import edu.ufu.poo2.si.model.ItemPedido;
import edu.ufu.poo2.si.util.exceptions.ValidacaoException;

public interface NivelVendedor {
    void validarDesconto(ItemPedido ip) throws ValidacaoException;
}
