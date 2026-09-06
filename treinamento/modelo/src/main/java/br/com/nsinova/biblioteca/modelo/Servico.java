import java.math.BigDecimal;
import java.util.Date;

public class Servico{
    private int id;
    private String descricao;
    private BigDecimal num;
    private Date dt_inicio;
    private Date dt_final;
    private BigDecimal valor;
    private Veiculo veiculo;

    public Servico(){}

    public int getId(){
        return this.id;
    }

    public void setId(int id){
        this.id = id;
    }
    public String getDescricaoServico(){
        return this.descricao;
    }

    public void setDescricaoServico(String descricao){
        this.descricao = descricao;
    }

    public BigDecimal getNum(){
        return this.num;
    }

    public void setNum(BigDecimal num){
        this.num = num;
    }

    public Date getDtInicio(){
        return this.dt_inicio;
    }

    public void setDtInicio(Date dt_inicio){
        this.dt_inicio = dt_inicio;
    }

    public Date getDtFinal(){
        return this.dt_final;
    }

    public void setDtFinal(Date dt_final){
        this.dt_final = dt_final;
    }

    public BigDecimal getValorServico(){
        return this.valor;
    }

    public void setValorServico(BigDecimal valor){
        this.valor = valor;
    }

    public Veiculo getVeiculo(){
        return this.veiculo;
    }

    public void setVeiculo(Veiculo veiculo){
        this.veiculo = veiculo;
    }
}