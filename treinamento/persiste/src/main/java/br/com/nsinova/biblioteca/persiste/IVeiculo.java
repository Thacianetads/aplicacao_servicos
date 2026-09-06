package br.com.nsinova.biblioteca.persiste;

import java.sql.SQLException;
import java.util.List;

import br.com.nsinova.biblioteca.persiste.postgres.Veiculo;

public interface IVeiculo{
    public int manter(Veiculo veiculo) throws SQLException;
    public Veiculo obterPlaca(String placa) throws SQLException;
    public List<Veiculo> obterLista() throws SQLException;
}