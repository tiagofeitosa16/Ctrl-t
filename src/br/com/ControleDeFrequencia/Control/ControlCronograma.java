/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.ControleDeFrequencia.Control;

import br.com.ControleDeFrequencia.DAO.AulaDAO;
import br.com.ControleDeFrequencia.Model.Aula;
import br.com.ControleDeFrequencia.Model.Disciplina;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.HashMap;

/**
 *
 * @author Usuario
 */
public class ControlCronograma implements ControlPadrao{

    private Aula aula;
    private AulaDAO aulaDao;
    private Disciplina disciplina;
        
    @Override
    public boolean ControlInserir(Object objeto) {
        HashMap map = (HashMap) objeto;
        
        this.aula = new Aula();
        
        try{
            SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
            Calendar cal = Calendar.getInstance();
            cal.setTime(sdf.parse((String) map.get("DataAula")));
            this.aula.setData_aula(cal);
        } catch(ParseException e){
            e.printStackTrace();
        }
        
        try{
            SimpleDateFormat sdf = new SimpleDateFormat("HH:mm");
            Calendar cal = Calendar.getInstance();
            cal.setTime(sdf.parse((String) map.get("HoraInicio")));
            this.aula.setHora_inicio(cal);
        } catch(ParseException e){
            e.printStackTrace();
        }
        
        try{
            SimpleDateFormat sdf = new SimpleDateFormat("HH:mm");
            Calendar cal = Calendar.getInstance();
            cal.setTime(sdf.parse((String) map.get("HoraTermino")));
            this.aula.setHora_termino(cal);
        } catch(ParseException e){
            e.printStackTrace();
        }

        this.aula.setHoras_diarias(Integer.parseInt(map.get("HorasDiarias").toString()));
        
        if (this.disciplina == null){
            this.disciplina = new Disciplina();
        }
        this.disciplina.setId(Long.parseLong(map.get("CodigoDisciplina").toString()));
        this.aula.setDisciplina(this.disciplina);
        
        if (this.aulaDao == null){
            this.aulaDao = new AulaDAO();
        }
   
        if(this.aulaDao.inserir(this.aula)){
            return true;
        }
        return false;
    }

    @Override
    public boolean ControlAlterar(Object objeto) {
        HashMap map = (HashMap) objeto;
        
        this.aula = new Aula();
        
        try{
            SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
            Calendar cal = Calendar.getInstance();
            cal.setTime(sdf.parse((String) map.get("DataAula")));
            this.aula.setData_aula(cal);
        } catch(ParseException e){
            e.printStackTrace();
        }
        
        try{
            SimpleDateFormat sdf = new SimpleDateFormat("HH:mm:ss");
            Calendar cal = Calendar.getInstance();
            cal.setTime(sdf.parse((String) map.get("HoraInicio")));
            this.aula.setHora_inicio(cal);
        } catch(ParseException e){
            e.printStackTrace();
        }
        
        try{
            SimpleDateFormat sdf = new SimpleDateFormat("HH:mm:ss");
            Calendar cal = Calendar.getInstance();
            cal.setTime(sdf.parse((String) map.get("HoraTermino")));
            this.aula.setHora_termino(cal);
        } catch(ParseException e){
            e.printStackTrace();
        }

        this.aula.setHoras_diarias(Integer.parseInt(map.get("HorasDiarias").toString()));
        
        if (this.disciplina == null){
            this.disciplina = new Disciplina();
        }
        this.disciplina.setId(Long.parseLong(map.get("CodigoDisciplina").toString()));
        this.aula.setDisciplina(this.disciplina);
        
        if (this.aulaDao == null){
            this.aulaDao = new AulaDAO();
        }
   
        if(this.aulaDao.alterar(this.aula)){
            return true;
        }
        return false;
    }

    @Override
    public boolean ControlDeletar(long id) {
        if (this.aulaDao == null){
            this.aulaDao = new AulaDAO();
        }
        
        if (this.aulaDao.deletar(id)){
            return true;
        } else{
            return false;
        }    
    }

    @Override
    public HashMap ControlSelecionar(Object id) {
        if (this.aulaDao == null){
            this.aulaDao = new AulaDAO();
        }
        
        this.aula = (Aula) this.aulaDao.selecionar(id);
        
        if (this.disciplina != null){
            HashMap selecao = new HashMap();
            selecao.put("codigo",  this.aula.getId());
            selecao.put("codigoDisciplina", this.aula.getDisciplina().getId());
            selecao.put("nomeDisciplina", this.aula.getDisciplina().getDisciplina());
            selecao.put("DataAula", this.aula.getData_aula());
            selecao.put("HoraInicio", this.aula.getHora_inicio());
            selecao.put("HoraTermino", this.aula.getHora_termino());
            selecao.put("HorasDiarias", this.aula.getHoras_diarias());
            
            return selecao;
        }
        
        return null;
    }

    @Override
    public void ControlPesquisar(int opcao, String valor) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
