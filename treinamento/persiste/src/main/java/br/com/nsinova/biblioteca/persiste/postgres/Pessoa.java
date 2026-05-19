package br.com.nsinova.biblioteca.persiste.postgres;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import br.com.nsinova.biblioteca.persiste.IPessoa;
import builders.PessoaBuilderBuilder;
import builders.ServicoBuilder;

public class Pessoa implements IPessoa{

    private final Connection conexao;

    public Servico(Connection conexao) {
        this.conexao = conexao;
    }

     private StringBuilder montarSQL(){
        StringBuilder textoSQL = new StringBuilder();
        extoSQL.append("SELECT id");
        textoSQL.append("from pessoa ");
        return textoSQL;
    }

    private br.com.nsinova.biblioteca.modelo.Pessoa montarItem(ResultSet resultSet) throws SQLException{
        Pessoa pessoa = PessoaBuilder.builder()
        .setId(resultSet.getString("id"))
        .build();
    }

    @Override
    public int manter(br.com.nsinova.biblioteca.modelo.Pessoa pessoa) throws SQLException {
        StringBuilder textoSQL = new StringBuilder();
        textoSQL.append("INSERT INTO pessoa ");
        textoSQL.append("(id)");
        textoSQL.append("VALUES(?) ");
        
        try(PreparedStatement comando = conexao.prepareStatement(textoSQL.toString())){
            comando.setInt(1, servico.getPessoa()).getId();
            return comando.executeUpdate();
        }
    }
}