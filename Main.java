import java.util.Comparator;
import java.util.List;
import java.util.OptionalDouble;

public class Main{

    public static void main(String[] args) {
        Cliente c1 = new Cliente("Maria",true, "1234", 3);
        Cliente c2 = new Cliente("Joao",true, "1222", 1);
        Cliente c3 = new Cliente("Sonia",false, "4444", 2);
        Cliente c4 = new Cliente("Daniel",true, "1444", 10);
        Cliente c5 = new Cliente("Paulo",true, "0000", 8);
        Cliente c6 = new Cliente("Regiane",true, "88824", 10);
        Cliente c7 = new Cliente("Renata",true, "9234", 9);
        Cliente c8 = new Cliente("Manuel",false, "1234", 1);
        Cliente c9 = new Cliente("Soraia",true, "1264", 7);
        Cliente c10 = new Cliente("Joaquim",true, "1111", 5);

        List<Cliente> clientes = List.of(c1, c2, c3, c4, c5, c6, c7, c8, c9, c10);

        // Qual foi o cliente que fez mais compras?
        Comparator<Cliente> comparator = Comparator.comparing(Cliente::getCompras);
        List<Cliente> clienteMaisCompras = clientes.stream().max(comparator).stream().toList();
        clienteMaisCompras.forEach(c -> System.out.println(c.getNome()));

        //Qual foi o cliente que fez menos compras?

        List<Cliente> clientesMenosCompras = clientes.stream().
                min(Comparator.comparing(Cliente::getCompras)).stream().findAny().stream().toList();
        clientesMenosCompras.forEach(c -> System.out.println((c.getNome())));

        // Qual a média de compras dos clientes da lista?

        OptionalDouble media = clientes.stream().mapToDouble(Cliente::getCompras).average();
        System.out.println(media);

    }
}
