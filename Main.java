import java.util.Comparator;
import java.util.List;
import java.util.OptionalDouble;
import java.util.stream.Collectors;


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

        // Qual foi o cliente que fez mais compras? primeira ocorrencia
        Comparator<Cliente> comparator = Comparator.comparing(Cliente::getCompras);
        Cliente clienteMaisCompras = clientes.stream().max(comparator).get();
        System.out.println("Maior comprador primeira ocorrencia: " + clienteMaisCompras.getNome());

        // Qual foi o cliente que fez mais compras? lista
        List<Cliente> maiores = clientes.stream().
                filter(cliente -> cliente.getCompras() == clienteMaisCompras.getCompras())
                .collect(Collectors.toList());
        System.out.println("Lista Maiores compradores:");
        maiores.forEach(cliente -> System.out.println(cliente.getNome() + "   "));

        //Qual foi o cliente que fez menos compras? primeira ocorrencia
        Cliente clienteMenosCompras = clientes.stream().
                min(Comparator.comparing(Cliente::getCompras)).get();
        System.out.println("Cliente menos compras primeira ocorrencia: " + clienteMenosCompras.getNome());


        //Qual foi o cliente que fez menos compras? Lista
        List<Cliente> menores = clientes.stream().
                filter(cliente -> cliente.getCompras() == clienteMenosCompras.getCompras())
                .collect(Collectors.toList());
        System.out.println("Lista quem fez menos compras:");
        menores.forEach(cliente -> System.out.println(cliente.getNome() + "   "));

        // Qual a média de compras dos clientes da lista?
        OptionalDouble media = clientes.stream().mapToDouble(Cliente::getCompras).average();
        System.out.println("Média de compras Clientes: " + media.getAsDouble());

    }
}
