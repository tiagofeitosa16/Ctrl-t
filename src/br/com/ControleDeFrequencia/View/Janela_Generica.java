/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.ControleDeFrequencia.View;

import br.com.ControleDeFrequencia.Control.ADMControlPadrao;
import br.com.ControleDeFrequencia.Control.ControlPadrao;
import br.com.ControleDeFrequencia.Control.ControlProfessor;
import br.com.ControleDeFrequencia.Model.TableModelGeneric;
import java.awt.Point;
import com.sun.glass.events.KeyEvent;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.ScrollPaneConstants;
import javax.swing.table.TableModel;

/**
 *
 * @author Usuario
 */
public class Janela_Generica extends javax.swing.JDialog {

    public ADMJanelas cadJanela = null;
    public static TableModelGeneric tabelaModelo = null;
    private String sql;
    private int id;
    private String[] opcoes;
    private boolean equi_classe = false;

    /**
     * Creates new form Janela_Generica
     */
    public Janela_Generica(int id, String titulo, String[] opcoes) {
        this.id = id;
        this.setSQl(this.id);
        this.opcoes = opcoes;
        this.setTitle(titulo);
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

        jButtonInserir = new javax.swing.JButton();
        jButtonAlterar = new javax.swing.JButton();
        jButtonExcluir = new javax.swing.JButton();
        jButtonSair = new javax.swing.JButton();
        jScrollPane2 = new javax.swing.JScrollPane(jTable2, ScrollPaneConstants.VERTICAL_SCROLLBAR_AS_NEEDED, ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
        try{
            this.tabelaModelo = new TableModelGeneric(this.sql);
        } catch(SQLException e){
            e.printStackTrace();
        }
        jTable2 = new javax.swing.JTable(this.tabelaModelo);
        jPanel1 = new javax.swing.JPanel();
        jCBPesquisar = new javax.swing.JComboBox();
        jTFPesquisar = new javax.swing.JTextField();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowActivated(java.awt.event.WindowEvent evt) {
                formWindowActivated(evt);
            }
            public void windowOpened(java.awt.event.WindowEvent evt) {
                formWindowOpened(evt);
            }
        });

