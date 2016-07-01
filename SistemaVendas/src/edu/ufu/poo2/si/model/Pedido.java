package edu.ufu.poo2.si.model;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import edu.ufu.poo2.si.util.enums.EnumFormaPagamento;

public class Pedido {
	private Long codigoPedido;

    private List<ItemPedido> itens;

    private Vendedor vendedor;

    private Cliente cliente;

    private EnumFormaPagamento formaPagamento;

    private BigDecimal valorTotal;

    public Long getCodigoPedido() {
        return codigoPedido;
    }

    public void setCodigoPedido(Long codigoPedido) {
        this.codigoPedido = codigoPedido;
    }

    public List<ItemPedido> getItens() {
        if (itens == null)
            itens = new ArrayList<ItemPedido>();

        return itens;
    }

    public void setItens(List<ItemPedido> itens) {
        this.itens = itens;
    }

    public Vendedor getVendedor() {
        return vendedor;
    }

    public void setVendedor(Vendedor vendedor) {
        this.vendedor = vendedor;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    public EnumFormaPagamento getFormaPagamento() {
        return formaPagamento;
    }

    public void setFormaPagamento(EnumFormaPagamento formaPagamento) {
        this.formaPagamento = formaPagamento;
    }

    public BigDecimal getValorTotal() {
        return valorTotal;
    }

    public void setValorTotal(BigDecimal valorTotal) {
        this.valorTotal = valorTotal;
    }
    
    @Override
	public String toString() {
		return codigoPedido.toString();
	}
}
