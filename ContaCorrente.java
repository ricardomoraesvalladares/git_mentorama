public class ContaCorrente extends Conta{

    private double chequeEspecial;

    public ContaCorrente(int numero, int agencia, String banco, double saldo, double chequeEspecial) {
        super(numero, agencia, banco, saldo);
        this.chequeEspecial = chequeEspecial;
    }

    @Override
    public boolean sacar(double valor) {
        if(valor <= this.saldo + chequeEspecial){
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
        return this.saldo + this.chequeEspecial;
    }

    public double getChequeEspecial() {
        return chequeEspecial;
    }

    public void setChequeEspecial(double chequeEspecial) {
        this.chequeEspecial = chequeEspecial;
    }

    @Override
    public String toString() {
        return "ContaCorrente{" +
                "saldo=" + saldo +
                ", chequeEspecial=" + chequeEspecial +
                '}';
    }
}
