public class ContaCorrente extends Conta implements Tarifavel{

    private double chequeEspecial;

    public ContaCorrente(int numero, Banco banco, double saldo, double chequeEspecial, Cliente cliente) {
        super(numero, banco, saldo, cliente);
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
        return this.saldo + this.chequeEspecial;
    }

    public double getChequeEspecial() {
        return chequeEspecial;
    }

    public void setChequeEspecial(double chequeEspecial) {
        this.chequeEspecial = chequeEspecial;
    }

    @Override
    public double aplicarTarifa(double valor) {
        return valor * 0.02;
    }
}
