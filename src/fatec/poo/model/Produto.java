package fatec.poo.model;

public class Produto {
    private int codigo;
    private String descricao;
    private int qtdDisponivel;
    private double precoUnit;
    private int estoqueMin;
    //private ItemPedido itemPedido;

    public Produto(int codigo, String descricao) {
        this.codigo = codigo;
        this.descricao = descricao;
    }

    public void setQtdDisponivel(int qtdDisponivel) {
        this.qtdDisponivel = qtdDisponivel;
    }

    public void setPrecoUnit(double precoUnit) {
        this.precoUnit = precoUnit;
    }

    public void setEstoqueMin(int estoqueMin) {
        this.estoqueMin = estoqueMin;
    }

    public int getCodigo() {
        return codigo;
    }

    public String getDescricao() {
        return descricao;
    }

    public int getQtdDisponivel() {
        return qtdDisponivel;
    }

    public double getPrecoUnit() {
        return precoUnit;
    }

    public int getEstoqueMin() {
        return estoqueMin;
    }
/*    public ItemPedido getItemPedido() {
        return itemPedido;
    }
    
    public void setItemPedido(ItemPedido i){
        itemPedido = i;
    }
*/
}
