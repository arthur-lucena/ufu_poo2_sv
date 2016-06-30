package edu.ufu.poo2.si.util.nivelVendedor;

import edu.ufu.poo2.si.api.NivelVendedor;
import edu.ufu.poo2.si.model.ItemPedido;
import edu.ufu.poo2.si.util.enums.EnumNivelVendedor;
import edu.ufu.poo2.si.util.exceptions.ValidacaoException;

public class VendedorPrata implements NivelVendedor {

	private NivelVendedor sucessor = new VendedorOuro();

	public void validarDesconto(ItemPedido ip) throws ValidacaoException {
		if (ip.getDesconto() > 5) {
			this.sucessor.validarDesconto(ip);
		} else {
			ip.setNivelVendedoLibera(EnumNivelVendedor.Prata);
		}
	}
}
