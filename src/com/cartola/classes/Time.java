package com.cartola.classes;

public class Time {
    private int id;
    private String nome;
    private String sigla;

    public Time(){
        id = 0;
        nome = null;
        sigla = "XXX";
    }
    public Time(Time outroTime){
        this(outroTime.id, outroTime.nome, outroTime.sigla);
    }
    public Time(int id, String nome, String sigla) {
        this.id = id;
        this.nome = nome;
        this.sigla = sigla;
    }

    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }
    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getSigla() {
        return sigla;
    }
    public void setSigla(String sigla) {
        this.sigla = sigla;
    }
}
