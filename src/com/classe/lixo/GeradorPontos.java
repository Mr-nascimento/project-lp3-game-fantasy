package com.classe.lixo;

import com.cartola.classes.Atacante;
import com.cartola.classes.Jogador;
import com.cartola.classes.Levantador;
import com.cartola.classes.Libero;

import java.util.Random;
import java.lang.Math;

public class GeradorPontos {
    private boolean ganhador;
    private short[][] pontA = new short[7][13];
    private short[][] pontB  = new short[7][13];
    private String result;


    public GeradorPontos(){
        ganhador = sortGanhador();
        result = (ganhador)? String.valueOf((((int) (Math.random()*10))%3)) + String.valueOf(3):
                            String.valueOf(3) + String.valueOf((((int) (Math.random()*10))%3));
        this.geraTabela();

    }

    public boolean getGanhador() {
        return ganhador;
    }
    public void setGanhador(boolean ganhador) {
        this.ganhador = ganhador;
    }

    public short[][] getPontA() {
        return pontA;
    }
    public void setPontA(short[][] pontA) {
        this.pontA = pontA;
    }

    public short[][] getPontB() {
        return pontB;
    }
    public void setPontB(short[][] pontB) {
        this.pontB = pontB;
    }

    public String getResult() {
        return result;
    }
    public void setResult(String result) {
        this.result = result;
    }

    private boolean sortGanhador(){
        Random sort = new Random();
        return sort.nextBoolean();
    }

    private void geraTabela(){
        /*
           //cada linha corresponde a pontuacao de um jogador
           //as colunas tem as estaticas do jogo, seguindo a seguinte ordem:
           [0]blocks  ; [1]tent. blocks ; [2]errs de block ; [3]pts de saque ; [4]erros de saque
           [5]pts de ataque; [6]tent. de ataques; [7]err de atk; [8]recepcao perfeitas;
           [9]recp. okay ; [10]err de recep; [11]defesa ; [12]erro de defesa

           //gerador supoe que apenas 7 jogadores entraram em quadra
           //seguindo a ordem das  linhas 2 ponteiros, 1 oposto, 2 centrais, 1 levantador, 1 libero
           // as posiçoes sao importante para decidir a forma de distribuir pontos

        */



        /*    time ganhador | time perderdor
            3 x 0 = 75      | 0 a 69
            3 x 1 = 75 a 98 | 25 a 94
            3 x 2 = 75 a 121| 50 a 119
         */

        //chance de errar por categoria
        //27.5errAtk;
        //22.5errBlo;
        //17.5errSaque;
        //12.5recepErr;
        //20errDef;
        int ptsA, ptsB, ptsErrA, ptsErrB;
        int sets;


        sets = (result.charAt(0)-48) +(result.charAt(1)-48); //qntd de sets

        //pontos feitos em erro do adversario
        ptsErrA = (!ganhador)? 5 + ((int) (Math.random()*100))% 18: 10 + ((int) (Math.random()*100))% 25;
        ptsErrB = (ganhador)? 5 + ((int) (Math.random()*100))% 18: 10 +((int) (Math.random()*100))% 25;



        //calculo total de pontos do time
        if(sets==3){
            if(ganhador){ //f(x) = -0.33x + 26.33
                ptsB = 3*25;
                ptsA = (int )Math.round((-0.33*ptsErrA) + 26.33) *3;
            }else{
                ptsA = 3*25;
                ptsB = (int )Math.round((-0.33*ptsErrB) + 26.33) *3;
            }
        }else if(sets==4){
            if(ganhador){
                ptsB = 3*25 + (int )Math.round((-0.33*ptsErrB) + 26.33);
                ptsA = 25 + (((int )Math.round((-0.33*((ptsErrA*2)/3)) + 26))*3); //f(x) = -0.33((2/3)x) + 26.33
            }else{
                ptsA = 3*25 + (int )Math.round((-0.33*ptsErrA) + 26.33);
                ptsB = 25 + (((int )Math.round((-0.33*((ptsErrB*2)/3)) + 26))*3);
            }
        }else{
            if(ganhador){
                ptsB = 2*25 + 15 + ((int )Math.round((-0.33*ptsErrB) + 26.33)*2);
                ptsA = 25*2 + (((int )Math.round((-0.33*((ptsErrA*2)/3)) + 26))*2) + (((int )Math.round(((-0.29)*ptsErrA) + 15.9))*2); //f(x) = -0.29x + 15.9
            }else{
                ptsA = 2*25 + 15 + ((int )Math.round((-0.33*ptsErrA) + 26.33)*2);
                ptsB = 25 + (((int )Math.round((-0.33*((ptsErrB*2)/3)) + 26))*2) + (((int )Math.round(((-0.29)*ptsErrB) + 15.9))*2);
            }
        }

        //calcular pontos de saque
        //saque = entre 1.74% e 11.3% --> f(erros) = -0,329*errs + 12,945


    }

