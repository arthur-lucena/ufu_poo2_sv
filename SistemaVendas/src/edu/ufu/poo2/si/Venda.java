package edu.ufu.poo2.si;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.ArrayList;
import java.util.List;

import edu.ufu.poo2.si.control.PedidoDAO;
import edu.ufu.poo2.si.control.ProdutoDAO;
import edu.ufu.poo2.si.model.ItemPedido;
import edu.ufu.poo2.si.model.Pedido;
import edu.ufu.poo2.si.model.Produto;
import edu.ufu.poo2.si.util.enums.EnumNivelVendedor;
import edu.ufu.poo2.si.util.exceptions.ErroException;
import edu.ufu.poo2.si.util.exceptions.ValidacaoException;

public class Venda {
	public void fechaVenda(Pedido pedido) throws ErroException, ValidacaoException {
		avaliaDescontoDosItensPedido(pedido);		
		verificarNivelVendedor(pedido);
		faturarPedido(pedido);
		recebePedido(pedido);
	}
	
	/**
	 * Avisa ao caixa qual será a forma de recebimento
	 * @param pedido
	 */
	public void recebePedido(Pedido pedido) {
		System.out.println("recebendo...");
		System.out.println(pedido.getFormaPagamento().getClassFormaPagamento().receber());
	}
	
	/**
	 * Calcula desconto dos itens do pedido
	 * @param pedido
	 */
	public void avaliaDescontoDosItensPedido(Pedido pedido) {
		for (ItemPedido ip : pedido.getItens()) {
			BigDecimal desconto = ip.getValor().multiply(BigDecimal.valueOf(100));
			desconto = desconto.divide(ip.getProduto().getPreco(), 2, RoundingMode.HALF_UP);

			ip.setDesconto(100-desconto.intValue());
		}
	}

	public void avaliaDescontoItemPedido(ItemPedido itemPedido)	{
		BigDecimal desconto = itemPedido.getValor().multiply(BigDecimal.valueOf(100));
		desconto = desconto.divide(itemPedido.getProduto().getPreco(), 2, RoundingMode.HALF_UP);

		itemPedido.setDesconto(100-desconto.intValue());
	}

	/**
	 * Valida o desconto do nivel de desconto que o vendedor pode dar
	 * 
	 * @param pedido
	 * @throws ValidacaoException
	 */
	public void verificarNivelVendedor(Pedido pedido) throws ValidacaoException {
		for (ItemPedido ip : pedido.getItens()) {
			EnumNivelVendedor nivelVendedor = pedido.getVendedor().getNivel();

			nivelVendedor.getCommandClass().validarDesconto(ip);

			if (!ip.getNivelVendedoLibera().equals(nivelVendedor)) {
				String msg = "Para liberar o desconto do produto " + ip.getProduto().getCodigoProduto()
						+ " é necessário que o vendedor seja nível " + ip.getNivelVendedoLibera().name()
						+ "! Favor abaixar o desconto ou mudar de vendedor.";

				throw new ValidacaoException(msg);
			}
		}
	}

	/**
	 * Processo de faturamento de pedido atomico
	 * 
	 * @param pedido
	 * @throws ErroException
	 * @throws ValidacaoException
	 */
	public void faturarPedido(Pedido pedido) throws ErroException, ValidacaoException {
		ProdutoDAO produtoDAO = new ProdutoDAO();
		List<Produto> produtosASeremFaturadosRollBack = new ArrayList<Produto>();

		try {
			// carregando os produto que seram faturados com informações
			// atualizadas
			for (ItemPedido ip : pedido.getItens()) {
				ip.setProduto((produtoDAO.buscar(ip.getProduto().getCodigoProduto())));
			}
		} catch (ErroException e) {
			throw new ErroException("Falha ao carregar produtos a serem faturados", e);
		}

		// clonando objetos
		for (ItemPedido ip : pedido.getItens()) {
			produtosASeremFaturadosRollBack.add(new Produto(ip.getProduto()));
		}

		try {
			for (ItemPedido ip : pedido.getItens()) {
				// tentando faturar o produto
				ip.getProduto().getEstoque().faturar(ip.getQuantidade());
				produtoDAO.update(ip.getProduto());
			}

			gravarPedido(pedido);
		} catch (ValidacaoException e) {
			// caso não seja possivel faturar deve se efetuar o rollback do
			// outros produto
			// voltando a quantidade anterior antes de serem faturados
			for (Produto p : produtosASeremFaturadosRollBack) {
				produtoDAO.update(p);
			}

			throw e;
		} catch (Exception e) {
			// caso não seja possivel faturar deve se efetuar o rollback do
			// outros produto
			// voltando a quantidade anterior antes de serem faturados
			for (Produto p : produtosASeremFaturadosRollBack) {
				produtoDAO.update(p);
			}

			throw e;
		}
	}

	public void gravarPedido(Pedido pedido) throws ErroException {
		PedidoDAO pedidoDAO = new PedidoDAO();
		pedidoDAO.insert(pedido);
	}
}
