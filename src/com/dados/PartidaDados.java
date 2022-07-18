package com.dados;

import com.cartola.classes.Partida;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class PartidaDados {
    private File Dados;
    private Scanner scan;
    private List<Partida> games;

    public PartidaDados() throws FileNotFoundException {
        Dados = new File("dados/Partida.txt");
        scan = new Scanner(Dados);
        games = this.ListPartida();

    }

    public List<Partida> ListPartida() {
        List<Partida> jogo = new ArrayList<>();
        String linha;
        String[] parts;
        String result;
        Partida temp;

        while (scan.hasNext()) {
            linha = scan.nextLine();
            parts = linha.split("\t");
            result = parts[3];
            temp = new Partida(Integer.parseInt(parts[0]), Integer.parseInt(parts[4]), Integer.parseInt(parts[5]),
                    Byte.parseByte(result.substring(0,1)), Byte.parseByte(result.substring(2)), parts[1], parts[2]);
            jogo.add(temp);
        }


        return jogo;
    }

    public boolean existPartida(int id){
        for (Partida jogo : games) {
            if(jogo.getIdPart()==id)
                return true;
        }
        return false;
    }
    public Partida buscPartida(int id){
        for (Partida jogo : games) {
            if(jogo.getIdPart()==id)
                return jogo;
        }
        return null;
    }

    public List<Partida> getPartidas() {
        return games;
    }
    public void setPartidas(List<Partida> teams) {
        this.games = games;
    }
}
