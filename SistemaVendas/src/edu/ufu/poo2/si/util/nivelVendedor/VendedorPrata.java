package edu.ufu.poo2.si.util.nivelVendedor;

import edu.ufu.poo2.si.api.NivelVendedor;

public class VendedorPrata implements NivelVendedor {
    
    public nivelVendedor Sucessor;

    public void realizarVenda(ItemPedido p) {
            
        if(p.getDesconto() < 5){
             p.setvalor(p.getValor() * p.getDesconto()/100);
              p.toString();
        }
        else if(this.getSucessor() != Null){
            this.getSucessor().realizarVenda(ItemPedido p);
        }
    }

    public void setSucessor(NivelVendedor nivelvendedor){
        this.Sucessor = nivelvendedor;
    }
    
    public NivelVendedor getSucessor(){
        return Sucessor;
    }
    

}
