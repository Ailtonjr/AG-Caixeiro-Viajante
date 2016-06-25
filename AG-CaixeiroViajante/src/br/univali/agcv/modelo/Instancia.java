package br.univali.agcv.modelo;

import com.sun.javafx.scene.control.skin.VirtualFlow;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Instancia {
    private int qtdCidades;
    private List<Rota> listRotas;
    private List<Rota> listNovaPopulacao;
    private double[][] matrizDistancias;
    private Rota fitness;
    private Roleta roleta;
    private int chanceMutacao;

    public Instancia(int qtdCidades, int percentualCruzamento, int chanceMutacao) {
        this.qtdCidades = qtdCidades;
        listRotas = new ArrayList();
        listNovaPopulacao = new ArrayList();
        matrizDistancias = new double[qtdCidades][qtdCidades];
        this.chanceMutacao = chanceMutacao;
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
    
    public void cruzaPopulacao() {
        //  Selecao dos pais
        Rota pai1;
        Rota pai2;
        roleta = new Roleta(listRotas);
        
        pai1 = listRotas.get(roleta.getSorteadoIndex()); 
        do {
            pai2 = listRotas.get(roleta.getSorteadoIndex());
        } while(pai1.getSequencia().equals(pai2.getSequencia()));
        
        //  Cruzar
        if (pai1.getDistanciaPercorrida() < pai2.getDistanciaPercorrida()) {    //  Teste de individuo predominante
            cruzar(pai1, pai2);
        } else if (pai2.getDistanciaPercorrida() < pai1.getDistanciaPercorrida()) {
            cruzar(pai2, pai1);
        } else {
            //  Distancia igual
            cruzar(pai1, pai2);
        }
        
        System.out.println("------------------------------\nCruzamento: ");
        pai1.exibeRota();
        pai2.exibeRota();
        System.out.println("Filho: ");
        listNovaPopulacao.get(listNovaPopulacao.size()-1).exibeRota();
        
        listRotas = new ArrayList(listNovaPopulacao);
    }
    
    public void cruzar(Rota predominante, Rota rota) {
        // Teste probabilistico do cruzamento
        
        Rota filho = new Rota();
        
        boolean igual;
        int size = Math.round(predominante.getSequencia().size()/2);    //  talvez necessario size() ser transformado apra double
        System.out.println("Média de cidades:" + size);
        
        for (int i=0; i < size; i++) {  //  Metade do predominante
            filho.getSequencia().add(predominante.getSequencia().get(i));
        }
        
        for (Integer sRota : rota.getSequencia()) {
            igual = false;
            for (Integer sFilho1 : filho.getSequencia()) {
                if (sRota == sFilho1) {
                    igual = true;
                    break;
                }
            }
            if (!igual) {
                filho.getSequencia().add(sRota);
            }
        }
        filho.getSequencia().add(filho.getSequencia().get(0));
       
        //  Insere na nova populacao
        filho.calculaDistancia(matrizDistancias);
        listNovaPopulacao.add(filho);
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
    
    public void exibeRotasNovaPopulacao() {
        for (Rota rota : listNovaPopulacao) {
            rota.exibeRota();
        }
    }
    
    public void exibeMatriz() {
        for (int l=0; l < qtdCidades; l++) {
                for (int c=0; c < qtdCidades; c++) {
                    System.out.print(matrizDistancias[l][c] + "\t");
                }
                System.out.println("");
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