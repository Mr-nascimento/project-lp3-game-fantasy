package com.cartola.classes;

public abstract class Jogador {
    private String nome;
    private byte numero;
    private String posicao;
    private static int maxID=0;
    private int id;
    private String time;
    private double pontuacao;
    private double preco;

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
        this.pontuacao = pontuacao;
    }

    public double getPreco() {
        return preco;
    }
    public void setPreco(double preco) {
        this.preco = preco;
    }

    public abstract double calcPonto();
    public String imprimeJogador(int modo){
        switch (modo){
            case 1: //tela de ver time
                return this.getNumero()+"\t"+this.getNome()+"\t\tTime: "+this.getTime()+"\t\t| pts:"+ this.getPontuacao();
            case 2: // muda time - atual
                return "ID "+this.getId()+":\t"+this.getNome()+"\t\tTime: "+this.getTime()+"\t\t| pts:"+ this.getPontuacao();
            case 3: // muda time - opcoes
                return "ID "+this.getId()+":\t"+this.getNome()+"\t\tTime: "+this.getTime()+"\t\t| pts:"+
                        this.getPontuacao()+"| preco:"+this.getPreco();
            case 4://completo jogador
                return "ID "+this.getId()+":\t\t("+this.getNumero()+") "+this.getNome()+"\t\t"+this.getPosicao()+
                        "\t\tTime: "+this.getTime()+ "\t\t| pts:"+ this.getPontuacao()+"| preco:"+this.getPreco();
            default:
                break;
        }
        return null;
    };
    public abstract void setDefesas(short def, short errDef);
    public abstract void setRecepcao(short recReg, short recPerf, short recErr);
    public abstract void setAtaque(short Atk, short errAtk);
    public abstract void setSaque(short saque, short errSaque);
    public abstract void setBloqueio(short bck, short errBlock);
}
