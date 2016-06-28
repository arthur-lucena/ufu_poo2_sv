package edu.ufu.poo2.si.control;

import edu.ufu.poo2.si.model.Cliente;

public class Teste {

	public static void main(String[] args) {
		ClienteDAO dao = new ClienteDAO();
		
		Cliente c1 = new Cliente();
		c1.setCPF("09052671680");
		c1.setNome("Arthur Lucena");
		
		Cliente c2 = new Cliente();
		c2.setCPF("09052671681");
		c2.setNome("Arthur Lucena");
			
		dao.delete(c1);
		dao.insert(c1);
		
		dao.delete(c2);
		dao.insert(c2);
		
		c1.setNome("Art Luc");
		dao.update(c1);
		
		Cliente c = dao.buscar(c1);
		System.out.println(c);
		
		for (Cliente ce : dao.buscarTodos()) {
			System.out.println(ce);
		}
	}

}
