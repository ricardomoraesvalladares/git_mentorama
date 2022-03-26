import java.time.LocalDate;

public class ContaPoupanca extends Conta{

    private int aniversario;
    private double taxaJuros;

    public ContaPoupanca(int numero, Banco banco, double saldo, int aniversario, Cliente cliente) {
        super(numero, banco, saldo, cliente);
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
    public boolean transferir(Conta contaDestino, double valor) {
        if(contaDestino.getSaldo() >= valor){
            this.saldo += valor;
            contaDestino.saldo -= valor;
            return true;
        }
        return false;
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
}
