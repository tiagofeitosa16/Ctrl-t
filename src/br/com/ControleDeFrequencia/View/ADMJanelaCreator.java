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
    public static final int cadastro_equipamento = 3;
    
    public ADMJanelas creator(int janela){
        if (janela == ADMJanelaCreator.cadastro_professor){
            return new JanCad_Professor();
        }else if(janela == ADMJanelaCreator.cadastro_equipamento){
            return new JanCad_Equipamento();
        }
        
        
        else{
            throw new IllegalArgumentException("Tipo de janela não encontrada");
        }          
    }
    
}
