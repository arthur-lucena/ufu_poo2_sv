package edu.ufu.poo2.si.control;

import edu.ufu.poo2.si.model.Cliente;
import edu.ufu.poo2.si.model.Vendedor;
import edu.ufu.poo2.si.util.EnumNivelVendedor;

public class Teste {

	public static void main(String[] args) {
		testeVendedor();
	}

	public static void testeCliente() {
		ClienteDAO dao = new ClienteDAO();
		
		Cliente c1 = new Cliente();
		c1.setCPF("09052671680");
		c1.setNome("Arthur Lucena");
		
		Cliente c2 = new Cliente();
		c2.setCPF("09052671681");
		c2.setNome("Arthur Lucena");
			
		dao.delete(c1.getCPF());
		dao.insert(c1);
		
		dao.delete(c2.getCPF());
		dao.insert(c2);
		
		c1.setNome("Art Luc");
		dao.update(c1);
		
		Cliente c = dao.buscar(c1.getCPF());
		System.out.println(c);
		
		for (Cliente ce : dao.buscarTodos()) {
			System.out.println(ce);
		}
	}
	
	public static void testeVendedor() {
		VendedorDAO dao = new VendedorDAO();
		
		Vendedor v1 = new Vendedor();
		v1.setCPF("09052671680");
		v1.setNome("Arthur Lucena");
		v1.setNivel(EnumNivelVendedor.Ouro);
		
		Vendedor v2 = new Vendedor();
		v2.setCPF("09052671681");
		v2.setNome("Arthur Lucena");
		v2.setNivel(EnumNivelVendedor.Prata);
			
		dao.delete(v1.getCPF());
		dao.insert(v1);
		
		dao.delete(v2.getCPF());
		dao.insert(v2);
		
		v1.setNome("Art Luc");
		dao.update(v1);
		
		Vendedor c = dao.buscar(v1.getCPF());
		System.out.println(c);
		
		for (Vendedor ce : dao.buscarTodos()) {
			System.out.println(ce);
		}
	}
}
