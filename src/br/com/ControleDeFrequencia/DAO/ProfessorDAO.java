/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.ControleDeFrequencia.DAO;

import br.com.ControleDeFrequencia.Model.Professor;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Calendar;

/**
 *
 * @author Usuario
 */
public class ProfessorDAO implements PadraoDAO{
    private Professor professor;
    private String sql;
    private PreparedStatement stmt;
    
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
            stmt.setInt(7, this.professor.getVinculo());
            stmt.setInt(8, this.professor.getCargo());
            
            stmt.execute();
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
            sql = "update professor set nome = ?, cpf = ?, sexo = ?, data_nascimento = ?, siape = ?, titulo = ?, cargo = ?  where id = ?";
            
            this.professor = (Professor) objeto;
            
            stmt = Conexao.getInstance().getConexao().prepareStatement(sql);
            
            stmt.setString(1, this.professor.getNome());
            stmt.setString(2, this.professor.getCpf());
            stmt.setString(3, this.professor.getSexo().getSexo());
            stmt.setDate(4, new java.sql.Date(this.professor.getData_nascimento().getTimeInMillis()));
            stmt.setString(5, this.professor.getSiape());
            stmt.setInt(6, this.professor.getVinculo());
            stmt.setInt(7, this.professor.getCargo());
            stmt.setInt(8, this.professor.getId());
            
            stmt.execute();
            
            Conexao.getInstance().fechaConexao(stmt);
            
            return true;
            
        } catch(SQLException e){
            e.printStackTrace();
        }
        return false;
    }

    @Override
    public boolean deletar(int id) {
        try{
            sql = "delete from professor where id = ?";
            stmt = Conexao.getInstance().getConexao().prepareStatement(sql);
            
            stmt.setInt(1, id);
            stmt.execute();
            
            Conexao.getInstance().fechaConexao(stmt);
            
            return true;
            
        } catch(SQLException e){
            e.printStackTrace();
        }
        return false;
    }
    
    @Override
    public Object selecionar(Object objeto) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
    public void setSQL(String sql){
        
    }
}
