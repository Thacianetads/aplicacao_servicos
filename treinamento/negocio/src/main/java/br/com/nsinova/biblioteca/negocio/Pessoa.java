import br.com.nsinova.biblioteca.persiste.DaoFabrica;
import br.com.nsinova.biblioteca.persiste.IPessoa;

public class Pessoa{
    private IPessoa pessoaDao;
    private Conexao conexao;

    public Pessoa(Conexao conexao){
        this.conexao = conexao;
        inicializar();
    }

    public void inicializar(){
        pessoaDao =  DaoFabrica.criarPessoa(conexao);
    }

    public int manter(br.com.nsinova.biblioteca.modelo.Pessoa pessoa) throws Exception {
        try{
            return Manter.persist(pessoa, 
                (br.com.nsinova.biblioteca.modelo.Pessoa pessoa2) -> manter2(pessoa),
                conexao);
        }catch(Exception ex){
            throw new Exception("Erro ao manter pessoa!", ex);
        }
    }

       private int manter2(br.com.nsinova.biblioteca.modelo.Pessoa pessoa){
        try{
            if(pessoa.getNome() == null || pessoa.getDtNasc() == null){
                throw new RuntimeException("Dados incompletos");
            }

            return pessoaDao.manter(pessoa);
        }catch(Exception ex){
            throw new RuntimeException(ex);
        }
    }


}

