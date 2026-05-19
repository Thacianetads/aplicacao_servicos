package br.com.nsinova.biblioteca.persiste;

import java.sql.SQLException;
import java.util.List;

import br.com.nsinova.biblioteca.persiste.postgres.Pessoa;

public interface IPessoa{
    public int manter(Pessoa pessoa) throws SQLException;
    public Pessoa obterPorId(int id) throws SQLException;
    public List<Pessoa> obterLista() throws SQLException;
}
