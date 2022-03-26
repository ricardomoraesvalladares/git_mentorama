public abstract class Conta {

    private int numero;
    private Banco banco;
    protected double saldo;
    protected Cliente cliente;


    public Conta(int numero, Banco banco, double saldo, Cliente cliente) {
        this.numero = numero;
        this.banco = banco;
        this.saldo = saldo;
        this.cliente = cliente;
    }

    public abstract boolean sacar(double valor);

    public abstract void depositar(double valor);

    public abstract boolean transferir(Conta contaDestino, double valor);

    public int getNumero() {
        return numero;
    }

    public void setNumero(int numero) {
        this.numero = numero;
    }

    public Banco getBanco() {
        return banco;
    }

    public void setBanco(Banco banco) {
        this.banco = banco;
    }

    public abstract double getSaldo();

    @Override
    public String toString() {
        return "criada com sucesso: {" +
                "numero= " + numero +
                ", banco= " + banco.getNomeBanco() +
                ", saldo= " + saldo +
                ", cliente= " + cliente.getNome() +
                '}';
    }
}
