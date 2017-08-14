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
public class Aula {
    
    private long id;
    private Calendar data_aula;
    private Calendar hora_inicio;
    private Calendar hora_termino;
    private int horas_diarias;
    private Disciplina disciplina;
    
    private ArrayList<Equipamento> euipamentos; 

    public Aula(){
        
    }
    
    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public Calendar getData_aula() {
        return data_aula;
    }

    public void setData_aula(Calendar data_aula) {
        this.data_aula = data_aula;
    }

    public Calendar getHora_inicio() {
        return hora_inicio;
    }

    public void setHora_inicio(Calendar hora_inicio) {
        this.hora_inicio = hora_inicio;
    }

    public Calendar getHora_termino() {
        return hora_termino;
    }

    public void setHora_termino(Calendar hora_termino) {
        this.hora_termino = hora_termino;
    }

    public int getHoras_diarias() {
        return horas_diarias;
    }

    public void setHoras_diarias(int horas_diarias) {
        this.horas_diarias = horas_diarias;
    }

    public Disciplina getDisciplina() {
        return disciplina;
    }

    public void setDisciplina(Disciplina disciplina) {
        this.disciplina = disciplina;
    }

    public ArrayList<Equipamento> getEuipamentos() {
        return euipamentos;
    }

    public void setEuipamentos(ArrayList<Equipamento> euipamentos) {
        this.euipamentos = euipamentos;
    }
    
}
