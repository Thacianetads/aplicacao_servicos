import java.math.BigDecimal;

public class TipoServico{
    private String codigo;
    private String descricao;
    private BigDecimal valor;

    public TipoServico(){}

    public String getCodigo(){
        return this.codigo;
    }

    public void setCodigo(String codigo){
        this.codigo = codigo;
    }

    public String  getDescricao(){
        return this.descricao;
    }

    public void setDescricao(String descricao){
        this.descricao = descricao;
    }

    public BigDecimal getValor(){
        return this.valor;
    }

    public void setValor(BigDecimal valor){
        this.valor = valor;
    }
}