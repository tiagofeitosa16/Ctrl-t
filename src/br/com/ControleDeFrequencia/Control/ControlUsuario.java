/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.ControleDeFrequencia.Control;

import br.com.ControleDeFrequencia.DAO.PadraoDAO;
import br.com.ControleDeFrequencia.DAO.UsuarioDAO;
import br.com.ControleDeFrequencia.Model.Usuario;
import java.util.HashMap;

/**
 *
 * @author Usuario
 */
public class ControlUsuario implements ControlPadrao{
    private UsuarioDAO usuarioDao;
    private Usuario usuario;
    
    
    @Override
    public boolean ControlInserir(Object objeto) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean ControlAlterar(Object objeto) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean ControlDeletar(long id) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public HashMap ControlSelecionar(Object id) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void ControlPesquisar(int opcao, String valor) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
    public boolean ControlValidarUsuario(String usuario, String senha){
        if(this.usuarioDao == null){
            this.usuarioDao = new UsuarioDAO();
        }
        
        System.out.println(senha);
        
        if (this.usuarioDao.ValidarUsuario(usuario, senha)){
            return true;
        }else{
            return false;
        }
    }
}
