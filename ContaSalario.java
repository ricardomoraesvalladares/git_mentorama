public class ContaSalario extends Conta{

    private int limiteSaques;

    public ContaSalario(int numero, int agencia, String banco, double saldo, int limiteSaques) {
        super(numero, agencia, banco, saldo);
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
    public String toString() {
        return "ContaSalario{" +
                "saldo=" + saldo +
                ", limiteSaques=" + limiteSaques +
                '}';
    }
}
