/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.ControleDeFrequencia.Control;

import br.com.ControleDeFrequencia.DAO.DisciplinaDAO;
import br.com.ControleDeFrequencia.Model.Disciplina;
import br.com.ControleDeFrequencia.Model.Professor;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.HashMap;
import javax.swing.JOptionPane;

/**
 *
 * @author Usuario
 */
public class ControlDisciplina implements ControlPadrao {
    private Disciplina disciplina;
    private DisciplinaDAO DisciplinaDao;
    private Professor professor;
    
    @Override
    public boolean ControlInserir(Object objeto) {
        HashMap map = (HashMap) objeto;
        
        this.disciplina = new Disciplina();
        this.disciplina.setDisciplina(map.get("Disciplina").toString());
        
        if (map.get("Semestre").toString() != ""){
            this.disciplina.setSemestre(Integer.parseInt(map.get("Semestre").toString()));
            this.disciplina.setCurso(map.get("Curso").toString());
        }else{
            this.disciplina.setSerie(Integer.parseInt(map.get("Serie").toString()));
        }
           
        this.disciplina.setCarga_horaria(Integer.parseInt(map.get("Horario").toString()));
        
        if (this.professor == null){
            this.professor = new Professor();
        }
        
        this.professor.setId(Long.parseLong(map.get("Id_Professor").toString()));
        
        this.disciplina.setProfessor(professor);
        

        if (this.DisciplinaDao == null){
            this.DisciplinaDao = new DisciplinaDAO();
        }
   
        if(this.DisciplinaDao.inserir(this.disciplina)){
            return true;
        }
        return false;
    }

    @Override
    public boolean ControlAlterar(Object objeto) {
        HashMap map = (HashMap) objeto;

        this.disciplina = new Disciplina();

        this.disciplina.setId(Long.parseLong(map.get("Codigo").toString()));
        this.disciplina.setDisciplina(map.get("Disciplina").toString());
        
        if (map.get("Semestre").toString() != ""){
            this.disciplina.setSemestre(Integer.parseInt(map.get("Semestre").toString()));
            this.disciplina.setCurso(map.get("Curso").toString());
        }else{
            this.disciplina.setSerie(Integer.parseInt(map.get("Serie").toString()));
        }
           
        this.disciplina.setCarga_horaria(Integer.parseInt(map.get("Horario").toString()));
        
        if (this.professor == null){
            this.professor = new Professor();
        }
        
        this.professor.setId(Long.parseLong(map.get("Id_Professor").toString()));
        
        this.disciplina.setProfessor(this.professor);

        if (this.DisciplinaDao == null){
            this.DisciplinaDao = new DisciplinaDAO();
        }

        if(this.DisciplinaDao.alterar(this.disciplina)){
            return true;
        }
        return false;
    }

    @Override
    public boolean ControlDeletar(long id) {
        if (this.DisciplinaDao == null){
            this.DisciplinaDao = new DisciplinaDAO();
        }
        
        if (this.DisciplinaDao.deletar(id)){
            return true;
        } else{
            return false;
        }
    }

    @Override
    public HashMap ControlSelecionar(Object id) {
        if(this.DisciplinaDao == null){
            this.DisciplinaDao = new DisciplinaDAO();
        }
        
        this.disciplina = (Disciplina) this.DisciplinaDao.selecionar(id);
        
        if (this.disciplina != null){
            HashMap selecao = new HashMap();
            selecao.put("Codigo",  this.disciplina.getId());
            selecao.put("Disciplina", this.disciplina.getDisciplina());
            selecao.put("Semestre", this.disciplina.getSemestre());
            selecao.put("Serie", this.disciplina.getSerie());
            selecao.put("Carga_Horaria", this.disciplina.getCarga_horaria());
            selecao.put("Codigo_Professor", this.disciplina.getProfessor().getId());
            selecao.put("Nome_Professor", this.disciplina.getProfessor().getNome());
            selecao.put("Curso", this.disciplina.getCurso());
            
            return selecao;
        }
        
        return null;
    }

    @Override
    public void ControlPesquisar(int opcao, String valor) {
        if (DisciplinaDao == null) {
            this.DisciplinaDao = new DisciplinaDAO();
            
        }
        
        this.DisciplinaDao.pesquisar(opcao, valor);
    }
   
}
