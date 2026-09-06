package br.com.nsinova.biblioteca.persiste.postgres;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import br.com.nsinova.biblioteca.persiste.IVeiculo;
import builders.ServicoBuilder;
import builders.VeiculoBuilder;

public class Veiculo implements IVeiculo{
    private final Connection conexao;

    public Servico(Connection conexao) {
        this.conexao = conexao;
    }

    private StringBuilder montarSQL(){
        StringBuilder textoSQL = new StringBuilder();
        textoSQL.append("SELECT oficina.placa");
        textoSQL.append("from veiculo");
        return textoSQL;
    }

    private br.com.nsinova.biblioteca.modelo.Veiculo montarItem(ResultSet resultSet) throws SQLException{
        Veiculo veiculo = VeiculoBuilder.builder()
        .setPlaca(resultSet.getString("placa"))
        .build();
    }

     private List<br.com.nsinova.biblioteca.modelo.Veiculo> montarLista(ResultSet resultSet) throws SQLException{
        List<br.com.nsinova.biblioteca.modelo.Veiculo> veiculos = new ArrayList<>();
        while (resultSet.next()) {            
            veiculos.add(montarItem(resultSet));
        }
        return veiculos;
    }

     @Override
    public int manter(br.com.nsinova.biblioteca.modelo.Veiculo veiculo) throws SQLException {
        StringBuilder textoSQL = new StringBuilder();
        textoSQL.append("INSERT INTO oficina.veiculo ");
        textoSQL.append("(placa)");
        textoSQL.append("VALUES(?) ");
        
        try(PreparedStatement comando = conexao.prepareStatement(textoSQL.toString())){
            comando.setString(1, veiculo.getVeiculo()).getPlaca();
            return comando.executeUpdate();
        }
    }

     @Override
    public br.com.nsinova.biblioteca.modelo.Veiculo obter(String placa) throws SQLException {
        StringBuilder textoSQL = montarSQL();
        textoSQL.append("WHERE placa = ?");
        try(PreparedStatement comando = conexao.prepareStatement(textoSQL.toString())){
            comando.setString(1, placa);
            try(ResultSet result = comando.executeQuery()){
                return result.next() ? montarItem(result): null;
            }
        }
    }
}
