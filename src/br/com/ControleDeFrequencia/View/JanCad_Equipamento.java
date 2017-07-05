/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.ControleDeFrequencia.View;

import br.com.ControleDeFrequencia.Control.ControlEquipamento;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.HashMap;
import javax.swing.JOptionPane;

/**
 *
 * @author Lucas Eduardo
 */
public class JanCad_Equipamento extends javax.swing.JDialog implements ADMJanelas {

    public HashMap infoJanela = null;

    public JanCad_Equipamento() {
        this.setModal(true);
        initComponents();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jBnSalvar = new javax.swing.JButton();
        jBnCancelar = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jTFcodigo = new javax.swing.JTextField();
        jTFdescricao = new javax.swing.JTextField();
        jTFnumero_tombamento = new javax.swing.JTextField();
        try{ 
            javax.swing.text.MaskFormatter tombamento= new javax.swing.text.MaskFormatter("######");
            tombamento.setPlaceholderCharacter('_');
            jTFnumero_tombamento = new javax.swing.JFormattedTextField(tombamento);
        }
        catch (Exception e){
        }
        jTFdata_cadastro = new javax.swing.JTextField();
        jCbstatus = new javax.swing.JComboBox<>();
        jChInativo = new javax.swing.JCheckBox();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Cadastro de Equipamento");

        jBnSalvar.setText("Salvar");
        jBnSalvar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBnSalvarActionPerformed(evt);
            }
        });

        jBnCancelar.setText("Cancelar");
        jBnCancelar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBnCancelarActionPerformed(evt);
            }
        });

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel1.setText("Descrição");

        jLabel2.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel2.setText("Número de Tombamento");

        jLabel3.setText("Data de Cadastro");

        jLabel4.setText("Código");

        jLabel5.setText("Status");

        jLabel6.setText("Inativo");

        jTFcodigo.setEditable(false);

        jTFdata_cadastro.setEditable(false);
        jTFdata_cadastro.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTFdata_cadastroActionPerformed(evt);
            }
        });

        jCbstatus.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Disponível", "Reservado", "Manutenção" }));

        jChInativo.setText("Inativar!");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(144, Short.MAX_VALUE)
                .addComponent(jBnSalvar)
                .addGap(18, 18, 18)
                .addComponent(jBnCancelar)
                .addGap(28, 28, 28))
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addGroup(layout.createSequentialGroup()
                            .addComponent(jLabel4)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addComponent(jTFcodigo))
                        .addGroup(layout.createSequentialGroup()
                            .addComponent(jLabel1)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addComponent(jTFdescricao, javax.swing.GroupLayout.PREFERRED_SIZE, 168, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGroup(layout.createSequentialGroup()
                            .addComponent(jLabel2)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addComponent(jTFnumero_tombamento)))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel3)
                            .addComponent(jLabel5)
                            .addComponent(jLabel6))
                        .addGap(16, 16, 16)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jChInativo)
                            .addComponent(jTFdata_cadastro, javax.swing.GroupLayout.PREFERRED_SIZE, 91, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jCbstatus, javax.swing.GroupLayout.PREFERRED_SIZE, 91, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(16, 16, 16)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(jTFcodigo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(jTFdescricao, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(jTFnumero_tombamento, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(jTFdata_cadastro, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5)
                    .addComponent(jCbstatus, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(34, 34, 34)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jChInativo)
                    .addComponent(jLabel6))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 68, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jBnSalvar)
                    .addComponent(jBnCancelar))
                .addContainerGap())
        );

        setSize(new java.awt.Dimension(344, 338));
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void jBnSalvarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBnSalvarActionPerformed
        if (!(jTFdescricao.getText().isEmpty()) && !(jTFnumero_tombamento.getText().equals("______"))) {
            this.infoJanela = new HashMap();

            this.infoJanela.put("descrição", this.jTFdescricao.getText());
            System.out.println(jTFdescricao.getText());
            this.infoJanela.put("numero_tombamento", this.jTFnumero_tombamento.getText());
            this.infoJanela.put("estatus", this.jCbstatus.getSelectedIndex());

            if (this.jChInativo.isSelected()) {
                this.infoJanela.put("inativo", 1);
            } else {
                this.infoJanela.put("inativo", 0);
            }

            // this.infoJanela.put("estatus", this.jTFstatus.getText());
            // this.infoJanela.put("inativo", this.jTFInativo.getText());
            ControlEquipamento cp = new ControlEquipamento();
            if (!(this.jTFcodigo.getText().isEmpty())) {
                this.infoJanela.put("codigo", this.jTFcodigo.getText());
                if (cp.ControlAlterar(this.infoJanela)) {
                    JOptionPane.showMessageDialog(null, "Alteração realizada com sucesso!");
                } else {
                    JOptionPane.showMessageDialog(null, "Não foi possivel salvar as alterações!");
                }
            } else {
                if (cp.ControlInserir(this.infoJanela)) {
                    JOptionPane.showMessageDialog(null, "Cadastro realizado com sucesso!");
                } else {
                    JOptionPane.showMessageDialog(null, "Não foi possivel realizar o cadastro!");
                }
            }
            dispose();
        } else {
            JOptionPane.showMessageDialog(null, "Preencha os campos obrigatórios (em negrito)!");
        }
    }//GEN-LAST:event_jBnSalvarActionPerformed

    private void jBnCancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBnCancelarActionPerformed
        dispose();
    }//GEN-LAST:event_jBnCancelarActionPerformed

    private void jTFdata_cadastroActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTFdata_cadastroActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTFdata_cadastroActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(JanCad_Equipamento.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(JanCad_Equipamento.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(JanCad_Equipamento.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(JanCad_Equipamento.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new JanCad_Equipamento().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jBnCancelar;
    private javax.swing.JButton jBnSalvar;
    private javax.swing.JComboBox<String> jCbstatus;
    private javax.swing.JCheckBox jChInativo;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JTextField jTFcodigo;
    private javax.swing.JTextField jTFdata_cadastro;
    private javax.swing.JTextField jTFdescricao;
    private javax.swing.JTextField jTFnumero_tombamento;
    // End of variables declaration//GEN-END:variables

    @Override
    public void mostrarJanela() {
        this.setVisible(true);
    }

    @Override
    public void setValoresSelecao(HashMap selecao) {
        jTFcodigo.setText(selecao.get("codigo").toString());
        jTFdescricao.setText(selecao.get("descrição").toString());
        jTFnumero_tombamento.setText(selecao.get("numero_tombamento").toString());
        try {
            SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");

            Calendar cadastramento = (Calendar) selecao.get("data_cadastro");

            jTFdata_cadastro.setText(sdf.format(cadastramento.getTime()));

        } catch (Exception e) {
            e.printStackTrace();
        }
        jCbstatus.setSelectedIndex((int) selecao.get("estatus"));

        if (Integer.parseInt(selecao.get("inativo").toString()) == 1) {
            jChInativo.setSelected(true);

        }

    }
}
