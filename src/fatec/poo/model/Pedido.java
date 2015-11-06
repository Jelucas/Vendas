package fatec.poo.model;

import java.util.ArrayList;

public class Pedido {
    private int numero;
    private String dataEmissaoPedido;
    private String dataPagto;
    private boolean status;
    private Cliente cliente;
    private Vendedor vendedor;
    private ArrayList<ItemPedido> itens;

    public Pedido(int numero, String dataEmissaoPedido, Cliente cliente, Vendedor vendedor) {
        this.numero = numero;
        this.dataEmissaoPedido = dataEmissaoPedido;
        this.cliente = cliente;
        this.vendedor = vendedor;
        
    }

    public void setDataPagto(String dataPagto) {
        this.dataPagto = dataPagto;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }

    public int getNumero() {
        return numero;
    }

    public String getDataEmissaoPedido() {
        return dataEmissaoPedido;
    }

    public String getDataPagto() {
        return dataPagto;
    }

    public boolean isStatus() {
        return status;
    }
    
    public void addItemPedido(ItemPedido item){
        itens.add(item);
        //A fazer
    }

}
