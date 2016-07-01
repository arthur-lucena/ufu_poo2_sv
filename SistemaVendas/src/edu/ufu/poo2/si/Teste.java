package edu.ufu.poo2.si;

import java.math.BigDecimal;

import edu.ufu.poo2.si.control.ClienteDAO;
import edu.ufu.poo2.si.control.PedidoDAO;
import edu.ufu.poo2.si.control.ProdutoDAO;
import edu.ufu.poo2.si.control.VendedorDAO;
import edu.ufu.poo2.si.model.ItemPedido;
import edu.ufu.poo2.si.model.Pedido;
import edu.ufu.poo2.si.model.Produto;
import edu.ufu.poo2.si.util.enums.EnumFormaPagamento;
import edu.ufu.poo2.si.util.exceptions.ErroException;

public class Teste {

	public static void main(String[] args) {
		// testeAdicaoDeProduto();
		testePedido();

		PedidoDAO pedidoDAO = new PedidoDAO();

		// printado todos os pedidos
		try {
			for (Pedido pe : pedidoDAO.buscarTodos()) {
				System.out.println(pe);
			}
		} catch (ErroException e) {
			e.printStackTrace();
		}
	}

	public static void testePedido() {
		VendedorDAO vendedorDAO = new VendedorDAO();
		ClienteDAO clienteDAO = new ClienteDAO();
		ProdutoDAO produtoDAO = new ProdutoDAO();

		try {
			Pedido p = new Pedido();
			p.setFormaPagamento(EnumFormaPagamento.Dinheiro);
			p.setCliente(clienteDAO.buscar("02172030945"));
			p.setVendedor(vendedorDAO.buscar("03587339872"));

			ItemPedido ip = new ItemPedido();
			ip.setQuantidade(1);
			ip.setValor(new BigDecimal(96));
			ip.setProduto(produtoDAO.buscar(8l));

			p.setValorTotal(ip.getValor().multiply(BigDecimal.valueOf(ip.getQuantidade())));

			p.getItens().add(ip);

			new Venda().fechaVenda(p);
		} catch (ErroException e) {
			System.out.println(e.getMessage());
			e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public static void testeAdicaoDeProduto() {
		ProdutoDAO produtoDAO = new ProdutoDAO();
		Produto produto;

		try {
			produto = produtoDAO.buscar(8l);
			produto.getEstoque().adicionar(3);
			produtoDAO.update(produto);
		} catch (ErroException e) {
			e.printStackTrace();
		}
	}
}
