package edu.ufu.poo2.si.control;

import edu.ufu.poo2.si.control.utils.FactoryConnection;
import edu.ufu.poo2.si.model.Pedido;
import edu.ufu.poo2.si.model.Vendedor;
import edu.ufu.poo2.si.util.EnumFormaPagamento;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class PedidoDAO {

    private FactoryConnection fc;
    private String tabela = "pedido";
    private String columnPk = "codigo_pedido ";
    private String columns = "forma_pagamento, "
            + "valor_total, "
            + "vendedor_cpf, "
            + "cliente_cpf ";

    public PedidoDAO() {
        this.fc = FactoryConnection.getInstance();
    }

    public List<Pedido> buscarTodos() {
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
            e.printStackTrace();
        }

        return retorno;
    }

    public Pedido buscar(Long codigoPedido) {
        Pedido retorno = new Pedido();

        try {
            PreparedStatement stmt = fc.getConnection().prepareStatement("select * from " + tabela + " where " + columnPk + " = ?");
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
            e.printStackTrace();
        }

        return retorno;
    }

    public Pedido insert(Pedido p) {
        String sql = "insert into "
                + tabela
                + "(" + columnPk
                + ", " + columns
                + ") " + "values (?,?,?,?,?)";

        p.setCodigoPedido(getNextPkPedido());

        PreparedStatement stmt;
        try {
            stmt = fc.getConnection().prepareStatement(sql);

            stmt.setLong(1, p.getCodigoPedido());
            stmt.setInt(2, p.getFormaPagamento().ordinal());
            stmt.setBigDecimal(3, p.getValorTotal());
            stmt.setString(4, p.getVendedor().getCPF());
            stmt.setString(5, p.getCliente().getCPF());

            //TODO GRAVAR ITENS

            stmt.execute();
            stmt.close();

            fc.getConnection().close();
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return p;
    }

    public Vendedor update(Vendedor v) {
//		String sql = "update " + tabela + " set nome_cliente = ?, nivel = ? where cpf = ?";
//
//		PreparedStatement stmt;
//
//		try {
//			stmt = fc.getConnection().prepareStatement(sql);
//
//			stmt.setString(1, v.getNome());
//			stmt.setInt(2, v.getNivel().ordinal());
//			stmt.setString(3, v.getCPF());
//			
//			stmt.execute();
//			stmt.close();
//
//			fc.getConnection().close();
//		} catch (SQLException e) {
//			e.printStackTrace();
//		}
//
        return v;
    }

    public void delete(Long codigoPedido) {
        String sql = "delete from " + tabela + " where codigo_pedido = ?";

        PreparedStatement stmt;

        try {
            stmt = fc.getConnection().prepareStatement(sql);

            stmt.setLong(1, codigoPedido);

            stmt.execute();
            stmt.close();

            fc.getConnection().close();
        } catch (SQLException e) {
            e.printStackTrace();
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

    private Pedido montaPedido(ResultSet rs) throws SQLException {
        Pedido retorno = new Pedido();

        retorno.setCodigoPedido(rs.getLong("codigo_pedido"));
        retorno.setFormaPagamento(EnumFormaPagamento.getFormaPagamento(rs.getInt("forma_pagamento")));
        retorno.setValorTotal(rs.getBigDecimal("nivel"));

        ClienteDAO daoCliente = new ClienteDAO();
        retorno.setCliente(daoCliente.buscar(rs.getString("cliente_cpf")));

        VendedorDAO daoVendedor = new VendedorDAO();
        retorno.setVendedor(daoVendedor.buscar(rs.getString("vendedor_cpf")));

        //TODO CARREGAR ITENS

        return retorno;
    }
}
