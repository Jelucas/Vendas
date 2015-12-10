package fatec.poo.model;

public class ItemPedido {
    private int numeroItem;
    private int qtdeVendida;
    private Pedido pedido;
    private Produto produto;

    public ItemPedido(int numeroItem,int qtdeVendida) {
        this.numeroItem = numeroItem;
        this.qtdeVendida = qtdeVendida;
    }

    public void setPedido(Pedido pedido) {
        this.pedido = pedido;
    }

    public void setProduto(Produto p) {
        produto = p;
        produto.setQtdDisponivel(produto.getQtdDisponivel() - qtdeVendida);
    }

    public int getNumeroItem() {
        return numeroItem;
    }

    public int getQtdeVendida() {
        return qtdeVendida;
    }

    public Pedido getPedido() {
        return pedido;
    }

    public Produto getProduto() {
        return produto;
    }
    
}
