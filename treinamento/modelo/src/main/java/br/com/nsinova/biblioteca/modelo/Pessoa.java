import java.util.Date;

public class Pessoa{
    private int id;
    private String nome;
    private Date dt_nasc;
    private String cpf_cnpj;
    
    public Pessoa(){}

    public int getId(){
        return this.id;
    }

    public void setId(int id){
        this.id = id;
    }

    public String getNome(){
        return this.nome;
    }

    public void setNome(String nome){
        this.nome = nome;
    }

    public Date getDtNasc(){
        return this.dt_nasc;
    }

    public void setDtNasc(Date dt_nasc){
        this.dt_nasc = dt_nasc;
    }

    public String getCpfCnpj(){
        return this.cpf_cnpj;
    }

    public void setCpfCnpj(String cpf_cnpj){
        this.cpf_cnpj = cpf_cnpj;
    }

}