package com.dados;

import com.cartola.obj.Pontuacao;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class PontuacaoDados {
    private File Dados;
    private Scanner scan;
    private List<Pontuacao> pts;

    public PontuacaoDados() throws FileNotFoundException {
        Dados = new File("dados/Pontuacao.txt");
        scan = new Scanner(Dados);
        pts = this.ListPontuacoes();

    }

    public List<Pontuacao> ListPontuacoes() {
        List<Pontuacao> ponts = new ArrayList<>();
        String linha;
        String[] parts;
        Pontuacao temp;

        while (scan.hasNext()) {
            linha = scan.nextLine();
            parts = linha.split("\t");
            temp = new Pontuacao(Short.parseShort(parts[0]), Short.parseShort(parts[1]), Short.parseShort(parts[2]),
                    Short.parseShort(parts[3]), Short.parseShort(parts[4]), Short.parseShort(parts[5]),
                    Short.parseShort(parts[6]), Short.parseShort(parts[7]), Short.parseShort(parts[8]),
                    Short.parseShort(parts[9]), Short.parseShort(parts[10]), Short.parseShort(parts[11]),
                    Short.parseShort(parts[12]), Short.parseShort(parts[13]), Short.parseShort(parts[14]));
            ponts.add(temp);
        }
        return ponts;
    }


    public boolean existPontuacao(int idPart, int idJogd){
        for (Pontuacao ponts : pts) {
            if(ponts.getId_jogador()==idJogd && ponts.getId_partida()==idPart)
                return true;
        }
        return false;
    }
    public Pontuacao buscPontuacao(int idPart, int idJodg){
        for (Pontuacao ponts : pts) {
            if(ponts.getId_jogador()==idJodg && ponts.getId_partida()==idPart)
                return ponts;
        }
        return null;
    }

    public List<Pontuacao> getPontuacoes() {
        return pts;
    }
    public void setPontuacoes(List<Pontuacao> ponts) {
        this.pts = pts;
    }
}
