/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.ControleDeFrequencia.Model;

import java.util.Calendar;

/**
 *
 * @author Lucas Eduardo
 */
public class Equipamento {

    private long id;
    private String descricao;
    private int numero_tombamento;
    private Calendar data_cadastro;
    private int estatus;
    private int inativo;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public int getNumero_tombamento() {
        return numero_tombamento;
    }

    public void setNumero_tombamento(int numero_tombamento) {
        this.numero_tombamento = numero_tombamento;
    }

    public Calendar getData_cadastro() {
        return data_cadastro;
    }

    public void setData_cadastro(Calendar data_cadastro) {
        this.data_cadastro = data_cadastro;
    }

    public int getEstatus() {
        return estatus;
    }

    public void setEstatus(int estatus) {
        this.estatus = estatus;
    }

    public int getInativo() {
        return inativo;
    }

    public void setInativo(int inativo) {
        this.inativo = inativo;
    }

}
