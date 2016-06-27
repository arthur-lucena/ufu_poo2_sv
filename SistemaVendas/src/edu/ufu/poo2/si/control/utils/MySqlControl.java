package edu.ufu.poo2.si.control.utils;

import java.sql.Connection;

public class MySqlControl {
	public static void  main(String[] args) {
		FactoryConnection factory = FactoryConnection.getInstance();
		
		Connection connection = factory.getConnection();
		
		factory.fecharConexao(connection);
	}
}