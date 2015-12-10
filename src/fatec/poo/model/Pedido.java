package fatec.poo.model;

import java.util.ArrayList;

public class Pedido {
    private int numero;
    private String dataEmissaoPedido;
    private String dataPagto;
    private int status;
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

    public Cliente getCliente() {
        return cliente;
    }

    public Vendedor getVendedor() {
        return vendedor;
    }

    public void setVendedor(Vendedor vendedor) {
        this.vendedor = vendedor;
        this.vendedor.addPedidos(this);
    }
    
    public void setDataPagto(String dataPagto) {
        this.dataPagto = dataPagto;
    }

    public void setStatus(int status) {
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

    public int isStatus() {
        return status;
    }
    
    public void addItemPedido(ItemPedido item){
        System.out.println("0.5");
        itens.add(item);
        System.out.println("1");
        item.setPedido(this);
        System.out.println("2");
        cliente.addCompra(item.getProduto().getPrecoUnit() * item.getQtdeVendida());
        System.out.println("3");
    }
    
    public ArrayList<ItemPedido> getItens(){
        return itens;
    }

}