    private short[] sortBlock(double efi, double probErr, int erros, int pts){
        short[] linha = new short[13];

        //[0]blocks  ; [1]tent. blocks ; [2]errs de block;

        // feitos/block = eficiencia --> f = e.b --> b = f/e



        linha[0] =  (short) pts;
        linha[1] =  (short) Math.round(pts/(efi/100));
        linha[2] = (short) Math.round(erros*0.225*(probErr/100)); //22.5% de chance errBlock;

        return linha;
    }

    private short[] sortSaque(double efi, double probErr, int erros, int pts){
        short[] linha = new short[13];

        // feitos/saques = eficiencia --> f = e.s

        //[3]pts de saque ; [4]erros de saque
        linha[3] =  (short) pts;
        linha[4] = (short) Math.round(erros*0.175*(probErr/100)); //17.5% de chance errBlock;

        return linha;
    }

    private short[] sortAtaque(double efi, double probErr, int erros, int pts){
        short[] linha = new short[13];

        //[5]pts de ataque; [6]tent. de ataques; [7]err de atk;

        // feitos/atacados = eficiencia --> f = e.a --> a = f/e



        linha[5] =  (short) pts;
        linha[6] =  (short) Math.round(pts/(efi/100));
        linha[7] = (short) Math.round(erros*0.275*(probErr/100)); //27.5errAtk;

        return linha;
    }

    private short[] sortDefesa(double probErr, int erros, int atks, int saqs){
        short[] linha = new short[13];
        int errDef, errRecep, err;

        err = (int)Math.round((probErr/100)*0.325*erros);
        errDef = (int)Math.round(err*0.20);
        errRecep = err - errDef;


        //[8]recepcao perfeitas; [9]recp. okay ; [10]err de recep;
        //[11]defesa ; [12]erro de defesa
        linha[8] =  (short) Math.round((saqs-erros)*(probErr/100)*0.125);
        linha[9] =  (short) Math.round((saqs-erros)*(probErr/100)*0.375);
        linha[10] = (short)errRecep;
        linha[11] = (short) Math.round((atks-erros)*(probErr/100)*0.5);
        linha[12] = (short)errDef;

        return linha;
    }



    public int returnSomaColuna(int coluna, boolean time){
        int i, atks=0;
        for(i =0;i<7;i++){
            atks = (time)? atks+pontB[i][coluna] : atks+pontA[i][coluna];
        }
        return atks;
    }

