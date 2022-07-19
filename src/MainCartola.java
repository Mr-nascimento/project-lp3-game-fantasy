import com.cartola.classes.User;
import com.cartola.obj.Rodada;
import com.telas.Menu;
import com.telas.TelaRod;

import java.io.FileNotFoundException;
import java.io.IOException;

public class MainCartola {
    public static void main(String[] args) throws IOException {
        int opc=1;
        User usuario = new User();
        Rodada rod;
        while(opc!=0) {
            opc = Menu.printMenu(usuario);
            Menu.tela(opc, usuario);
            if(opc==5){
                int countJgs = TelaRod.printTela();
                if(countJgs!=0){
                    int idsJgs[] = TelaRod.guardaIds(countJgs);
                    rod = new Rodada(idsJgs);
                }
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
