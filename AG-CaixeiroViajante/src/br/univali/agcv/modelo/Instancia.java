package br.univali.agcv.modelo;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

//Usuário define quantidade de cidades e a distancia entre elas.    OK
//Usuário define quantidades de rotas aleatórias a serem geradas.   OK
//É gerado rotas aleatórias.                                        OK
//Escolhido 2 melhores rotas e gerado 2 filhos através do cruzamento.
//É escolhido mais 2 melhores rotas, e assim sucessivamente até não haver mais 

public class Instancia {
    private int qtdCidades;
    private List<Rota> listRotas;
    private double[][] matrizDistancias;

    public Instancia(int qtdCidades) {
        this.qtdCidades = qtdCidades;
        listRotas = new ArrayList();
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
