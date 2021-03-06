/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.ControleDeFrequencia.Control;

/**
 *
 * @author Usuario
 */
public class ADMControlPadrao {

    public static final int ControlProfessor = 1;
    public static final int ControlUsuario = 2;
    public static final int ControlEquipamentos = 3;
    public static final int ControlDisciplina = 4;
    public static final int ControlCronograma = 5;
    
    public ControlPadrao creator(int control){
        if (control == ADMControlPadrao.ControlProfessor){
            return new ControlProfessor();
        }else if(control == ADMControlPadrao.ControlUsuario){
            return new ControlUsuario();
        } else if (control == ADMControlPadrao.ControlEquipamentos) {
            return new ControlEquipamento();
        } else if (control == ADMControlPadrao.ControlDisciplina) {
            return new ControlDisciplina();
        } else if (control == ADMControlPadrao.ControlCronograma){
            return new ControlCronograma();
        } else {
            throw new IllegalArgumentException("Controle padrão não encontrado");
        }
    }
}
