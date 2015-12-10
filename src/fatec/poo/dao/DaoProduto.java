package fatec.poo.dao;

import fatec.poo.model.Produto;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class DaoProduto {
    private Connection conn;

    public DaoProduto(Connection conn) {
        this.conn = conn;
    }
    
    public void inserir(Produto produto) {
        PreparedStatement ps = null;
        try {
            ps = conn.prepareStatement("INSERT INTO tbproduto(cod_produto, descricao, qtdDisponivel, precoUnit, estoqueMin) VALUES(?,?,?,?,?)");
            ps.setInt(1, produto.getCodigo());
            ps.setString(2, produto.getDescricao());
            ps.setInt(3, produto.getQtdDisponivel());
            ps.setDouble(4, produto.getPrecoUnit());
            ps.setInt(5, produto.getEstoqueMin());
            
            ps.execute();
        } catch (SQLException ex) {
            System.out.println(ex.toString());
        }
    }
    
    public void alterar(Produto produto) {
        PreparedStatement ps = null;
        try {
            ps = conn.prepareStatement("UPDATE tbproduto SET descricao = ?, qtdDisponivel = ?, precoUnit = ?, estoqueMin = ? where cod_produto = ?" );
            
            ps.setString(1, produto.getDescricao());
            ps.setInt(2, produto.getQtdDisponivel());
            ps.setDouble(3, produto.getPrecoUnit());
            ps.setInt(4, produto.getEstoqueMin());  
            ps.setInt(5, produto.getCodigo());
            
            ps.execute();
        } catch (SQLException ex) {
            System.out.println(ex.toString());
        }
    }
    
    public Produto consultar(int cod_produto) {
        Produto p = null;
        PreparedStatement ps = null;
        try {
            ps = conn.prepareStatement("SELECT * FROM tbproduto WHERE cod_produto = ?");
            ps.setInt(1, cod_produto);
            ResultSet rs = ps.executeQuery();
            
            if (rs.next() == true) {
                p = new Produto(cod_produto, rs.getString("descricao"));
                p.setEstoqueMin(rs.getInt("estoquemin"));
                p.setQtdDisponivel(rs.getInt("qtddisponivel"));
                p.setPrecoUnit(rs.getDouble("precounit"));
            }
        } catch (SQLException ex) {
            System.out.println(ex.toString());
        }
        return p;
    }
    
    public void excluir(Produto produto) {
        PreparedStatement ps = null;
        try {
            ps = conn.prepareStatement("DELETE FROM tbproduto WHERE cod_produto = ?");
            ps.setInt(1, produto.getCodigo());
            ps.execute();
        } catch (SQLException ex) {
            System.out.println(ex.toString());
        }
    }
}
