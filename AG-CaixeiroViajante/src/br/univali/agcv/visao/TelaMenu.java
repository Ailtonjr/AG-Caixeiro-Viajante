/*
1 - Usuário define quantidade de cidades e a distancia entre elas.  ok

2 - Usuário define quantidades de rotas aleatórias a serem geradas. ok

3 - É gerado rotas aleatórias.                                      ok

4 - É gravado a melhor rota destas aleatórias, para sua distancia ser usada como fitness.   ok

5 - Escolhido 2 melhores rotas e gerado 2 filhos através do cruzamento (que podem ou não ter mutação). Gravando em uma lista de população nova.

6 - É escolhido mais 2 melhores rotas, e assim sucessivamente até não haver mais nada da população antiga. Gerando uma população totalmente nova, só de filhos.

7 - Verificado se alguma rota da nova população de filhos é menor que o fitness. Caso não, é feito o cruzamento novamente com a nova população, voltando ao passo 5. Caso sim é dado como solução do problema.

*/

package br.univali.agcv.visao;

import br.univali.agcv.modelo.Instancia;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;


public class TelaMenu extends javax.swing.JFrame {

    public TelaMenu() {
        initComponents();
        this.setTitle("AG-Caixeiro");
        this.setResizable(false);
        this.setLocationRelativeTo(null);
        this.setVisible(true);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        panelPrincipal = new javax.swing.JPanel();
        buttonNovaInstancia = new javax.swing.JButton();
        textCidades = new javax.swing.JTextField();
        textRotas = new javax.swing.JTextField();
        labelCidades = new javax.swing.JLabel();
        labelRotas = new javax.swing.JLabel();
        labelMutacao = new javax.swing.JLabel();
        textMutacao = new javax.swing.JTextField();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        panelPrincipal.setBorder(javax.swing.BorderFactory.createTitledBorder(""));

        buttonNovaInstancia.setText("Nova instancia");
        buttonNovaInstancia.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonNovaInstanciaActionPerformed(evt);
            }
        });

        textCidades.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                textCidadesActionPerformed(evt);
            }
        });

        textRotas.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                textRotasActionPerformed(evt);
            }
        });

        labelCidades.setText("Quantidade de cidades:");

        labelRotas.setText("Quantidade de rotas:");

        labelMutacao.setText("Percentual de mutação:");

        textMutacao.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                textMutacaoActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout panelPrincipalLayout = new javax.swing.GroupLayout(panelPrincipal);
        panelPrincipal.setLayout(panelPrincipalLayout);
        panelPrincipalLayout.setHorizontalGroup(
            panelPrincipalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelPrincipalLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(panelPrincipalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(panelPrincipalLayout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(buttonNovaInstancia))
                    .addGroup(panelPrincipalLayout.createSequentialGroup()
                        .addGroup(panelPrincipalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(labelRotas)
                            .addComponent(labelCidades)
                            .addComponent(labelMutacao))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 47, Short.MAX_VALUE)
                        .addGroup(panelPrincipalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(textMutacao)
                            .addComponent(textCidades, javax.swing.GroupLayout.DEFAULT_SIZE, 54, Short.MAX_VALUE)
                            .addComponent(textRotas))))
                .addContainerGap())
        );
        panelPrincipalLayout.setVerticalGroup(
            panelPrincipalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelPrincipalLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(panelPrincipalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(textCidades, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(labelCidades))
                .addGap(13, 13, 13)
                .addGroup(panelPrincipalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(textRotas, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(labelRotas))
                .addGap(18, 18, 18)
                .addGroup(panelPrincipalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(labelMutacao)
                    .addComponent(textMutacao, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 20, Short.MAX_VALUE)
                .addComponent(buttonNovaInstancia)
                .addContainerGap())
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(panelPrincipal, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(panelPrincipal, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void buttonNovaInstanciaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonNovaInstanciaActionPerformed
        Instancia instancia;
        try {
            instancia = new Instancia(Integer.parseInt(textCidades.getText()));
            double[][] matrizAux = instancia.getMatrizDistancias();
            
            for (int i=0; i < instancia.getQtdCidades(); i++) {  // Cidade
                int j = i;    //  Cascata
                while (j < instancia.getQtdCidades()) {  // Distancia cidades
                    
                    matrizAux[i][j] = Integer.parseInt(JOptionPane.showInputDialog("Distancia entre cidade" + i + " e cidade" + j));
                    j++;
                }
            }
            
            //  Exibicao
            for (int l=0; l < instancia.getQtdCidades(); l++) {
                for (int c=0; c < instancia.getQtdCidades(); c++) {
                    System.out.print(matrizAux[l][c] + "\t");
                }
                System.out.println("");
            }
            
            //  Rotas aleatorias
            instancia.gerarRotas(Integer.parseInt(textRotas.getText()));
            
            //  Sem comentarios
            instancia.calculaFitness();
            
            //  Cruzamento e formacao da nova populacao
            instancia.cruzaPopulacao(Double.parseDouble(textMutacao.getText()));
            
        } catch (Exception e) {
            e.printStackTrace();
        }
    }//GEN-LAST:event_buttonNovaInstanciaActionPerformed

    private void textCidadesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_textCidadesActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_textCidadesActionPerformed

    private void textRotasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_textRotasActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_textRotasActionPerformed

    private void textMutacaoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_textMutacaoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_textMutacaoActionPerformed

    public static void main(String args[]) {
        try {
            UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(TelaMenu.class.getName()).log(Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            Logger.getLogger(TelaMenu.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            Logger.getLogger(TelaMenu.class.getName()).log(Level.SEVERE, null, ex);
        } catch (UnsupportedLookAndFeelException ex) {
            Logger.getLogger(TelaMenu.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new TelaMenu().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton buttonNovaInstancia;
    private javax.swing.JLabel labelCidades;
    private javax.swing.JLabel labelMutacao;
    private javax.swing.JLabel labelRotas;
    private javax.swing.JPanel panelPrincipal;
    private javax.swing.JTextField textCidades;
    private javax.swing.JTextField textMutacao;
    private javax.swing.JTextField textRotas;
    // End of variables declaration//GEN-END:variables
}
