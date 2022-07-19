package com.telas;

import java.util.Scanner;

public abstract class TelaRod {


    public static int printTela(){
        Scanner scan = new Scanner(System.in);
        int opc;
        System.out.println("(0) para cancelar.\n");
        System.out.print("Quantos jogos serao realizados: ");
        opc = scan.nextInt();
        return opc;
    }

    public static int[] guardaIds(int size){
        Scanner scan = new Scanner(System.in);
        int ids[] = new int[size];
        int i=0;
        do{
            System.out.print("Digite ID do jogo: ");
            ids[i] = scan.nextInt();
            i++;
        }while(i<size);
        return ids;
    }
}
