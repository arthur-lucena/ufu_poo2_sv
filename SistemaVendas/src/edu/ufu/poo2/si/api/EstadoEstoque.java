package edu.ufu.poo2.si.api;

import edu.ufu.poo2.si.model.Estoque;

public interface EstadoEstoque {

    void faturar(Estoque estoque);

    void reservar(Estoque estoque);

}
