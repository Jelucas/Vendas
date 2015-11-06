package fatec.poo.model;

import java.util.ArrayList;

public class Vendedor {
    private ArrayList<Pedido> pedidos;
    
   public Vendedor(){
       pedidos = new ArrayList<Pedido>();
    }
    
    public ArrayList<Pedido> getPedidos(){
        return pedidos;
    }
    
    public void addPedidos(Pedido p){
        pedidos.add(p);
    }
}