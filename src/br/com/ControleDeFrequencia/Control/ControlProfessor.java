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
            SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
            Calendar cal = Calendar.getInstance();
            cal.setTime(sdf.parse((String) map.get("nascimento")));
            this.professor.setData_nascimento(cal);
        } catch(ParseException e){
            e.printStackTrace();
        }

        if (this.professorDao == null){
            this.professorDao = new ProfessorDAO();
        }
   
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
        
        this.professor.setId((Long) Long.parseLong(map.get("codigo").toString()));
        
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

        if (this.professorDao == null){
            this.professorDao = new ProfessorDAO();
        }

        if(this.professorDao.alterar(this.professor)){
            return true;
        }
        return false;
    }

    @Override
    public boolean ControlDeletar(long id) {
        if (this.professorDao == null){
            this.professorDao = new ProfessorDAO();
        }
        
        if (this.professorDao.deletar(id)){
            return true;
        } else{
            return false;
        }
    }

    @Override
    public HashMap ControlSelecionar(Object id) {
        if (this.professorDao == null){
            this.professorDao = new ProfessorDAO();
        }
        
        if (this.professorDao.selecionar(id) != ""){
            this.professor = (Professor) this.professorDao.selecionar(id);
            HashMap selecao = new HashMap();
            selecao.put("id", this.professor.getId());
            selecao.put("nome", this.professor.getNome());
            selecao.put("cpf", this.professor.getCpf());
            selecao.put("siape", this.professor.getSiape());
            
            System.out.println(this.professor.getSexo());
            
            selecao.put("sexo", this.professor.getSexo());
            selecao.put("nascimento", this.professor.getData_nascimento());
            selecao.put("cadastro", this.professor.getData_cadastramento());
            selecao.put("titulo", this.professor.getTitulo());
            selecao.put("vinculo", this.professor.getVinculo());
            
            return selecao;
        }
        return null;
    }
    
    public void ControlPesquisar(int opcao, String valor){       
        if (professorDao == null){
             this.professorDao = new ProfessorDAO();
        }
        
        if (opcao == 3){
            valor = valor.replaceAll("[^0-9]","");
        }
        
        this.professorDao.pesquisar(opcao, valor);

    }
    
}
