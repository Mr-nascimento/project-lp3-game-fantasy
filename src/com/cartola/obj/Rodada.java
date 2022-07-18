package com.cartola.obj;

import com.cartola.classes.Partida;
import com.dados.PartidaDados;
import com.dados.PontuacaoDados;

import java.io.FileNotFoundException;
import java.util.List;

public class Rodada {
    private int jogosId[];
    private PartidaDados regJogos = new PartidaDados();
    private List<Partida> jogs = regJogos.ListPartida();

    Rodada(int jogosID[]) throws FileNotFoundException {
        this.jogosId = jogosID;
        for(int i=0;i<jogosID.length;i++){
            if (regJogos.existPartida(jogosID[i])){
                makegame(jogosID[i]);
            }
        }
    }

    public void makegame(int idPart) throws FileNotFoundException {
        PontuacaoDados pts = new PontuacaoDados();
        List<Pontuacao> listaPont = pts.getPontuacoes();
        Partida prt = regJogos.buscPartida(idPart);




    }
}
