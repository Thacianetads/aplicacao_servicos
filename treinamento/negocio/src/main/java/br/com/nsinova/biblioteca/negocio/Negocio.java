package br.com.nsinova.biblioteca.negocio;
import br.com.nsinova.biblioteca.persiste.postgres.Servico;
import main.java.br.com.nsinova.conexao.bd.Conexao;

public class Negocio
{
    public static void main(String[] args) throws Exception
    {
        Conexao conexao = null;
        try
        {
            conexao = new Conexao("postgresql", "curso",
             "postgres", "root");
            
            Servico novoservico = new Servico();
        } catch(Exception ex){
            if(conexao != null && conexao.emTransacao()){
                conexao.reverterTransacao();
            }
            throw ex;
        }finally{
            if(conexao != null){
                conexao.close();
            }
        }
    }
}
