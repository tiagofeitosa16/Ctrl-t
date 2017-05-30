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
public enum Vinculo {
    
    E("Efetivo"),
    T("Temporário");
    
    private String tipoVinculo;
    
    Vinculo(String tipoVinculo){
        this.tipoVinculo = tipoVinculo;
    }
    
    public String getTipoVinculo(){
        return this.tipoVinculo;
    }
    
}
