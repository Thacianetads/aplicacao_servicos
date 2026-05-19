
public class Veiculo{
    private String placa;
    private Pessoa proprietario;

    public Veiculo(){}

    public String getPlaca(){
        return this.placa;
    }

    public void setPlaca(String placa){
        this.placa = placa;
    }

    public Pessoa getProprietario(){
        return this.proprietario;
    }

    public void setProprietario(Pessoa proprietario){
        this.proprietario = proprietario;
    }
}