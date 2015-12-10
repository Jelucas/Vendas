package fatec.poo.model;

import java.util.ArrayList;

public class Cliente extends Pessoa{
    private ArrayList<Pedido> pedidos;
    private double limiteCred;
    private double limiteDisp;
    
    public Cliente(String cpf, String nome,double limiteCred){
        super(cpf,nome);
        this.limiteCred = limiteCred;
        this.limiteDisp = limiteCred;
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

    public void setLimiteCred(double limiteCred) {
        this.limiteCred = limiteCred;
    }

    public double getLimiteCred() {
        return limiteCred;
    }

    public double getLimiteDisp() {
        return limiteDisp;
    }
    
}
