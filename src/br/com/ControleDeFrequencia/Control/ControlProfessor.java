/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.ControleDeFrequencia.Control;

import br.com.ControleDeFrequencia.DAO.ProfessorDAO;
import br.com.ControleDeFrequencia.Model.Cargo;
import br.com.ControleDeFrequencia.Model.Professor;
import br.com.ControleDeFrequencia.Model.Sexo;
import br.com.ControleDeFrequencia.Model.Titulo;
import br.com.ControleDeFrequencia.View.JanCad_Professor;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.HashMap;

/**
 *
 * @author Usuario
 */
public class ControlProfessor {
    
    private Professor professor;
    private ProfessorDAO professorDao;
    
    public boolean ControleInserir(HashMap map){
        
        this.professor = new Professor();
        this.professor.setNome(map.get("nome").toString());
        this.professor.setCpf(map.get("cpf").toString());
        this.professor.setSiape(map.get("siape").toString());
        
        if((int) map.get("sexo") == 1){
            this.professor.setSexo(Sexo.Masculino);
        }else if((int) map.get("sexo") == 2){
            this.professor.setSexo(Sexo.Feminino);
        }
        
        this.professor.setTitulo((int) map.get("titulo"));
        this.professor.setCargos((int) map.get("cargo"));
        
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
}
