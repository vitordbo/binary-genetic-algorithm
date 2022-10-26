/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package src;

import java.util.ArrayList;
import java.util.Random;

/**
 *
 * @author vitor
 */
public class AlgoritmoGenetico {
    Individuo melhorIndividuo;
    ArrayList<Individuo> populacao;

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
        this.populacao = new ArrayList<>();

        int gerarRand; 
        int range = (maxFuncao -  minFuncao) + 1; 
        
        for(int i = 0; i<this.numIndividuos; i++){
            gerarRand = ((int) (Math.random() * range) + minFuncao);
            this.populacao.add(new Individuo(gerarRand));
        }

        this.guardaMelhorIndividuo();
    }


    // construtor algoritmo genetico => define as taxas de tudo => const com matriz
    public AlgoritmoGenetico(int numIndividuos,int numGeracoes,int taxaCrossover,int taxaMutacao) {
        this.numIndividuos = numIndividuos;
        this.numGeracoes = numGeracoes;
        this.taxaCrossover = taxaCrossover;
        this.taxaMutacao = taxaMutacao;
        this.populacao = new ArrayList<>();

        int gerarRand1, gerarRand2; 
        int range = (maxFuncao -  minFuncao) + 1; 
        
        for(int i = 0; i<this.numIndividuos; i++){
            gerarRand1 = ((int) (Math.random() * range) + minFuncao);
            gerarRand2 = ((int) (Math.random() * range) + minFuncao);
            this.populacao.add(new Individuo(gerarRand1, gerarRand2));
        }

        this.guardaMelhorIndividuo();
    }

    // faz o crossover de dois individuos de acordo com a probabilidade fornecida
    public ArrayList<Individuo> fazCrossOver(Individuo indi1, Individuo ind2){
    
        int ptCorte = 3;
        char[] aux1 = new char[5];
        char[] aux2 = new char [5];
        
        ArrayList<Individuo> retorno = new ArrayList<>();
        Individuo filho1;
        Individuo filho2;

        Random random = new Random ();
        int rand = random.nextInt(100);

        if(rand < this.taxaCrossover){
            //faz crossover
            for (int i=0; i<5; i++) {
                if (i <ptCorte) {
                    aux1[i] = indi1.cromossomos[i];
                    aux2[i] = ind2.cromossomos[i];
                }else{
                    aux1[i] = ind2.cromossomos[i];
                    aux2[i] = indi1.cromossomos[i];
                }
            }
            filho1 = new Individuo(aux1);
            filho2 = new Individuo(aux2);
            filho1.ajustaValor();
            filho2.ajustaValor();
            retorno.add(filho1);
            retorno.add(filho2);
        }else{         
            // retorna os mesmo individuos
            retorno.add(indi1);
            retorno.add(ind2);
        }
        return retorno;
    }

        public Individuo selecaoPorClassificacao(Individuo indi1, Individuo indi2){
            if (indi1.pontuacao >indi2.pontuacao){
                return indi1;
            }else{
                return indi2;
            }
        }

    public Individuo torneio() { // out of bounds 
        Individuo Individuol;
        Individuo Individuo2;
        int rand1;
        int rand2;

        rand1 = ((int) (Math.random() * this.numIndividuos));
        Individuol = new Individuo(this.populacao.get(rand1).valor);
        do{
            rand2 = ((int) (Math.random() * this.numIndividuos));
        }while(rand2 == rand1);
           
        Individuo2 = new Individuo (this.populacao.get(rand2).valor);
        if (Individuol.pontuacao > Individuo2.pontuacao) {
            return Individuol;
        }else{
            return Individuo2;
        }
    }

    /*
    * metodo criar nova geracao
    * cria nova geracao e sobrescreve a geracao atual
    */
    public void novaGeracao() {
        ArrayList<Individuo> novaGeracao = new ArrayList<>(); 
        ArrayList<Individuo> aux = new ArrayList<>(); 
        

        int rand1, rand2;
        rand1 = ((int) (Math.random() * this.numIndividuos)); 
        rand2 = ((int) (Math.random() * this.numIndividuos));
        
        Individuo pai1 = new Individuo(this.populacao.get(rand1).valor);
        Individuo pai2 =new Individuo(this.populacao.get(rand2).valor); 
        Individuo novoIndividuo;

        while (novaGeracao.size() < this.numIndividuos){
            aux.clear();
            novoIndividuo = this.selecaoPorClassificacao(pai1,pai2);
            aux = this.fazCrossOver(pai1, pai2);

            for (Individuo it : aux){
                novoIndividuo = new Individuo(it.valor, it.valor);
                novoIndividuo.aplicaMutacao(this.taxaMutacao);
                novaGeracao.add(novoIndividuo);
            }
            this.populacao = novaGeracao; 
            this.guardaMelhorIndividuo();
        }
    }

    public void guardaMelhorIndividuo(){
        if(this.melhorIndividuo==null){
            this.melhorIndividuo = new Individuo(this.populacao.get(0).valor);
        }else{
            for(Individuo it: this.populacao){
                if(it.valor < this.melhorIndividuo.valor){
                    melhorIndividuo = new Individuo(it.valor);
                }
            }   
        }
    }

    public void imprimeGeracao(){
        System.out.println("-----------------------------");
        System.out.println("Num individuos: "  + this.numIndividuos);
        System.out.println("Num geracoes: " + this.numGeracoes);
        System.out.println("Populacao toString "  + this.populacao.toString());
        System.out.println("Melhor indi valor " + this.melhorIndividuo.valor);
        System.out.println("-----------------------------");
    }

    public void imprimeMelhorIndividuo(){
        System.out.println("-----------------------------");
        System.out.println("Melhor indi pontuação " + this.melhorIndividuo.pontuacao);
        System.out.println("Melhor indi cromossomos toString " +this.melhorIndividuo.cromossomos.toString());
        //System.out.println("Melhor indi valorMat " +this.melhorIndividuo.valorMat.toString());
        System.out.println("-----------------------------");
    }
}

