/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package src;

import java.util.ArrayList;

/**
 *
 * @author vitor
 */
public class AlgoritmoGenetico {
    Individuo melhorIndividuo;
    int[] individuos;

    // valores
    int minFuncao;
    int maxFuncao;
    int numIndividuos;
    int numGeracoes;
    int taxaCrossover;
    int taxaMutacao;

    // construtor algoritmo genetico => define as taxas de tudo 
    public AlgoritmoGenetico(int minFuncao,int maxFuncao,int numIndividuos,int numGeracoes,int taxaCrossover,int taxaMutacao) {
        this.minFuncao = minFuncao;
        this.maxFuncao = maxFuncao;
        this.numIndividuos = numIndividuos;
        this.numGeracoes = numGeracoes;
        this.taxaCrossover = taxaCrossover;
        this.taxaMutacao = taxaMutacao;

        //this.individuos = new ArrayList<>();
        int gerarRandX, gerarRandY;  
        int range = (maxFuncao -  minFuncao) + 1; 
        for(int i = 0; i<this.numIndividuos; i++){
            gerarRandX = ((int) (Math.random() * range) + minFuncao);
            gerarRandY = ((int) (Math.random() * range) + minFuncao);
            //this.individuos.add(new Individuo(gerarRandX, gerarRandY));
            individuos[0] = gerarRandX;
            individuos[1] = gerarRandY;
        }
    }


}
