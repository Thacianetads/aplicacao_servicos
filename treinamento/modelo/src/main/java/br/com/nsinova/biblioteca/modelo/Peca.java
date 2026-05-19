
import java.math.BigDecimal;

public class Peca{
    private String codigo;
    private BigDecimal valor;
    private String descricao;

    public Peca(){}

    public String getCodigoPeca(){
        return this.codigo;
    }

    public void setCodigoPeca(String codigo){
        this.codigo = codigo;
    }

    public BigDecimal getValorPeca(){
        return this.valor;
    }

    public void setValorPeca(BigDecimal valor){
        this.valor = valor;
    }

    public String getDescricaoPeca(){
        return this.descricao;
    }

    public void setDescricaoPeca(String descricao){
        this.descricao = descricao;
    }
}