package com.cartola.classes;

public class Atacante extends Jogador {
    private short atk, errAtk, tentAtk;
    private short block, errBlock;
    private short saque, errSaque;
    private short recepPerf;
    private short recepReg, recepErr;
    private short def, errDef;

    public Atacante(boolean modo, String posicao){
            super(modo, posicao);
            atk = 0;
            errAtk = 0;
            tentAtk = 0;
            block = 0;
            errBlock = 0;
            saque = 0;
            errSaque = 0;
            recepPerf = 0;
            recepReg = 0;
            recepErr = 0;
            def = 0;
            errDef = 0;

    }
    public Atacante(int id, String nome, byte numero, String posicao, String time){
        super(id, nome, numero, posicao,time);
    }

    public double calcPonto(){
        double ptsAtks, ptsBlck, ptsSaque, ptsDef, ptsRec;
        double pts;

        ptsAtks = atk - (errAtk * 0.5);
        ptsBlck= (block * 2) - (errBlock * 0.5);
        ptsSaque = (saque * 2) - (errSaque * 0.5);
        ptsDef = (def - errDef) * 0.4;
        ptsRec = (recepPerf * 0.4) +(((recepReg-recepErr-recepPerf) - recepErr) * 0.1);

        pts = ptsAtks + ptsBlck + ptsSaque + ptsDef + ptsRec;

        return pts;
    }

    public String imprimeJogador(){
        return super.imprimeJogador(4);
    }

    public short getAtk() {
        return atk;
    }
    public void setAtk(short atk) {
        this.atk = atk;
    }
    public short getErrAtk() {
        return errAtk;
    }
    public void setErrAtk(short errAtk) {
        this.errAtk = errAtk;
    }
    public short getTentAtk() {
        return tentAtk;
    }
    public void setTentAtk(short tentAtk) {
        this.tentAtk = tentAtk;
    }
    public void setAtaque(short Atk,short tentAtk,short errAtk){
        this.atk = Atk;
        this.tentAtk = tentAtk;
        this.errAtk = errAtk;
    }

    public short getBlock() {
        return block;
    }
    public void setBlock(short block) {
        this.block = block;
    }
    public short getErrBlock() {
        return errBlock;
    }
    public void setErrBlock(short errBlo) {
        this.errBlock = errBlo;
    }
    public void setBloqueio(short bck, short errBlock) {
        this.errBlock = errBlock;
        block = bck;
    }

    public short getSaque() {
        return saque;
    }
    public void setSaque(short saque) {
        this.saque = saque;
    }
    public short getErrSaque() {
        return errSaque;
    }
    public void setErrSaque(short errSaque) {
        this.errSaque = errSaque;
    }
    public void setSaque(short saque, short errSaque){
        this.saque = saque;
        this.errSaque = errSaque;
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


}
