package com.telas;

import com.cartola.classes.Jogador;

import java.io.FileNotFoundException;
import java.util.Scanner;

import com.cartola.classes.User;
import com.cartola.obj.MeuTime;

public abstract class TelaMenu {
    public static int printMenu(User usuario){
        int opc;
        Scanner scan = new Scanner(System.in);
        System.out.println("\t\t-----"+usuario.getTeam().getNome()+"-----");
        System.out.println("Pts rodada:"+usuario.getPtRodada()+"\tPts totais: "+usuario.getPtRodada());
        System.out.println("\n\t\t(1) Ver time");
        System.out.println("\t\t(2) Mudar time");
        System.out.println("\t\t(3) Mudar nome time");
        System.out.println("\t\t(4) Mudar capitao time");

        System.out.println("\n\t\t(5) Confirmar time");
        System.out.println("\n\t\t(0) Sair");

        System.out.print("\n\n\t\tDigite opcao: ");
        opc = scan.nextInt();

        return opc;
    }

    public static void tela(int modo, User usuario) throws FileNotFoundException {
        Scanner scan = new Scanner(System.in);
        MeuTime self = new MeuTime(usuario);

        boolean opSucesso;
        int id;
        switch (modo){
            case 0:
                break;
            case 1:
                self.showTime(1);
                scan.nextLine();
                break;
            case 2:
                opSucesso = TelaMudarTela.telaMudarTime(self);
                if(opSucesso){
                    System.out.print("Alteracao realizada!!!");
                    scan.nextLine();
                    System.out.println("\n\n\n\n\n\n\n\n\n\n");
                }else{
                    scan.nextLine();
                    System.out.println("Saldo insuficiente");
                    scan.nextLine();
                    System.out.println("\n\n\n\n\n\n\n\n\n\n");
                    TelaMenu.tela(modo, usuario);
                }
                break;
            case 3:
                String nome;
                System.out.println("Nome atual:\t"+usuario.getTeam().getNome());
                System.out.print("Novo nome: ");
                nome = scan.nextLine();
                self.changeTime(nome);

                System.out.print("Alteracao realizada!!!");
                scan.nextLine();
                System.out.println("\n\n\n\n\n\n\n\n\n\n");
                break;
            case 4:
                Jogador jgdrs[] = self.getVetorJogadores();
                self.showTime(2);
                System.out.print("\nNovo capitao (ID): ");
                id = scan.nextInt();

                for( int i=0;i<7;i++){
                    if(id==jgdrs[i].getId()){
                        self.changeCap(id);

                        scan.nextLine();
                        System.out.print("Alteracao realizada!!!");
                        scan.nextLine();
                        return;
                    }
                }
                scan.nextLine();
                System.out.println("Opcao invalida!!!");
                scan.nextLine();
                System.out.println("\n\n\n\n\n\n\n\n\n\n");
                TelaMenu.tela(modo, usuario);
                break;
            case 5:
                System.out.println("\n\n\n\n\n\n\n\n\n\n");
                System.out.print("Aperte enter para passar rodada... ");
                scan.nextLine();
                System.out.println("\n\n\n\n\n\n\n\n\n\n");
                break;
            default:
                System.out.println("Opcao invalida!!!");
                scan.nextLine();
                System.out.println("\n\n\n\n\n\n\n\n\n\n");
                modo = TelaMenu.printMenu(usuario);
                TelaMenu.tela(modo, usuario);
                break;
        }
    }

}
