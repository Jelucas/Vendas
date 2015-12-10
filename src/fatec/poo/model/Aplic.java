/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package fatec.poo.model;

/**
 *
 * @author Jefferson
 */
public class Aplic {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        
        Cliente cli1 = new Cliente("123456789","Clientela", 1000);
        Vendedor vend1 = new Vendedor("123456789","VENDO", 1000);
        Produto prod1 = new Produto(100, "Farinha");
        Pedido ped1 = new Pedido(1,"01/02/03");
        ItemPedido item1 = new ItemPedido(1,10);
        item1.setProduto(prod1);
        
        ped1.setCliente(cli1);
        ped1.setVendedor(vend1);
        ped1.addItemPedido(item1);
        
    }
    
}
