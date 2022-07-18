package com.cartola.obj;

import com.cartola.classes.*;

import java.util.Scanner;

public class MeuTime {
    private User usuario;
    private Scanner scan = new Scanner(System.in);

    public MeuTime(User usuario){
        this.usuario = usuario;
    }

    public void showTime(int modo){
        System.out.println("\t\t-----" + usuario.getTeam().getNome() + "-----");
        if(modo==1)
            System.out.println("Pts rodada:" + usuario.getPtRodada() + "\tPts totais: " + usuario.getPtRodada() + "\n");

        System.out.println("Central:\t"+ usuario.getTeam().getCtrl1().imprimeJogador(modo));
        System.out.println("Central:\t"+ usuario.getTeam().getCtrl2().imprimeJogador(modo));
        System.out.println("Ponteiro:\t"+ usuario.getTeam().getPont1().imprimeJogador(modo));
        System.out.println("Ponteiro:\t"+ usuario.getTeam().getPont2().imprimeJogador(modo));
        System.out.println("Oposto:\t\t"+ usuario.getTeam().getOpost().imprimeJogador(modo));
        System.out.println("Levantador:\t"+ usuario.getTeam().getLvnt().imprimeJogador(modo));
        System.out.println("Libero:\t\t"+ usuario.getTeam().getLibr().imprimeJogador(modo));

        if(modo==1)
            System.out.println("\nCapitao: "+usuario.getTeam().getCapitao()+"\n");

    }

    public void changeTime(String novoNome){
        this.usuario.getTeam().setNome(novoNome);
    }

    public void changeCap(int id){
        this.usuario.getTeam().setCapitao(id);
    }

    public Jogador[] getVetorJogadores(){
        Jogador jgr[] = new Jogador[7];

        jgr[0]= (Jogador) usuario.getTeam().getCtrl1();
        jgr[1]= (Jogador) usuario.getTeam().getCtrl2();
        jgr[2]= (Jogador) usuario.getTeam().getPont1();
        jgr[3]= (Jogador) usuario.getTeam().getPont1();
        jgr[4]= (Jogador) usuario.getTeam().getOpost();
        jgr[5]= (Jogador) usuario.getTeam().getLvnt();
        jgr[6]= (Jogador) usuario.getTeam().getLibr();

        return jgr;
    }

    private boolean checarSaldo(double oldPreco, double preco) {
        double dinheiro = this.usuario.getDinheiro();

        if ((dinheiro + oldPreco) >= preco) {
            return true;
        }
        return false;
    }

    public boolean changePontero(Atacante pontNovo, boolean modo){
        boolean saldo;

        double precoNovo = pontNovo.getPreco();
        saldo = (modo)?this.checarSaldo(this.usuario.getTeam().getPont1().getPreco(), precoNovo):
                this.checarSaldo(this.usuario.getTeam().getPont2().getPreco(), precoNovo);
        if(saldo){
            if(modo){
                this.usuario.setDinheiro((this.usuario.getDinheiro()+this.usuario.getTeam().getPont1().getPreco())-precoNovo);
                this.usuario.getTeam().setPont1(pontNovo);
            }else{
                this.usuario.setDinheiro((this.usuario.getDinheiro()+this.usuario.getTeam().getPont2().getPreco())-precoNovo);
                this.usuario.getTeam().setPont2(pontNovo);

            }
            return true;
        }
        return false;
    }
    public boolean changeCentral(Atacante ctrlNovo, boolean modo){
        boolean saldo;
        double precoNovo = ctrlNovo.getPreco();
        saldo = (modo)?this.checarSaldo(this.usuario.getTeam().getPont1().getPreco(), precoNovo):
                this.checarSaldo(this.usuario.getTeam().getPont2().getPreco(), precoNovo);

        if(saldo){
            if(modo){
                this.usuario.setDinheiro((this.usuario.getDinheiro()+this.usuario.getTeam().getCtrl1().getPreco())-precoNovo);
                this.usuario.getTeam().setCtrl1(ctrlNovo);
            }else{
                this.usuario.setDinheiro((this.usuario.getDinheiro()+this.usuario.getTeam().getCtrl2().getPreco())-precoNovo);
                this.usuario.getTeam().setCtrl2(ctrlNovo);
            }
            return true;
        }
        return false;
    }
    public boolean changeOposto(Atacante OpostNovo){
        double precoNovo = OpostNovo.getPreco();
        if(this.checarSaldo(this.usuario.getTeam().getOpost().getPreco(), precoNovo)){
            this.usuario.setDinheiro((this.usuario.getDinheiro()+this.usuario.getTeam().getOpost().getPreco())-precoNovo);
            this.usuario.getTeam().setOpost(OpostNovo);
            return true;
        }
        return false;
    }

    public boolean changeLevantador(Levantador LvntNovo){
        double precoNovo = LvntNovo.getPreco();
        if(this.checarSaldo(this.usuario.getTeam().getLvnt().getPreco(), precoNovo)){
            this.usuario.setDinheiro((this.usuario.getDinheiro()+this.usuario.getTeam().getLvnt().getPreco())-precoNovo);
            this.usuario.getTeam().setLvnt(LvntNovo);
            return true;
        }
        return false;
    }

    public boolean changeLibero(Libero LibrNovo){
        double precoNovo = LibrNovo.getPreco();
        if(this.checarSaldo(this.usuario.getTeam().getLibr().getPreco(), precoNovo)){
            this.usuario.setDinheiro((this.usuario.getDinheiro()+this.usuario.getTeam().getLibr().getPreco())-precoNovo);
            this.usuario.getTeam().setLibr(LibrNovo);
            return true;
        }
        return false;
    }

    public boolean existID(int id){
        Jogador[] jgdrs = this.getVetorJogadores();
        for(int i=0;i<7;i++){
            if(jgdrs[i].getId()==id){
                return true;
            }
        }
        return false;
    }

    public void changePontucao(Pontuacao pts, int id){
        Jogador[] jgdrs = this.getVetorJogadores();

        for(int i=0;i<7;i++){
            if(jgdrs[i].getId()==id){
                jgdrs[i].setDefesas(pts.getDefesa(), pts.getErr_defesa());
                jgdrs[i].setRecepcao((short) (pts.getPerf_recep()+pts.getErr_recep()+ pts.getBom_recep()), pts.getPerf_recep(),pts.getErr_recep());
                jgdrs[i].setAtaque(pts.getPts_ataque(), pts.getErr_ataque());
                jgdrs[i].setSaque(pts.getPts_saque(), pts.getErr_saque());
                jgdrs[i].setBloqueio(pts.getPts_block(), pts.getErr_block());
            }
        }
    }

    public User getUsuario() {
        return usuario;
    }
    public void setUsuario(User usuario) {
        this.usuario = usuario;
    }
}
