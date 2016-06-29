package edu.ufu.poo2.si.model;

import edu.ufu.poo2.si.util.EnumNivelVendedor;

public class Vendedor {

    private String Nome;

    private String CPF;

    private EnumNivelVendedor nivel;

    public String getNome() {
        return Nome;
    }

    public void setNome(String nome) {
        Nome = nome;
    }

    public String getCPF() {
        return CPF;
    }

    public void setCPF(String cPF) {
        CPF = cPF;
    }

    public EnumNivelVendedor getNivel() {
        return nivel;
    }

    public void setNivel(EnumNivelVendedor nivel) {
        this.nivel = nivel;
    }

    @Override
    public String toString() {
        return "Vendedor [Nome=" + Nome + ", CPF=" + CPF + ", nivel=" + nivel + "]";
    }


}
