/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.ControleDeFrequencia.Model;

import java.util.ArrayList;
import java.util.Calendar;

/**
 *
 * @author Usuario
 */
public class Professor extends Pessoa {

    private String Siape;
    private int titulo;
    private int vinculo;
    private Calendar data_cadastramento;

    @Override
    boolean ValidarCPF(String cpf) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    boolean ValidarDataNascimento(Calendar data) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public boolean validarSiape(String siape) {
        return true;
    }

    public int getVinculo() {
        return vinculo;
    }

    public void setVinculo(int id) {
        this.vinculo = id;
    }

    public String getSiape() {
        return Siape;
    }

    public void setSiape(String Siape) {
        this.Siape = Siape;
    }

    public int getTitulo() {
        return titulo;
    }

    public void setTitulo(int id) {
        this.titulo = id;            
    }

    public Calendar getData_cadastramento() {
        return data_cadastramento;
    }
    
}
