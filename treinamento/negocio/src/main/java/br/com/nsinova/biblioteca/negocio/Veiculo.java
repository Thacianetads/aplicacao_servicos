import br.com.nsinova.biblioteca.persiste.DaoFabrica;
import br.com.nsinova.biblioteca.persiste.IVeiculo;
import main.java.br.com.nsinova.conexao.bd.Conexao;
import java.sql.SQLException;
import java.util.List;

public class Veiculo{
    private IVeiculo veiculoDao;
    private Conexao conexao;

    public Veiculo(Conexao conexao){
        this.conexao = conexao;
        inicializar();
    }

    public void inicializar(){
        veiculoDao =  DaoFabrica.criarVeiculo(conexao);
    }

    public int manter(br.com.nsinova.biblioteca.modelo.Veiculo veiculo) throws Exception {
        try{
            return Manter.persist(veiculo, 
                (br.com.nsinova.biblioteca.modelo.Veiculo veiculo2) -> manter2(veiculo),
                conexao);
        }catch(Exception ex){
            throw new Exception("Erro ao manter veiculo!", ex);
        }
    }

     private int manter2(br.com.nsinova.biblioteca.modelo.Veiculo veiculo){
        try{
            if(veiculo.getProprietario() == null){
                throw new RuntimeException("Veiculo não possui proprietario");
            }

            return veiculoDao.manter(veiculo);
        }catch(Exception ex){
            throw new RuntimeException(ex);
        }
    }
}