import com.cartola.classes.User;
import com.cartola.obj.Rodada;
import com.telas.TelaMenu;
import com.telas.TelaRod;

import java.io.IOException;

public class MainCartola {
    public static void main(String[] args) throws IOException {
        int opc=1;
        User usuario = new User();
        Rodada rod;
        while(opc!=0) {
            opc = TelaMenu.printMenu(usuario);
            TelaMenu.tela(opc, usuario);
            if(opc==5){
                int countJgs = TelaRod.printTela();
                if(countJgs!=0){
                    int idsJgs[] = TelaRod.guardaIds(countJgs);
                    rod = new Rodada(idsJgs);
                    usuario.update();
                }
            }
        }

    }


}
