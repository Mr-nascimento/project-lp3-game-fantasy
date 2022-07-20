package com.cartola.classes;

import com.dados.PontsDados;

import java.io.FileNotFoundException;
import java.text.DecimalFormat;
import java.text.NumberFormat;
import java.util.Locale;

public class User {
    private Equipe team;
    private double ptTotal;
    private double ptRodada;
    private double din;

    private static final DecimalFormat formatacao = new DecimalFormat("0.00");

    public User(Equipe team, double ptTotal, double ptRodada, double din) {
        this.team = team;
        this.ptTotal = ptTotal;
        this.ptRodada = ptRodada;
        this.din = din;
    }
    public User(){
        this(new Equipe(), 0,0,100);
    }
    public User(User outroUsuario){
        this(outroUsuario.team, outroUsuario.ptTotal, outroUsuario.ptRodada, outroUsuario.din);
    }

    public void update() throws FileNotFoundException {
        PontsDados acesso = new PontsDados();
        int[] ids = {team.ctrl1.getId(),team.ctrl2.getId(),team.opost.getId(),
                    team.pont1.getId(),team.pont2.getId(),team.lvnt.getId(), team.libr.getId()};
        int idCap = team.getCapitao();
        Jogador atual;
        String[] valAtual = new String[3];
        String pos;

        String[] ponts = acesso.buscString(ids); //tds as pontuacoes do time

        ptRodada = 0;
        for(int i=0;i<ids.length;i++){
            if(ponts[i]!=null){
                atual = team.buscJogador(ids[i]);
                if (atual != null) {
                    pos = atual.getPosicao();

                    for (int j = 0; j < ponts.length; j++) {
                        if (ponts[j]!=null) {
                            if (Integer.parseInt(ponts[j].split("\t")[0]) == atual.getId()) {
                                valAtual = ponts[j].split("\t");
                                break;
                            }
                        }
                    }

                    this.updateJog(valAtual, pos);
                    if(atual.getId() == idCap)
                        ptRodada = Double.parseDouble(formatacao.format((2 * atual.getPontuacao())+ptRodada).replace(",","."));
                    else
                        ptRodada =Double.parseDouble(formatacao.format(atual.getPontuacao()+ptRodada).replace(",","."));

                }
            }
        }
        ptTotal=Double.parseDouble(formatacao.format(ptRodada+ptTotal).replace(",","."));

    }

    public double precTime(){
        double prec = 0;

        prec+=team.ctrl1.getPreco();
        prec+=team.ctrl2.getPreco();
        prec+=team.pont1.getPreco();
        prec+=team.pont2.getPreco();
        prec+=team.opost.getPreco();
        prec+=team.libr.getPreco();
        prec+=team.lvnt.getPreco();

        return prec;
    }

    public void updateJog(String[] newVal, String pos){
        if(pos.equals("Central")){
            if(Integer.parseInt(newVal[0])==team.ctrl1.getId()){
                team.ctrl1.setPontuacao(Double.parseDouble(newVal[1]));
                team.ctrl1.setPreco(Double.parseDouble(newVal[2]));
            }else{
                team.ctrl2.setPontuacao(Double.parseDouble(newVal[1]));
                team.ctrl2.setPreco(Double.parseDouble(newVal[2]));
            }
        }
        if(pos.equals("Ponteiro")) {
            if(Integer.parseInt(newVal[0])==team.pont1.getId()){
                team.pont1.setPontuacao(Double.parseDouble(newVal[1]));
                team.pont1.setPreco(Double.parseDouble(newVal[2]));
            }else{
                team.pont2.setPontuacao(Double.parseDouble(newVal[1]));
                team.pont2.setPreco(Double.parseDouble(newVal[2]));
            }
        }
        if(pos.equals("Oposto")) {
            team.opost.setPontuacao(Double.parseDouble(newVal[1]));
            team.opost.setPreco(Double.parseDouble(newVal[2]));
        }
        if(pos.equals("Levantador")) {
            team.lvnt.setPontuacao(Double.parseDouble(newVal[1]));
            team.lvnt.setPreco(Double.parseDouble(newVal[2]));
        }
        if(pos.equals("Libero")) {
            team.libr.setPontuacao(Double.parseDouble(newVal[1]));
            team.libr.setPreco(Double.parseDouble(newVal[2]));
        }
    }

    public Equipe getTeam() {
        return team;
    }
    public void setTeam(Equipe team) {
        this.team = team;
    }

    public double getPtTotal() {
        return ptTotal;
    }
    public void setPtTotal(double ptTotal) {
        this.ptTotal = Double.parseDouble(formatacao.format(ptTotal).replace(",","."));
    }

    public double getPtRodada() {
        return ptRodada;
    }
    public void setPtRodada(double ptRodada) {
        this.ptRodada = Double.parseDouble(formatacao.format(ptRodada).replace(",","."));
    }

    public double getDinheiro() {
        return din;
    }
    public void setDinheiro(double din) {
        this.din = Double.parseDouble(formatacao.format(din).replace(",","."));
    }
}
