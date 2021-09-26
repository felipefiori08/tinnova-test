package com.exercises;

public class SomaMultiplos {
    public SomaMultiplos(){}

    public SomaMultiplos(int numeroBase){
        this.numeroBase = numeroBase;
    }

    private int numeroBase;

    public void somaMultiplosdeTresOuCinco(){
        int soma = 0;
        for(int a = numeroBase; a>=3; a--){
            if(a % 3 == 0 || a % 5 == 0){
                soma+=a;
            }
        }

        System.out.println("A soma dos múltiplos de 3 e 5 a partir do número "+this.numeroBase+" é "+soma);
    }
}
