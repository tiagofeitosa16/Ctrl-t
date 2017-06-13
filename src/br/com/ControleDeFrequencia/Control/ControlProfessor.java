/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.ControleDeFrequencia.Control;

import br.com.ControleDeFrequencia.DAO.ProfessorDAO;
import br.com.ControleDeFrequencia.Model.Professor;
import br.com.ControleDeFrequencia.Model.Sexo;
import br.com.ControleDeFrequencia.View.JanCad_Professor;
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
public class ControlProfessor implements ControlPadrao {
    
    private Professor professor;
    private ProfessorDAO professorDao;
    
    @Override
    public boolean ControlInserir(Object objeto){
        HashMap map = (HashMap) objeto;
        String siape = map.get("siape").toString();
        String cpf = map.get("cpf").toString();
        cpf = cpf.replaceAll("[^0-9]","");
        
        this.professor = new Professor();
        this.professor.setNome(map.get("nome").toString());
        
        if(this.professor.validarSiape(siape)) {
            this.professor.setSiape(siape);
        } else {
            JOptionPane.showMessageDialog(null, "Siape inválido!");
            return false;
        }
        
        if(!this.professor.ValidarCPF(cpf)) {
            JOptionPane.showMessageDialog(null, "CPF inválido!");
            return false;
        } else {
            this.professor.setCpf(cpf);
        }
        
        if(map.get("sexo").toString() == "Masculino"){
            this.professor.setSexo(Sexo.Masculino);
        }else if(map.get("sexo").toString() == "Feminino"){
            this.professor.setSexo(Sexo.Feminino);
        }
        
        this.professor.setTitulo((int) map.get("titulo"));
        this.professor.setVinculo((int) map.get("vinculo"));
        
        try{
            SimpleDateFormat sdf = new SimpleDateFormat("dd/mm/yyyy");
            Calendar cal = Calendar.getInstance();
            cal.setTime(sdf.parse((String) map.get("nascimento")));
            this.professor.setData_nascimento(cal);
        } catch(ParseException e){
            e.printStackTrace();
        }

        this.professorDao = new ProfessorDAO();
   
        if(this.professorDao.inserir(this.professor)){
            return true;
        }
        return false;
    }

    @Override
    public boolean ControlAlterar(Object objeto) {
        HashMap map = (HashMap) objeto;
        String siape = map.get("siape").toString();
        String cpf = map.get("cpf").toString();
        cpf = cpf.replaceAll("[^0-9]","");
        
        this.professor = new Professor();
        this.professor.setNome(map.get("nome").toString());
        
        if(this.professor.validarSiape(siape)) {
            this.professor.setSiape(siape);
        } else {
            JOptionPane.showMessageDialog(null, "Siape inválido!");
            return false;
        }
        
        if(!this.professor.ValidarCPF(cpf)) {
            JOptionPane.showMessageDialog(null, "CPF inválido!");
            return false;
        } else {
            this.professor.setCpf(cpf);
        }
        
        if(map.get("sexo").toString() == "Masculino"){
            this.professor.setSexo(Sexo.Masculino);
        }else if(map.get("sexo").toString() == "Feminino"){
            this.professor.setSexo(Sexo.Feminino);
        }
        
        this.professor.setTitulo((int) map.get("titulo"));
        this.professor.setVinculo((int) map.get("vinculo"));
        this.professor.setId(Integer.parseInt((String) map.get("id")));
        
        try{
            SimpleDateFormat sdf = new SimpleDateFormat("dd/mm/yyyy");
            Calendar cal = Calendar.getInstance();
            cal.setTime(sdf.parse((String) map.get("nascimento")));
            this.professor.setData_nascimento(cal);
        } catch(ParseException e){
            e.printStackTrace();
        }

        this.professorDao = new ProfessorDAO();
   
        if(this.professorDao.alterar(this.professor)){
            return true;
        }
        return false;
    }

    @Override
    public boolean ControlDeletar(int id) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public HashMap ControlSelecionar(int id) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}
