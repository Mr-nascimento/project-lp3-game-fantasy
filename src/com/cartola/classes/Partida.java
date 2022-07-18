package com.cartola.classes;

public class Partida {
    private int idPart, idTime1, idTime2;
    private byte res1, res2;
    String desc;
    String ganhador;

    public Partida(int idPart, int idTime1, int idTime2, byte res1, byte res2, String desc, String ganhador) {
        this.idPart = idPart;
        this.idTime1 = idTime1;
        this.idTime2 = idTime2;
        this.res1 = res1;
        this.res2 = res2;
        this.desc = desc;
        this.ganhador = ganhador;
    }
    public Partida(int idPart, int idTime1, int idTime2, String desc) {
        this(idPart, idTime1, idTime2,(byte) 0, (byte)0, desc, null);
    }

    public int getIdTime1() {
        return idTime1;
    }
    public void setIdTime1(int idTime1) {
        this.idTime1 = idTime1;
    }

    public int getIdTime2() {
        return idTime2;
    }
    public void setIdTime2(int idTime2) {
        this.idTime2 = idTime2;
    }

    public int getIdPart() {
        return idPart;
    }
    public void setIdPart(int idPart) {
        this.idPart = idPart;
    }

    public byte getRes1() {
        return res1;
    }
    public void setRes1(byte res1) {
        this.res1 = res1;
    }

    public byte getRes2() {
        return res2;
    }
    public void setRes2(byte res2) {
        this.res2 = res2;
    }

    public String getDesc() {
        return desc;
    }
    public void setDesc(String desc) {
        this.desc = desc;
    }

    public String getGanhador() {
        return ganhador;
    }
    public void setGanhador(String ganhador) {
        this.ganhador = ganhador;
    }
}
