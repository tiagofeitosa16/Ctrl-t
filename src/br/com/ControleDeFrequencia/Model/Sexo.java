/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.ControleDeFrequencia.Model;

/**
 *
 * @author Usuario
 */
public enum Sexo {
    Masculino("M"),
    Feminino("F");
    
    private String sexo;
    
    Sexo(String sexo){
        this.sexo = sexo;
    }
    
    public String getSexo(){
        return this.sexo;
    }  
    
}
