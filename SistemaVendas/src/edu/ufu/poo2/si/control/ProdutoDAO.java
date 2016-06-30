package edu.ufu.poo2.si.control;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import edu.ufu.poo2.si.control.utils.FactoryConnection;
import edu.ufu.poo2.si.model.Produto;

public class ProdutoDAO {

	private FactoryConnection fc;
	private String tabela = "produto";
	private String columnPk = "codigo_produto ";
	private String columns = "nome_produto, " + "preco, " + "codigo_estoque ";

	public ProdutoDAO() {
		this.fc = FactoryConnection.getInstance();
	}

	public List<Produto> buscarTodos() {
		List<Produto> retorno = new ArrayList<>();

		try {
			PreparedStatement stmt = fc.getConnection().prepareStatement("select * from " + tabela);

			ResultSet rs = stmt.executeQuery();

			while (rs.next()) {
				retorno.add(montaProduto(rs));
			}

			rs.close();
			stmt.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return retorno;
	}

	public Produto buscar(Long codigoProduto) {
		Produto retorno = new Produto();

		String sql = "select * from " + tabela + " where " + columnPk + " = ?";

		try {
			PreparedStatement stmt = fc.getConnection().prepareStatement(sql);
			stmt.setLong(1, codigoProduto);

			ResultSet rs = stmt.executeQuery();

			if (rs.next()) {
				retorno = montaProduto(rs);
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

	public Produto insert(Produto p) {
		String sql = "insert into " + tabela + "(" + columnPk + ", " + columns + ") " + "values (?,?,?,?)";

		p.setCodigoProduto(getNextPkProduto());

		PreparedStatement stmt;
		try {
			EstoqueDAO estoqueDAO = new EstoqueDAO();
			p.setEstoque(estoqueDAO.insert(p.getEstoque()));
			
			stmt = fc.getConnection().prepareStatement(sql);

			stmt.setLong(1, p.getCodigoProduto());
			stmt.setString(2, p.getNomeProduto());
			stmt.setBigDecimal(3, p.getPreco());
			stmt.setLong(4, p.getEstoque().getCodigoEstoque());

			stmt.execute();
			stmt.close();

			fc.getConnection().close();
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return p;
	}

	public Produto update(Produto p) {
		String sql = "update " + tabela + " set nome_produto = ?, preco = ? where " + columnPk + " = ?";

		PreparedStatement stmt;

		try {
			stmt = fc.getConnection().prepareStatement(sql);

			stmt.setString(1, p.getNomeProduto());
			stmt.setBigDecimal(2, p.getPreco());
			stmt.setLong(3, p.getCodigoProduto());

			stmt.execute();
			stmt.close();
			
			// atualizando estoque
			EstoqueDAO estoqueDAO = new EstoqueDAO();
			estoqueDAO.update(p.getEstoque());

			fc.getConnection().close();
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return p;
	}

	public void delete(Long codigoProduto) {
		String sql = "delete from " + tabela + " where " + columnPk + " = ?";

		PreparedStatement stmt;
		Produto produto = buscar(codigoProduto);
		
		try {
			stmt = fc.getConnection().prepareStatement(sql);

			stmt.setLong(1, codigoProduto);

			stmt.execute();
			stmt.close();

			fc.getConnection().close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		if (produto != null) {
			EstoqueDAO estoqueDAO = new EstoqueDAO();
			estoqueDAO.delete(produto.getEstoque().getCodigoEstoque());
		}
	}

	private Long getNextPkProduto() {
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

	private Produto montaProduto(ResultSet rs) throws SQLException {
		EstoqueDAO estoqueDAO = new EstoqueDAO();
		
		Produto retorno = new Produto();

		retorno.setCodigoProduto(rs.getLong("codigo_Produto"));
		retorno.setNomeProduto(rs.getString("nome_produto"));
		retorno.setPreco(rs.getBigDecimal("preco"));
		retorno.setEstoque(estoqueDAO.buscar(rs.getLong("codigo_estoque")));
		// TODO carregar estoque

		return retorno;
	}
}
