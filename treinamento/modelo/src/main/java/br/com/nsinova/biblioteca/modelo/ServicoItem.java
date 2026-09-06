import java.math.BigDecimal;

public class ServicoItem{
    private Servico servico;
    private char tipo;
    private String codigo;
    private BigDecimal qtde;
    private String descricao;

    public ServicoItem(){}

    public Servico getServico(){
        return this.servico;
    }

    public void setServico(Servico servico){
        this.servico = servico;
    }

    public char getTipo(){
        return this.tipo;
    }

    public void setTipo(char tipo){
        this.tipo = tipo;
    }

    public String getCodigoItem(){
        return this.codigo;
    }

    public void setCodigoItem(String codigo){
        this.codigo = codigo;
    }

    public BigDecimal getQtde(){
        return this.qtde;
    }

    public void setQtde(BigDecimal qtde){
        this.qtde = qtde;
    }

    public String getDescricaoItem(){
        return this.descricao;
    }

    public void setDescricaoItem(String descricao){
        this.descricao = descricao;
    }
}