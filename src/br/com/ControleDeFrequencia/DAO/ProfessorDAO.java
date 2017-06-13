/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.ControleDeFrequencia.DAO;

import br.com.ControleDeFrequencia.Model.Professor;
import br.com.ControleDeFrequencia.Model.Sexo;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

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
            stmt.setInt(7, this.professor.getTitulo());
            stmt.setInt(8, this.professor.getVinculo());
            
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
            sql = "update professor set nome = ?, cpf = ?, sexo = ?, data_nascimento = ?, siape = ?, titulo = ?, vinculo = ?  where id_professor = ?";
            
            this.professor = (Professor) objeto;
            
            stmt = Conexao.getInstance().getConexao().prepareStatement(sql);
            
            stmt.setString(1, this.professor.getNome());
            stmt.setString(2, this.professor.getCpf());
            stmt.setString(3, this.professor.getSexo().getSexo());
            stmt.setDate(4, new java.sql.Date(this.professor.getData_nascimento().getTimeInMillis()));
            stmt.setString(5, this.professor.getSiape());
            stmt.setInt(6, this.professor.getTitulo());
            stmt.setInt(7, this.professor.getVinculo());
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
            sql = "delete from professor where id_professor = ?";
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
    public List<Professor> listar() {
        try {
            List<Professor> professores = new ArrayList<Professor>();
            sql =  "select * from professor";
            
            
            stmt = Conexao.getInstance().getConexao().prepareStatement(sql);
            
            ResultSet rs = stmt.executeQuery();
            
            while (rs.next()) {                
                Professor prof = new Professor();
                prof.setId(rs.getInt("id_professor"));
                prof.setSiape(rs.getString("siape"));
                prof.setNome(rs.getString("nome"));
                
                
                professores.add(prof);
            }
            rs.close();
            Conexao.getInstance().fechaConexao(stmt);
            return professores;
            
            
        } catch (Exception e) {
        throw new RuntimeException(e);
        }
               

    }
    
    @Override
    public Professor exibir(int id) {
        try {
            sql =  "select * from professor where id_professor = ?";
            
            stmt = Conexao.getInstance().getConexao().prepareStatement(sql);
            stmt.setInt(1, id);
            ResultSet rs = stmt.executeQuery();
            
            rs.next();
            Professor prof = new Professor();
            prof.setId(rs.getInt("id_professor"));
            String opSexual = rs.getString("sexo");
            Sexo sexo = null;
            if (opSexual.equals("M")) {
                sexo = Sexo.Masculino;
            } else if (opSexual.equals("F")) {
                sexo = Sexo.Feminino;
            }
            prof.setSexo(sexo);
            prof.setCpf(rs.getString("cpf"));
            prof.setSiape(rs.getString("siape"));
            prof.setNome(rs.getString("nome"));
            prof.setTitulo(rs.getInt("titulo"));
            prof.setVinculo(rs.getInt("vinculo"));
            Calendar cal = Calendar.getInstance();
            cal.setTime(rs.getDate("data_nascimento"));
            prof.setData_nascimento(cal);
            Calendar dtCad = Calendar.getInstance();
            dtCad.setTime(rs.getDate("data_cadastro"));
            prof.setData_cadastramento(dtCad);
            rs.close();
            Conexao.getInstance().fechaConexao(stmt);
            return prof;
            
            
        } catch (Exception e) {
        throw new RuntimeException(e);
        }
               

    }
    
    public void setSQL(String sql){
        
    }
}
