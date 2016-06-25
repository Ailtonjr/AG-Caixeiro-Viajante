package br.univali.agcv.modelo;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Roleta {
    private List<Integer> roleta;
    private Random rand;

    public Roleta(List<Rota> populacao) {
        roleta = new ArrayList();
        rand = new Random();
        
        for (int i=0; i < populacao.size(); i++) {
            for (int j=0; j < populacao.get(i).getFitness(); j++) {
                roleta.add(i);
            }
        }
    }
    
    public int getSorteadoIndex() {
        int numero = rand.nextInt(roleta.size());
        System.out.println(numero);
        return numero;
    }
}
