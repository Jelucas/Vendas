package fatec.poo.dao;

import fatec.poo.model.Vendedor;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class DaoVendedor {
    private Connection conn;

    public DaoVendedor(Connection conn) {
        this.conn = conn;
    }
    
    public void inserir(Vendedor vendedor) {
        PreparedStatement ps = null;
        try {
            ps = conn.prepareStatement("INSERT INTO tbvendedor(cpf_vendedor, nome_vendedor, endereco_vendedor, cidade_vendedor, cep_vendedor, uf_vendedor, ddd_vendedor, telefone_vendedor, salarioBase, comissao) VALUES(?,?,?,?,?,?,?,?,?,?)");
            ps.setString(1, vendedor.getCpf());
            ps.setString(2, vendedor.getNome());
            ps.setString(3, vendedor.getEndereco());
            ps.setString(4, vendedor.getCidade());
            ps.setString(5, vendedor.getCep());
            ps.setString(6, vendedor.getUf());
            ps.setString(7, vendedor.getDdd());
            ps.setString(8, vendedor.getTelefone());
            ps.setDouble(9, vendedor.getSalarioBase());
            ps.setDouble(10, vendedor.getComissao());
            
            ps.execute();
        } catch (SQLException ex) {
            System.out.println(ex.toString());
        }
    }
    
    public void alterar(Vendedor vendedor) {
        PreparedStatement ps = null;
        try {
            ps = conn.prepareStatement("UPDATE tbvendedor SET nome_vendedor = ?, endereco_vendedor = ?, cidade_vendedor = ?, cep_vendedor = ?, uf_vendedor = ?, ddd_vendedor = ?, telefone_vendedor = ?, salarioBase = ?, comissao = ? WHERE cpf_vendedor = ?");
            ps.setString(1, vendedor.getNome());
            ps.setString(2, vendedor.getEndereco());
            ps.setString(3, vendedor.getCidade());
            ps.setString(4, vendedor.getCep());
            ps.setString(5, vendedor.getUf());
            ps.setString(6, vendedor.getDdd());
            ps.setString(7, vendedor.getTelefone());
            ps.setDouble(8, vendedor.getSalarioBase());
            ps.setDouble(9, vendedor.getComissao());
            ps.setString(10, vendedor.getCpf());
            
            ps.execute();
        } catch (SQLException ex) {
            System.out.println(ex.toString());
        }
    }
    
    public void excluir(Vendedor vendedor) {
        PreparedStatement ps = null;
        try {
            ps = conn.prepareStatement("DELETE FROM tbvendedor WHERE cpf_vendedor = ?");
            ps.setString(1, vendedor.getCpf());
            ps.execute();
        } catch (SQLException ex) {
            System.out.println(ex.toString());
        }
    }
    
    public Vendedor consultar(String cpf) {
        Vendedor v = null;
        PreparedStatement ps = null;
        try {
            ps = conn.prepareStatement("SELECT * FROM tbvendedor WHERE cpf_vendedor = ?");
            ps.setString(1, cpf);
            ResultSet rs = ps.executeQuery();
            
            if (rs.next() == true) {
                v = new Vendedor(cpf, rs.getString("nome_vendedor"), rs.getDouble("salarioBase"));
                v.setEndereco(rs.getString("endereco_vendedor"));
                v.setCidade(rs.getString("cidade_vendedor"));
                v.setUf(rs.getString("uf_vendedor"));
                v.setCep(rs.getString("cep_vendedor"));
                v.setDdd(rs.getString("ddd_vendedor"));
                v.setTelefone(rs.getString("telefone_vendedor"));
                v.setComissao(rs.getDouble("comissao"));
            }
        } catch (SQLException ex) {
            System.out.println(ex.toString());
        }
        return v;
    }
}
