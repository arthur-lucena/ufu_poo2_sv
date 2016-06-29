package edu.ufu.poo2.si.model;

import edu.ufu.poo2.si.util.EnumFormaPagamento;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

public class Pedido {

    private Long codigoPedido;

    private List<ItemVenda> itens;

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

    public List<ItemVenda> getItens() {
        if (itens == null)
            return new ArrayList<>();

        return itens;
    }

    public void setItens(List<ItemVenda> itens) {
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
}
