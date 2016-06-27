package edu.ufu.poo2.si.control.utils;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class FactoryConnection {
	
	private static FactoryConnection thiz;
	private FactoryConnection() {}

	public static synchronized FactoryConnection getInstance() {
		if (thiz == null)
			thiz = new FactoryConnection();

		return thiz;
	}

	// Método de Conexão//
	public Connection getConnection() {
		Connection connection = null; // atributo do tipo Connection
		
		try {
			// Carregando o JDBC Driver padrão
			String driverName = "com.mysql.jdbc.Driver";

			Class.forName(driverName);

			// Configurando a nossa conexão com um banco de dados//
			String serverName = "localhost"; // caminho do servidor do BD
			String mydatabase = "mysql"; // nome do seu banco de dados
			String url = "jdbc:mysql://" + serverName + "/" + mydatabase;
			String username = "root"; // nome de um usuário de seu BD
			String password = "root"; // sua senha de acesso
			connection = DriverManager.getConnection(url, username, password);

			return connection;
		} catch (ClassNotFoundException e) { // Driver não encontrado
			System.out.println("O driver expecificado nao foi encontrado.");

			return null;
		} catch (SQLException e) {
			// Não conseguindo se conectar ao banco
			System.out.println("Nao foi possivel conectar ao Banco de Dados.");

			return null;
		}
	}

	public boolean fecharConexao(Connection connection) {
		try {
			connection.close();
			return true;
		} catch (SQLException e) {
			return false;
		}
	}

	public Connection reiniciarConexao(Connection connection) {
		fecharConexao(connection);
		return FactoryConnection.getInstance().getConnection();
	}
}