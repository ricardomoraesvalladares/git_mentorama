import java.util.Scanner;

class TarefaModuloDois {

    public static void main(String[] args) {
        
        Scanner valor = new Scanner(System.in);
        int opcao;

        do{
            imprimeMenu();
            opcao = valor.nextInt();
            menu(opcao);    
        }
        while(opcao != 3);
    }

    //Metodo para imprimir opções Menu
    public static void imprimeMenu(){
        System.out.println("--------------");
        System.out.println("MENU DE OPÇÕES:");
        System.out.println("1- Opção 1");
        System.out.println("2- Opção 2");
        System.out.println("3- Sair");
        System.out.println("Digite a opção desejada:");
        System.out.println("--------------");
    }

    //faz o processamento opcoes do menu
    public static void menu(int opcao){

        switch(opcao){
            case 1: 
                System.out.println("Você escolheu a primeira opção");
                break;
            case 2:
                System.out.println("Você escolheu a segunda opção");
                break;
            case 3:
                System.out.println("O programa foi encerrado");
                break;
        } 
    }
}