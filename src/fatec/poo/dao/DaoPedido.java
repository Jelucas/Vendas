package fatec.poo.dao;

import fatec.poo.model.Cliente;
import fatec.poo.model.Pedido;
import fatec.poo.model.Vendedor;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class DaoPedido {

    private Connection conn;

    public DaoPedido(Connection conn) {
        this.conn = conn;
    }

    public Pedido consultar(Integer numPed) {
        DaoCliente daoCliente = new DaoCliente(conn);
        DaoVendedor daoVendedor = new DaoVendedor(conn);
        Pedido ped = null;
        Cliente cli = null;
        Vendedor vend = null;
        PreparedStatement ps = null;
        try {
            ps = conn.prepareStatement("SELECT * FROM tbpedido WHERE numero_pedido = ?");
            ps.setInt(1, numPed);
            ResultSet rs = ps.executeQuery();

            if (rs.next() == true) {
                ped = new Pedido(numPed, rs.getString("dataemissaopedido"));
                ped.setDataPagto(rs.getString("datapagto"));
                ped.setStatus(rs.getInt("status"));
                
                cli = daoCliente.consultar(rs.getString("cpf_cliente"));
                ped.setCliente(cli);
                
                vend = daoVendedor.consultar(rs.getString("cpf_vendedor"));
                ped.setVendedor(vend);
            }
        } catch (SQLException ex) {
            System.out.println(ex.toString());
        }
        return ped;
    }

    public void inserir(Pedido pedido) {
        PreparedStatement ps = null;
        try {
            ps = conn.prepareStatement("INSERT INTO TBPEDIDO(NUMERO_PEDIDO, DATAEMISSAOPEDIDO, DATAPAGTO, STATUS, CPF_CLIENTE, CPF_VENDEDOR) VALUES(?,?,?,?,?,?) ");
            ps.setInt(1, pedido.getNumero());
            ps.setString(2, pedido.getDataEmissaoPedido());
            ps.setString(3, pedido.getDataPagto());
            ps.setInt(4, pedido.isStatus());
            ps.setString(5, pedido.getCliente().getCpf());
            ps.setString(6, pedido.getVendedor().getCpf());
            
            ps.execute();
        } catch (SQLException ex) {
            System.out.println(ex.toString());
        }

    }
}
