package edu.ufu.poo2.si.api;

import edu.ufu.poo2.si.model.Estoque;

public interface EstadoEstoque {

	public abstract void faturar(Estoque estoque);

	public abstract void reservar(Estoque estoque);

}
