/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.ControleDeFrequencia.DAO;

/**
 *
 * @author Usuario
 */
public interface PadraoDAO {
    
    public boolean inserir(Object objeto);
    public boolean alterar(Object objeto);
    public boolean deletar(long id);
    public Object selecionar(Object objeto);
    public void pesquisar(int opcao, String valor);
    public void AtualizarTabela(String sql);

}
