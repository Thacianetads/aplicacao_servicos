package br.com.nsinova.biblioteca.persiste;

import main.java.br.com.nsinova.conexao.bd.Conexao;

public abstract class DaoServico{
    public static IServico criarServico(Conexao conexao){
        if("postgresql".equalsIgnoreCase(conexao.getProvedor())){
            return new br.com.nsinova.biblioteca
.persiste.postgres.Servico(conexao.getConnection());
        }
        return null;
    }
}
