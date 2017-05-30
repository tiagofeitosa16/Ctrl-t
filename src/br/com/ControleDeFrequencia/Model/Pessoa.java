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
public abstract class Pessoa {
    private int id;
    private String nome;
    private String cpf;
    private Sexo sexo;
    private Calendar data_nascimento;

    
    public Pessoa(){
        
    }
    
    abstract boolean ValidarCPF(String cpf);
    
    abstract boolean ValidarDataNascimento(Calendar data);
    
    public int getId() {
        return id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public Sexo getSexo() {
        return sexo;
    }

    public void setSexo(Sexo sexo) {
        this.sexo = sexo;
    }

    public Calendar getData_nascimento() {
        return data_nascimento;
    }

    public void setData_nascimento(Calendar data_nascimento) {
        this.data_nascimento = data_nascimento;
    }

}
    
    
    
 
