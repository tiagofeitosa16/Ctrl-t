/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.ControleDeFrequencia.Control;

import java.util.HashMap;

/**
 *
 * @author Programação
 */
public interface ControlPadrao {
    
    public boolean ControlInserir(Object objeto);
    
    public boolean ControlAlterar(Object objeto);
    
    public boolean ControlDeletar(int id);
    
    public HashMap ControlSelecionar(int id);
    
}
