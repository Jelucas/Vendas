package fatec.poo.dao;

import fatec.poo.model.Pedido;
import fatec.poo.model.Produto;
import fatec.poo.model.ItemPedido;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class DaoItemPedido {

    private Connection conn;

    public DaoItemPedido(Connection conn) {
        this.conn = conn;
    }

//    public ItemPedido consultar(Integer numPed, Integer cod_produto) {
//        DaoPedido daoPedido = new DaoPedido(conn);
//        DaoProduto daoProduto = new DaoProduto(conn);
//        Pedido ped = null;
//        Produto p = null;
//        PreparedStatement ps = null;
//        try {
//            ps = conn.prepareStatement("SELECT * FROM tbitempedido WHERE numero_pedido = ? AND cod_produto = ?");
//            ps.setInt(1, numPed);
//            ResultSet rs = ps.executeQuery();
//
//            if (rs.next() == true) {
//                ped = new Pedido(numPed, rs.getString("dataemissaopedido"));
//                ped.setDataPagto(rs.getString("datapagto"));
//                ped.setStatus(rs.getInt("status"));
//                
//                cli = daoCliente.consultar(rs.getString("cpf_cliente"));
//                ped.setCliente(cli);
//                
//                vend = daoVendedor.consultar(rs.getString("cpf_vendedor"));
//                ped.setVendedor(vend);
//            }
//        } catch (SQLException ex) {
//            System.out.println(ex.toString());
//        }
//        return ped;
//    }

    public void inserir(ItemPedido item) {
        PreparedStatement ps = null;
        try {
            ps = conn.prepareStatement("INSERT INTO TBITEMPEDIDO(NUMEROITEM, QTDEVENDIDA, NUMERO_PEDIDO, COD_PRODUTO) VALUES(?,?,?,?)");
            ps.setInt(1, item.getNumeroItem());
            ps.setInt(2, item.getQtdeVendida());
            ps.setInt(4, item.getPedido().getNumero());
            ps.setInt(4, item.getProduto().getCodigo());
            
            ps.execute();
        } catch (SQLException ex) {
            System.out.println(ex.toString());
        }

    }
}
