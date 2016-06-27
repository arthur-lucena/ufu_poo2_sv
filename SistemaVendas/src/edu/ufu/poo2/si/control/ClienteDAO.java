package edu.ufu.poo2.si.control;

import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import edu.ufu.poo2.si.control.utils.FactoryConnection;
import edu.ufu.poo2.si.model.Cliente;

public class ClienteDAO {

	private FactoryConnection fc;
	private String tabela = "contatos";
	private String columns = "cpf, nome";

	public ClienteDAO(FactoryConnection fc) {
		this.fc = fc;
	}

	public List<Cliente> buscarClientes(Cliente c) {
		List<Cliente> retorno = new ArrayList<Cliente>();

		return retorno;
	}

	public Cliente buscar(Cliente c) {
		Cliente retorno = new Cliente();

		return retorno;
	}

	public Cliente insert(Cliente c) {
		Cliente retorno = new Cliente();

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
			e.printStackTrace();
		}

		return retorno;
	}

	public Cliente update(Cliente c) {
		Cliente retorno = new Cliente();

		return retorno;
	}

	public Cliente delete(Cliente c) {
		Cliente retorno = new Cliente();

		return retorno;
	}
}
