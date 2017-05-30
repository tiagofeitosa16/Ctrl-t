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
public abstract class Generic {

    private int id;
    private String nome;
    private Calendar data_criacao;

    public Generic() {

    }

    public int getId() {
        return id;
    }
    
    public void setId(int id){
        this.id = id;
    }
    
    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public Calendar getData_criacao() {
        return data_criacao;
    }

    public void setData_criacao(Calendar data_criacao) {
        this.data_criacao = data_criacao;
    }

}
