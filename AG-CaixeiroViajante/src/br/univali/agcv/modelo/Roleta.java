package br.univali.agcv.modelo;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Roleta {
    private List<Integer> roleta;
    private Random rand;
    private double totalFitnes = 0.0;

    public Roleta(List<Rota> populacao) {
        roleta = new ArrayList();
        rand = new Random();
        
        for (Rota individuo : populacao) {
            totalFitnes += individuo.getFitness()*100;
        }
        
        for (int i=0; i < populacao.size(); i++) {
            int percent = (int) Math.round(((populacao.get(i).getFitness()*100)/totalFitnes)*100); // Vai retornar um percentual arredondado
            for (int j=0; j < percent; j++) {
                roleta.add(i);
            }
        }
    }
    
    public int getSorteadoIndex() {
        return roleta.get(rand.nextInt(roleta.size()));
    }
}
