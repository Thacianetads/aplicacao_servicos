package builders;

import br.com.nsinova.biblioteca.persiste.postgres.Pessoa;
import br.com.nsinova.biblioteca.persiste.postgres.Veiculo;

public class VeiculoBuilder {
    private String placa;
    private Pessoa proprietario;

    private VeiculoBuilder(){}

    public VeiculoBuilder builder(){
        return new VeiculoBuilder();
    }

    public VeiculoBuilder setPlaca(String placa){
        this.placa = placa;
        return this;
    }

    public VeiculoBuilder setProprietario(Pessoa proprietario){
        this.proprietario = proprietario;
        return this;
    }

    public Veiculo build(){
        Veiculo veiculo = new Veiculo();
        veiculo.setPlaca(placa);
        veiculo.setProprietario(proprietario);
        return veiculo;
        
    }
}
