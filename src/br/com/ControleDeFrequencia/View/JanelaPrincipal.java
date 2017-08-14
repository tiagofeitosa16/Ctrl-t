/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.ControleDeFrequencia.View;

import br.com.ControleDeFrequencia.Model.TableModelGeneric;
import java.sql.SQLException;

/**
 *
 * @author Usuario
 */
public class JanelaPrincipal extends javax.swing.JFrame {
    
    private TableModelGeneric tabelaModelo = null;
    private String sql = "Select p.nome, d.disciplina, a.Data_aula, a.hora_inicio, a.hora_terminio from aula as a "
            + "inner join Disciplina as d on a.id_disciplina = d.codigo "
            + "left join professor as p on d.id_professor = p.id_professor  where a.Data_aula = CURDATE()";
    
    /**
     * Creates new form JanelaPrincipal
     */
    public JanelaPrincipal() {
        this.setExtendedState(MAXIMIZED_BOTH);
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

        jScrollPane2 = new javax.swing.JScrollPane();
        try{
            this.tabelaModelo = new TableModelGeneric(this.sql);
        } catch(SQLException e){
            e.printStackTrace();
        }
        jTableAulas = new javax.swing.JTable(this.tabelaModelo);
        jTableAulas = new javax.swing.JTable();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jButton3 = new javax.swing.JButton();
        jPanel1 = new javax.swing.JPanel();
        jMenuBar1 = new javax.swing.JMenuBar();
        jMenuCadastros = new javax.swing.JMenu();
        jMenuItemProfessores = new javax.swing.JMenuItem();
        jSeparator1 = new javax.swing.JPopupMenu.Separator();
        jMenuItemEquipamentos = new javax.swing.JMenuItem();
        jSeparator5 = new javax.swing.JPopupMenu.Separator();
        jMenuItem2 = new javax.swing.JMenuItem();
        jMenu1 = new javax.swing.JMenu();
        jMenuItem1 = new javax.swing.JMenuItem();
        jMenuItem3 = new javax.swing.JMenuItem();
        jMenuManutencao = new javax.swing.JMenu();
        jMenuUsuarios = new javax.swing.JMenu();
        jMenuItemCadastrar = new javax.swing.JMenuItem();
        jSeparator3 = new javax.swing.JPopupMenu.Separator();
        jMenuItemTrocarSenha = new javax.swing.JMenuItem();
        jMenuSair = new javax.swing.JMenu();
        jMenuItemMudarUsuario = new javax.swing.JMenuItem();
        jMenuItemEmEspera = new javax.swing.JMenuItem();
        jSeparator4 = new javax.swing.JPopupMenu.Separator();
        jMenuItemSairSistema = new javax.swing.JMenuItem();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Gerenciador de Frequência");

        jScrollPane2.setBorder(javax.swing.BorderFactory.createTitledBorder("Aulas do Dia"));

        jTableAulas.setModel(this.tabelaModelo);
        jScrollPane2.setViewportView(jTableAulas);

        jButton1.setText("Cronograma");

        jButton2.setText("Frequência");

        jButton3.setText("Registrar Presença");

        jPanel1.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 30, Short.MAX_VALUE)
        );

        jMenuCadastros.setText("Cadastros");

        jMenuItemProfessores.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_P, java.awt.event.InputEvent.CTRL_MASK));
        jMenuItemProfessores.setText("Professores");
        jMenuItemProfessores.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItemProfessoresActionPerformed(evt);
            }
        });
        jMenuCadastros.add(jMenuItemProfessores);
        jMenuCadastros.add(jSeparator1);

        jMenuItemEquipamentos.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_E, java.awt.event.InputEvent.CTRL_MASK));
        jMenuItemEquipamentos.setText("Equipamentos");
        jMenuItemEquipamentos.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItemEquipamentosActionPerformed(evt);
            }
        });
        jMenuCadastros.add(jMenuItemEquipamentos);
        jMenuCadastros.add(jSeparator5);

        jMenuItem2.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_D, java.awt.event.InputEvent.CTRL_MASK));
        jMenuItem2.setText("Disciplinas");
        jMenuItem2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem2ActionPerformed(evt);
            }
        });
        jMenuCadastros.add(jMenuItem2);

        jMenuBar1.add(jMenuCadastros);

        jMenu1.setText("Aulas");

        jMenuItem1.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_C, java.awt.event.InputEvent.CTRL_MASK));
        jMenuItem1.setText("Cronograma");
        jMenuItem1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem1ActionPerformed(evt);
            }
        });
        jMenu1.add(jMenuItem1);

        jMenuItem3.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_F, java.awt.event.InputEvent.CTRL_MASK));
        jMenuItem3.setText("Frequência");
        jMenu1.add(jMenuItem3);

        jMenuBar1.add(jMenu1);

        jMenuManutencao.setText("Manutenção");

        jMenuUsuarios.setText("Usuários");

        jMenuItemCadastrar.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_U, java.awt.event.InputEvent.CTRL_MASK));
        jMenuItemCadastrar.setText("Cadastrar");
        jMenuItemCadastrar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItemCadastrarActionPerformed(evt);
            }
        });
        jMenuUsuarios.add(jMenuItemCadastrar);
        jMenuUsuarios.add(jSeparator3);

        jMenuItemTrocarSenha.setText("Trocar Senha");
        jMenuUsuarios.add(jMenuItemTrocarSenha);

        jMenuManutencao.add(jMenuUsuarios);

        jMenuBar1.add(jMenuManutencao);

        jMenuSair.setText("Sair");

        jMenuItemMudarUsuario.setText("Mudar de usuário");
        jMenuSair.add(jMenuItemMudarUsuario);

        jMenuItemEmEspera.setText("Em espera");
        jMenuSair.add(jMenuItemEmEspera);
        jMenuSair.add(jSeparator4);

        jMenuItemSairSistema.setText("Sair do Sistema");
        jMenuItemSairSistema.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItemSairSistemaActionPerformed(evt);
            }
        });
        jMenuSair.add(jMenuItemSairSistema);

        jMenuBar1.add(jMenuSair);

        setJMenuBar(jMenuBar1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jButton1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jButton3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jButton2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(18, 18, 18)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 539, Short.MAX_VALUE)
                .addContainerGap())
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jButton3, javax.swing.GroupLayout.PREFERRED_SIZE, 85, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 85, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 85, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 46, Short.MAX_VALUE)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        setSize(new java.awt.Dimension(716, 574));
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void jMenuItemProfessoresActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItemProfessoresActionPerformed
        // TODO add your handling code here:
        String[] opcoes = {"Selecione...","Código","Nome","CPF","Siape"};
        Janela_Generica janela = new Janela_Generica(1, "Relação de Professores", opcoes);
        janela.setVisible(true);
    }//GEN-LAST:event_jMenuItemProfessoresActionPerformed

    private void jMenuItemCadastrarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItemCadastrarActionPerformed
        // TODO add your handling code here:
        String[] opcoes = {"Selecione...","Código","Usuário","Grupo"};
        Janela_Generica janela = new Janela_Generica(2,"Relação de Usuários", opcoes);
        janela.setVisible(true);
    }//GEN-LAST:event_jMenuItemCadastrarActionPerformed

    private void jMenuItemEquipamentosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItemEquipamentosActionPerformed
        // TODO add your handling code here:
        String[] opcoes = {"Selecione...","Código","Descrição","Status"};
        Janela_Generica janela = new Janela_Generica(3,"Relação de Equipamentos", opcoes);
        janela.setVisible(true);
    }//GEN-LAST:event_jMenuItemEquipamentosActionPerformed

    private void jMenuItem2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem2ActionPerformed
        // TODO add your handling code here:
        String[]opcoes = {"Selecionar...","Código","Disciplina","Carga Horária","Professor"};
        Janela_Generica janela = new Janela_Generica(4, "Relação de Disciplinas", opcoes);
        janela.setVisible(true);
    }//GEN-LAST:event_jMenuItem2ActionPerformed

    private void jMenuItemSairSistemaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItemSairSistemaActionPerformed
        // TODO add your handling code here:
        System.exit(0);
    }//GEN-LAST:event_jMenuItemSairSistemaActionPerformed

    private void jMenuItem1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem1ActionPerformed
        // TODO add your handling code here:
        String[]opcoes = {"Selecionar...","Disciplina","Data","Carga horária","Professor"};
        Janela_Generica janela = new Janela_Generica(5, "Cronograma", opcoes);
        janela.setVisible(true);
    }//GEN-LAST:event_jMenuItem1ActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JMenu jMenu1;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JMenu jMenuCadastros;
    private javax.swing.JMenuItem jMenuItem1;
    private javax.swing.JMenuItem jMenuItem2;
    private javax.swing.JMenuItem jMenuItem3;
    private javax.swing.JMenuItem jMenuItemCadastrar;
    private javax.swing.JMenuItem jMenuItemEmEspera;
    private javax.swing.JMenuItem jMenuItemEquipamentos;
    private javax.swing.JMenuItem jMenuItemMudarUsuario;
    private javax.swing.JMenuItem jMenuItemProfessores;
    private javax.swing.JMenuItem jMenuItemSairSistema;
    private javax.swing.JMenuItem jMenuItemTrocarSenha;
    private javax.swing.JMenu jMenuManutencao;
    private javax.swing.JMenu jMenuSair;
    private javax.swing.JMenu jMenuUsuarios;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JPopupMenu.Separator jSeparator1;
    private javax.swing.JPopupMenu.Separator jSeparator3;
    private javax.swing.JPopupMenu.Separator jSeparator4;
    private javax.swing.JPopupMenu.Separator jSeparator5;
    private javax.swing.JTable jTableAulas;
    // End of variables declaration//GEN-END:variables
}
