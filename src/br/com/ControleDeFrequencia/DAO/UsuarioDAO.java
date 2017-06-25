/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.ControleDeFrequencia.DAO;

import br.com.ControleDeFrequencia.Model.Usuario;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 *
 * @author Usuario
 */
public class UsuarioDAO implements PadraoDAO{

    private Usuario usuario;
    private String sql;
    private PreparedStatement stmt;
    private ResultSet rs;    
    
    @Override
    public boolean inserir(Object objeto) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean alterar(Object objeto) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean deletar(long id) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Object selecionar(Object objeto) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
    public boolean ValidarUsuario(String usuario, String senha){
        try{
            this.sql = "select count(*) as total from usuario where usuario = ? and senha = MD5(?)";
            
            this.stmt = Conexao.getInstance().getConexao().prepareStatement(sql);
            this.stmt.setString(1, usuario);
            this.stmt.setString(2, senha);
            
            this.stmt.execute();
            
            this.rs = this.stmt.getResultSet();
            this.rs.absolute(1);
            
            long quant = (long) this.rs.getObject(1);
                 
            if (quant >=1){
                Conexao.getInstance().fechaConexao(stmt, rs);
                return true;
            }else{
                return false;
            }                  
        } catch(SQLException e){
            e.printStackTrace();
        }
        return false;
    }
    
}
