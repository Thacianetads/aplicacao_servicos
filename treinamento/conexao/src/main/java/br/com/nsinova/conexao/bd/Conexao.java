
package main.java.br.com.nsinova.conexao.bd;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Conexao {

    private Connection connection;
    private String provedor;

    /**
     *
     * @param provedor geralmente postgresql
     * @param banco
     * @param user
     * @param senha
     * @throws Exception
     */
    public Conexao(String provedor,
            String banco,
            String user,
            String senha) throws Exception {
        this.provedor = provedor;
        inicializar(banco, user, senha);
    }

    private void inicializar(String banco,
            String user,
            String senha) throws Exception {
        Class.forName("org.postgresql.Driver").newInstance();
        connection = DriverManager.getConnection(
                "jdbc:" + provedor + "://localhost:5432/" + banco + "?"
                + "user=" + user + "&password=" + senha);
    }

    public String getProvedor() {
        return provedor;
    }

    public Connection getConnection() {
        return connection;
    }

    public void reverterTransacao() throws Exception {
        if (connection != null && !connection.isClosed() && !connection.getAutoCommit()) {
            connection.rollback();
            connection.setAutoCommit(true);
        }
    }

    public void inicializarTransacao() throws Exception {
        connection.setAutoCommit(false);
    }

    public void confirmarTransacao() throws Exception {
        if (connection != null && !connection.isClosed()) {
            connection.commit();
            connection.setAutoCommit(true);
        }
    }

    public Boolean isClosed() throws Exception {
        if (connection != null) {
            return connection.isClosed();
        }
        return null;
    }

    public void close() throws Exception {
        connection.close();
    }
    
    public boolean emTransacao() throws SQLException{
        return !connection.getAutoCommit();
    }

}

