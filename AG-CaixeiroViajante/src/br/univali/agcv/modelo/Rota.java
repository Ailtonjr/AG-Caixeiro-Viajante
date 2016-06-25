package br.univali.agcv.modelo;

import java.util.ArrayList;
import java.util.List;

public class Rota {
    private List<Integer> sequencia;
    private double distanciaPercorrida = 0;
    private double fitness;

    public Rota(int qtdCidades) {
        sequencia = new ArrayList();
        for (int i=0; i < qtdCidades; i++) {
            sequencia.add(i);
        }
    }
    
    public Rota() {
        sequencia = new ArrayList();
    }
    
    public void calculaDistancia(double[][] matrizDistancias) {
        for (int i=1; i < sequencia.size(); i++) {  //  Comeca em 1 para para nao acontecer nullPointer
            if (sequencia.get(i-1) >= sequencia.get(i)) {   //  Regra para pegar a diagonal superior da matriz
                distanciaPercorrida += matrizDistancias[sequencia.get(i)][sequencia.get(i-1)];
            } else {
                distanciaPercorrida += matrizDistancias[sequencia.get(i-1)][sequencia.get(i)];
            }
        }
        fitness = 1/distanciaPercorrida;    //  Calcula o fitness da rota
    }
    
    public void exibeRota() {
        for (Integer s : sequencia) {
            System.out.print(s + "\t");
        }
        System.out.println("|" + "Distancia:" + distanciaPercorrida);
    }

    public List<Integer> getSequencia() {
        return sequencia;
    }

    public void setSequencia(List<Integer> sequencia) {
        this.sequencia = sequencia;
    }

    public double getDistanciaPercorrida() {
        return distanciaPercorrida;
    }

    public void setDistanciaPercorrida(double distanciaPercorrida) {
        this.distanciaPercorrida = distanciaPercorrida;
    }

    public double getFitness() {
        return fitness;
    }

    public void setFitness(double fitness) {
        this.fitness = fitness;
    }
    
    
    
}
