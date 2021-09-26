package com.exercises;

public class Fatorial {
    public Fatorial(){}

    public Fatorial(int numeroBase){
        this.numeroBase = numeroBase;
    }

    private int numeroBase;

    public int getNumeroBase() {
        return this.numeroBase;
    }

    public void setNumeroBase(int numeroBase) {
        this.numeroBase = numeroBase;
    }

    public void calculaFatorialNumeroBase(){
        int resultado = 1;
        if(this.numeroBase > 1) {
            
            resultado = this.numeroBase;
            for(int a = this.numeroBase-1; a > 1; a--){
                resultado = resultado*a;
            }
        }

        System.out.println("O fatorial de "+this.numeroBase+" é "+resultado);


    }
}
