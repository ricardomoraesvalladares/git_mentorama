import java.util.ArrayList;
import java.util.List;

public class TarefaModuloSeis {

    public static void main(String[] args) {

        List alunos = new ArrayList<String>(){{
            add("Maria");
            add("João");
            add("Joaquim");
            add("Daniela");
            }};

        List presenca = new ArrayList<String>();
    
        for(int i=1; i <= 31; i++){
            if(i == 6 || i == 13 || i ==20 || i == 27){
                presenca.add("ausente");
            }
            else{
                presenca.add("presente");
            }
            
        }        
        
        for(int y=0; y < alunos.size(); y++){
            System.out.println(alunos.get(y));
            for(int i = 0; i < 31; i++){  
                System.out.println("Dia: " + (i+1) + " - " + presenca.get(i));
            }
        }

    }
    
}
