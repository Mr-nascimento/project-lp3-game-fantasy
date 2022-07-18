package com.cartola.classes;

public class User {
    private Equipe team;
    private double ptTotal;
    private double ptRodada;
    private double din;

    public User(){
        team = new Equipe();
        din = 100;
        ptTotal = 0;
        ptRodada = 0;
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