    public int totalPtsBlocks(boolean time){
        return  returnSomaColuna(0, time);
    }
    public int totalBlocks(boolean time){
        return  returnSomaColuna(1, time);
    }
    public int totalErrBlocks(boolean time){
        return  returnSomaColuna(2, time);
    }
    public int totalPtsSaque(boolean time){
        return  returnSomaColuna(3, time);
    }
    public int totalErrSaque(boolean time){
        return  returnSomaColuna(4, time);
    }
    public int totalPtsAtaque(boolean time){
        return  returnSomaColuna(5, time);
    }
    public int totalAtaque(boolean time){
        return  returnSomaColuna(6, time);
    }
    public int totalErrAtaque(boolean time){
        return  returnSomaColuna(7, time);
    }
    public int totalRecepPerf(boolean time){
        return  returnSomaColuna(8, time);
    }
    public int totalRecepOk(boolean time){
        return  returnSomaColuna(9, time);
    }
    public int totalRecepErro(boolean time){
        return  returnSomaColuna(10, time);
    }
    public int totalDefesa(boolean time){
        return  returnSomaColuna(11, time);
    }
    public int totalErrDefesa(boolean time){
        return  returnSomaColuna(12, time);
    }
    public double desvioPadraoAtks(boolean time){
        double variancia = 0, media;

        media = totalPtsAtaque(time)/5;
        for(int i=0;i<5;i++){
            if(time)
                variancia += Math.pow(((double)(pontB[i][0]+pontB[i][3]+pontB[i][5]))-media,2);
            else
                variancia += Math.pow(((double)(pontA[i][0]+pontA[i][3]+pontA[i][5]))-media,2);
        }
        variancia = variancia/5;

        return  Math.sqrt(variancia);
    }


