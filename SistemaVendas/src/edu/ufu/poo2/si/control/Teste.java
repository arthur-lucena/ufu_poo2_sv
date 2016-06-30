package edu.ufu.poo2.si.control;

import java.math.BigDecimal;

import edu.ufu.poo2.si.model.Cliente;
import edu.ufu.poo2.si.model.Estoque;
import edu.ufu.poo2.si.model.ItemPedido;
import edu.ufu.poo2.si.model.Pedido;
import edu.ufu.poo2.si.model.Produto;
import edu.ufu.poo2.si.model.Vendedor;
import edu.ufu.poo2.si.util.enums.EnumEstadoEstoque;
import edu.ufu.poo2.si.util.enums.EnumFormaPagamento;
import edu.ufu.poo2.si.util.enums.EnumNivelVendedor;
import edu.ufu.poo2.si.util.exceptions.ErroException;

public class Teste {

	public static void main(String[] args) {
		testePedido();
	}

	public static void testeCliente() {
		ClienteDAO dao = new ClienteDAO();

		Cliente c1 = new Cliente();
		c1.setCPF("09052671680");
		c1.setNome("Arthur Lucena");

		Cliente c2 = new Cliente();
		c2.setCPF("09052671681");
		c2.setNome("Arthur Lucena");
		
		try {
			dao.delete(c1.getCPF());
			dao.insert(c1);

			dao.delete(c2.getCPF());
			dao.insert(c2);

			c1.setNome("Art Luc");
			dao.update(c1);

			Cliente c = dao.buscar(c1.getCPF());
			System.out.println(c);

			for (Cliente ce : dao.buscarTodos()) {
				System.out.println(ce);
			}
		} catch (ErroException e) {
			System.out.println(e.getMessage());
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public static void testeVendedor() {
		VendedorDAO dao = new VendedorDAO();

		Vendedor v1 = new Vendedor();
		v1.setCPF("09052671680");
		v1.setNome("Arthur Lucena");
		v1.setNivel(EnumNivelVendedor.Ouro);

		Vendedor v2 = new Vendedor();
		v2.setCPF("09052671681");
		v2.setNome("Arthur Lucena");
		v2.setNivel(EnumNivelVendedor.Prata);
		
		try {
			dao.delete(v1.getCPF());
			dao.insert(v1);

			dao.delete(v2.getCPF());
			dao.insert(v2);

			v1.setNome("Art Luc");
			dao.update(v1);

			Vendedor c = dao.buscar(v1.getCPF());
			System.out.println(c);

			for (Vendedor ce : dao.buscarTodos()) {
				System.out.println(ce);
			}
		} catch (ErroException e) {
			System.out.println(e.getMessage());
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public static void testePedido() {
		VendedorDAO vendedorDAO = new VendedorDAO();
		ClienteDAO clienteDAO = new ClienteDAO();
		PedidoDAO pedidoDAO = new PedidoDAO();
		
		try {
			pedidoDAO.delete(1l);

			Pedido p = new Pedido();
			p.setFormaPagamento(EnumFormaPagamento.Dinheiro);
			p.setValorTotal(new BigDecimal(120.5));
			p.setCliente(clienteDAO.buscar("09052671680"));
			p.setVendedor(vendedorDAO.buscar("09052671681"));

			ItemPedido ip = new ItemPedido();
			ip.setQuantidade(1);
			ip.setValor(new BigDecimal(13213.5));
			ip.setCodigoProduto(1l);

			p.getItens().add(ip);

			pedidoDAO.insert(p);

			for (Pedido pd : pedidoDAO.buscarTodos()) {
				System.out.println(pd);
			}

		} catch (ErroException e) {
			System.out.println(e.getMessage());
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public static void testeProduto() {
		Produto produto = new Produto();
		produto.setNomeProduto("Ferrari");
		produto.setPreco(new BigDecimal(1100010.5));

		Estoque estoque = new Estoque();
		estoque.setQuantidade(2);
		estoque.setQuantidadeReservada(0);
		estoque.setEstadoEstoque(EnumEstadoEstoque.EmEstoque);

		produto.setEstoque(estoque);
		
		try {
			ProdutoDAO dao = new ProdutoDAO();
			dao.delete(1l);
			dao.insert(produto);

			for (Produto pr : dao.buscarTodos()) {
				System.out.println(pr);
			}

		} catch (ErroException e) {
			System.out.println(e.getMessage());
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
