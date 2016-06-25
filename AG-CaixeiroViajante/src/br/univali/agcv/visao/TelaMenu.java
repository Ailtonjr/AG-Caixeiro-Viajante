package br.univali.agcv.visao;

import br.univali.agcv.modelo.Instancia;
import br.univali.agcv.modelo.Rota;
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
        labelIteracoes = new javax.swing.JLabel();
        textIteracores = new javax.swing.JTextField();
        labelSobreviventes = new javax.swing.JLabel();
        textSobreviventes = new javax.swing.JTextField();
        labelPercentual = new javax.swing.JLabel();
        textCruzamento = new javax.swing.JTextField();

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

        labelIteracoes.setText("Quantidade de iterações:");

        textIteracores.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                textIteracoresActionPerformed(evt);
            }
        });

        labelSobreviventes.setText("Sobreviventes por geração");

        textSobreviventes.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                textSobreviventesActionPerformed(evt);
            }
        });

        labelPercentual.setText("Percentual de cruzamento:");

        textCruzamento.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                textCruzamentoActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout panelPrincipalLayout = new javax.swing.GroupLayout(panelPrincipal);
        panelPrincipal.setLayout(panelPrincipalLayout);
        panelPrincipalLayout.setHorizontalGroup(
            panelPrincipalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelPrincipalLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(panelPrincipalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(buttonNovaInstancia, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(panelPrincipalLayout.createSequentialGroup()
                        .addGroup(panelPrincipalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(labelRotas)
                            .addComponent(labelCidades)
                            .addComponent(labelMutacao)
                            .addComponent(labelIteracoes)
                            .addComponent(labelSobreviventes)
                            .addComponent(labelPercentual))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 29, Short.MAX_VALUE)
                        .addGroup(panelPrincipalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(textCruzamento)
                            .addComponent(textSobreviventes)
                            .addComponent(textIteracores)
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
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(panelPrincipalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(labelMutacao)
                    .addComponent(textMutacao, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(panelPrincipalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(labelIteracoes)
                    .addComponent(textIteracores, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(panelPrincipalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(labelSobreviventes)
                    .addComponent(textSobreviventes, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(panelPrincipalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(labelPercentual)
                    .addComponent(textCruzamento, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
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
        int qtdCidades = Integer.parseInt(textCidades.getText());
        int percentualCruzamento = Integer.parseInt(textCruzamento.getText());
        int chanceMutacao = Integer.parseInt(textRotas.getText());
        int qtdIteracoes = Integer.parseInt(textIteracores.getText());
        
        try {
            instancia = new Instancia(qtdCidades, percentualCruzamento, chanceMutacao);
            double[][] matrizAux = instancia.getMatrizDistancias(); //  Ponteiro
            
            //  Entrada de dados
            for (int i=0; i < instancia.getQtdCidades(); i++) {  // Cidade
                int j = i;    //  Cascata
                while (j < instancia.getQtdCidades()) {  // Distancia cidades
                    matrizAux[i][j] = Integer.parseInt(JOptionPane.showInputDialog("Distancia entre cidade" + i + " e cidade" + j));
                    j++;
                }
            }
            
            //  Exibicao matriz
            System.out.println("------------------------------\nMatriz de adjacencia:");
            instancia.exibeMatriz();
            
            //  Rotas aleatorias
            System.out.println("(\"------------------------------\nPopulação");
            instancia.gerarRotas(Integer.parseInt(textRotas.getText()));
            
            //  Cruzamento e formacao da nova populacao
            System.out.println("------------------------------\nCRUZAMENTOS" + Integer.parseInt(textIteracores.getText()));
            for (int geracao=0; geracao < qtdIteracoes; geracao++) {
                System.out.println("++++++++++++++++++++++++++++++\nGeração " + geracao);
                instancia.cruzaPopulacao();
                instancia.exibeRotasNovaPopulacao();
            }
            
            //  Solucao
            Rota solucao = instancia.menorRota();
            System.out.println("------------------------------\nSolução encontrada:");
            solucao.exibeRota();
            
            String solucaoPane = "";
            for (Integer sequencia : solucao.getSequencia()) {
                solucaoPane += sequencia + " - ";
            }
            
            JOptionPane.showMessageDialog(null, "Melhor rota encontrada em " + textIteracores.getText() + " iteracoes:\n" + solucaoPane);
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

    private void textIteracoresActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_textIteracoresActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_textIteracoresActionPerformed

    private void textSobreviventesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_textSobreviventesActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_textSobreviventesActionPerformed

    private void textCruzamentoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_textCruzamentoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_textCruzamentoActionPerformed

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
    private javax.swing.JLabel labelIteracoes;
    private javax.swing.JLabel labelMutacao;
    private javax.swing.JLabel labelPercentual;
    private javax.swing.JLabel labelRotas;
    private javax.swing.JLabel labelSobreviventes;
    private javax.swing.JPanel panelPrincipal;
    private javax.swing.JTextField textCidades;
    private javax.swing.JTextField textCruzamento;
    private javax.swing.JTextField textIteracores;
    private javax.swing.JTextField textMutacao;
    private javax.swing.JTextField textRotas;
    private javax.swing.JTextField textSobreviventes;
    // End of variables declaration//GEN-END:variables
}
