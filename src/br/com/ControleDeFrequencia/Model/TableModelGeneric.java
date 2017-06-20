/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.ControleDeFrequencia.Model;

import br.com.ControleDeFrequencia.DAO.Conexao;
import java.sql.ResultSetMetaData;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javax.swing.table.AbstractTableModel;

/**
 *
 * @author Usuario
 */
public class TableModelGeneric extends AbstractTableModel {
    
    private Statement stmt;
    private ResultSet rs;
    private ResultSetMetaData rm;
    
    private boolean statusConexao = false;
    private int numeroDeLinhas;
    
    public TableModelGeneric(String sql) throws SQLException{
        
        this.stmt = Conexao.getInstance().getConexao().createStatement(ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_READ_ONLY);
        
        this.statusConexao = true;
        
        setSQL(sql);

    }
    
    public Class getColumnClass(int coluna) throws IllegalStateException{
        if(!this.statusConexao){
            throw new IllegalStateException("Banco de Dados não Conectado!");
        }
        
        try{
            
            String nomeDaClasse = this.rm.getColumnClassName(coluna + 1);
            return Class.forName(nomeDaClasse);
            
        } catch(Exception e){
            
            e.printStackTrace();
            
        }
        return Object.class;
    } 
    
    @Override
    public int getRowCount() throws IllegalStateException{
        if(!this.statusConexao){
            throw new IllegalStateException("Banco de Dados não conectado!");
        }
        
        return this.numeroDeLinhas;
        
    }    
    
    @Override
    public int getColumnCount() throws IllegalStateException {
        if(!this.statusConexao){
            throw new IllegalStateException("Banco de Dados não conectado!");
        }
        
        try{
            return this.rm.getColumnCount();
        } catch(SQLException e){
            e.printStackTrace();
        }
        return 0;
    }
    
    public String getColumnName(int coluna) throws IllegalStateException{
		// Garantir que o banco de dados esteja conectado
		if(!statusConexao){
			throw new IllegalStateException("Banco de dados não conectado!");
		}
		
		try{
			
			return this.rm.getColumnName(coluna + 1);
		
		} catch(SQLException e){
			e.printStackTrace();
		}
	
		return "";
				
	}

    @Override
    public Object getValueAt(int linha, int coluna) throws IllegalStateException {
        if(!this.statusConexao){
            throw new IllegalStateException("Banco de Dados não conectado!");
        }
        
        try{
            
            this.rs.absolute(linha + 1);
            return this.rs.getObject(coluna + 1);
            
        } catch(SQLException e){
            e.printStackTrace();
        }
        return "";
    }
    
    
    
    public void setSQL(String sql) throws IllegalStateException, SQLException{
        
        if(!this.statusConexao){
            throw new IllegalStateException("Banco de Dados não conectado!");
        }
        
        try{
            this.rs = this.stmt.executeQuery(sql);
            this.rm = this.rs.getMetaData();
        
            this.rs.last();
            this.numeroDeLinhas = this.rs.getRow();
            
            fireTableStructureChanged();
            
        } catch(SQLException e){
            e.printStackTrace();
        }
    }

    public void DisconectarConexao(){
		if(this.statusConexao){
			try{
                            stmt.close();
                            Conexao.getInstance().fechaConexao(null, rs);
			} catch(SQLException sqlexception){
				sqlexception.printStackTrace();
			}finally{
				this.statusConexao = true;
			}
		}
	}

    
}
