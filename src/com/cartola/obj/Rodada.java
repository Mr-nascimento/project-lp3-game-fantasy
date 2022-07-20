package com.cartola.obj;

import com.cartola.classes.*;
import com.dados.*;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.List;

import static com.cartola.classes.Jogador.ordenaJogs;

public class Rodada {
    private int jogosId[];

    //acesso aos dados
    private PartidaDados regJogos = new PartidaDados();
    private PontuacaoDados pts = new PontuacaoDados();
    private AtacanteDados atcDados = new AtacanteDados();
    private LiberoDados lbrDados = new LiberoDados();
    private LevantadorDados levDados = new LevantadorDados();
    private PontsDados arq = new PontsDados();

    //pontuacao da partida atual
    private List<Pontuacao> pontMatch;


    //lsita de jogadores
    private List<Atacante> atcs;
    private List<Levantador> levs;
    private List<Libero> libr;

    public Rodada(int jogosID[]) throws IOException {
        this.jogosId = jogosID;
        for(int i=0;i<jogosID.length;i++){
            if (regJogos.existPartida(jogosID[i])){
                pontMatch = pts.buscPontuacoes(jogosID[i]);
                atcs = new ArrayList<>();
                levs = new ArrayList<>();
                libr = new ArrayList<>();
                makegame(jogosID[i]);
                this.calcAtacantes();
                this.calcLevantadors();
                this.calcLiberos();
                arq.editPont(ordenaJogs(atcs, levs, libr));
            }
        }
    }

    public void makegame(int idPart) throws FileNotFoundException {
        Pontuacao atual;
        Jogador jgr;
        Partida prt = regJogos.buscPartida(idPart);


        for (int i=0;i<pontMatch.size();i++) {
            atual = pts.buscPontuacao(prt.getIdPart(), pontMatch.get(i).getId_jogador());
            if(atcDados.existJogador(pontMatch.get(i).getId_jogador())) {
                jgr = atcDados.buscJogador(pontMatch.get(i).getId_jogador());
                if(jgr!=null) {
                    jgr.setEstatisticas(atual);
                    atcs.add((Atacante) jgr);
                }
            }
            else if(levDados.existJogador(pontMatch.get(i).getId_jogador())) {
                jgr = levDados.buscJogador(pontMatch.get(i).getId_jogador());
                if(jgr!=null) {
                    jgr.setEstatisticas(atual);
                    levs.add((Levantador) jgr);
                }
            }
            else {
                jgr = lbrDados.buscJogador(pontMatch.get(i).getId_jogador());
                if(jgr!=null) {
                    jgr.setEstatisticas(atual);
                    libr.add((Libero) jgr);
                }
            }
        }

    }

    public void calcAtacantes(){
        for (Atacante jgdrs:atcs){
            jgdrs.setPontuacao(jgdrs.calcPonto());
            jgdrs.setPreco(jgdrs.calcPreco());
        }
    }
    public void calcLiberos(){
        for (Libero jgdrs:libr){
            jgdrs.setPontuacao(jgdrs.calcPonto());
            jgdrs.setPreco(jgdrs.calcPreco());
        }
    }
    public void calcLevantadors(){
        for (Levantador jgdrs:levs){
            jgdrs.setPontuacao(jgdrs.calcPonto());
            jgdrs.setPreco(jgdrs.calcPreco());
        }
    }

}
