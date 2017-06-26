/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.ControleDeFrequencia.Control;

import br.com.ControleDeFrequencia.DAO.TurmaDAO;
import br.com.ControleDeFrequencia.Model.Turma;
import br.com.ControleDeFrequencia.Model.Sexo;
import br.com.ControleDeFrequencia.View.JanCad_Turma;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.HashMap;
import javax.swing.JOptionPane;

/**
 *
 * @author Usuario
 */
public class ControlTurma implements ControlPadrao {
    
    private Turma turma;
    private TurmaDAO turmaDao;
    
    @Override
    public boolean ControlInserir(Object objeto){
        HashMap map = (HashMap) objeto;

        this.turma = new Turma();
        
        if ( !turma.setDescricao( map.get("descricao").toString() ) ){
            JOptionPane.showMessageDialog(null, "Descrição inválida!");
        }

        if ( !turma.setGraduacao( Integer.parseInt(map.get("graduacao").toString()) ) ){
            JOptionPane.showMessageDialog(null, "Graduação inválida!");
        }

        if ( !turma.setAno_letivo( map.get("ano_letivo").toString()) ){
            JOptionPane.showMessageDialog(null, "Ano letivo inválida!");
        }
        
        if (this.turmaDao == null){
            this.turmaDao = new TurmaDAO();
        }
        
        if(this.turmaDao.inserir(this.turma)){
            return true;
        }

        return false;
    }

    @Override
    public boolean ControlAlterar(Object objeto) {
        HashMap map = (HashMap) objeto;

        this.turma = new Turma();
        
        if ( !turma.setCodigo( Integer.parseInt(map.get("codigo").toString()) ) ){
            JOptionPane.showMessageDialog(null, "Descrição inválida!");
        }
        
        if ( !turma.setDescricao( map.get("descricao").toString() ) ){
            JOptionPane.showMessageDialog(null, "Descrição inválida!");
        }

        if ( !turma.setGraduacao( Integer.parseInt(map.get("graduacao").toString()) ) ){
            JOptionPane.showMessageDialog(null, "Graduação inválida!");
        }

        if ( !turma.setAno_letivo( map.get("ano_letivo").toString() ) ){
            JOptionPane.showMessageDialog(null, "Ano letivo inválida!");
        }

        if (this.turmaDao == null){
            this.turmaDao = new TurmaDAO();
        }

        if(this.turmaDao.alterar(this.turma)){
            return true;
        }
        return false;
    }

    @Override
    public boolean ControlDeletar(long codigo) {
        if (this.turmaDao == null){
            this.turmaDao = new TurmaDAO();
        }
        
        if (this.turmaDao.deletar(codigo)){
            return true;
        } else{
            return false;
        }
    }

    @Override
    public HashMap ControlSelecionar(Object codigo) {
        if (this.turmaDao == null){
            this.turmaDao = new TurmaDAO();
        }
        
        if (this.turmaDao.selecionar(codigo) != ""){
            this.turma = (Turma) this.turmaDao.selecionar(codigo);
            HashMap selecao = new HashMap();
            selecao.put("codigo", this.turma.getCodigo());
            selecao.put("descricao", this.turma.getDescricao());
            selecao.put("graduacao", this.turma.getGraduacao());
            selecao.put("ano_letivo", this.turma.getAno_letivo());            
            return selecao;
        }
        return null;
    }
    
    public void ControlPesquisar(int opcao, String valor){       
        if (turmaDao == null){
             this.turmaDao = new TurmaDAO();
        }
        
        // if (opcao == 3){
        //     valor = valor.replaceAll("[^0-9]","");
        // }
        
        this.turmaDao.pesquisar(opcao, valor);

    }
    
}
