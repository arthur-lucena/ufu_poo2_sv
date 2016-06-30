package edu.ufu.poo2.si.control;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import edu.ufu.poo2.si.control.utils.FactoryConnection;
import edu.ufu.poo2.si.model.ItemPedido;
import edu.ufu.poo2.si.model.Pedido;
import edu.ufu.poo2.si.util.enums.EnumFormaPagamento;
import edu.ufu.poo2.si.util.exceptions.ErroException;

public class PedidoDAO {

	private FactoryConnection fc;
	private String tabela = "pedido";
	private String columnPk = "codigo_pedido ";
	private String columns = "forma_pagamento, " + "valor_total, " + "vendedor_cpf, " + "cliente_cpf ";

	public PedidoDAO() {
		this.fc = FactoryConnection.getInstance();
	}

	public List<Pedido> buscarTodos() throws ErroException {
		List<Pedido> retorno = new ArrayList<>();

		try {
			PreparedStatement stmt = fc.getConnection().prepareStatement("select * from " + tabela);

			ResultSet rs = stmt.executeQuery();

			while (rs.next()) {
				retorno.add(montaPedido(rs));
			}

			rs.close();
			stmt.close();
		} catch (SQLException e) {
			throw new ErroException("Falha ao buscar todos os pedidos!", e);
		}

		return retorno;
	}

	public Pedido buscar(Long codigoPedido) throws ErroException {
		Pedido retorno = new Pedido();

		String sql = "select * from " + tabela + " where " + columnPk + " = ?";

		try {
			PreparedStatement stmt = fc.getConnection().prepareStatement(sql);
			stmt.setLong(1, codigoPedido);

			ResultSet rs = stmt.executeQuery();

			if (rs.next()) {
				retorno = montaPedido(rs);
			} else {
				return null;
			}

			rs.close();
			stmt.close();
		} catch (SQLException e) {
			throw new ErroException("Falha ao buscar todos os Pedido!", e);
		}

		return retorno;
	}

	public Pedido insert(Pedido p) throws ErroException {
		String sql = "insert into " + tabela + "(" + columnPk + ", " + columns + ") " + "values (?,?,?,?,?)";

		p.setCodigoPedido(getNextPkPedido());

		PreparedStatement stmt;
		try {
			stmt = fc.getConnection().prepareStatement(sql);

			stmt.setLong(1, p.getCodigoPedido());
			stmt.setInt(2, p.getFormaPagamento().ordinal());
			stmt.setBigDecimal(3, p.getValorTotal());
			stmt.setString(4, p.getVendedor().getCPF());
			stmt.setString(5, p.getCliente().getCPF());

			stmt.execute();
			stmt.close();

			fc.getConnection().close();
		} catch (SQLException e) {
			throw new ErroException("Falha ao grava pedido! " + p, e);
		}

		// GRAVAR ITENS
		ItemPedidoDAO itemPedidoDAO = new ItemPedidoDAO();
		for (ItemPedido ip : p.getItens()) {
			ip.setCodigoPedido(p.getCodigoPedido());
			itemPedidoDAO.insert(ip);
		}

		return p;
	}

	public void delete(Long codigoPedido) throws ErroException {
		String sql = "delete from " + tabela + " where " + columnPk + " = ?";

		PreparedStatement stmt;

		ItemPedidoDAO itemPedidoDAO = new ItemPedidoDAO();
		itemPedidoDAO.deletePorPedido(codigoPedido);

		try {
			stmt = fc.getConnection().prepareStatement(sql);

			stmt.setLong(1, codigoPedido);

			stmt.execute();
			stmt.close();

			fc.getConnection().close();
		} catch (SQLException e) {
			throw new ErroException("Falha ao deletar pedido " + codigoPedido + "!", e);
		}
	}

	private Long getNextPkPedido() {
		Long retorno = null;

		try {
			String sql = "select max(" + columnPk + ") as last from " + tabela;

			PreparedStatement stmt = fc.getConnection().prepareStatement(sql);

			ResultSet rs = stmt.executeQuery();

			if (rs.next()) {
				retorno = rs.getLong("last");
			}

			rs.close();
			stmt.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}

		if (retorno == null || retorno.equals(0L)) {
			return 1L;
		}

		return retorno + 1L;
	}

	private Pedido montaPedido(ResultSet rs) throws SQLException, ErroException {
		Pedido retorno = new Pedido();

		retorno.setCodigoPedido(rs.getLong("codigo_pedido"));
		retorno.setFormaPagamento(EnumFormaPagamento.getFormaPagamento(rs.getInt("forma_pagamento")));
		retorno.setValorTotal(rs.getBigDecimal("valor_total"));

		ClienteDAO daoCliente = new ClienteDAO();
		retorno.setCliente(daoCliente.buscar(rs.getString("cliente_cpf")));

		VendedorDAO daoVendedor = new VendedorDAO();
		retorno.setVendedor(daoVendedor.buscar(rs.getString("vendedor_cpf")));

		// CARREGAR ITENS
		ItemPedidoDAO itemPedidoDAO = new ItemPedidoDAO();
		retorno.setItens(itemPedidoDAO.buscarPorPedido(retorno.getCodigoPedido()));

		return retorno;
	}
}
