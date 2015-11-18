package fatec.poo.model;

public class ItemPedido {
    private int numeroItem;
    private int qtdeVendida;
    private Pedido pedido;
    private Produto produto;

    public ItemPedido(int qtdeVendida) {
        numeroItem = pedido.getItens().size() + 1; //Pega a quatidade de itens do ArrayList e soma 1
        //VERIFICAR caso seja excluido um item no meio ou ínicio do pedido.
        this.qtdeVendida = qtdeVendida;
    }

    public void setPedido(Pedido pedido) {
        this.pedido = pedido;
    }

    public void setProduto(Produto p) {
        produto = p;
        produto.setQtdDisponivel(produto.getQtdDisponivel() - qtdeVendida); //Retirada do "estoque"
        //E SE NÃO TIVER NO ESTOQUE???
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
