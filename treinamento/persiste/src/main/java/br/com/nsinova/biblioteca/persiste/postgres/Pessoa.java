package br.com.nsinova.biblioteca.persiste.postgres;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import br.com.nsinova.biblioteca.persiste.IPessoa;
import builders.PessoaBuilder;
import builders.ServicoBuilder;

public class Pessoa implements IPessoa{

    private final Connection conexao;

    public Servico(Connection conexao) {
        this.conexao = conexao;
    }

     private StringBuilder montarSQL(){
        StringBuilder textoSQL = new StringBuilder();
        textoSQL.append("SELECT id");
        textoSQL.append("from oficina.pessoa ");
        return textoSQL;
    }

    private br.com.nsinova.biblioteca.modelo.Pessoa montarItem(ResultSet resultSet) throws SQLException{
        Pessoa pessoa = PessoaBuilder.builder()
        .setId(resultSet.getInt("id"))
        .build();
    }

    private List<br.com.nsinova.biblioteca.modelo.Pessoa> montarLista(ResultSet resultSet) throws SQLException{
        List<br.com.nsinova.biblioteca.modelo.Pessoa> pesssoas = new ArrayList<>();
        while (resultSet.next()) {            
            pessoas.add(montarItem(resultSet));
        }
        return pessoas;
    }

    @Override
    public int manter(br.com.nsinova.biblioteca.modelo.Pessoa pessoa) throws SQLException {
        StringBuilder textoSQL = new StringBuilder();
        textoSQL.append("INSERT INTO oficina.pessoa ");
        textoSQL.append("(id)");
        textoSQL.append("VALUES(?) ");
        
        try(PreparedStatement comando = conexao.prepareStatement(textoSQL.toString())){
            comando.setInt(1, pessoa.getPessoa()).getId();
            return comando.executeUpdate();
        }
    }

     @Override
    public br.com.nsinova.biblioteca.modelo.Pessoa obter(int id) throws SQLException {
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
