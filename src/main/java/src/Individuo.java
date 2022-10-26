/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package src;

import java.util.Vector;

/**
 *
 * @author vitor
 */
public class Individuo {
    int valor; // valor do individuo => trocar para vetor ou matriz 
    int[][] valorMat; // valor matriz
    char[] cromossomos; // binario  
    int pontuacao; // para saber quem é o melhor individuo

    // cria a partir de um valor recebindo => v = valor do individou em decimal => "seu id"
    public Individuo(int x){ // recebendo x e y?
        this.valor = x;
        this.cromossomos = new char[5];
        calcPoints();
        toBinary();
    }

 // cria a partir de um valor recebindo => v = valor do individou em decimal => "seu id"
    public Individuo(int x, int y){ // recebendo x e y?
        this.valorMat[0][0] = x;
        this.valorMat[1][1] = y;
        this.cromossomos = new char[5];
        calcPointsMat(valorMat[0][0], valorMat[0][1]);
        toBinary();
    }

  // cria a partir dos cromossomos repetidos 
    public Individuo(char[] c){ // recebendo x e y?
        this.cromossomos = c;
        toInt();
        calcPoints();
    }

    private void calcPoints(){
        this.pontuacao = this.valor; // aqui entra a função => ajeitar
    }

    private void calcPointsMat(int x, int y){
        this.pontuacao = (int) Math.sqrt(Math.pow(x, 3) + 2 * (Math.pow(y, 4))); // aqui entra a função => ajeitar
    }


    // converte o int para binario => bit mais a esquerda => positivo ou negativo
    // menos significativos a direita
    private void toBinary(){
        int resultado = this.valor;
        if (this.valor >= 0){
            this.cromossomos[0] = (char) 0 + '0';
        }else{
            this.cromossomos[0] = (char)0+'1';
            resultado = resultado * (-1);
        }
        for(int i = (this.cromossomos.length)-1; i>=1; i--){
            this.cromossomos[i] = (char) ((resultado%2)+'0');
            resultado = resultado/2;
        }
    }

    private void toInt(){
        int pos;
        int resultado = 0;
        int v;

        for(int i =0; i<((this.cromossomos.length)-1);i++){
            pos = ((this.cromossomos.length)-1)-i;
            v = Character.getNumericValue(cromossomos[pos]);
            resultado = resultado + (v) * ((int) (Math.pow(2, i)));
        }
        if (this.cromossomos[0]=='1'){
            resultado = 0 - resultado;
        }
        this.valor = resultado;
    }

    // recebe chance => de acordo do random => troca os cromossomos 
    public void aplicaMutacao(int chance){
        int random = ((int) (Math.random() * 100))+1;
        if (random <= chance ){
            random = ((int) (Math.random() * 5));

            if(this.cromossomos[random] == '0'){
                this.cromossomos[random] = '1';
            }else{
                this.cromossomos[random] = '0';
            }
        } 
        this.toInt();
        this.ajustaValor();
        this.toBinary();
        this.calcPoints();
    }

    // caso o crossover passe
    public void ajustaValor(){
        if(this.valor > 7){
            this.valor = 7;
        }
        if(this.valor > 7){
            this.valor = 7;
        }
        if(this.valor < 0){
            this.valor = 0;
        }
        if(this.valor < 0){
            this.valor = 0;
        }
    }

    // caso o crossover passe
    public void ajustaValorMat(){
        if(this.valorMat[0][0] > 7){
            this.valorMat[0][0] = 7;
        }
        if(this.valorMat[0][1] > 7){
            this.valorMat[0][1] = 7;
        }
        if(this.valorMat[0][0] < 0){
            this.valorMat[0][0] = 0;
        }
        if(this.valorMat[0][1] < 0){
            this.valorMat[0][1] = 0;
        }
    }

    public void showIndividuos(){
        System.out.println("Valor " + this.valor);
        System.out.println("Cromossomos " + this.cromossomos);
        System.out.println("Pontuação " + this.pontuacao);
        System.out.println("--------------------------------");
    }
}

