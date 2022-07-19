package com.cartola.classes;

public class User {
    private Equipe team;
    private double ptTotal;
    private double ptRodada;
    private double din;


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
        this.ptTotal = ptTotal;
    }

    public double getPtRodada() {
        return ptRodada;
    }
    public void setPtRodada(double ptRodada) {
        this.ptRodada = ptRodada;
    }

    public double getDinheiro() {
        return din;
    }
    public void setDinheiro(double din) {
        this.din = din;
    }
}
