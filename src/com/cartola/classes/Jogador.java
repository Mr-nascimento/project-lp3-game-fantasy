package com.cartola.classes;

import com.cartola.obj.Pontuacao;

import java.text.DecimalFormat;
import java.text.NumberFormat;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;

public abstract class Jogador {
    private String nome;
    private byte numero;
    private String posicao;
    private static int maxID=0;
    private int id;
    private String time;
    private double pontuacao;
    private double preco;

    private static final DecimalFormat formatacao = new DecimalFormat("0.00") ;

    public Jogador(){//jogador default
        this(true, null);

    }
    public Jogador(boolean modo, String posicao){//jogador default
        if(modo){
            nome = null;
            id = maxID;
            preco = 15;
        }else{
            nome = "Sem nome";
            id = 0;
            preco = 0;
        }
        numero = 0;
        this.posicao = posicao;
        time = null;
        pontuacao = 0;
    }
    public Jogador(int id, String nome, byte numero, String posicao, String time) {
        //if(id>maxID) {
            this.nome = nome;
            this.numero = numero;
            this.posicao = posicao;
            this.id = id;
            this.time = time;
            maxID++;
            pontuacao = 0;
            preco =0;
        //}else{
        //    System.out.println("ID invalido");
        //}
    }

    public String getNome() {
        return nome;
    }
    public void setNome(String nome) {
        this.nome = nome;
    }

    public byte getNumero() {
        return numero;
    }
    public void setNumero(byte numero) {
        this.numero = numero;
    }

    public String getPosicao() {
        return posicao;
    }
    public void setPosicao(String posicao) {
        this.posicao = posicao;
    }

    public int getId() {
        return id;
    }

    public static int getMaxID() {
        return maxID;
    }
    public static void setMaxID(short maxID) {
        Jogador.maxID = maxID;
    }

    public String getTime() {
        return time;
    }
    public void setTime(String time) {
        this.time = time;
    }

    public double getPontuacao() {
        return pontuacao;
    }
    public void setPontuacao(double pontuacao) {
        this.pontuacao = Double.parseDouble(formatacao.format(pontuacao).replace(",","."));
    }

    public double getPreco() {
        return preco;
    }
    public void setPreco(double preco) {
        this.preco = Double.parseDouble(formatacao.format(preco).replace(",","."));
    }

    public abstract double calcPonto();
    public String imprimeJogador(int modo){
        switch (modo){
            case 1: //tela de ver time
                return this.getNumero()+"\t"+this.getNome()+"\t\tTime: "+this.getTime()+"\t\t| pts:"+ this.getPontuacao();
            case 2: // muda time - atual
                return "ID "+this.getId()+":\t"+this.getNome()+"\tTime: "+this.getTime()+"\t| pts:"+ this.getPontuacao();
            case 3: // muda time - opcoes
                return "ID "+this.getId()+":\t"+this.getNome()+"\t\tTime: "+this.getTime()+"\t\t| pts:"+
                        this.getPontuacao()+" | preco:"+this.getPreco();
            case 4://completo jogador
                return "ID "+this.getId()+":\t\t("+this.getNumero()+") "+this.getNome()+"\t\t"+this.getPosicao()+
                        "\t\tTime: "+this.getTime()+ "\t\t| pts:"+ this.getPontuacao()+" | preco:"+this.getPreco();
            default:
                break;
        }
        return null;
    };
    public abstract void setDefesas(short def, short errDef);
    public abstract void setRecepcao(short recReg, short recPerf, short recErr);
    public abstract void setAtaque(short Atk,short tentAtk, short errAtk);
    public abstract void setSaque(short saque, short errSaque);
    public abstract void setBloqueio(short bck, short errBlock);

    public void setEstatisticas(Pontuacao pont){
        this.setDefesas(pont.getDefesa(), pont.getErr_defesa());
        this.setRecepcao((short)(pont.getBom_recep()+pont.getErr_recep()+pont.getPerf_recep()), pont.getPerf_recep(), pont.getErr_recep());
        this.setAtaque(pont.getPts_ataque(), pont.getTent_ataque(),pont.getErr_ataque());
        this.setSaque(pont.getErr_saque(), pont.getErr_saque());
        this.setBloqueio(pont.getErr_block(), pont.getErr_block());
    }

    public double calcPreco(){
        return (this.preco*0.6) + (this.pontuacao*0.4);
    }
    public static List<Jogador> ordenaJogs(List<Atacante> atc, List<Levantador> lev , List<Libero> lib){
        List<Jogador> jogs=new ArrayList<>();
        int i=0,j=0,k=0;
        int idA=0,idLV=0, idLib=0;
        while(i<atc.size() || j<lev.size() || k<lib.size()){
            if(i<atc.size())
                idA = atc.get(i).getId();
            if(j<lev.size())
                idLV = lev.get(j).getId();
            if(k<lib.size()) {
                idLib = lib.get(k).getId();
            }

            //i e menor
                //tds existem
                //i so j exis
                //i so k exs
                //i so ele exit
            if(((j==lev.size() && k==lib.size())) || (i<atc.size() && idA<idLV && k==lib.size())
                || (i<atc.size() && idA<idLib && j==lev.size()) || (i<atc.size() && idA<idLib && idA<idLV)){
                jogs.add(atc.get(i));
                i++;
            }else if(((i==atc.size() && k==lib.size())) || (j<lev.size() && idLV<idA && k==lib.size())
                    || (j<lev.size() && idLV<idLib && i==atc.size()) || (j<lev.size() && idLV<idLib && idLV<idA)){
                jogs.add(lev.get(j));
                j++;
            }else if((i==atc.size() && j==lev.size()) || (k<lib.size() && idLib<idA && j==lev.size())
                    || (k<lib.size() && idLib<idLV && i==atc.size()) || (k<lib.size() && idLib<idLV && idLib<idA)){
                jogs.add(lib.get(k));
                k++;
            }

        }
        return jogs;
    }
}
