package br.com.nsinova.biblioteca.persiste.postgres;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
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
        textoSQL.append("from oficina.servico ");
        return textoSQL;
    }

     private br.com.nsinova.biblioteca.modelo.Servico montarItem(ResultSet resultSet) throws SQLException{
        Servico servico = ServicoBuilder.builder()
                .setId(resultSet.getInt("id"))
                .build();
    }

    private List<br.com.nsinova.biblioteca.modelo.Servico> montarLista(ResultSet resultSet) throws SQLException{
        List<br.com.nsinova.biblioteca.modelo.Servico> servicos = new ArrayList<>();
        while (resultSet.next()) {            
            servicos.add(montarItem(resultSet));
        }
        return servicos;
    }

    @Override
    public int manter(br.com.nsinova.biblioteca.modelo.Servico servico) throws SQLException {
        StringBuilder textoSQL = new StringBuilder();
        textoSQL.append("INSERT INTO oficina.servico ");
        textoSQL.append("(id)");
        textoSQL.append("VALUES(?) ");
        
        try(PreparedStatement comando = conexao.prepareStatement(textoSQL.toString())){
            comando.setInt(1, servico.getServico()).getId();
            return comando.executeUpdate();
        }
    }


    @Override
    public br.com.nsinova.biblioteca.modelo.Servico obter(int id) throws SQLException {
        StringBuilder textoSQL = montarSQL();
        textoSQL.append("WHERE id = ?");
        try(PreparedStatement comando = conexao.prepareStatement(textoSQL.toString())){
            comando.setInt(1, id);
            try(ResultSet result = comando.executeQuery()){
                return result.next() ? montarItem(result): null;
            }
        }
    }


}
