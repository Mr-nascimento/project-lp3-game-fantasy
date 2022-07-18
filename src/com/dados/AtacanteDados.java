package com.dados;

import com.cartola.classes.Atacante;
import com.cartola.classes.Time;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;


public class AtacanteDados {
    private File Dados, Mercado;
    private Scanner scan, scanM;
    private List<Atacante> atacantes;
    private Time selTime;
    private TimeDados times;

    public AtacanteDados() throws FileNotFoundException {
        Dados = new File("dados/Jogador.txt");
        scan = new Scanner(Dados);
        Mercado = new File("dados/Mercado.txt");
        scanM = new Scanner(Mercado);
        times = new TimeDados();
        atacantes = this.ListAtacantes();

    }

    public List<Atacante> ListAtacantes() throws FileNotFoundException {
        List<Atacante> atc = new ArrayList<>();
        String linha, scr;
        String[] parts, partsMerc;
        Atacante temp;

        while(scan.hasNext()){
            linha = scan.nextLine();
            scr = scanM.nextLine();
            parts = linha.split("\t");
            partsMerc = scr.split("\t");
            if(parts[3].equals("Ponteiro") || parts[3].equals("Central") || parts[3].equals("Oposto")) {
                selTime = times.buscTime(Integer.parseInt(parts[4]));
                temp = new Atacante(Integer.parseInt(parts[0]), parts[1], Byte.parseByte(parts[2]),
                        parts[3], selTime.getSigla());
                temp.setPontuacao(Double.parseDouble(partsMerc[1]));
                temp.setPreco(Double.parseDouble(partsMerc[2]));
                atc.add(temp);
            }
        }

        return atc;
    }

    public List<Atacante> getCentrais(){
        List<Atacante> cntr = new ArrayList<>();
        for(Atacante jogador: atacantes){
            if(jogador.getPosicao().equals("Central")){
                cntr.add(jogador);
            }
        }
        return cntr;
    }
    public List<Atacante> getPonteiros(){
        List<Atacante> pntr = new ArrayList<>();
        for (int i = 0; i < atacantes.size(); i++){
            if(atacantes.get(i).getPosicao().equals("Ponteiro")){
                pntr.add(atacantes.get(i));
                System.out.print(atacantes.get(i).getPosicao()+" ");
            }
        }
        return pntr;
    }
    public List<Atacante> getOpostos(){
        List<Atacante> opst = new ArrayList<>();
        for(Atacante jogador: atacantes){
            if(jogador.getPosicao().equals("Oposto")){
                opst.add(jogador);
            }
        }
        return opst;
    }

    public boolean existJogador(int id){
        for (Atacante jgdr : atacantes) {
            if(jgdr.getId()==id)
                return true;
        }
        return false;
    }
    public Atacante buscJogador(int id){
        for (Atacante jgdr : atacantes) {
            if(jgdr.getId()==id)
                return jgdr;
        }
        return null;
    }

    public List<Atacante> getAtacantes(){
        return atacantes;
    }
    public void setAtacantes(List<Atacante> atacantes) {
        this.atacantes = atacantes;
    }
}
