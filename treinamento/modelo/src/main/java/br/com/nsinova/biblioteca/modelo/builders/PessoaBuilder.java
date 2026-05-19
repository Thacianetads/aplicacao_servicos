package builders;
import java.util.Date;
import br.com.nsinova.biblioteca.persiste.postgres.Pessoa;

public class PessoaBuilder {
    private int id;
    private String nome;
    private String dt_nasc;
    private String cpf_cnpj;

    private PessoaBuilder(){}

    public static PessoaBuilder builder(){
        return new PessoaBuilder();
    }

    public PessoaBuilder setId(int id){
        this.id = id;
        return this;
    }

    public PessoaBuilder setNome(String nome){
        this.nome = nome;
        return this;
    }

    public PessoaBuilder setDtNasc(Date dt_nasc){
        this.dt_nasc = dt_nasc;
        return this;
    }

    public PessoaBuilder setCpfCnpj(String cpf_cnpj){
        this.cpf_cnpj = cpf_cnpj;
        return this;
    }

    public Pessoa build(){
        Pessoa pessoa = new Pessoa();
        pessoa.setId(id);
        pessoa.setNome(nome);
        pessoa.setDtNasc(dt_nasc);
        pessoa.setCpfCnpj(cpf_cnpj);
        return pessoa;
    }
    
}