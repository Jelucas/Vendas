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

    public Pedido(int numero, String dataEmissaoPedido) {
        this.numero = numero;
        this.dataEmissaoPedido = dataEmissaoPedido;
        itens = new ArrayList<ItemPedido>();
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
        this.cliente.addPedidos(this);
    }

    public void setVendedor(Vendedor vendedor) {
        this.vendedor = vendedor;
        this.vendedor.addPedidos(this);
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
        item.setPedido(this);
        this.cliente.addCompra(item.getProduto().getPrecoUnit() * item.getQtdeVendida());
    }
    
    public ArrayList<ItemPedido> getItens(){
        return itens;
    }

}
