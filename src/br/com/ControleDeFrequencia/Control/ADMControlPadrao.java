/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.ControleDeFrequencia.Control;

/**
 *
 * @author Usuario
 */
public class ADMControlPadrao {
    public static final int ControlProfessor = 1;
    
    public ControlPadrao creator(int control){
        if (control == ADMControlPadrao.ControlProfessor){
            return new ControlProfessor();
        }else{
            throw new IllegalArgumentException("Controle padrão não encontrado");
        }
    }
}
