package edu.ufu.poo2.si.util.nivelVendedor;

import edu.ufu.poo2.si.api.NivelVendedor;
import edu.ufu.poo2.si.model.ItemPedido;
import edu.ufu.poo2.si.util.enums.EnumNivelVendedor;
import edu.ufu.poo2.si.util.exceptions.ValidacaoException;

public class VendedorPlatina implements NivelVendedor {

	public NivelVendedor sucessor = null;

	public void validarDesconto(ItemPedido ip) throws ValidacaoException {
		if (ip.getDesconto() > 15) {
			throw new ValidacaoException("O desconto não é possível liberar uma compra com 15% de desconto!");
		} else {
			ip.setNivelVendedoLibera(EnumNivelVendedor.Platina);
		}
	}
}
