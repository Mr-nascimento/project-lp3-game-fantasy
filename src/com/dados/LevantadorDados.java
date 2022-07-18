package com.dados;

import com.cartola.classes.Levantador;
import com.cartola.classes.Time;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class LevantadorDados{
    private File Dados, Mercado;
    private Scanner scan, scanM;
    private List<Levantador> levantadores;
    private Time selTime;
    private TimeDados times;

    public LevantadorDados() throws FileNotFoundException {
        Dados = new File("dados/Jogador.txt");
        scan = new Scanner(Dados);
        Mercado = new File("dados/Mercado.txt");
        scanM = new Scanner(Mercado);
        times = new TimeDados();
        levantadores = this.ListLevantador();

    }

    public List<Levantador> ListLevantador() {
        List<Levantador> lvtd = new ArrayList<>();
        String linha, scr;
        String[] parts, partsMerc;
        Levantador temp;

         while (scan.hasNext()) {
             linha = scan.nextLine();
             scr = scanM.nextLine();
             parts = linha.split("\t");
             partsMerc = scr.split("\t");
             if (parts[3].equals("com.cartola.classes.Levantador")) {
                 selTime = times.buscTime(Integer.parseInt(parts[4]));
                 temp = new Levantador(Integer.parseInt(parts[0]), parts[1], Byte.parseByte(parts[2]),
                         parts[3], selTime.getSigla());
                 temp.setPontuacao(Double.parseDouble(partsMerc[1]));
                 temp.setPreco(Double.parseDouble(partsMerc[2]));
                 lvtd.add(temp);
             }
         }


        return lvtd;
    }

    public boolean existJogador(int id){
        for (Levantador jgdr : levantadores) {
            if(jgdr.getId()==id)
                return true;
        }
        return false;
    }
    public Levantador buscJogador(int id){
        for (Levantador jgdr : levantadores) {
            if(jgdr.getId()==id)
                return jgdr;
        }
        return null;
    }

    public List<Levantador> getLevantadores() {
        return levantadores;
    }
    public void setLevantador(List<Levantador> levantadore) {
        this.levantadores = levantadores;
    }

}
