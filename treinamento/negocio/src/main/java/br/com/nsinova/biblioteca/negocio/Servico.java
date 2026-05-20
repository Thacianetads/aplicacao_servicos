package main.java.br.com.nsinova.biblioteca.negocio;
import br.com.nsinova.biblioteca.negocio.util.Manter;
import br.com.nsinova.biblioteca.persiste.DaoFabrica;
import br.com.nsinova.biblioteca.persiste.DaoServico;
import br.com.nsinova.biblioteca.persiste.IServico;
import main.java.br.com.nsinova.biblioteca.negocio.util.Manter;
import main.java.br.com.nsinova.conexao.bd.Conexao;
import java.sql.SQLException;
import java.util.List;

public class Servico{
    private IServico servicoDao;
    private Conexao conexao;
    
    public Servico(Conexao conexao){
        this.conexao = conexao;
        inicializar();
    }

    public void inicializar(){
        servicoDao =  DaoFabrica.criarServico(conexao);
    }

    public int manter(br.com.nsinova.biblioteca.modelo.Servico servico) throws Exception {
        try{
            return Manter.persist(servico, 
                (br.com.nsinova.biblioteca.modelo.Servico servico2) -> manter2(servico),
                conexao);
        }catch(Exception ex){
            throw new Exception("Erro ao manter Serviço!", ex);
        }
    }

    private int manter2(br.com.nsinova.biblioteca.modelo.Servico servico){
        try{
            if(servico.getVeiculo() == null || servico.getPlaca() == null){
                throw new RuntimeException("Não é possível registrar um serviço sem um veículo associado!");
            }


            if(servico.getDtInicio()== null){
                throw new RuntimeException("Data inicio obrigatória");
            }

            return servicoDao.manter(servico);
        }catch(Exception ex){
            throw new RuntimeException(ex);
        }
    }
}
