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

    /*  
        instruções
        x, y [0, 7]
        pop inicial = 4 
        mutação taxa 1%
        crossOver 70%
    */
        
        // valores
       int minFuncao = 0;
       int maxFuncao = 7;
       int numIndividuos = 5;
       int numGeracoes = 5;
       int taxaCrossover = 60;
       int taxaMutacao = 1;

       AlgoritmoGenetico algoritmo = new AlgoritmoGenetico(minFuncao, maxFuncao, numIndividuos, numGeracoes, taxaCrossover, taxaMutacao);

        System.out.println("******************");
        System.out.println("Geração inicial");
        System.out.println("******************");

        algoritmo.imprimeGeracao();

        // cria as gerações fornecidas
        for (int i = 0; i< numGeracoes; i++){
            System.out.println("********************");
            System.out.println("Geracao " + (i + 1));
            System.out.println("********************");
        
            algoritmo.novaGeracao();
            algoritmo.imprimeGeracao();
        }

        //mostra o melhor individuo
        System.out.println("********************");
        System.out.println("Melhor individuo");
        System.out.println("********************");
        algoritmo.imprimeMelhorIndividuo();
    } 
}
