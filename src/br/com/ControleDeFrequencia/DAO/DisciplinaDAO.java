/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.ControleDeFrequencia.DAO;

import br.com.ControleDeFrequencia.Model.Disciplina;
import br.com.ControleDeFrequencia.Model.Professor;
import br.com.ControleDeFrequencia.View.Janela_Generica;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Usuario
 */
public class DisciplinaDAO implements PadraoDAO{
    
    private Disciplina disciplina;
    private Professor professor;
    private String sql;
    private PreparedStatement stmt;
    private ResultSet rs;

    @Override
    public boolean inserir(Object objeto) {
        try{
            this.disciplina = (Disciplina) objeto;
            
            this.sql = "Insert into Disciplina(disciplina, semestre, carga_horaria, id_professor, serie, curso) values(?,?,?,?,?,?)"; 
            this.stmt = Conexao.getInstance().getConexao().prepareStatement(this.sql);
            
            if (this.disciplina.getSemestre() > 0){
                this.stmt.setInt(2, this.disciplina.getSemestre());
                this.stmt.setInt(5, 0);
                this.stmt.setString(6, this.disciplina.getCurso());
            }else{
                this.stmt.setInt(2, 0);
                this.stmt.setInt(5, this.disciplina.getSerie());
                this.stmt.setString(6, "");
            }
            this.stmt.setString(1, this.disciplina.getDisciplina());
            this.stmt.setInt(3, this.disciplina.getCarga_horaria());
            this.stmt.setLong(4, this.disciplina.getProfessor().getId());
            
            
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
    public boolean alterar(Object objeto) {
        try{
            sql = "update Disciplina set disciplina = ?, semestre = ?, carga_horaria = ?, id_professor = ?, serie = ?, curso = ? where codigo = ?";
            
            this.disciplina = (Disciplina) objeto;
            
            this.stmt = Conexao.getInstance().getConexao().prepareStatement(sql);
            
            this.stmt.setString(1, this.disciplina.getDisciplina());
            
            if (this.disciplina.getSemestre() > 0){
                this.stmt.setInt(2, this.disciplina.getSemestre());
                this.stmt.setInt(5, 0);
                this.stmt.setString(6, this.disciplina.getCurso());
            }else{
                this.stmt.setInt(2, 0);
                this.stmt.setInt(5, this.disciplina.getSerie());
                this.stmt.setString(6, "");
            }
            this.stmt.setInt(3, this.disciplina.getCarga_horaria());
            this.stmt.setLong(4, this.disciplina.getProfessor().getId());
            this.stmt.setLong(7, this.disciplina.getId());
            
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
            sql = "delete from Disciplina where codigo = ?";
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
            sql = "Select codigo, disciplina, semestre, carga_horaria, p.id_professor, serie, p.nome, curso from Disciplina as d"
                    + " left join professor as p on d.id_professor = p.id_professor where codigo = ?";
            stmt = Conexao.getInstance().getConexao().prepareStatement(sql);
            
            stmt.setLong(1, (long) objeto);
            stmt.execute();
            
            this.rs = stmt.getResultSet();
            this.rs.absolute(1);
            
            if(this.disciplina == null){
                this.disciplina = new Disciplina();
            }
            
            this.disciplina.setId((long) this.rs.getObject(1));
            this.disciplina.setDisciplina((String) this.rs.getObject(2));                       
            this.disciplina.setSemestre(Integer.parseInt(this.rs.getObject(3).toString()));
            this.disciplina.setSerie(Integer.parseInt(this.rs.getObject(6).toString()));
            this.disciplina.setCarga_horaria(Integer.parseInt(this.rs.getObject(4).toString()));
            this.disciplina.setCurso((String) this.rs.getObject(8));
            
            this.professor = new Professor();
            this.professor.setId(this.rs.getLong(5));
            this.professor.setNome(this.rs.getString(7));
            this.disciplina.setProfessor(professor);
            
            Conexao.getInstance().fechaConexao(stmt);
            
            return this.disciplina;
            
        } catch(SQLException e){
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public void pesquisar(int opcao, String valor) {
        String sqlTemp = "Select d.codigo as Código, d.disciplina as Disciplina, d.carga_horaria Horas, p.nome as Professor from Disciplina as d"
                        + " left join professor as p on d.id_professor = p.id_professor";
        
        switch (opcao){
            case 1:
                sqlTemp = sqlTemp.concat(" where d.codigo = '"+valor+"'");
                break;
            case 2:
                sqlTemp = sqlTemp.concat(" where d.disciplina like '%"+valor+"%'");
                break;
            case 3:
                sqlTemp = sqlTemp.concat(" where d.carga_horaria = '"+valor+"'");
                break;
            case 4:
                sqlTemp = sqlTemp.concat(" where p.nome like '"+valor+"%'");
                break;
            default:
                break;  }
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

    @Override
    public void AtualizarTabela(String sql) {
        try {
            if (sql == ""){
                Janela_Generica.tabelaModelo.setSQL("Select d.codigo as Código, d.disciplina as Disciplina, d.carga_horaria Horas, p.nome as Professor from Disciplina as d left join professor as p on d.id_professor = p.id_professor");
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
