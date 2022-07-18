package com.telas;

import com.cartola.classes.Atacante;
import com.cartola.classes.Jogador;
import com.cartola.classes.Levantador;
import com.cartola.classes.Libero;
import com.dados.AtacanteDados;
import com.dados.LevantadorDados;
import com.dados.LiberoDados;

import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import com.cartola.classes.User;
import com.cartola.obj.MeuTime;

public abstract class Menu{
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
                opSucesso = telaMudarTime(self);
                if(opSucesso){
                    System.out.print("Alteracao realizada!!!");
                    scan.nextLine();
                    System.out.println("\n\n\n\n\n\n\n\n\n\n");
                }else{
                    scan.nextLine();
                    System.out.println("Saldo insuficiente");
                    scan.nextLine();
                    System.out.println("\n\n\n\n\n\n\n\n\n\n");
                    Menu.tela(modo, usuario);
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
                self.showTime(1);
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
                Menu.tela(modo, usuario);
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
                modo = Menu.printMenu(usuario);
                Menu.tela(modo, usuario);
                break;
        }
    }

    public static boolean telaMudarTime(MeuTime team) throws FileNotFoundException {
        Scanner scan = new Scanner(System.in);
        AtacanteDados dadosAtc = new AtacanteDados();
        LevantadorDados dadosLev = new LevantadorDados();
        LiberoDados dadosLib = new LiberoDados();

        List<Atacante> atac = new ArrayList<>();
        List<Libero> lib = dadosLib.getLiberos();
        List<Levantador> levnt = dadosLev.getLevantadores();

        Atacante atc;
        Libero lbr;
        Levantador lvnt;
        int opc, idnew, idold;
        boolean cont=false, result=true, modo=false;

        team.showTime(2);

        System.out.println("\n\t\t(1) Ponteiro");
        System.out.println("\t\t(2) Central");
        System.out.println("\t\t(3) Oposto");
        System.out.println("\t\t(4) Levantador");
        System.out.println("\t\t(5) Libero");
        System.out.print("\nQual opcao deseja mudar?");
        opc = scan.nextInt();

        do {
            switch (opc) {
                case 1:
                    atac = dadosAtc.getPonteiros();
                    System.out.println("Ponteiros atuais");
                    System.out.println(team.getUsuario().getTeam().getPont1().imprimeJogador(2) + " | " +
                            team.getUsuario().getTeam().getPont2().imprimeJogador(2));
                    break;
                case 2:
                    atac = dadosAtc.getCentrais();
                    System.out.println("Centrais atuais");
                    System.out.println(team.getUsuario().getTeam().getCtrl1().imprimeJogador(2) + " | " +
                            team.getUsuario().getTeam().getCtrl2().imprimeJogador(2));
                    break;
                case 3:
                    atac = dadosAtc.getOpostos();
                    System.out.println("\t\tOposto atual");
                    System.out.println(team.getUsuario().getTeam().getOpost().imprimeJogador(2));
                    break;
                case 4:
                    System.out.println("\t\tLevantador atual");
                    System.out.println(team.getUsuario().getTeam().getLvnt().imprimeJogador(2));
                    for (Levantador jgdr : levnt) {
                        System.out.println(jgdr.imprimeJogador(4));
                    }
                    break;
                case 5:
                    System.out.println("\t\tLibero atual");
                    System.out.println(team.getUsuario().getTeam().getLibr().imprimeJogador(2));
                    for (Libero jgdr : lib) {
                        System.out.println(jgdr.imprimeJogador(4));
                    }
                    break;
                default:
                    scan.nextLine();
                    System.out.println("Opcao invalida!!!");
                    scan.nextLine();
                    System.out.println("\n\n\n\n\n\n\n\n\n\n");
                    break;
            }
        }while(opc<1 ||opc>5);
        System.out.println("\n\t\tMercado:");
        if (opc ==1 || opc ==2 ||opc ==3) {
            for (Atacante jgdr : atac) {
                System.out.println(jgdr.imprimeJogador(4));
            }
        }
        System.out.println("\nDinheiro restante: "+team.getUsuario().getDinheiro());


        do{
            System.out.print("\nQual jogador deseja comprar (id): ");
            idnew = scan.nextInt();
            if (opc ==1 || opc ==2 ||opc ==3) {
                cont = dadosAtc.existJogador(idnew);
            }else if(opc==4){
                cont = dadosLev.existJogador(idnew);
            }else{
                cont = dadosLib.existJogador(idnew);
            }

            if(!cont){
                System.out.println("ID NAO ENCONTRADO!!!!!!!!");
                scan.nextLine();
            }
        }while(cont==false);

        cont = false;
        do{
            System.out.print("\nQual jogador deseja substituir (id): ");
            idold = scan.nextInt();
            cont = team.existID(idold);
            switch (opc){
                case 1:
                    modo = (team.getUsuario().getTeam().getPont1().getId()==idold)? false:true;
                    break;
                case 2:
                    modo = (team.getUsuario().getTeam().getCtrl1().getId()==idold)? false:true;
                    break;
                case 3:
                    break;
                case 4:
                    cont = (team.getUsuario().getTeam().getLvnt().getId()==idold);
                    result = MudarTime(team, dadosLev.buscJogador(idnew),opc, false);
                    break;
                case 5:
                    cont = (team.getUsuario().getTeam().getLibr().getId()==idold);
                    result = MudarTime(team, dadosLib.buscJogador(idnew),opc, false);
                    break;
            }

            if(!cont){
                System.out.println("JOGADOR NAO ESTA NO TIME!!!!!!!!");
                scan.nextLine();
            }
        }while(cont==false);

        if (opc ==1 || opc ==2 ||opc ==3)
            result = MudarTime(team, dadosAtc.buscJogador(idnew),opc, modo);

        return result;
    }

    private static boolean MudarTime(MeuTime team, Jogador novoJogador, int opc, boolean modo){
        switch (opc){
            case 1:
                return team.changePontero((Atacante) novoJogador, modo);
            case 2:
                return team.changeCentral((Atacante) novoJogador, modo);
            case 3:
                return team.changeOposto((Atacante) novoJogador);
            case 4:
                return team.changeLevantador((Levantador) novoJogador);
            case 5:
                return team.changeLibero((Libero) novoJogador);
            default:
                System.out.println("ERRO!!!");
                return false;
        }
    }
}
