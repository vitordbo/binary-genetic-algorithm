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
    ArrayList<Individuo> individuos;

    // valores
    int minFun = 0;
    int maxFun = 7;
    int numIndividuos;
    int numGeracoes;
    int taxaCrossover;
    int taxaMutacao;
}
