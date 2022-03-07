
public class Carro{

    private int numeroDePortas;
    private String cor;
    private String numeroDoChassi;
    private int anoFabricacao;
    private String combustivel;

    public Carro(int numeroDePortas, String numeroDoChassi, int anoFabricacao, String combustivel) {
        this.numeroDePortas = numeroDePortas;
        this.numeroDoChassi = numeroDoChassi;
        this.anoFabricacao = anoFabricacao;
        this.combustivel = combustivel;
    }

    public String getCombustivel() {
        return combustivel;
    }

    public int getAnoFabricacao() {
        return anoFabricacao;
    }

    public String getNumeroDoChassi() {
        return numeroDoChassi;
    }

    public String getCor() {
        return cor;
    }

    public void setCor(String cor) {
        this.cor = cor;
    }

    public int getNumeroDePortas() {
        return numeroDePortas;
    }
    
}


