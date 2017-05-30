/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.ControleDeFrequencia.Model;

import java.util.Calendar;

/**
 *
 * @author Usuario
 */
public class Titulo extends Generic {
    
    private Calendar ano;

    public Calendar getAno() {
        return ano;
    }

    public void setAno(Calendar ano) {
        this.ano = ano;
    }
    
}
