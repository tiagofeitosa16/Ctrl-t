/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.ControleDeFrequencia.DAO;

import br.com.ControleDeFrequencia.Model.Grupo;
import br.com.ControleDeFrequencia.Model.Usuario;
import br.com.ControleDeFrequencia.View.Janela_Generica;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Usuario
 */
public class UsuarioDAO implements PadraoDAO{

    private Usuario usuario;
    private Grupo grupo;
    private String sql;
    private PreparedStatement stmt;
    private ResultSet rs;    
    
    @Override
    public boolean inserir(Object objeto) {
        try{
            this.sql = "insert into usuario(nome, usuario, senha, id_grupo) values(?, ?, MD5(?), ?)";
            
            this.usuario = (Usuario) objeto;
            
            this.stmt = Conexao.getInstance().getConexao().prepareStatement(this.sql);
            this.stmt.setString(1, this.usuario.getNome());
            this.stmt.setString(2, this.usuario.getUsuario());
            this.stmt.setString(3, this.usuario.getSenha());
            this.stmt.setLong(4, this.usuario.getGrupo().getCodigo());
            
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
            this.sql = "update usuario set nome = ?, usuario = ?, id_grupo = ? where id_usuario = ?";
            
            this.usuario = (Usuario) objeto;
            
            this.stmt = Conexao.getInstance().getConexao().prepareStatement(this.sql);
            this.stmt.setString(1, this.usuario.getNome());
            this.stmt.setString(2, this.usuario.getUsuario());
            this.stmt.setLong(3, this.usuario.getGrupo().getCodigo());
            this.stmt.setLong(4, this.usuario.getCodigo());
            
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
            this.sql = "delete from usuario where id_usuario = ?";
            
            this.stmt = Conexao.getInstance().getConexao().prepareStatement(this.sql);
            this.stmt.setLong(1, id);
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
    public Object selecionar(Object objeto) {
        try{
            this.sql = "Select id_usuario, nome, usuario, id_grupo from usuario where id_usuario = ?";
            
            this.stmt = Conexao.getInstance().getConexao().prepareStatement(this.sql);
            this.stmt.setLong(1, (long) objeto);
            this.stmt.execute();
            
            this.rs = this.stmt.getResultSet();
            this.rs.absolute(1);
            
            this.usuario = new Usuario();
            this.usuario.setCodigo(Long.parseLong(this.rs.getObject(1).toString()));
            this.usuario.setNome(this.rs.getObject(2).toString());
            this.usuario.setUsuario(this.rs.getObject(3).toString());
            
            this.grupo = new Grupo();
            this.grupo.setCodigo(Integer.parseInt(this.rs.getObject(4).toString()));
            this.usuario.setGrupo(this.grupo);
            
            Conexao.getInstance().fechaConexao(stmt, rs);
            
            return this.usuario;
            
        } catch(SQLException e){
            e.printStackTrace();
        }
        
        return null;
        
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

    public void AtualizarTabela(String sql){
        try {
            if (sql == ""){
                Janela_Generica.tabelaModelo.setSQL("Select id_usuario, usuario, id_grupo from Usuario");
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
