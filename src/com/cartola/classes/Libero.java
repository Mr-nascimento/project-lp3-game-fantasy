package com.cartola.classes;

public class Libero extends Jogador{
    private short recepPerf;
    private short recepReg, recepErr;
    private short def, errDef;

    public Libero(boolean modo){
        super(modo, "com.cartola.classes.Libero");
        recepPerf = 0;
        recepReg = 0;
        recepErr = 0;
        def = 0;
        errDef = 0;
    }
    public Libero(int id, String nome, byte numero, String posicao, String time) {
        super( id, nome, numero, posicao, time);
    }

    public double calcPonto(){
        double ptsRec, ptsDef, pts;

        ptsRec = (recepPerf * 0.4) + (((recepReg-recepErr-recepPerf) - recepErr) * 0.2);
        ptsDef =  (def - errDef) * 0.5;
        pts = ptsRec + ptsDef;

        return  pts;
    }

    public String imprimeJogador(){
        return super.imprimeJogador(4);
    }

    public short getRecepPerf() {
        return recepPerf;
    }
    public void setRecepPerf(short recepPerf) {
        this.recepPerf = recepPerf;
    }

    public short getRecepReg() {
        return recepReg;
    }
    public void setRecepReg(short recepReg) {
        this.recepReg = recepReg;
    }

    public short getRecepErr() {
        return recepErr;
    }
    public void setRecepErr(short recepErr) {
        this.recepErr = recepErr;
    }

    public void setRecepcao(short recReg, short recPerf, short recErr){
        recepPerf = recPerf;
        recepReg = recReg;
        recepErr = recErr;
    }

    public short getDef() {
        return def;
    }
    public void setDef(short def) {
        this.def = def;
    }

    public short getErrDef() {
        return errDef;
    }
    public void setErrDef(short errDef) {
        this.errDef = errDef;
    }

    public void setDefesas(short def, short errDef){
        this.def = def;
        this.errDef = errDef;
    }

    public void setAtaque(short Atk, short tentAtk, short errAtk){
        return;
    }
    public void setSaque(short saque, short errSaque){
        return;
    }
    public void setBloqueio(short bck, short errBlock){
        return;
    }

}
