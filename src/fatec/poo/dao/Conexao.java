package fatec.poo.dao;

import java.sql.Connection;
import java.sql.DriverManager;

public class Conexao {

    private String connectionString;
    private String driver;
    private String usuario;
    private String senha;
    private Connection connection = null;

    public Conexao(String usuario, String senha) {
        this.usuario = usuario;
        this.senha = senha;
    }

    public void setConnectionString(String connectionString) {
        this.connectionString = connectionString;
    }

    public void setDriver(String driver) {
        this.driver = driver;
    }

    public Connection conectar() {
        if (connection == null) {
            try {
                Class.forName(driver);

                connection = DriverManager.getConnection(connectionString, usuario, senha);
                System.out.println("Conexão OK");
            } catch (Exception ex) {
                System.out.println("Falha na Conexão");
                System.out.println(ex.toString() + ex.getMessage());
            }
        }
        return connection;
    }

    public void fecharConexao() {
        if (connection != null) {
            try {
                connection.close();
            } catch (Exception ex) {
                System.out.println(ex.toString());
            }
        }
    }
}