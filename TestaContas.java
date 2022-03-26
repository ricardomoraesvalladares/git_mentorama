import java.time.LocalDate;
import java.util.Date;
import java.util.List;
import java.util.Scanner;
import java.util.concurrent.TimeUnit;

public class TestaContas {

    public static final Banco banco = new Banco(1, 001, "Banco A");
    public static int index = 0;

    public static void main(String[] args) throws InterruptedException {

        Scanner valor = new Scanner(System.in);
        int opcao;

        do{
            imprimeMenu();
            opcao = valor.nextInt();
            menu(opcao);
        }
        while(opcao != 7);
    }

    public static void imprimeMenu(){
        System.out.println("--- BANCO MENTORAMA ---");
        System.out.println("MENU DE OPÇÕES:");
        System.out.println("1- Criar Conta");
        System.out.println("2- Sacar");
        System.out.println("3- Depositar");
        System.out.println("4- Criar Cliente");
        System.out.println("5- Transferir Valores");
        System.out.println("6- Mostrar montantes disponível Contas");
        System.out.println("7- Sair");
        System.out.println("Digite a opção desejada:");
        System.out.println("--------------");
    }

    private static Conta buscaConta(Scanner scanner) {
        System.out.println(" Digite nome cliente: ");
        String nomeCliente = scanner.next();
        Conta conta = banco.getContasBanco().get(nomeCliente);
        return conta;
    }

    public static void menu(int opcao) throws InterruptedException {

        Scanner scanner = new Scanner(System.in);

        switch(opcao){
            case 1:
                System.out.println(" Digite 1 para criar Conta Corrente: ");
                System.out.println(" Digite 2 para criar Conta Salário: ");
                System.out.println(" Digite 3 para criar Conta Poupança: ");
                Scanner opt = new Scanner(System.in);
                int val = opt.nextInt();
                if(val == 1){
                    System.out.println("Criar conta corrente");
                    System.out.println(" Digite o Saldo: ");
                    double saldo = opt.nextDouble();
                    System.out.println(" Digite o cheque especial: ");
                    double chequeEspecial = opt.nextDouble();
                    System.out.println(" Digite nome cliente: ");
                    String nomeCliente = opt.next();
                    Cliente cliente = new Cliente(nomeCliente);
                    Conta novacc = new ContaCorrente(index++, banco, saldo, chequeEspecial,cliente);
                    banco.setContasBanco(cliente.getNome(), novacc);
                    System.out.println("Conta Corrente :" + novacc);
                    TimeUnit.SECONDS.sleep(2);
                    break;
                }
                if(val == 2){
                    System.out.println("Criar conta Salário");
                    System.out.println(" Digite o Saldo: ");
                    double saldo = opt.nextDouble();
                    System.out.println(" Digite o número de limite de saques: ");
                    int limiteSaques = opt.nextInt();
                    System.out.println(" Digite nome cliente: ");
                    String nomeCliente = opt.next();
                    Cliente cliente = new Cliente(nomeCliente);
                    Conta novaContaSalario = new ContaSalario(index++, banco, saldo, limiteSaques, cliente);
                    banco.setContasBanco(cliente.getNome(), novaContaSalario);
                    System.out.println("Conta Salário :" + novaContaSalario);
                    TimeUnit.SECONDS.sleep(2);
                    break;
                }
                if(val == 3){
                    System.out.println("Criar conta Poupança");
                    System.out.println(" Digite o Saldo: ");
                    double saldo = opt.nextDouble();
                    int aniversario = LocalDate.now().getDayOfMonth();
                    System.out.println(" Digite nome cliente: ");
                    String nomeCliente = opt.next();
                    Cliente cliente = new Cliente(nomeCliente);
                    Conta novaContaPoupanca = new ContaPoupanca(index++, banco, saldo, aniversario, cliente);
                    banco.setContasBanco(cliente.getNome(), novaContaPoupanca);
                    System.out.println("Conta Poupança :" + novaContaPoupanca);
                    TimeUnit.SECONDS.sleep(2);
                    break;
                }

                break;
            case 2:
                Conta conta = buscaConta(scanner);
                System.out.println(" Digite o valor a sacar: ");
                double valor = scanner.nextDouble();
                if(conta.sacar(valor)){
                    System.out.println("Saque realizado com sucesso: " + valor);
                }
                else{
                    System.out.println("Não foi possível realizar saque!");
                }
                TimeUnit.SECONDS.sleep(2);
                break;
            case 3:
                Conta contaDeposito = buscaConta(scanner);
                System.out.println(" Digite o valor a depositar: ");
                double valorDeposito = scanner.nextDouble();
                contaDeposito.depositar(valorDeposito);
                System.out.println("Valor depositado com sucesso: " + valorDeposito);
                TimeUnit.SECONDS.sleep(2);
                break;
            case 4:
                System.out.println(" Digite nome cliente: ");
                String nomeDoCliente = scanner.next();
                Cliente novoCliente = new Cliente(nomeDoCliente);
                System.out.println(novoCliente);
                TimeUnit.SECONDS.sleep(2);
                break;
            case 5:
                System.out.println("Informe conta origem da transferencia.");
                Conta contaOrigem = buscaConta(scanner);
                System.out.println("Informe conta destino da transferencia.");
                Conta contaDestino = buscaConta(scanner);
                System.out.println("Digite o valor a ser transferido: ");
                double valorTransferencia = scanner.nextDouble();
                if(contaOrigem.transferir(contaDestino, valorTransferencia)){
                    System.out.println("Transferencia realizada com sucesso, valor: " + valorTransferencia);
                }
                else{
                    System.out.println("Não foi possível realizar transferencia!");
                }
                TimeUnit.SECONDS.sleep(2);
                break;
            case 6:
                System.out.println(banco.calculaValorTodasContasBanco());
                TimeUnit.SECONDS.sleep(2);
                break;
            case 7:
                System.out.println("O programa foi encerrado");
                break;

        }
    }

}
