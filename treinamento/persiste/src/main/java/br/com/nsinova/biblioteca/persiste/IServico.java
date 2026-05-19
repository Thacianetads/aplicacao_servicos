package br.com.nsinova.biblioteca.persiste;

import java.sql.SQLException;
import java.util.List;

import br.com.nsinova.biblioteca.persiste.postgres.Servico;

public interface IServico{
    public int manter(Servico servico) throws SQLException;
    public Servico obterPorId(int id) throws SQLException;
    public List<Servico> obterLista() throws SQLException;
}