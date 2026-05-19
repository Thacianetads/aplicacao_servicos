package main.java.br.com.nsinova.biblioteca.negocio;

import br.com.nsinova.biblioteca.persiste.DaoServico;
import br.com.nsinova.biblioteca.persiste.IServico;
import main.java.br.com.nsinova.biblioteca.negocio.util.Manter;
import main.java.br.com.nsinova.conexao.bd.Conexao;

public class Servico{
    private IServico servicoDao;
    private Conexao conexao;
    
    public Servico(Conexao conexao){
        this.conexao = conexao;
    }

    public void inicializar(){
        servicoDao =  DaoServico.criarServico(conexao);
    }

    public int manter() throws Exception {
        try{
            return Manter.persist();
        }catch(Exception ex){
            throw new Exception("Erro ao manter Serviço!", ex);
        }
    }
}
