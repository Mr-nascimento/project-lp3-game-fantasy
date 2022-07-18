import com.cartola.classes.User;
import com.telas.Menu;

import java.io.FileNotFoundException;

public class MainCartola {
    public static void main(String[] args) throws FileNotFoundException {
        int opc=1;
        User usuario = new User();
        while(opc!=0) {
            opc = Menu.printMenu(usuario);
            Menu.tela(opc, usuario);
            if(opc==5){

            }
        }
        //List<com.cartola.classes.Atacante> atacantes;
        //com.dados.AtacanteDados dadosAtc = new com.dados.AtacanteDados();
        //atacantes = dadosAtc.getAtacantes();

       // for(com.cartola.classes.Atacante atc:atacantes){
        //    System.out.println(atc.imprimeJogador());
        //}

    }


}
