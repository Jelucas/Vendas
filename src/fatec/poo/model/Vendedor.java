package fatec.poo.model;

import java.util.ArrayList;

public class Vendedor extends Pessoa {
    private double salarioBase;
    private double comissao;
    private ArrayList<Pedido> pedidos;

    public Vendedor(String cpf, String nome, double salarioBase) {
        super(cpf, nome);
        this.salarioBase = salarioBase;
        pedidos = new ArrayList<Pedido>();
    }
    
   
    
    public ArrayList<Pedido> getPedidos(){
        return pedidos;
    }
    
    public void addPedidos(Pedido p){
        pedidos.add(p);
    }

    public double getSalarioBase() {
        return salarioBase;
    }

    public void setSalarioBase(double salarioBase) {
        this.salarioBase = salarioBase;
    }

    public double getComissao() {
        return comissao;
    }

    public void setComissao(double comissao) {
        this.comissao = comissao/100;
    }
    
}