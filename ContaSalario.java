public class ContaSalario extends Conta implements Tarifavel{

    private int limiteSaques;

    public ContaSalario(int numero, Banco banco, double saldo, int limiteSaques, Cliente cliente) {
        super(numero, banco, saldo, cliente);
        this.limiteSaques = limiteSaques;
    }

    @Override
    public boolean sacar(double valor) {

        if (this.limiteSaques > 0 && valor <= this.saldo){
           this.saldo -= valor;
           this.limiteSaques --;
           return true;
        }
        else
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
            this.saldo -= aplicarTarifa(this.saldo);
            contaDestino.saldo -= valor;
            return true;
        }
        return false;
    }

    @Override
    public double getSaldo() {
        return this.saldo;
    }

    public int getLimiteSaques() {
        return limiteSaques;
    }

    public void setLimiteSaques(int limiteSaques) {
        this.limiteSaques = limiteSaques;
    }

    @Override
    public double aplicarTarifa(double valor) {
        return valor * 0.01;
    }
}
