/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.ControleDeFrequencia.Control;

import br.com.ControleDeFrequencia.DAO.PadraoDAO;
import br.com.ControleDeFrequencia.DAO.UsuarioDAO;
import br.com.ControleDeFrequencia.Model.Grupo;
import br.com.ControleDeFrequencia.Model.Usuario;
import java.util.HashMap;

/**
 *
 * @author Usuario
 */
public class ControlUsuario implements ControlPadrao{
    private UsuarioDAO usuarioDao;
    private Usuario usuario;
    private Grupo grupo;
    
    
    @Override
    public boolean ControlInserir(Object objeto) {
        
        if(this.usuario == null){
            this.usuario = new Usuario();
        }
        
        HashMap infoJanela = (HashMap) objeto;
        
        this.usuario.setNome((String) infoJanela.get("nome"));
        this.usuario.setUsuario((String) infoJanela.get("usuario"));
        this.usuario.setSenha((String) infoJanela.get("senha"));
        this.grupo = new Grupo();
        this.grupo.setCodigo(Long.parseLong(infoJanela.get("id_grupo").toString()));
        this.usuario.setGrupo(this.grupo);
        
        if(this.usuarioDao == null){
            this.usuarioDao = new UsuarioDAO();
        }
        
        if (this.usuarioDao.inserir(this.usuario)){
            return true;
        }
        return false;
    }

    @Override
    public boolean ControlAlterar(Object objeto) {
        if(this.usuario == null){
            this.usuario = new Usuario();
        }
        
        HashMap infoJanela = (HashMap) objeto;
        
        this.usuario.setCodigo(Long.parseLong(infoJanela.get("id_usuario").toString()));
        this.usuario.setNome((String) infoJanela.get("nome"));
        this.usuario.setUsuario((String) infoJanela.get("usuario"));
        this.usuario.setSenha((String) infoJanela.get("senha"));
        this.grupo = new Grupo();
        this.grupo.setCodigo(Integer.parseInt(infoJanela.get("id_grupo").toString()));
        this.usuario.setGrupo(this.grupo);
        
        if(this.usuarioDao == null){
            this.usuarioDao = new UsuarioDAO();
        }
        
        if (this.usuarioDao.alterar(this.usuario)){
            return true;
        }
        return false;
    }

    @Override
    public boolean ControlDeletar(long id) {
        if(this.usuarioDao == null){
            this.usuarioDao = new UsuarioDAO();
        }
        
        if(this.usuarioDao.deletar(id)){
            return true;
        }
        return false;
    }

    @Override
    public HashMap ControlSelecionar(Object id) {
        if(this.usuarioDao == null){
            this.usuarioDao = new UsuarioDAO();
        }
        
        this.usuario = (Usuario) this.usuarioDao.selecionar(id);
        
        if(this.usuario != null){
            HashMap selecao = new HashMap();
            selecao.put("id_usuario", this.usuario.getCodigo());
            selecao.put("nome", this.usuario.getNome());
            selecao.put("usuario", this.usuario.getUsuario());
            selecao.put("id_grupo", this.usuario.getGrupo().getCodigo());
            
            return selecao;
        }
        return null;
    }

    @Override
    public void ControlPesquisar(int opcao, String valor) {
        if(this.usuarioDao == null){
            this.usuarioDao = new UsuarioDAO();
        }
        
        this.usuarioDao.pesquisar(opcao, valor);
        
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
