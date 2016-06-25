package br.univali.agcv.modelo;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Roleta {
    private List<Integer> roleta;
    private Random rand;
    private double totalFitnes;

    public Roleta(List<Rota> populacao) {
        roleta = new ArrayList();
        rand = new Random();
        
        for (Rota individui : populacao) {
            totalFitnes += individui.getFitness()*100;
        }
        
        for (int i=0; i < populacao.size(); i++) {
            int percent = (int) Math.round(((populacao.get(i).getFitness()*100)/totalFitnes)*100); // Vai retornar um percentual arredondado
            for (int j=0; j < percent; j++) {
                roleta.add(i);
            }
            System.out.println("");
        }
        System.out.println("");
    }
    
    public int getSorteadoIndex() {
        return roleta.get(rand.nextInt(roleta.size()));
    }
}
