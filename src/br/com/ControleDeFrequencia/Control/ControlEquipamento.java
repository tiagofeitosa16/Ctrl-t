/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.ControleDeFrequencia.Control;

import br.com.ControleDeFrequencia.DAO.EquipamentoDAO;
import br.com.ControleDeFrequencia.Model.Equipamento;
import java.util.HashMap;

/**
 *
 * @author Lucas Eduardo
 */
public class ControlEquipamento implements ControlPadrao{
    
    private Equipamento equipamento;
    private EquipamentoDAO equipamentoDao;

    @Override
    public boolean ControlInserir(Object objeto) {
        this.equipamento = new Equipamento();
        
        
        HashMap map = (HashMap) objeto;
        this.equipamento.setDescricao((String) map.get("descrição").toString());
        this.equipamento.setNumero_tombamento(Integer.parseInt(map.get("numero_tombamento").toString()));
        this.equipamento.setEstatus((int) map.get("estatus"));
        this.equipamento.setInativo((int) map.get("inativo"));
        
        if (this.equipamentoDao == null){
            this.equipamentoDao = new EquipamentoDAO();
        }
   
        if(this.equipamentoDao.inserir(this.equipamento)){
            return true;
        }
        return false;
    }

    @Override
    public boolean ControlAlterar(Object objeto) {
        HashMap map = (HashMap) objeto;


        this.equipamento = new Equipamento();

        this.equipamento.setId(Long.parseLong(map.get("codigo").toString()));
        this.equipamento.setDescricao(map.get("descrição").toString());
        this.equipamento.setNumero_tombamento(Integer.parseInt(map.get("numero_tombamento").toString()));
        this.equipamento.setEstatus((int)map.get("estatus"));
        this.equipamento.setInativo((int)map.get("inativo"));

        if (this.equipamentoDao == null){
                this.equipamentoDao = new EquipamentoDAO();
            }

            if(this.equipamentoDao.alterar(this.equipamento)){
                return true;
            }
            return false;
    
    }

    @Override
    public boolean ControlDeletar(long id) {
    if (this.equipamentoDao == null){
            this.equipamentoDao = new EquipamentoDAO();
        }
        
        if (this.equipamentoDao.deletar(id)){
            return true;
        } else{
            return false;
        }    
    }

    @Override
    public HashMap ControlSelecionar(Object id) {
        if (this.equipamentoDao == null){
            this.equipamentoDao = new EquipamentoDAO();
        }
        
        if (this.equipamentoDao.selecionar(id) != ""){
            this.equipamento = (Equipamento) this.equipamentoDao.selecionar(id);
            HashMap selecao = new HashMap();
            selecao.put("codigo", this.equipamento.getId());
            selecao.put("descrição", this.equipamento.getDescricao());
            selecao.put("numero_tombamento", this.equipamento.getNumero_tombamento());
            selecao.put("data_cadastro", this.equipamento.getData_cadastro());
            selecao.put("estatus", this.equipamento.getEstatus());
            selecao.put("inativo", this.equipamento.getInativo());
          
            
            return selecao;
        }
        return null;
    }

    @Override
    public void ControlPesquisar(int opcao, String valor) {
    if (equipamentoDao == null){
             this.equipamentoDao = new EquipamentoDAO();
        }   
    
    this.equipamentoDao.pesquisar(opcao, valor);
    }
    
}
