package br.univali.agcv.modelo;

import com.sun.javafx.scene.control.skin.VirtualFlow;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Random;

public class Instancia {
    private int qtdCidades;
    private List<Rota> listRotas;
    private List<Rota> listNovaPopulacao;
    private double[][] matrizDistancias;
    private Rota melhorRotaInstancia;
    private Roleta roleta;
    private int chanceCruzamento;
    private int chanceMutacao;
    private Random rand;

    public Instancia(int qtdCidades, int percentualCruzamento, int percentualMutacao) {
        this.qtdCidades = qtdCidades;
        listRotas = new ArrayList();
        listNovaPopulacao = new ArrayList();
        matrizDistancias = new double[qtdCidades][qtdCidades];
        this.chanceCruzamento = percentualCruzamento;
        this.chanceMutacao = percentualMutacao;
        rand = new Random();
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
    
    public void cruzaPopulacao(int qtdSobreviventes) {
        //  Selecao dos pais
        Rota pai1;
        Rota pai2;
        int indexPai1;
        int indexPai2;
        
        // Adicionando os melhores na proxima geração
        for (int i = 0; i < qtdSobreviventes; i++) {
            Rota rotaAux = menorRota();
            listNovaPopulacao.add(rotaAux);
            listRotas.remove(rotaAux);
        }
        for (Rota r : listNovaPopulacao) {
            listRotas.add(r);
        }
        
        for (int i=0; i < (listRotas.size() - qtdSobreviventes); i++) {
            roleta = new Roleta(listRotas);
            indexPai1 = roleta.getSorteadoIndex();
            pai1 = listRotas.get(indexPai1);
//            System.out.println("PAI1");
            //pai1.exibeRota();
            do {
                indexPai2 = roleta.getSorteadoIndex();
                pai2 = listRotas.get(indexPai2);
                //pai2.exibeRota();
            } while(indexPai1 == indexPai2);
                    
            if (roleta.chanceAleatoria(chanceCruzamento)) { // Chance de cruzar ou nao
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
            } else i--;
        }
        
        //  Melhor da instancia
        if (melhorRotaInstancia != null) {
            if (menorRota().getDistanciaPercorrida() < melhorRotaInstancia.getDistanciaPercorrida()) {
                melhorRotaInstancia = menorRota();
            }
        } else {
            melhorRotaInstancia = menorRota();
        }
        
        
        listRotas = new ArrayList(listNovaPopulacao);   //  Populacao atual passa a ser a nova populacao
        listNovaPopulacao = new ArrayList();            //  Zera nova populacao
        exibeRotas();                                   //  Exibe população atual
    }
    
    public void cruzar(Rota predominante, Rota rota) {
        Rota filho = new Rota();
        boolean igual;

        int size = Math.round(predominante.getSequencia().size()/2);    //  talvez necessario size() ser transformado para double

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
        
        if (roleta.chanceAleatoria(chanceMutacao)) {
            int a = rand.nextInt(filho.getSequencia().size());
            int b;
            do{                                                                 // Evitar uma mutação que nao muda nada
                b = rand.nextInt(filho.getSequencia().size());
            }while (a == b);
            
            int aux = filho.getSequencia().get(a);
            filho.getSequencia().set(a, filho.getSequencia().get(b));
            filho.getSequencia().set(b, aux);
            
            System.out.println("Mutacao");
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

    public Rota getMelhorRotaInstancia() {
        return melhorRotaInstancia;
    }

    public void setMelhorRotaInstancia(Rota melhorRotaInstancia) {
        this.melhorRotaInstancia = melhorRotaInstancia;
    }
}