    public void registraPontos(Jogador[] plyrs, Jogador[] plyrs2){
        /*[0]blocks  ; [1]tent. blocks ; [2]errs de block ; [3]pts de saque ; [4]erros de saque
          [5]pts de ataque; [6]tent. de ataques; [7]err de atk; [8]recepcao perfeitas;
          [9]recp. okay ; [10]err de recep; [11]defesa ; [12]erro de defesa

          2 ponteiros, 1 oposto, 2 centrais, 1 levantador, 1 libero
        */
        for (int i=0;i<7;i++){
            if ((plyrs[i] instanceof Libero)) { //so defende
                ((Libero) plyrs[i]).setRecepcao(pontA[6][9], pontA[6][8],pontA[6][10]);
                ((Libero) plyrs[i]).setDefesas(pontA[6][11], pontA[6][12]);

            }else if ((plyrs[i] instanceof Atacante)) { //defende, ataca, bloqueia, saca
                if(plyrs[i].getPosicao().equals("Ponteiro")){
                    ((Atacante) plyrs[i]).setSaque(pontA[i%2][3], pontA[i%2][4]);

                    ((Atacante) plyrs[i]).setBloqueio(pontA[i%2][0], pontA[i%2][2]);

                    ((Atacante) plyrs[i]).setAtaque(pontA[i%2][5], pontA[i%2][7]);

                    ((Atacante) plyrs[i]).setRecepcao(pontA[i%2][9], pontA[i%2][8],pontA[i%2][10]);
                    ((Atacante) plyrs[i]).setDefesas(pontA[i%2][11], pontA[i%2][12]);
                }else if(plyrs[i].getPosicao().equals("Central")){
                    ((Atacante) plyrs[i]).setSaque(pontA[3+(i%2)][3], pontA[3+(i%2)][4]);

                    ((Atacante) plyrs[i]).setBloqueio(pontA[3+(i%2)][0], pontA[3+(i%2)][2]);

                    ((Atacante) plyrs[i]).setAtaque(pontA[3+(i%2)][5], pontA[3+(i%2)][7]);

                    ((Atacante) plyrs[i]).setRecepcao(pontA[3+(i%2)][9], pontA[3+(i%2)][8],pontA[3+(i%2)][10]);
                    ((Atacante) plyrs[i]).setDefesas(pontA[3+(i%2)][11], pontA[3+(i%2)][12]);
                }else{ // Oposto
                    ((Atacante) plyrs[i]).setSaque(pontA[2][3], pontA[2][4]);

                    ((Atacante) plyrs[i]).setBloqueio(pontA[2][0], pontA[2][2]);

                    ((Atacante) plyrs[i]).setAtaque(pontA[2][5], pontA[2][7]);

                    ((Atacante) plyrs[i]).setRecepcao(pontA[2][9], pontA[2][8],pontA[2][10]);
                    ((Atacante) plyrs[i]).setDefesas(pontA[2][11], pontA[2][12]);
                }
            }else if ((plyrs[i] instanceof Levantador)) { //defende, ataca, bloqueia, saca, levanta
                ((Levantador) plyrs[i]).setSaque(pontA[5][3], pontA[5][4]);

                ((Levantador) plyrs[i]).setBloqueio(pontA[5][0], pontA[5][2]);

                ((Levantador) plyrs[i]).setAtaque(pontA[5][5], pontA[5][7]);

                ((Levantador) plyrs[i]).setDistri(desvioPadraoAtks(false));
                ((Levantador) plyrs[i]).setEfic( ((double)(totalPtsAtaque(false))/(double)totalAtaque(false)));

                ((Levantador) plyrs[i]).setRecepcao(pontA[5][9], pontA[5][8],pontA[5][10]);
                ((Levantador) plyrs[i]).setDefesas(pontA[5][11], pontA[5][12]);
            }

            //time2
            if ((plyrs2[i] instanceof Libero)) { //so defende
                ((Libero) plyrs2[i]).setRecepcao(pontA[6][9], pontA[6][8],pontA[6][10]);
                ((Libero) plyrs[i]).setDefesas(pontA[6][11], pontA[6][12]);

            }else if ((plyrs2[i] instanceof Atacante)) { //defende, ataca, bloqueia, saca
                if(plyrs2[i].getPosicao().equals("Ponteiro")){
                    ((Atacante) plyrs2[i]).setSaque(pontB[i%2][3], pontB[i%2][4]);

                    ((Atacante) plyrs2[i]).setBloqueio(pontB[i%2][0], pontB[i%2][2]);

                    ((Atacante) plyrs2[i]).setAtaque(pontB[i%2][5], pontB[i%2][7]);

                    ((Atacante) plyrs2[i]).setRecepcao(pontB[i%2][9], pontB[i%2][8],pontB[i%2][10]);
                    ((Atacante) plyrs2[i]).setDefesas(pontB[i%2][11], pontB[i%2][12]);
                }else if(plyrs2[i].getPosicao().equals("Central")){
                    ((Atacante) plyrs2[i]).setSaque(pontB[3+(i%2)][3], pontB[3+(i%2)][4]);

                    ((Atacante) plyrs2[i]).setBloqueio(pontB[3+(i%2)][0], pontB[3+(i%2)][2]);

                    ((Atacante) plyrs2[i]).setAtaque(pontB[3+(i%2)][5], pontB[3+(i%2)][7]);

                    ((Atacante) plyrs2[i]).setRecepcao(pontB[3+(i%2)][9], pontB[3+(i%2)][8],pontB[3+(i%2)][10]);
                    ((Atacante) plyrs2[i]).setDefesas(pontB[3+(i%2)][11], pontB[3+(i%2)][12]);
                }else{ // Oposto
                    ((Atacante) plyrs2[i]).setSaque(pontB[2][3], pontB[2][4]);

                    ((Atacante) plyrs2[i]).setBloqueio(pontB[2][0], pontB[2][2]);

                    ((Atacante) plyrs2[i]).setAtaque(pontB[2][5], pontB[2][7]);

                    ((Atacante) plyrs2[i]).setRecepcao(pontB[2][9], pontB[2][8],pontB[2][10]);
                    ((Atacante) plyrs2[i]).setDefesas(pontB[2][11], pontB[2][12]);
                }
            }else if ((plyrs2[i] instanceof Levantador)) { //defende, ataca, bloqueia, saca, levanta
                ((Levantador) plyrs2[i]).setSaque(pontB[5][3], pontB[5][4]);

                ((Levantador) plyrs2[i]).setBloqueio(pontB[5][0], pontB[5][2]);

                ((Levantador) plyrs2[i]).setAtaque(pontB[5][5], pontB[5][7]);

                ((Levantador) plyrs2[i]).setDistri(desvioPadraoAtks(true));
                ((Levantador) plyrs2[i]).setEfic( ((double)(totalPtsAtaque(true))/(double)totalAtaque(true)));

                ((Levantador) plyrs2[i]).setRecepcao(pontB[5][9], pontB[5][8],pontA[5][10]);
                ((Levantador) plyrs2[i]).setDefesas(pontB[5][11], pontB[5][12]);
            }
        }
    }

}
