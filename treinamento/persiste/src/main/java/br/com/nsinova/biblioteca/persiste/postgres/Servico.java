package br.com.nsinova.biblioteca.persiste.postgres;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import br.com.nsinova.biblioteca.persiste.IServico;
import builders.ServicoBuilder;

    public class Servico implements IServico{

    private final Connection conexao;

    public Servico(Connection conexao) {
        this.conexao = conexao;
    }

    private StringBuilder montarSQL(){
        StringBuilder textoSQL = new StringBuilder();
        textoSQL.append("SELECT id");
        textoSQL.append("from servico ");
        return textoSQL;
    }

     private br.com.nsinova.biblioteca.modelo.Servico montarItem(ResultSet resultSet) throws SQLException{
        Servico servico = ServicoBuilder.builder()
                .setId(resultSet.getString("id"))
                .build();
    }

    @Override
    public int manter(br.com.nsinova.biblioteca.modelo.Pessoa pessoa) throws SQLException {
        StringBuilder textoSQL = new StringBuilder();
        textoSQL.append("INSERT INTO servico ");
        textoSQL.append("(id)");
        textoSQL.append("VALUES(?) ");
        
        try(PreparedStatement comando = conexao.prepareStatement(textoSQL.toString())){
            comando.setInt(1, servico.getServico()).getId();
            return comando.executeUpdate();
        }
    }

}
