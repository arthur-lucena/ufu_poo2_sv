package edu.ufu.poo2.si;

import java.math.BigDecimal;

import edu.ufu.poo2.si.control.ClienteDAO;
import edu.ufu.poo2.si.control.ProdutoDAO;
import edu.ufu.poo2.si.control.VendedorDAO;
import edu.ufu.poo2.si.model.Cliente;
import edu.ufu.poo2.si.model.Estoque;
import edu.ufu.poo2.si.model.Produto;
import edu.ufu.poo2.si.model.Vendedor;
import edu.ufu.poo2.si.util.enums.EnumEstadoEstoque;
import edu.ufu.poo2.si.util.enums.EnumNivelVendedor;
import edu.ufu.poo2.si.util.exceptions.ErroException;

public class UtilsTeste {
	public static void cargaDeCliente() {
		ClienteDAO dao = new ClienteDAO();

		try {
			Cliente cliente;
			for (int i = 0; i < 100; i++) {
				cliente = new Cliente();
				cliente.setCPF(geraCPF());
				cliente.setNome("Cliente " + i);
				dao.delete(cliente.getCPF());
				dao.insert(cliente);
			}

			for (Cliente c : dao.buscarTodos()) {
				System.out.println(c);
			}
		} catch (ErroException e) {
			System.out.println(e.getMessage());
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public static void cargaDeVendedor() {
		VendedorDAO dao = new VendedorDAO();

		try {
			Vendedor vendedor;
			for (int i = 0; i < 100; i++) {
				vendedor = new Vendedor();
				vendedor.setCPF(geraCPF());
				vendedor.setNome("Vendedor " + i);
				vendedor.setNivel(i % 2 == 0 ? EnumNivelVendedor.Ouro : EnumNivelVendedor.Prata);
				dao.delete(vendedor.getCPF());
				dao.insert(vendedor);
			}

			for (Vendedor ve : dao.buscarTodos()) {
				System.out.println(ve);
			}
		} catch (ErroException e) {
			System.out.println(e.getMessage());
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public static void cargaDeProduto() {
		ProdutoDAO dao = new ProdutoDAO();

		try {
			Produto produto;
			Estoque estoque;
			for (int i = 0; i < 50; i++) {
				produto = new Produto();
				estoque = new Estoque();

				produto.setNomeProduto("Produto " + i);
				produto.setPreco(new BigDecimal((Math.random() * 1000) / 7));

				estoque.setQuantidade(Long.valueOf(Math.round((Math.random() * 100))).intValue());
				estoque.setQuantidadeReservada(0);
				estoque.setEstadoEstoque(EnumEstadoEstoque.EmEstoque);

				produto.setEstoque(estoque);

				dao.insert(produto);
			}

			for (Produto prod : dao.buscarTodos()) {
				System.out.println(prod);
			}
		} catch (ErroException e) {
			System.out.println(e.getMessage());
		} catch (Exception e) {
			e.printStackTrace();
		}
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
	
	private static String calcDigVerif(String num) {
		Integer primDig, segDig;
		int soma = 0, peso = 10;
		for (int i = 0; i < num.length(); i++)
			soma += Integer.parseInt(num.substring(i, i + 1)) * peso--;
		if (soma % 11 == 0 | soma % 11 == 1)
			primDig = new Integer(0);
		else
			primDig = new Integer(11 - (soma % 11));
		soma = 0;
		peso = 11;
		for (int i = 0; i < num.length(); i++)
			soma += Integer.parseInt(num.substring(i, i + 1)) * peso--;
		soma += primDig.intValue() * 2;
		if (soma % 11 == 0 | soma % 11 == 1)
			segDig = new Integer(0);
		else
			segDig = new Integer(11 - (soma % 11));
		return primDig.toString() + segDig.toString();
	}

	public static String geraCPF() {
		String iniciais = "";
		Integer numero;
		for (int i = 0; i < 9; i++) {
			numero = new Integer((int) (Math.random() * 10));
			iniciais += numero.toString();
		}
		return iniciais + calcDigVerif(iniciais);
	}
}
