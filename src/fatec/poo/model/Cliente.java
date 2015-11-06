package fatec.poo.model;

import java.util.ArrayList;

public class Cliente extends Pessoa{
    private ArrayList<Pedido> pedidos;
    private double limiteCred;
    private double limiteDisp;
    
    public Cliente(String cpf, String nome,double limiteCred, double limiteDisp){
        super(cpf,nome);
        this.limiteCred = limiteCred;
        this.limiteDisp = limiteDisp;
        pedidos = new ArrayList<Pedido>();
    }
    
    public void addCompra(double compra){
        limiteDisp-= compra;
    }
    
    public ArrayList<Pedido> getPedidos(){
        return pedidos;
    }
    
    public void addPedidos(Pedido p){
        pedidos.add(p);
    }
}
