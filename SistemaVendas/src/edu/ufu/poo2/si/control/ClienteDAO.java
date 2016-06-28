package edu.ufu.poo2.si.control;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import edu.ufu.poo2.si.control.utils.FactoryConnection;
import edu.ufu.poo2.si.model.Cliente;

public class ClienteDAO {

	private FactoryConnection fc;
	private String tabela = "cliente";
	private String columns = "cpf, "
			+ "nome_cliente";

	public ClienteDAO() {
		this.fc = FactoryConnection.getInstance();
	}

	public List<Cliente> buscarTodos() {
		List<Cliente> retorno = new ArrayList<Cliente>();
        
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
			e.printStackTrace();
		}
		
		return retorno;
	}

	public Cliente buscar(Cliente c) {
		Cliente retorno = new Cliente();

        try {
        	PreparedStatement stmt = fc.getConnection().prepareStatement("select * from cliente where cpf = ?");
        	stmt.setString(1, c.getCPF());
        	
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
			e.printStackTrace();
		}
		
		return retorno;
	}

	public Cliente insert(Cliente c) {
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

		return c;
	}

	public Cliente update(Cliente c) {
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
			e.printStackTrace();
		}

		return c;
	}

	public void delete(Cliente c) {
		String sql = "delete from " + tabela + " where cpf = ?";

		PreparedStatement stmt;

		try {
			stmt = fc.getConnection().prepareStatement(sql);
	
			stmt.setString(1, c.getCPF());

			stmt.execute();
			stmt.close();

			fc.getConnection().close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
}
