/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.ControleDeFrequencia.DAO;

import br.com.ControleDeFrequencia.Model.Professor;
import br.com.ControleDeFrequencia.Model.Sexo;
import br.com.ControleDeFrequencia.View.Janela_Generica;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Usuario
 */
public class ProfessorDAO implements PadraoDAO{
    private Professor professor;
    private String sql;
    private PreparedStatement stmt;
    private ResultSet rs;
    
    @Override
    public boolean inserir(Object objeto) {
        try{
            sql = "insert into professor(nome, cpf, sexo, data_nascimento, data_cadastro, siape, titulo, vinculo) values(?,?,?,?,?,?,?,?)";
            this.professor = (Professor) objeto;
  
            stmt = Conexao.getInstance().getConexao().prepareStatement(sql);
            
            stmt.setString(1, this.professor.getNome());
            stmt.setString(2, this.professor.getCpf());
            stmt.setString(3, this.professor.getSexo().getSexo());
            stmt.setDate(4, new java.sql.Date(this.professor.getData_nascimento().getTimeInMillis()));
            stmt.setDate(5, new java.sql.Date(Calendar.getInstance().getTimeInMillis()));
            stmt.setString(6, this.professor.getSiape());
            stmt.setInt(7, this.professor.getTitulo());
            stmt.setInt(8, this.professor.getVinculo());
            
            stmt.execute();
            
            this.AtualizarTabela("");
            
            Conexao.getInstance().fechaConexao(stmt);
           
            return true;
            
        } catch(SQLException e){
            e.printStackTrace();
        }    
        return false;
    }

    @Override
    public boolean alterar(Object objeto) {
        try{
            sql = "update professor set nome = ?, cpf = ?, sexo = ?, data_nascimento = ?, siape = ?, titulo = ?, vinculo = ?  where id_professor = ?";
            
            this.professor = (Professor) objeto;
            
            this.stmt = Conexao.getInstance().getConexao().prepareStatement(sql);
            
            this.stmt.setString(1, this.professor.getNome());
            this.stmt.setString(2, this.professor.getCpf());
            this.stmt.setString(3, this.professor.getSexo().getSexo());
            this.stmt.setDate(4, new java.sql.Date(this.professor.getData_nascimento().getTimeInMillis()));
            this.stmt.setString(5, this.professor.getSiape());
            this.stmt.setInt(6, this.professor.getTitulo());
            this.stmt.setInt(7, this.professor.getVinculo());
            this.stmt.setLong(8, this.professor.getId());
            
            this.stmt.execute();
            
            this.AtualizarTabela("");
            
            Conexao.getInstance().fechaConexao(stmt);
            
            return true;
            
        } catch(SQLException e){
            e.printStackTrace();
        }
        return false;
    }

    @Override
    public boolean deletar(long id) {
        try{
            sql = "delete from professor where id_professor = ?";
            stmt = Conexao.getInstance().getConexao().prepareStatement(sql);
            
            stmt.setLong(1, id);
            stmt.execute();
            
            this.AtualizarTabela("");
            
            Conexao.getInstance().fechaConexao(stmt);
            
            return true;
            
        } catch(SQLException e){
            e.printStackTrace();
        }
        return false;
    }
    
    @Override
    public Object selecionar(Object objeto) {
        try{
            sql = "Select id_professor, nome, cpf, siape, sexo, data_nascimento, data_cadastro, titulo, vinculo from professor where id_professor = ?";
            stmt = Conexao.getInstance().getConexao().prepareStatement(sql);
            
            stmt.setLong(1, (long) objeto);
            stmt.execute();
            
            this.rs = stmt.getResultSet();
            this.rs.absolute(1);
            
            if(this.professor == null){
                this.professor = new Professor();
            }
            
            this.professor.setId((long) this.rs.getObject(1));
            this.professor.setNome((String) this.rs.getObject(2));
            this.professor.setCpf((String) this.rs.getObject(3));
            this.professor.setSiape((String) this.rs.getObject(4));
            
            if (this.rs.getObject(5).equals("M")){
                this.professor.setSexo(Sexo.Masculino);
            } else if(this.rs.getObject(5).equals("F")){
                this.professor.setSexo(Sexo.Feminino);
            }   
            
            Calendar cal1 = Calendar.getInstance();
            Date dataNascimento, dataCadastro;
            
            dataNascimento = (Date) this.rs.getObject(6);
            cal1.setTime(dataNascimento);
            this.professor.setData_nascimento(cal1);
            
            Calendar cal2 = Calendar.getInstance();
            
            dataCadastro = (Date) this.rs.getObject(7);
            cal2.setTime(dataCadastro);
            this.professor.setData_cadastramento(cal2);
            
            this.professor.setTitulo((int) this.rs.getObject(8));
            this.professor.setVinculo((int) this.rs.getObject(9));
            
            Conexao.getInstance().fechaConexao(stmt);
            
            return this.professor;
            
        } catch(SQLException e){
            e.printStackTrace();
        }
        return null;
    }
    
    public void pesquisar(int opcao, String valor){
        String sqlTemp = "Select id_professor, nome, cpf, siape from professor ";
        
        switch (opcao){
            case 1:
                sqlTemp = sqlTemp.concat("where id_professor = '"+valor+"'");
                break;
            case 2:
                sqlTemp = sqlTemp.concat("where nome like '%"+valor+"%'");
                break;
            case 3:
                sqlTemp = sqlTemp.concat("where cpf = '"+valor+"'");
                break;
            case 4:
                sqlTemp = sqlTemp.concat("where siape like '"+valor+"%'");
                break;
            default:
                break;
        }
        
        try{
            if (!valor.isEmpty()){
                this.AtualizarTabela(sqlTemp);
            }else{
                this.AtualizarTabela("");
            }
            
        } catch(Exception e){
            e.printStackTrace();
        }
        
    }
    
    public ArrayList<Professor> pegarListaDeProfessores(){
        ArrayList<Professor> Professores = new ArrayList<>();
        try{
            this.sql = "Select id_professor, nome from Professor order by id_professor";
            this.stmt = Conexao.getInstance().getConexao().prepareStatement(this.sql);
            this.rs = this.stmt.executeQuery();
            
            while (this.rs.next()){
               if (this.professor == null){
                    this.professor = new Professor();
               }              
               this.professor.setId((Long) this.rs.getLong(1));
               this.professor.setNome(this.rs.getString(2));
               Professores.add(this.professor);
               this.professor = null;
            }
            
            Conexao.getInstance().fechaConexao(stmt, rs);
            
        } catch(SQLException e){
            e.printStackTrace();
        }
        
        return Professores;
    
    }
    
    public void AtualizarTabela(String sql){
        try {
            if (sql == ""){
                Janela_Generica.tabelaModelo.setSQL("Select id_professor, nome, cpf, siape from Professor");
            }else{
                System.out.println(sql);
                Janela_Generica.tabelaModelo.setSQL(sql);
            }
        } catch (IllegalStateException e) {
            Logger.getLogger(ProfessorDAO.class.getName()).log(Level.SEVERE, null, e);
        } catch (SQLException e) {
            Logger.getLogger(ProfessorDAO.class.getName()).log(Level.SEVERE, null, e);
        }
    }    
    
}
