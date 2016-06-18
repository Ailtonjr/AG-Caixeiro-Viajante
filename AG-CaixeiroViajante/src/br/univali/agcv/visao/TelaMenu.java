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
        this.setTitle("Algoritmo genético para Caixeiro viajante");
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
                            .addComponent(labelCidades))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 15, Short.MAX_VALUE)
                        .addGroup(panelPrincipalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
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
                .addGap(26, 26, 26)
                .addComponent(buttonNovaInstancia)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
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
        Instancia intancia;
        try {
            intancia = new Instancia(Integer.parseInt(textCidades.getText()));
            double[][] matrizAux = intancia.getMatrizDistancias();
            
            for (int i=0; i < intancia.getQtdCidades(); i++) {  // Cidade
                int j = i;    //  Cascata
                while (j < intancia.getQtdCidades()) {  // Distancia cidades
                    
                    matrizAux[i][j] = Integer.parseInt(JOptionPane.showInputDialog("Distancia entre cidade" + i + " e cidade" + j));
                    j++;
                }
            }
            
            //  Exibicao
            for (int l=0; l < intancia.getQtdCidades(); l++) {
                for (int c=0; c < intancia.getQtdCidades(); c++) {
                    System.out.print(matrizAux[l][c] + "\t");
                }
                System.out.println("");
            }
            
            //  Rotas aleatorias
            intancia.gerarRotas(Integer.parseInt(textRotas.getText()));
            
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
    private javax.swing.JLabel labelRotas;
    private javax.swing.JPanel panelPrincipal;
    private javax.swing.JTextField textCidades;
    private javax.swing.JTextField textRotas;
    // End of variables declaration//GEN-END:variables
}
