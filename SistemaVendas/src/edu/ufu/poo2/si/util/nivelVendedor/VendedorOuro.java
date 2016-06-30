package edu.ufu.poo2.si.util.nivelVendedor;

import edu.ufu.poo2.si.api.NivelVendedor;

public class VendedorOuro implements NivelVendedor {
    
    public nivelVendedor Sucessor;

    public void realizarVenda() {
        
        if(p.getDesconto() < 10){
             p.setvalor(p.getValor() * p.getDesconto()/100);
             p.toString();
        }else if(){
           System.out.println("O desconto não é válido pois possui valor muito alto!");
        }
    }
    public void setSucessor(NivelVendedor nivelvendedor){
        this.Sucessor = nivelvendedor;
    }
    
    public NivelVendedor getSucessor(){
        return Sucessor;
    }

}
