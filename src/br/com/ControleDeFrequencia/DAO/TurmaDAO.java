package br.com.ControleDeFrequencia.DAO;

import br.com.ControleDeFrequencia.Model.Turma;
import br.com.ControleDeFrequencia.View.Janela_Generica;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Usuario
 */
public class TurmaDAO implements PadraoDAO{
    private Turma turma;
    private String sql;
    private PreparedStatement stmt;
    private ResultSet rs;
    
    @Override
    public boolean inserir(Object objeto) {
        try{
            sql = "INSERT INTO Turma(descricao, graduacao, ano_letivo) values(?,?,?)";
            this.turma = (Turma) objeto;
  
            stmt = Conexao.getInstance().getConexao().prepareStatement(sql);
            
            stmt.setString(1, this.turma.getDescricao());
            stmt.setString(2, "" + this.turma.getGraduacao());
            stmt.setString(3, "" + this.turma.getAno_letivo());
            
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
            sql = "UPDATE Turma SET descricao = ?, graduacao = ?, ano_letivo = ? WHERE codigo = ?";
            
            this.turma = (Turma) objeto;
            
            stmt = Conexao.getInstance().getConexao().prepareStatement(sql);
            
            stmt.setString(1, this.turma.getDescricao());
            stmt.setInt(2, this.turma.getGraduacao());
            stmt.setString(3, this.turma.getAno_letivo());
            stmt.setLong(4, this.turma.getCodigo());
            
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
            sql = "DELETE FROM Turma where codigo = ?";
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
            sql = "SELECT codigo, descricao,  case graduacao\n" +
"								when 1 then 'Superior'\n" +
"								when 2 then 'Técnico'\n" +
"								when 3 then 'Subsequente'\n" +
"							end as graduacao, \n" +
"                              ano_letivo FROM Turma where codigo = ?";
            stmt = Conexao.getInstance().getConexao().prepareStatement(sql);
            
            stmt.setLong(1, (long) objeto);
            stmt.execute();
            
            this.rs = stmt.getResultSet();
            this.rs.absolute(1);
            
            if(this.turma == null){
                this.turma = new Turma();
            }
            
            this.turma.setCodigo(Integer.parseInt(this.rs.getObject(1).toString()));
            this.turma.setDescricao((String) this.rs.getObject(2));
            if ( this.rs.getObject(3).toString().equals("Superior") ){
                this.turma.setGraduacao(1);
            }
            else if ( this.rs.getObject(3).toString().equals("Técnico") ){
                this.turma.setGraduacao(2);
            } else {
                this.turma.setGraduacao(3);
            }
            this.turma.setAno_letivo(this.rs.getObject(4).toString());
            
            Conexao.getInstance().fechaConexao(stmt);
            
            return this.turma;
            
        } catch(SQLException e){
            e.printStackTrace();
        }
        return "";
    }
    
    public void pesquisar(int opcao, String valor){
        String sqlTemp = "SELECT codigo, descricao,  case graduacao\n" +
"								when 1 then 'Superior'\n" +
"								when 2 then 'Técnico'\n" +
"								when 3 then 'Subsequente'\n" +
"							end as graduacao, \n" +
"                              ano_letivo FROM Turma ";
        
        switch (opcao){
            case 1:
                sqlTemp = sqlTemp.concat("where codigo = '"+valor+"'");
                break;
            case 2:
                sqlTemp = sqlTemp.concat("where descricao like '%"+valor+"%'");
                break;
            case 3:
                if ((valor.toLowerCase().startsWith("s") || valor.toLowerCase().startsWith("su")) && (valor.length() == 1 || valor.length() == 2)){
                    sqlTemp = sqlTemp.concat("where graduacao = '1' or graduacao = '3'");
                    break;
                } else if (valor.toLowerCase().startsWith("sup")){
                    valor="1";
                } else if (valor.toLowerCase().startsWith("t")){
                    valor="2";
                } else if (valor.toLowerCase().startsWith("sub")){
                    valor="3";
                }
                sqlTemp = sqlTemp.concat("where graduacao = '"+valor+"'");
                break;
            case 4:
                sqlTemp = sqlTemp.concat("where ano_letivo = '"+valor+"'");
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
    
    public void AtualizarTabela(String sql){
        try {
            if (sql == ""){
                Janela_Generica.tabelaModelo.setSQL("SELECT codigo, descricao,  case graduacao\n" +
"								when 1 then 'Superior'\n" +
"								when 2 then 'Técnico'\n" +
"								when 3 then 'Subsequente'\n" +
"							end as graduacao, \n" +
"                              ano_letivo FROM Turma");
            }else{
                System.out.println(sql);
                Janela_Generica.tabelaModelo.setSQL(sql);
            }
        } catch (IllegalStateException e) {
            Logger.getLogger(TurmaDAO.class.getName()).log(Level.SEVERE, null, e);
        } catch (SQLException e) {
            Logger.getLogger(TurmaDAO.class.getName()).log(Level.SEVERE, null, e);
        }
    }    
    
}
