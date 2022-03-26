import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Banco {

    private int id;
    private int agencia;
    private String nomeBanco;
    private Map<String, Conta> contasBanco = new HashMap<String, Conta>();

    public Banco(int id, int agencia, String nomeBanco) {
        this.id = id;
        this.agencia = agencia;
        this.nomeBanco = nomeBanco;
    }

    public Map<String, Conta> getContasBanco() {
        return contasBanco;
    }

    public void setContasBanco(String cliente, Conta conta) {
        this.contasBanco.put(cliente, conta);
    }

    public int getId() {
        return id;
    }

    public int getAgencia() {
        return agencia;
    }

    public void setAgencia(int agencia) {
        this.agencia = agencia;
    }

    public String getNomeBanco() {
        return nomeBanco;
    }

    public void setNomeBanco(String nomeBanco) {
        this.nomeBanco = nomeBanco;
    }

    public double calculaValorTodasContasBanco(){
        double total = 0;
        Conta conta;
        for(String i : contasBanco.keySet()){
            conta = contasBanco.get(i);
            total += conta.saldo;
        }
        return total;
    }
}
