package br.univali.agcv.modelo;

import java.util.ArrayList;
import java.util.List;

//Usuário define quantidade de cidades e a distancia entre elas.    OK
//Usuário define quantidades de rotas aleatórias a serem geradas.
//É gerado rotas aleatórias.
//Escolhido 2 melhores rotas e gerado 2 filhos através do cruzamento.
//É escolhido mais 2 melhores rotas, e assim sucessivamente até não haver mais 

public class Instancia {
    private int qtdCidades;
    private List<Cidade> listCidades;
    private double[][] matrizDistancias;

    public Instancia(int qtdCidades) {
        this.qtdCidades = qtdCidades;
        listCidades = new ArrayList(qtdCidades);
        matrizDistancias = new double[qtdCidades][qtdCidades];
        zeraMatriz();
    }

    public void zeraMatriz(){
        for (int l=0; l < qtdCidades; l++) {
            for (int c=0; c < qtdCidades; c++) {
                matrizDistancias[l][c] = 0.0;
            }
        }
    }
    
    public int getQtdCidades() {
        return qtdCidades;
    }

    public void setQtdCidades(int qtdCidades) {
        this.qtdCidades = qtdCidades;
    }

    public List<Cidade> getListCidades() {
        return listCidades;
    }

    public void setListCidades(List<Cidade> listCidades) {
        this.listCidades = listCidades;
    }

    public double[][] getMatrizDistancias() {
        return matrizDistancias;
    }

    public void setMatrizDistancias(double[][] matrizDistancias) {
        this.matrizDistancias = matrizDistancias;
    }
    
    
}
