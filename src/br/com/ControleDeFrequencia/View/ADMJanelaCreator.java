/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.ControleDeFrequencia.View;

/**
 *
 * @author Usuario
 */
public class ADMJanelaCreator {
    
    public static final int cadastro_professor = 1;
    
    public ADMJanelas creator(int janela){
        if (janela == ADMJanelaCreator.cadastro_professor){
            return new JanCad_Professor();
        }else{
            throw new IllegalArgumentException("Tipo de janela não encontrada");
        }          
    }
    
}