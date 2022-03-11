import java.time.LocalDate;

public class TestaContas {

    public static void main(String[] args) {

        ContaCorrente cc = new ContaCorrente(1, 001, "Banco A", 10.00, 20.00);
        System.out.println(cc.sacar(2.00));
        System.out.println(cc);

        System.out.println(cc.sacar(100.00));
        System.out.println(cc);

        cc.depositar(5.00);
        System.out.println(cc);

        System.out.println(cc.sacar(3.00));
        System.out.println(cc);

        ContaPoupanca cp = new ContaPoupanca(1, 001, "Banco A", 100.00, 10);

        System.out.println(cp.getSaldo());

        ContaPoupanca cp2 = new ContaPoupanca(2, 001, "Banco A", 100.00, 13);

        System.out.println(cp2.getSaldo());

    }
}
