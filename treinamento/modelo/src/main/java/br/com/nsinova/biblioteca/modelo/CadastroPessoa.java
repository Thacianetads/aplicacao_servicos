import java.util.ArrayList;

public class CadastroPessoa{
    private Pessoa pessoa;
    private ArrayList<Servico> servicos;

    public CadastroPessoa(){}

    public Pessoa getPessoa(){
        return this.pessoa;
    }

    public void setPessoa(Pessoa pessoa){
        this.pessoa = pessoa;
    }

    public ArrayList<Servico> getServicos(){
        return this.servicos;
    }

    public void setServico(ArrayList<Servico> servicos){
        this.servicos = servicos;
    }
}