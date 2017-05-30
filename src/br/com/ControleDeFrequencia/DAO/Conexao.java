/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.ControleDeFrequencia.DAO;

import java.beans.Statement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import jdk.nashorn.internal.codegen.CompilerConstants;

/**
 *
 * @author Usuario
 */
public class Conexao {

    private static Conexao instance = null;
    private Connection conexao = null;
    
    public static Conexao getInstance(){
        if(Conexao.instance == null){
            Conexao.instance = new Conexao();
        }
        return Conexao.instance;
    }
    
    public Connection getConexao(){
        try{
            conexao = DriverManager.getConnection("jdbc:mysql://localhost/Dados","root","root");
            return conexao;
        } catch(SQLException e){
            throw new RuntimeException(e);
        }
    }
    
    public void fechaConexao(){
        try {
            if (this.conexao != null){
                this.conexao.close();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    
    public void fechaConexao(PreparedStatement ps){
        fechaConexao();
        try{
            if (ps != null){
                ps.close();
            }
        } catch(SQLException e){
            e.printStackTrace();
        }
    }
    
    public void fechaConexao(PreparedStatement ps, ResultSet rs){
        fechaConexao();
        try{
            if (ps != null){
                ps.close();
            }
            
            if(rs != null){
                rs.close();
            }
        } catch(SQLException e){
            e.printStackTrace();
        }
    }
}
