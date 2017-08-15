/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.ControleDeFrequencia.DAO;

import br.com.ControleDeFrequencia.Model.Aula;
import br.com.ControleDeFrequencia.Model.Disciplina;
import br.com.ControleDeFrequencia.View.Janela_Generica;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Time;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Usuario
 */
public class AulaDAO implements PadraoDAO{
    private String sql;
    private PreparedStatement stmt;
    private Aula aula;
    private ResultSet rs;
    private Disciplina disciplina;

    @Override
    public boolean inserir(Object objeto) {
        try{
            this.sql = "insert into aula(id_disciplina, Data_aula, horas_diarios, hora_inicio, hora_terminio) values(?,?,?,?,?)";
            this.aula = (Aula) objeto;
  
            this.stmt = Conexao.getInstance().getConexao().prepareStatement(sql);
            
            stmt.setLong(1, this.aula.getDisciplina().getId());
            stmt.setDate(2, new java.sql.Date(this.aula.getData_aula().getTimeInMillis()));
            stmt.setInt(3, this.aula.getHoras_diarias());
            stmt.setTime(4, new java.sql.Time(this.aula.getHora_inicio().getTimeInMillis()));
            stmt.setTime(5, new java.sql.Time(this.aula.getHora_termino().getTimeInMillis()));
            
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
            this.sql = "update aula set id_disciplina = ?, Data_aula = ?, horas_diarios = ?, hora_inicio = ?, hora_terminio = ? where id_aula = ? ";
            this.aula = (Aula) objeto;
  
            this.stmt = Conexao.getInstance().getConexao().prepareStatement(sql);
            
            stmt.setLong(1, this.aula.getDisciplina().getId());
            stmt.setDate(2, new java.sql.Date(this.aula.getData_aula().getTimeInMillis()));
            stmt.setInt(3, this.aula.getHoras_diarias());
            stmt.setTime(4, new java.sql.Time(this.aula.getHora_inicio().getTimeInMillis()));
            stmt.setTime(5, new java.sql.Time(this.aula.getHora_termino().getTimeInMillis()));
            stmt.setLong(6, this.aula.getId());
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
    public boolean deletar(long id) {
             try{
            sql = "delete from aula where id_aula = ?";
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
            sql = "Select a.id_aula, d.codigo, d.disciplina, a.hora_inicio, a.hora_terminio, a.horas_diarios, a.Data_aula from aula as a"
                    + " left join Disciplina as d on a.id_aula = d.codigo where id_aula = ?";
            stmt = Conexao.getInstance().getConexao().prepareStatement(sql);
            
            stmt.setLong(1, (long) objeto);
            stmt.execute();
            
            this.rs = stmt.getResultSet();
            this.rs.absolute(1);
            
            if(this.aula == null){
                this.aula = new Aula();
            }
            
            this.aula.setId(this.rs.getLong(1));
            
            if(this.disciplina == null){
                this.disciplina = new Disciplina();
            }
            this.disciplina.setId(this.rs.getLong(2));
            this.disciplina.setDisciplina(this.rs.getString(3));
            
            this.aula.setDisciplina(this.disciplina);                       
            
            Time HoraInicio, HoraFinal;
            Date DataAula;
            
            Calendar cal1 = Calendar.getInstance();
            HoraInicio = this.rs.getTime(4);
            cal1.setTime(HoraInicio);
            this.aula.setHora_inicio(cal1);
            
            Calendar cal2 = Calendar.getInstance();
            HoraFinal = this.rs.getTime(5);
            cal2.setTime(HoraFinal);
            this.aula.setHora_termino(cal2);
            
            this.aula.setHoras_diarias(this.rs.getInt(6));
            
            Calendar cal3 = Calendar.getInstance();
            DataAula = this.rs.getDate(7);
            cal3.setTime(DataAula);
            this.aula.setData_aula(cal3);
            
            Conexao.getInstance().fechaConexao(stmt);
            
            return this.aula;
            
        } catch(SQLException e){
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public void pesquisar(int opcao, String valor) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void AtualizarTabela(String sql) {
                try {
            if (sql == ""){
                Janela_Generica.tabelaModelo.setSQL("select a.id_aula, d.disciplina, p.nome, a.Data_aula, a.hora_inicio, a.hora_terminio from Aula as a inner join Disciplina as d on a.id_disciplina = d.codigo "
                        + "left join professor as p on d.id_professor = p.id_professor order by Data_aula");
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
