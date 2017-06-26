/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.ControleDeFrequencia.DAO;

import br.com.ControleDeFrequencia.Model.Equipamento;
import br.com.ControleDeFrequencia.View.Janela_Generica;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Calendar;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Lucas Eduardo
 */
public class EquipamentoDAO implements PadraoDAO {

    private Equipamento equipamento;
    private String sql;
    private PreparedStatement stmt;
    private ResultSet rs;

    @Override
    public boolean inserir(Object objeto) {
        try {
            sql = "insert into equipamento(descrição, numero_tombamento, data_cadastro, estatus, inativo) values(?,?,?,?,?)";
            this.equipamento = (Equipamento) objeto;

            stmt = Conexao.getInstance().getConexao().prepareStatement(sql);

            stmt.setString(1, this.equipamento.getDescricao());
            stmt.setInt(2, this.equipamento.getNumero_tombamento());
            stmt.setDate(3, new java.sql.Date(Calendar.getInstance().getTimeInMillis()));
            stmt.setInt(4, this.equipamento.getEstatus());
            stmt.setInt(5, this.equipamento.getInativo());

            stmt.execute();

            this.AtualizarTabela("");
            Conexao.getInstance().fechaConexao(stmt);

            return true;

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }

    @Override
    public boolean alterar(Object objeto) {
        try {
            sql = "update equipamento set descrição = ?, numero_tombamento = ?, data_cadastro = ?, estatus = ?, inativo = ? where codigo = ?";

            this.equipamento = (Equipamento) objeto;

            stmt = Conexao.getInstance().getConexao().prepareStatement(sql);

            stmt.setString(1, this.equipamento.getDescricao());
            stmt.setInt(2, this.equipamento.getNumero_tombamento());
            stmt.setDate(3, new java.sql.Date(Calendar.getInstance().getTimeInMillis()));
            stmt.setInt(4, this.equipamento.getEstatus());
            stmt.setInt(5, this.equipamento.getInativo());
            stmt.setLong(6, this.equipamento.getId());

            stmt.execute();

            this.AtualizarTabela("");
            Conexao.getInstance().fechaConexao(stmt);

            return true;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }

    @Override
    public boolean deletar(long id) {
        try {
            sql = "delete from equipamento where codigo = ?";
            stmt = Conexao.getInstance().getConexao().prepareStatement(sql);

            stmt.setLong(1, id);
            stmt.execute();

            this.AtualizarTabela("");
            Conexao.getInstance().fechaConexao(stmt);

            return true;

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }

    @Override
    public Object selecionar(Object objeto) {
        try {
            int inativo;
            sql = "Select codigo, descrição, numero_tombamento, data_cadastro, estatus, inativo from equipamento where codigo = ?";
            stmt = Conexao.getInstance().getConexao().prepareStatement(sql);

            stmt.setLong(1, (long) objeto);
            stmt.execute();

            this.rs = stmt.getResultSet();
            this.rs.absolute(1);

            if (this.equipamento == null) {
                this.equipamento = new Equipamento();
            }

            this.equipamento.setId((long) this.rs.getObject(1));
            this.equipamento.setDescricao((String) this.rs.getObject(2));
            this.equipamento.setNumero_tombamento((int) this.rs.getObject(3));
            Calendar cal1 = Calendar.getInstance();
            Date dataCadastro;
            dataCadastro = (Date) this.rs.getObject(4);
            cal1.setTime(dataCadastro);
            this.equipamento.setData_cadastro(cal1);
            this.equipamento.setEstatus((int) this.rs.getObject(5));
            if(Boolean.parseBoolean(this.rs.getObject(6).toString()))
                inativo = 1;
            else
                inativo = 0;
            this.equipamento.setInativo(inativo);

            Conexao.getInstance().fechaConexao(stmt);

            return this.equipamento;

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return "";

    }
    public void pesquisar(int opcao, String valor){
        String sqlTemp = "Select codigo, descrição, estatus from equipamento ";
        
        switch (opcao){
            case 1:
                sqlTemp = sqlTemp.concat("where codigo = '"+valor+"'");
                break;
            case 2:
                sqlTemp = sqlTemp.concat("where descrição like '%"+valor+"%'");
                break;
            case 3:
                sqlTemp = sqlTemp.concat("where estatus = '"+valor+"'");
                break;
            
            default:
                break;
        }
        
        try{
            if (!valor.isEmpty()){
                this.AtualizarTabela(sqlTemp);
            }else{
                this.AtualizarTabela("");
            }
            
        } catch(Exception e){
            e.printStackTrace();
        }
        
    }
    
    
    public void AtualizarTabela(String sql){
        try {
            if (sql == ""){
                Janela_Generica.tabelaModelo.setSQL("Select codigo, descrição, numero_tombamento from equipamento");
            }else{
                System.out.println(sql);
                Janela_Generica.tabelaModelo.setSQL(sql);
            }
        } catch (IllegalStateException e) {
            Logger.getLogger(EquipamentoDAO.class.getName()).log(Level.SEVERE, null, e);
        } catch (SQLException e) {
            Logger.getLogger(EquipamentoDAO.class.getName()).log(Level.SEVERE, null, e);
        }
    }

}
