package com.dados;

import com.cartola.classes.Libero;
import com.cartola.classes.Time;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class LiberoDados{
    private File Dados, Mercado;
    private Scanner scan, scanM;
    private List<Libero> liberos;
    private Time selTime;
    private TimeDados times;

    public LiberoDados() throws FileNotFoundException {
        Dados = new File("dados/Jogador.txt");
        scan = new Scanner(Dados);
        Mercado = new File("dados/Mercado.txt");
        scanM = new Scanner(Mercado);
        times = new TimeDados();
        liberos = this.ListLibero();

    }

    public List<Libero> ListLibero() {
        List<Libero> libr = new ArrayList<>();
        String linha, scr;
        String[] parts, partsMerc;
        Libero temp;


        while (scan.hasNext()) {
            linha = scan.nextLine();
            scr = scanM.nextLine();
            parts = linha.split("\t");
            partsMerc = scr.split("\t");
            if (parts[3].equals("Libero")) {
                selTime = times.buscTime(Integer.parseInt(parts[4]));
                temp = new Libero(Integer.parseInt(parts[0]), parts[1], Byte.parseByte(parts[2]),
                        parts[3], selTime.getSigla());
                temp.setPontuacao(Double.parseDouble(partsMerc[1]));
                temp.setPreco(Double.parseDouble(partsMerc[2]));
                libr.add(temp);
            }
        }


        return libr;
    }

    public boolean existJogador(int id){
        for (Libero jgdr : liberos) {
            if(jgdr.getId()==id)
                return true;
        }
        return false;
    }
    public Libero buscJogador(int id){
        for (Libero jgdr : liberos) {
            if(jgdr.getId()==id)
                return jgdr;
        }
        return null;
    }


    public List<Libero> getLiberos() {
        return liberos;
    }
    public void setLiberos(List<Libero> libero) {
        this.liberos = libero;
    }

}
