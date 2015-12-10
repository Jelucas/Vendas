package fatec.poo.dao;

import fatec.poo.model.Cliente;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class DaoCliente {
    private Connection conn;

    public DaoCliente(Connection conn) {
        this.conn = conn;
    }
    
    public void inserir(Cliente cliente) {
        PreparedStatement ps = null;
        try {
            ps = conn.prepareStatement("INSERT INTO tbcliente(cpf_cliente, nome_cliente, endereco_cliente, cidade_cliente, cep_cliente, uf_cliente, ddd_cliente, telefone_cliente, limitecred, limitedisp) VALUES(?,?,?,?,?,?,?,?,?,?)");
            ps.setString(1, cliente.getCpf());
            ps.setString(2, cliente.getNome());
            ps.setString(3, cliente.getEndereco());
            ps.setString(4, cliente.getCidade());
            ps.setString(5, cliente.getCep());
            ps.setString(6, cliente.getUf());
            ps.setString(7, cliente.getDdd());
            ps.setString(8, cliente.getTelefone());
            ps.setDouble(9, cliente.getLimiteCred());
            ps.setDouble(10, cliente.getLimiteDisp());
            
            ps.execute();
        } catch (SQLException ex) {
            System.out.println(ex.toString());
        }
    }
    
    public void alterar(Cliente cliente) {
        PreparedStatement ps = null;
        try {
            ps = conn.prepareStatement("UPDATE tbcliente SET nome_cliente = ?, endereco_cliente = ?, cidade_cliente = ?, cep_cliente = ?, uf_cliente = ?, ddd_cliente = ?, telefone_cliente = ?, limitecred = ?, limitedisp = ? WHERE cpf_cliente = ?");
            ps.setString(1, cliente.getNome());
            ps.setString(2, cliente.getEndereco());
            ps.setString(3, cliente.getCidade());
            ps.setString(4, cliente.getCep());
            ps.setString(5, cliente.getUf());
            ps.setString(6, cliente.getDdd());
            ps.setString(7, cliente.getTelefone());
            ps.setDouble(8, cliente.getLimiteCred());
            ps.setDouble(9, cliente.getLimiteDisp());
            ps.setString(10, cliente.getCpf());
            
            ps.execute();
        } catch (SQLException ex) {
            System.out.println(ex.toString());
        }
    }
    
    public Cliente consultar(String cpf) {
        Cliente c = null;
        PreparedStatement ps = null;
        try {
            ps = conn.prepareStatement("SELECT * FROM tbcliente WHERE cpf_cliente = ?");
            ps.setString(1, cpf);
            ResultSet rs = ps.executeQuery();
            
            if (rs.next() == true) {
                c = new Cliente(cpf, rs.getString("nome_cliente"), rs.getDouble("limitecred"));
                c.setEndereco(rs.getString("endereco_cliente"));
                c.setCidade(rs.getString("cidade_cliente"));
                c.setUf(rs.getString("uf_cliente"));
                c.setCep(rs.getString("cep_cliente"));
                c.setDdd(rs.getString("ddd_cliente"));
                c.setTelefone(rs.getString("telefone_cliente"));
            }
        } catch (SQLException ex) {
            System.out.println(ex.toString());
        }
        return c;
    }
    
    public void excluir(Cliente cliente) {
        PreparedStatement ps = null;
        try {
            ps = conn.prepareStatement("DELETE FROM tbcliente WHERE cpf_cliente = ?");
            ps.setString(1, cliente.getCpf());
            ps.execute();
        } catch (SQLException ex) {
            System.out.println(ex.toString());
        }
    }
}
