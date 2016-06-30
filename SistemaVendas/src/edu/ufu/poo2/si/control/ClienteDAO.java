package edu.ufu.poo2.si.control;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import edu.ufu.poo2.si.control.utils.FactoryConnection;
import edu.ufu.poo2.si.model.Cliente;
import edu.ufu.poo2.si.util.exceptions.ErroException;

public class ClienteDAO {

	private FactoryConnection fc;
	private String tabela = "cliente";
	private String columns = "cpf, " + "nome_cliente";

	public ClienteDAO() {
		this.fc = FactoryConnection.getInstance();
	}

	public List<Cliente> buscarTodos() throws ErroException {
		List<Cliente> retorno = new ArrayList<>();

		try {
			PreparedStatement stmt = fc.getConnection().prepareStatement("select * from cliente");

			ResultSet rs = stmt.executeQuery();

			Cliente cliente;

			while (rs.next()) {
				cliente = new Cliente();
				cliente.setCPF(rs.getString("cpf"));
				cliente.setNome(rs.getString("nome_cliente"));

				retorno.add(cliente);
			}

			rs.close();
			stmt.close();
		} catch (SQLException e) {
			throw new ErroException("Falha ao buscar todos os clientes!", e);
		}

		return retorno;
	}

	public Cliente buscar(String cpf) throws ErroException {
		Cliente retorno = new Cliente();

		try {
			PreparedStatement stmt = fc.getConnection().prepareStatement("select * from cliente where cpf = ?");
			stmt.setString(1, cpf);

			ResultSet rs = stmt.executeQuery();

			if (rs.next()) {
				retorno.setCPF(rs.getString("cpf"));
				retorno.setNome(rs.getString("nome_cliente"));
			} else {
				return null;
			}

			rs.close();
			stmt.close();
		} catch (SQLException e) {
			throw new ErroException("Falha ao buscar o cliente " + cpf + " !", e);
		}

		return retorno;
	}

	public Cliente insert(Cliente c) throws ErroException {
		String sql = "insert into " + tabela + "(" + columns + ") " + "values (?,?)";

		PreparedStatement stmt;

		try {
			stmt = fc.getConnection().prepareStatement(sql);

			stmt.setString(1, c.getCPF());
			stmt.setString(2, c.getNome());

			stmt.execute();
			stmt.close();

			fc.getConnection().close();
		} catch (SQLException e) {
			throw new ErroException("Falha ao inserir cliente! " + c, e);
		}

		return c;
	}

	public Cliente update(Cliente c) throws ErroException {
		String sql = "update " + tabela + " set nome_cliente = ? where cpf = ?";

		PreparedStatement stmt;

		try {
			stmt = fc.getConnection().prepareStatement(sql);

			stmt.setString(1, c.getNome());
			stmt.setString(2, c.getCPF());

			stmt.execute();
			stmt.close();

			fc.getConnection().close();
		} catch (SQLException e) {
			throw new ErroException("Falha ao atualizar o cliente! " + c, e);
		}

		return c;
	}

	public void delete(String cpf) throws ErroException {
		String sql = "delete from " + tabela + " where cpf = ?";

		PreparedStatement stmt;

		try {
			stmt = fc.getConnection().prepareStatement(sql);

			stmt.setString(1, cpf);

			stmt.execute();
			stmt.close();

			fc.getConnection().close();
		} catch (SQLException e) {
			throw new ErroException("Falha ao deletar o cliente " + cpf + "!", e);
		}
	}
}
