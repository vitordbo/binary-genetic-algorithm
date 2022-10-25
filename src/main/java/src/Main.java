/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package src;

/**
 *
 * @author vitor
 */
public class Main {
    public static void main(String[] args) {
        
        // valores
       int minFuncao = 0;
       int maxFuncao = 7;
       int numIndividuos = 5;
       int numGeracoes = 5;
       int taxaCrossover = 60;
       int taxaMutacao = 1;

       AlgoritmoGenetico algoritmo = new AlgoritmoGenetico(minFuncao, maxFuncao, numIndividuos, numGeracoes, taxaCrossover, taxaMutacao);
       AlgoritmoGenetico algoritmo2 = new AlgoritmoGenetico(minFuncao, maxFuncao, numIndividuos, numGeracoes, taxaCrossover, taxaMutacao);

        System.out.println("******************");
        System.out.println("Geração inicial");
        System.out.println("******************");
        
        int x = algoritmo.individuos[0];
        int y = algoritmo.individuos[1];

        int x1 = algoritmo2.individuos[0];
        int y1 = algoritmo2.individuos[1];

        // testar se gera os individuos entre 0 e 7
        System.out.println("Primeiro individuo x = " + x + " ,y =  " + y);
        System.out.println("Primeiro individuo x = " + x1 + " ,y =  " + y1);
        //algoritmo => mostrar geração
        // algoritmo => gerar geração => melhor pontuação? => dois melhores pra cruzar => torneio? => crossOver
        // chance de ter mutaçao 
        
        //for para gerações
        // mostrar melhores 
    }
}
