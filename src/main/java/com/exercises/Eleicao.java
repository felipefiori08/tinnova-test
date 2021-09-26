package com.exercises;

import java.math.RoundingMode;
import java.text.DecimalFormat;

public class Eleicao {
    private int totalDeEleitores;
    private int votosValidos;
    private int votosEmBranco;
    private int votosNulos;

    public Eleicao(){}

    public Eleicao(int votosValidos, int votosEmBranco, int votosNulos) {
        this.votosValidos = votosValidos;
        this.votosEmBranco = votosEmBranco;
        this.votosNulos = votosNulos;
    }

    public int getTotalDeEleitores() {
        return this.votosValidos+this.votosEmBranco+this.votosNulos;
    }

    public void setTotalDeEleitores(int totalDeEleitores) {
        this.totalDeEleitores = totalDeEleitores;
    }

    public int getVotosValidos() {
        return this.votosValidos;
    }

    public void setVotosValidos(int votosValidos) {
        this.votosValidos = votosValidos;
    }

    public int getVotosEmBranco() {
        return this.votosEmBranco;
    }

    public void setVotosEmBranco(int votosEmBranco) {
        this.votosEmBranco = votosEmBranco;
    }

    public int getVotosNulos() {
        return this.votosNulos;
    }

    public void setVotosNulos(int votosNulos) {
        this.votosNulos = votosNulos;
    }

    public String percentualDeVotosValidos (){
       double percentualDeVotosValidos = this.getVotosValidos() * 100.0 /  this.getTotalDeEleitores();
       DecimalFormat df = new DecimalFormat("0.00");
       df.setRoundingMode(RoundingMode.HALF_UP);

       return df.format(percentualDeVotosValidos);
    }
    
    public String percentualDeVotosEmBranco (){
        double percentualDeVotosEmBranco = this.getVotosEmBranco() * 100.0 /  this.getTotalDeEleitores();
        DecimalFormat df = new DecimalFormat("0.00");
        df.setRoundingMode(RoundingMode.HALF_UP);

        return df.format(percentualDeVotosEmBranco);
    }
    

    public String percentualDeVotosNulos (){
        double percentualDeVotosNulos = this.getVotosNulos() * 100.0 /  this.getTotalDeEleitores();
        DecimalFormat df = new DecimalFormat("0.00");
        df.setRoundingMode(RoundingMode.HALF_UP);
 
        return df.format(percentualDeVotosNulos);
    }
}
