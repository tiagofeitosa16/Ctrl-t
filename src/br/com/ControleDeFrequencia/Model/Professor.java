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
    private Titulo titulo;
    private Cargo cargos;
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

    public Cargo getCargos() {
        return cargos;
    }

    public void setCargos(int id) {
        this.cargos = new Cargo();
        this.cargos.setId(id);
    }

    public String getSiape() {
        return Siape;
    }

    public void setSiape(String Siape) {
        this.Siape = Siape;
    }

    public Titulo getTitulo() {
        return titulo;
    }

    public void setTitulo(int id) {
        this.titulo = new Titulo();
        this.titulo.setId(id);
                
    }

    public Calendar getData_cadastramento() {
        return data_cadastramento;
    }

    
}
