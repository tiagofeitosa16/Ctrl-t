package br.com.ControleDeFrequencia.Model;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.InputMismatchException;

/**
 *
 * @author Jerffeson
 */
public class Turma{

    private int codigo;
    private String descricao;
    private int graduacao;
    private String ano_letivo;

    public int getCodigo() {
        return this.codigo;
    }

    public boolean setCodigo(int codigo) {
        this.codigo = codigo;
        return true;
    }

    public String getDescricao() {
        return this.descricao;
    }

    public boolean setDescricao(String descricao) {
        this.descricao = descricao;
        return true;
    }

    public int getGraduacao() {
        return this.graduacao;
    }

    public boolean setGraduacao(int graduacao) {
        this.graduacao = graduacao;
        return true;
    }

    public String getAno_letivo() {
        return this.ano_letivo;
    }

    public boolean setAno_letivo(String ano_letivo) {
        this.ano_letivo = ano_letivo;
        return true;
    }

}
