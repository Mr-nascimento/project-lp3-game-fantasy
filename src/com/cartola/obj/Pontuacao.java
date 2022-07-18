package com.cartola.obj;

public class Pontuacao {
    private int id_partida;
	private int id_jogador;
	private short pts_ataque, tent_ataque, err_ataque;
	private short pts_block, tent_block, err_block;
	private short pts_saque, err_saque;
	private short perf_recep, bom_recep, err_recep;
	private short defesa, err_defesa;

    public Pontuacao(int id_partida, int id_jogador, short pts_ataque, short tent_ataque, short err_ataque,
                     short pts_block, short tent_block, short err_block,short pts_saque, short err_saque, short perf_recep,
                     short bom_recep, short err_recep, short defesa, short err_defesa) {
        this.id_partida = id_partida;
        this.id_jogador = id_jogador;
        this.pts_ataque = pts_ataque;
        this.tent_ataque = tent_ataque;
        this.err_ataque = err_ataque;
        this.pts_block = pts_block;
        this.tent_block = tent_block;
        this.err_block = err_block;
        this.pts_saque = pts_saque;
        this.err_saque = err_saque;
        this.perf_recep = perf_recep;
        this.bom_recep = bom_recep;
        this.err_recep = err_recep;
        this.defesa = defesa;
        this.err_defesa = err_defesa;
    }

    public int getId_partida() {
        return id_partida;
    }
    public void setId_partida(int id_partida) {
        this.id_partida = id_partida;
    }

    public int getId_jogador() {
        return id_jogador;
    }
    public void setId_jogador(int id_jogador) {
        this.id_jogador = id_jogador;
    }

    public short getPts_ataque() {
        return pts_ataque;
    }
    public void setPts_ataque(short pts_ataque) {
        this.pts_ataque = pts_ataque;
    }

    public short getTent_ataque() {
        return tent_ataque;
    }
    public void setTent_ataque(short tent_ataque) {
        this.tent_ataque = tent_ataque;
    }

    public short getErr_ataque() {
        return err_ataque;
    }
    public void setErr_ataque(short err_ataque) {
        this.err_ataque = err_ataque;
    }

    public short getPts_block() {
        return pts_block;
    }
    public void setPts_block(short pts_block) {
        this.pts_block = pts_block;
    }

    public short getTent_block() {
        return tent_block;
    }
    public void setTent_block(short tent_block) {
        this.tent_block = tent_block;
    }

    public short getErr_block() {
        return err_block;
    }
    public void setErr_block(short err_block) {
        this.err_block = err_block;
    }

    public short getPts_saque() {
        return pts_saque;
    }
    public void setPts_saque(short pts_saque) {
        this.pts_saque = pts_saque;
    }

    public short getErr_saque() {
        return err_saque;
    }
    public void setErr_saque(short err_saque) {
        this.err_saque = err_saque;
    }

    public short getPerf_recep() {
        return perf_recep;
    }
    public void setPerf_recep(short perf_recep) {
        this.perf_recep = perf_recep;
    }

    public short getBom_recep() {
        return bom_recep;
    }
    public void setBom_recep(short bom_recep) {
        this.bom_recep = bom_recep;
    }

    public short getErr_recep() {
        return err_recep;
    }
    public void setErr_recep(short err_recep) {
        this.err_recep = err_recep;
    }

    public short getDefesa() {
        return defesa;
    }
    public void setDefesa(short defesa) {
        this.defesa = defesa;
    }

    public short getErr_defesa() {
        return err_defesa;
    }
    public void setErr_defesa(short err_defesa) {
        this.err_defesa = err_defesa;
    }
}
