package com.exercises;

import java.util.List;

public class BubbleSort {
    
    public BubbleSort(){}

    public BubbleSort(int[] listaQueSeraOrdenada){
        this.listaQueSeraOrdenada = listaQueSeraOrdenada;
    }

    private int [] listaQueSeraOrdenada;


    public int[] getListaQueSeraOrdenada() {
        return this.listaQueSeraOrdenada;
    }

    public void setListaQueSeraOrdenada(int[] listaQueSeraOrdenada) {
        this.listaQueSeraOrdenada = listaQueSeraOrdenada;
    }

    public int getTamanhoListaQueSeraOrdenada() {
        return this.listaQueSeraOrdenada.length;
    }

   

//{5, 3, 2, 4, 7, 1, 0, 6}
    public void ordenarListaBubbleSort(){
        boolean percorreuTodosOsLacosNecessarios = false;
        int limiteDeInteracoes = this.getTamanhoListaQueSeraOrdenada();

        while(!percorreuTodosOsLacosNecessarios){

            for(int a = 0; a < limiteDeInteracoes-1; a++){
                int primeiroNumero = this.listaQueSeraOrdenada[a];
                int segundoNumero = this.listaQueSeraOrdenada[a+1];

                int numeroAuxiliarParaTroca;

                if(primeiroNumero > segundoNumero){

                    numeroAuxiliarParaTroca = primeiroNumero;
                    primeiroNumero = segundoNumero;
                    segundoNumero = numeroAuxiliarParaTroca;

                    listaQueSeraOrdenada[a] = primeiroNumero;
                    listaQueSeraOrdenada[a+1] = segundoNumero;

                }
            }

           if(limiteDeInteracoes > 1){
               limiteDeInteracoes --;
           }else{
               percorreuTodosOsLacosNecessarios = true;
           }

        }   
        
        this.imprimeListaOrdenada();

    }

    public void imprimeListaOrdenada(){
        String lista = "[";
        for (int i = 0; i < this.getTamanhoListaQueSeraOrdenada(); i++) {
            lista+=listaQueSeraOrdenada[i];

            lista += i+1 < this.getTamanhoListaQueSeraOrdenada() ? ", " : "";
        }
 
        lista+="]";
        System.out.println(lista);
    }
}
