package com.cartola.classes;

import com.cartola.classes.Atacante;
import com.cartola.classes.Levantador;
import com.cartola.classes.Libero;

public class Equipe {
    Atacante ctrl1, ctrl2;
    Atacante pont1, pont2;
    Atacante opost;
    Libero libr;
    Levantador lvnt;
    int capitao;
    String nome;

    public Equipe(){
        ctrl1 = new Atacante(false,"Central");
        ctrl2 = new Atacante(false,"Central");
        pont1 = new Atacante(false,"Ponteiro");
        pont2 = new Atacante(false,"Ponteiro");
        opost = new Atacante(false,"Oposto");
        libr = new Libero(false);
        lvnt = new Levantador(false);
        capitao = 0;
        nome = "Seu time";
    }

    public Atacante getCtrl1() {
        return ctrl1;
    }
    public void setCtrl1(Atacante ctrl1) {
        this.ctrl1 = ctrl1;
    }

    public Atacante getCtrl2() {
        return ctrl2;
    }
    public void setCtrl2(Atacante ctrl2) {
        this.ctrl2 = ctrl2;
    }

    public Atacante getPont1() {
        return pont1;
    }
    public void setPont1(Atacante pont1) {
        this.pont1 = pont1;
    }

    public Atacante getPont2() {
        return pont2;
    }
    public void setPont2(Atacante pont2) {
        this.pont2 = pont2;
    }

    public Atacante getOpost() {
        return opost;
    }
    public void setOpost(Atacante opost) {
        this.opost = opost;
    }

    public Libero getLibr() {
        return libr;
    }
    public void setLibr(Libero libr) {
        this.libr = libr;
    }

    public Levantador getLvnt() {
        return lvnt;
    }
    public void setLvnt(Levantador lvnt) {
        this.lvnt = lvnt;
    }

    public int getCapitao() {
        return capitao;
    }
    public void setCapitao(int capitao) {
        this.capitao = capitao;
    }

    public String getNome() {
        return nome;
    }
    public void setNome(String nome) {
        this.nome = nome;
    }
}