        jButtonInserir.setText("Inserir");
        jButtonInserir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonInserirActionPerformed(evt);
            }
        });

        jButtonAlterar.setText("Alterar");
        jButtonAlterar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonAlterarActionPerformed(evt);
            }
        });

        jButtonExcluir.setText("Excluir");
        jButtonExcluir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonExcluirActionPerformed(evt);
            }
        });

        jButtonSair.setText("Sair");
        jButtonSair.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonSairActionPerformed(evt);
            }
        });

        jScrollPane2.setLocation(10, 101);
        jScrollPane2.setViewportView(jTable2);
        jScrollPane2.setSize(701, 352);
        jScrollPane2.setForeground(new java.awt.Color(49, 20, 20));

        jTable2.setModel(this.tabelaModelo);
        jTable2.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTable2MouseClicked(evt);
            }
        });
        jScrollPane2.setViewportView(jTable2);

        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder("Pesquisar por:"));

        jCBPesquisar.setModel(new javax.swing.DefaultComboBoxModel(this.opcoes));
        jCBPesquisar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jCBPesquisarActionPerformed(evt);
            }
        });

        jTFPesquisar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTFPesquisarActionPerformed(evt);
            }
        });
        jTFPesquisar.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                jTFPesquisarKeyReleased(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jTFPesquisar)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jCBPesquisar, javax.swing.GroupLayout.PREFERRED_SIZE, 137, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jTFPesquisar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jCBPesquisar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(jButtonInserir, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jButtonAlterar, javax.swing.GroupLayout.PREFERRED_SIZE, 96, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jButtonExcluir, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jButtonSair, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap())
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jScrollPane2, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 644, Short.MAX_VALUE)
                            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addGap(12, 12, 12))))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(19, 19, 19)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 338, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addComponent(jButtonAlterar, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jButtonExcluir, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jButtonSair))
                    .addComponent(jButtonInserir))
                .addContainerGap(19, Short.MAX_VALUE))
        );

        setSize(new java.awt.Dimension(682, 532));
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void jButtonInserirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonInserirActionPerformed
        // TODO add your handling code here:
        new ADMJanelaCreator().creator(this.id).mostrarJanela();
    }//GEN-LAST:event_jButtonInserirActionPerformed

    private void jButtonAlterarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonAlterarActionPerformed
        // TODO add your handling code here:
        acaoAlterar();
    }//GEN-LAST:event_jButtonAlterarActionPerformed

    private void jButtonSairActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonSairActionPerformed
        // TODO add your handling code here:
        dispose();
    }//GEN-LAST:event_jButtonSairActionPerformed

    private void jTFPesquisarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTFPesquisarActionPerformed
        // TODO add your handling code here:
        if ((jCBPesquisar.getSelectedIndex() != 0)) {
            new ADMControlPadrao().creator(this.id).ControlPesquisar(jCBPesquisar.getSelectedIndex(), jTFPesquisar.getText());
        }
    }//GEN-LAST:event_jTFPesquisarActionPerformed

    private void jTFPesquisarKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTFPesquisarKeyReleased
        if (!(evt.getKeyCode() == KeyEvent.VK_BACKSPACE)) {
            if ((jCBPesquisar.getSelectedIndex() != 0)) {
                new ADMControlPadrao().creator(this.id).ControlPesquisar(jCBPesquisar.getSelectedIndex(), jTFPesquisar.getText());
            }
        } else if ((evt.getKeyCode() == KeyEvent.VK_BACKSPACE)) {
            if ((jCBPesquisar.getSelectedIndex() != 0)) {
                new ADMControlPadrao().creator(this.id).ControlPesquisar(jCBPesquisar.getSelectedIndex(), jTFPesquisar.getText());
            }
        }
    }//GEN-LAST:event_jTFPesquisarKeyReleased

    private void jButtonExcluirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonExcluirActionPerformed
        // TODO add your handling code here:
        String msg = "Deseja realmente excluir?";
        String titulo = "Confirmação";

        int reply = JOptionPane.showConfirmDialog(null, msg, titulo, JOptionPane.YES_NO_OPTION);

        if (reply == JOptionPane.YES_OPTION) {
            int linha = jTable2.getSelectedRow();

            if (linha > -1) { // Verificando de tem item selecionado
                long value = (long) jTable2.getValueAt(linha, 0);

                ControlPadrao cp = new ADMControlPadrao().creator(this.id);

                if (cp.ControlDeletar(value)) {
                    JOptionPane.showMessageDialog(null, "Exclusão realizada com sucesso!");
                } else {
                    JOptionPane.showMessageDialog(null, "Não foi possivel realizar a exclusão!");
                }
            }
        }

    }//GEN-LAST:event_jButtonExcluirActionPerformed

    private void jTable2MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTable2MouseClicked
        // TODO add your handling code here:
        if (evt.getClickCount() == 2) {
            if (equi_classe) {
                /*int linha = jTable2.getSelectedRow();

                if (linha > -1) { // Verificando de tem item selecionado
                    Object value = jTable2.getValueAt(linha, 0);

                    //ControlPadrao cp = new ADMControlPadrao().creator(this.id);

                    //HashMap selecao = cp.ControlSelecionar(value);

                    if (selecao != null) {
                        this.cadJanela = new ADMJanelaCreator().creator(this.id);
                        this.cadJanela.setValoresSelecao(selecao);
                        this.cadJanela.mostrarJanela();
                    } else {
                        JOptionPane.showMessageDialog(null, "Não foi possivel selecionar o item!");
                    }
                } else {
                    JOptionPane.showMessageDialog(null, "Selecione um item!");
                }*/
                dispose();
            } else {
                acaoAlterar();
            }
        }
    }//GEN-LAST:event_jTable2MouseClicked

    private void formWindowActivated(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowActivated

    }//GEN-LAST:event_formWindowActivated

    private void formWindowOpened(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowOpened
        if (jCBPesquisar.getSelectedIndex() == 0) {
            jTFPesquisar.setEnabled(false);
        } else if (jCBPesquisar.getSelectedIndex() != 0) {
            jTFPesquisar.setEnabled(true);
        }
    }//GEN-LAST:event_formWindowOpened

    private void jCBPesquisarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jCBPesquisarActionPerformed
        if (jCBPesquisar.getSelectedIndex() == 0) {
            jTFPesquisar.setText("");
            new ADMControlPadrao().creator(this.id).ControlPesquisar(jCBPesquisar.getSelectedIndex(), jTFPesquisar.getText());
            jTFPesquisar.setEnabled(false);
        } else if (jCBPesquisar.getSelectedIndex() != 0) {
            jTFPesquisar.setEnabled(true);
        }

    }//GEN-LAST:event_jCBPesquisarActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButtonAlterar;
    private javax.swing.JButton jButtonExcluir;
    private javax.swing.JButton jButtonInserir;
    private javax.swing.JButton jButtonSair;
    private javax.swing.JComboBox jCBPesquisar;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTextField jTFPesquisar;
    private javax.swing.JTable jTable2;
    // End of variables declaration//GEN-END:variables

    private void setSQl(int sql) {
        switch (sql) {
            case 1:
                this.sql = "Select id_professor as Código, nome as Professor, cpf as CPF, siape as Siape from Professor";
                break;
            case 2:
                this.sql = "Select id_usuario as Código, usuario as Usuário, id_grupo as Grupo from Usuario";
                break;
            case 3:
                this.sql = "Select codigo as Código, descricao as Equipamento, estatus as Status from Equipamento";
                break;
            case 4:
                this.sql = "Select d.codigo as Código, d.disciplina as Disciplina, d.carga_horaria Horas, p.nome as Professor from Disciplina as d"
                        + " left join professor as p on d.id_professor = p.id_professor";
                break;
            case 5:
                this.sql = "select a.id_aula, d.disciplina, p.nome, a.Data_aula, a.hora_inicio, a.hora_terminio from Aula as a inner join Disciplina as d on a.id_disciplina = d.codigo "
                        + "left join professor as p on d.id_professor = p.id_professor order by Data_aula";
                break;
            case 7:
                this.sql = "Select codigo as Código, descricao as Equipamento, estatus as Status from Equipamento";
                equi_classe = true;
                break;
            default:
                JOptionPane.showMessageDialog(null, "Não foi possível carregar a tabela!");
                dispose();
        }
    }

    private void acaoAlterar() {
        int linha = jTable2.getSelectedRow();

        if (linha > -1) { // Verificando de tem item selecionado
            Object value = jTable2.getValueAt(linha, 0);

            ControlPadrao cp = new ADMControlPadrao().creator(this.id);

            HashMap selecao = cp.ControlSelecionar(value);

            if (selecao != null) {
                this.cadJanela = new ADMJanelaCreator().creator(this.id);
                this.cadJanela.setValoresSelecao(selecao);
                this.cadJanela.mostrarJanela();
            } else {
                JOptionPane.showMessageDialog(null, "Não foi possivel selecionar o item!");
            }
        } else {
            JOptionPane.showMessageDialog(null, "Selecione um item!");
        }
    }

}
