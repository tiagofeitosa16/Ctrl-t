/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.ControleDeFrequencia.DAO;

import br.com.ControleDeFrequencia.Model.Professor;
import java.util.List;

/**
 *
 * @author Usuario
 */
public interface PadraoDAO {
    
    public boolean inserir(Object objeto);
    public boolean alterar(Object objeto);
    public boolean deletar(int id);
    public List<Professor> listar();
    public Professor exibir(int id);

}
