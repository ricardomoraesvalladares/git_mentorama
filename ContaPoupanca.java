import java.time.LocalDate;

public class ContaPoupanca extends Conta{

    private int aniversario;
    private double taxaJuros;

    public ContaPoupanca(int numero, int agencia, String banco, double saldo, int aniversario) {
        super(numero, agencia, banco, saldo);
        this.aniversario = aniversario;
        this.taxaJuros = 0.02;
    }

    @Override
    public boolean sacar(double valor) {

        if(valor <= saldo){
            this.saldo -= valor;
            return true;
        }
        return false;
    }

    @Override
    public void depositar(double valor) {
        this.saldo += valor;
    }

    @Override
    public double getSaldo() {
        int data = LocalDate.now().getDayOfMonth();
        if( data >= this.aniversario){
            return this.saldo += this.saldo * taxaJuros;
        }
        else{
            return this.saldo;
        }
    }

    @Override
    public String toString() {
        return "ContaPoupanca{" +
                "saldo=" + saldo +
                ", aniversario=" + aniversario +
                ", taxaJuros=" + taxaJuros +
                '}';
    }
}
