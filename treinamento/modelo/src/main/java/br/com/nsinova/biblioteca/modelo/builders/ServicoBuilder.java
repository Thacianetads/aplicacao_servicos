package builders;
import java.math.BigDecimal;
import java.util.Date;

import br.com.nsinova.biblioteca.persiste.postgres.Servico;
import br.com.nsinova.biblioteca.persiste.postgres.Veiculo;

public class ServicoBuilder {
    private int id;
    private BigDecimal valor;
    private String descricao;
    private Date dtinicio;
    private Date dtfinal;
    private Veiculo veiculo;
    private BigDecimal num;

    private ServicoBuilder(){}

    public static ServicoBuilder builder(){
        return new ServicoBuilder();
    }

    public ServicoBuilder setId(int id){
        this.id = id;
        return this;
    }

    public ServicoBuilder setNum(BigDecimal num){
        this.num = num;
        return this;
    }

    public ServicoBuilder setValor(BigDecimal valor){
        this.valor = valor;
        return this;
    }

    public ServicoBuilder setDescricao(String descricao){
        this.descricao = descricao;
        return this;
    }

    public ServicoBuilder setDtInicio(Date dtinicio){
        this.dtinicio = dtinicio;
        return this;
    }

    public ServicoBuilder setDtFinal(Date dtfinal){
        this.dtfinal = dtfinal;
        return this;
    }

    public ServicoBuilder setVeiculo(Veiculo veiculo){
        this.veiculo = veiculo;
        return this;
    }

    public Servico build() {
        Servico servico = new Servico();
        servico.setId(id);
        servico.setNum(num);
        servico.setValor(valor);
        servico.setDescricao(descricao);
        servico.setDtInicio(dtinicio);
        servico.setDtFinal(dtfinal);
        servico.setVeiculo(veiculo);
        return servico;
    }
}
