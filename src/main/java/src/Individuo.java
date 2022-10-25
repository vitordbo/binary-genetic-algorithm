/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package src;

/**
 *
 * @author vitor
 */
public class Individuo {
    int[] valor; // valor do individuo
    char[] cromossomos; // binario 
    int pontuacao; // para saber quem é o melhor individuo

    // cria a partir de um valor recebindo => v = valor do individou em decimal => "seu id"
    public Individuo(int x, int y){
        this.valor[0] = x;
        this.valor[1] = y;

        this.cromossomos = new char[5];
        //calcPoints();
    }

    // caso o crossover passe
    public void ajustaValor(){
        if(this.valor[0] > 7){
            this.valor[0] = 7;
        }
        if(this.valor[1] > 7){
            this.valor[1] = 7;
        }
        if(this.valor[0] < 0){
            this.valor[0] = 0;
        }
        if(this.valor[1] < 0){
            this.valor[1] = 0;
        }
    }

    public void showIndividuos(){
        System.out.println("Valor [0] " + this.valor[0]);
        System.out.println("Valor [1] " + this.valor[1]);
        System.out.println("Cromossomos " + this.cromossomos);
        System.out.println("Pontuação " + this.pontuacao);
        System.out.println("--------------------------------");
    }

}
