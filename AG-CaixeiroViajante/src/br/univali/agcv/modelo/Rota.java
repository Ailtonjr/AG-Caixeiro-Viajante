package br.univali.agcv.modelo;

import java.util.ArrayList;
import java.util.List;

public class Rota {
    private List<Integer> sequencia;
    private double distanciaPercorrida;

    public Rota(int qtdCidades) {
        sequencia = new ArrayList();
        for (int i=0; i < qtdCidades; i++) {
            sequencia.add(i);
        }
    }
    
    public void calculaDistancia(double[][] matrizDistancias) {
        
    }
    
    public void exibeSequencia() {
        System.out.println("\n");
        for (Integer s : sequencia) {
            System.out.print(s + "\t");
        }
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
    
    
}
