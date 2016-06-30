package edu.ufu.poo2.si.control;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import edu.ufu.poo2.si.control.utils.FactoryConnection;
import edu.ufu.poo2.si.model.Estoque;
import edu.ufu.poo2.si.util.enums.EnumEstadoEstoque;
import edu.ufu.poo2.si.util.exceptions.ErroException;

public class EstoqueDAO {

	private FactoryConnection fc;
	private String tabela = "estoque";
	private String columnPk = "codigo_estoque ";
	private String columns = "qtd, " + "qtd_reservada, " + "estado_estoque ";

	public EstoqueDAO() {
		this.fc = FactoryConnection.getInstance();
	}

	public List<Estoque> buscarTodos() throws ErroException {
		List<Estoque> retorno = new ArrayList<>();

		try {
			PreparedStatement stmt = fc.getConnection().prepareStatement("select * from " + tabela);

			ResultSet rs = stmt.executeQuery();

			while (rs.next()) {
				retorno.add(montaEstoque(rs));
			}

			rs.close();
			stmt.close();
		} catch (SQLException e) {
			throw new ErroException("Falha ao buscar todos os estoque!", e);
		}

		return retorno;
	}

	public Estoque buscar(Long codigoEstoque) throws ErroException {
		Estoque retorno = new Estoque();

		String sql = "select * from " + tabela + " where " + columnPk + " = ?";

		try {
			PreparedStatement stmt = fc.getConnection().prepareStatement(sql);
			stmt.setLong(1, codigoEstoque);

			ResultSet rs = stmt.executeQuery();

			if (rs.next()) {
				retorno = montaEstoque(rs);
			} else {
				return null;
			}

			rs.close();
			stmt.close();
		} catch (SQLException e) {
			throw new ErroException("Falha ao buscar o cliente" + codigoEstoque + "!", e);
		}

		return retorno;
	}

	public Estoque insert(Estoque p) throws ErroException {
		String sql = "insert into " + tabela + "(" + columnPk + ", " + columns + ") " + "values (?,?,?,?)";

		p.setCodigoEstoque(getNextPkEstoque());

		PreparedStatement stmt;
		try {
			stmt = fc.getConnection().prepareStatement(sql);

			stmt.setLong(1, p.getCodigoEstoque());
			stmt.setInt(2, p.getQuantidade());
			stmt.setInt(3, p.getQuantidadeReservada());
			stmt.setInt(4, p.getEstadoEstoque().ordinal());

			stmt.execute();
			stmt.close();

			fc.getConnection().close();
		} catch (SQLException e) {
			throw new ErroException("Falha ao inserir estoque! " + p, e);
		}

		return p;
	}

	public Estoque update(Estoque p) throws ErroException {
		String sql = "update " + tabela + " set qtd = ?, qtd_reserva = ?, estado_estoque where " + columnPk + " = ?";

		PreparedStatement stmt;

		try {
			stmt = fc.getConnection().prepareStatement(sql);

			stmt.setInt(1, p.getQuantidade());
			stmt.setInt(2, p.getQuantidadeReservada());
			stmt.setInt(3, p.getEstadoEstoque().ordinal());

			stmt.setLong(4, p.getCodigoEstoque());

			stmt.execute();
			stmt.close();

			fc.getConnection().close();
		} catch (SQLException e) {
			throw new ErroException("Falha ao atualizar o estoque! " + p, e);
		}

		return p;
	}

	public void delete(Long codigoEstoque) throws ErroException {
		String sql = "delete from " + tabela + " where " + columnPk + " = ?";

		PreparedStatement stmt;

		try {
			stmt = fc.getConnection().prepareStatement(sql);

			stmt.setLong(1, codigoEstoque);

			stmt.execute();
			stmt.close();

			fc.getConnection().close();
		} catch (SQLException e) {
			throw new ErroException("Falha ao deletar estoque" + codigoEstoque + "! ", e);
		}
	}

	private Long getNextPkEstoque() {
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

	private Estoque montaEstoque(ResultSet rs) throws SQLException {
		Estoque retorno = new Estoque();

		retorno.setCodigoEstoque(rs.getLong("codigo_estoque"));
		retorno.setQuantidade(rs.getInt("qtd"));
		retorno.setQuantidadeReservada(rs.getInt("qtd_reservada"));
		retorno.setEstadoEstoque(EnumEstadoEstoque.getEstadoEstoque(rs.getInt("estado_estoque")));

		return retorno;
	}
}
