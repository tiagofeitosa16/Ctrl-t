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
    public static final int ControlTurma = 4;
    
    public ControlPadrao creator(int control){
        if (control == ADMControlPadrao.ControlProfessor){
            return new ControlProfessor();
        }else if(control == ADMControlPadrao.ControlUsuario){
            return new ControlUsuario();
        } else if (control == ADMControlPadrao.ControlEquipamentos) {
            return new ControlEquipamento();
        } else if (control == ADMControlPadrao.ControlTurma) {
            return new ControlTurma();
        } else {
            throw new IllegalArgumentException("Controle padrão não encontrado");
        }
    }
}
