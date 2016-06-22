package br.univali.agcv.modelo;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
// TODO 5 - Escolhido 2 melhores rotas e gerado 2 filhos através do cruzamento (que podem ou não ter mutação). Gravando em uma lista de população nova.

public class Instancia {
    private int qtdCidades;
    private List<Rota> listRotas;
    private List<Rota> listNovaPopulacao;
    private double[][] matrizDistancias;
    private Rota fitness;

    public Instancia(int qtdCidades) {
        this.qtdCidades = qtdCidades;
        listRotas = new ArrayList();
        listNovaPopulacao = new ArrayList();
        matrizDistancias = new double[qtdCidades][qtdCidades];
        zeraMatriz();
    }

    public void gerarRotas(int qtdRotas) {
        for (int i=0; i < qtdRotas; i++) {
            Rota rotaAux = new Rota(qtdCidades);
            
            Collections.shuffle(rotaAux.getSequencia());
            if (!checaIgualdade(rotaAux)) {
                rotaAux.getSequencia().add(rotaAux.getSequencia().get(0));  //  Volta a cidade origem
                rotaAux.calculaDistancia(matrizDistancias);
                listRotas.add(rotaAux);
            } else {
                i--;    //  Refaz
            }
        }
        exibeRotas();
    }
    
    public void calculaFitness() {
        fitness = listRotas.get(0);
        for (Rota rota : listRotas) {
            if (rota.getDistanciaPercorrida() < fitness.getDistanciaPercorrida()) {
                fitness = rota;
            }
        }
        System.out.println("Fitness:\t" + fitness.getDistanciaPercorrida());
        fitness.exibeRota();
    }
    
    public void cruzaPopulacao() {
        //  Selecao dos pais
        
    }
    
    public boolean checaIgualdade(Rota r) {
        for (Rota rota : listRotas) {
            if (rota.getSequencia().equals(r.getSequencia())) {
                return true;
            }
        }
        return false;
    }
    
    public void zeraMatriz(){
        for (int l=0; l < qtdCidades; l++) {
            for (int c=0; c < qtdCidades; c++) {
                matrizDistancias[l][c] = 0.0;
            }
        }
    }
    
    public void exibeRotas() {
        for (Rota rota : listRotas) {
            rota.exibeRota();
        }
    }
    
    public int getQtdCidades() {
        return qtdCidades;
    }

    public void setQtdCidades(int qtdCidades) {
        this.qtdCidades = qtdCidades;
    }

    public double[][] getMatrizDistancias() {
        return matrizDistancias;
    }

    public void setMatrizDistancias(double[][] matrizDistancias) {
        this.matrizDistancias = matrizDistancias;
    } 
}