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
    
    public void calculaFitness() {  //  Isso pode morrer. Virando apenas menorRota();
        fitness = menorRota();
        System.out.println("Fitness:\t" + fitness.getDistanciaPercorrida());
        fitness.exibeRota();
    }
    
    public void cruzaPopulacao(double mutacao) {
        //  Selecao dos pais
        Rota pai1;
        Rota pai2;
        
        pai1 = menorRota();
        listRotas.remove(pai1);
        
        pai2 = menorRota();
        listRotas.remove(pai2);
        
        //  Cruzar
        if (pai1.getDistanciaPercorrida() < pai2.getDistanciaPercorrida()) {    //  Teste de gene predominante
            cruzar(pai1, pai2);
        } else if (pai2.getDistanciaPercorrida() < pai1.getDistanciaPercorrida()) {
            cruzar(pai2, pai1);
        } else {
            //  Distancia igual
        }
    }
    
    public void cruzar(Rota predominante, Rota rota) {
        Rota filho1 = new Rota();
        Rota filho2 = new Rota();
        int size = Math.round(predominante.getSequencia().size()/2);    //  talvez necessario size() ser transformado apra double
        
        for (int i=0; i < size; i++) {  //  Metade do predominante
            filho1.getSequencia().add(predominante.getSequencia().get(i));
        }
        for (int i=size+1; i < predominante.getSequencia().size();i++) {
            
        }
    }
    
    public Rota menorRota() {
        Rota rotaAux = listRotas.get(0);
        for (Rota rota : listRotas) {
            if (rota.getDistanciaPercorrida() < rotaAux.getDistanciaPercorrida()) {
                rotaAux = rota;
            }
        }
        return rotaAux;
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