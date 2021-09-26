package com.runner;
import com.exercises.*;

public class ExerciciosExecutados {
   
    
    public static void main(String[] args) {
      System.out.println("Exercício 1");

      Eleicao eleicao = new Eleicao(350, 757, 125);
      
      System.out.println("Total de Eleitores: "+eleicao.getTotalDeEleitores());
      System.out.println("Total de Votos Válidos: "+eleicao.getVotosValidos());
      System.out.println("Total de Votos em Branco: "+eleicao.getVotosEmBranco());
      System.out.println("Total de Votos Nulos: "+eleicao.getVotosNulos());

      System.out.println("Percentual de Votos Válidos: "+eleicao.percentualDeVotosValidos()+"%");
      System.out.println("Percentual de Votos em Branco: "+eleicao.percentualDeVotosEmBranco()+"%");
      System.out.println("Percentual de Votos Nulos: "+eleicao.percentualDeVotosNulos()+" %"); 


      System.out.println("Exercício 2");

      int listaQueSeraOrdenada[] = {5, 3, 2, 4, 7, 1, 0, 6, 8, 3, 21, 0};
      BubbleSort bubbleSort = new BubbleSort(listaQueSeraOrdenada);
      bubbleSort.ordenarListaBubbleSort();

      System.out.println("Exercício 3");
      Fatorial fatorial = new Fatorial(7);
      fatorial.calculaFatorialNumeroBase();

      System.out.println("Exercício 4");
      SomaMultiplos somaMultiplos = new SomaMultiplos(9);
      somaMultiplos.somaMultiplosdeTresOuCinco();

      
    }
}
