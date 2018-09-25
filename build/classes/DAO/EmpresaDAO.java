/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import Control.Conexao;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 *
 * @author gabri
 */
public class EmpresaDAO {

    private double cnpjEmp;
    private String nomeEmp;
    private int numeroVagasEmp;
    private String razaoSocialEmp;
    private int idEndereco_FK;

    public EmpresaDAO(){
        
    }
    
    public EmpresaDAO(double cnpjEmp, String nomeEmp, int numeroVagasEmp, String razaoSocialEmp, int idEndereco) {
        this.cnpjEmp = cnpjEmp;
        this.nomeEmp = nomeEmp;
        this.numeroVagasEmp = numeroVagasEmp;
        this.razaoSocialEmp = razaoSocialEmp;
        this.idEndereco_FK = idEndereco;
    }

    /**
     * Método para inserir uma empresa no banco de dados.
     */
    public void setEmpresa() {

        String comando = "insert into empresa values (?,?,?,?,?)";

        try {
            Connection conexao = new Conexao().getConnection();

            PreparedStatement comandoSQL = conexao.prepareStatement(comando);

            comandoSQL.setDouble(1, this.getCnpjEmp());
            comandoSQL.setString(2, this.getNomeEmp());
            comandoSQL.setInt(3, this.getNumeroVagasEmp());
            comandoSQL.setString(4, this.getRazaoSocialEmp());
            comandoSQL.setInt(5, this.getIdEndereco_FK());
            
            comandoSQL.executeUpdate();

            comandoSQL.close();
            conexao.close();
            
        } catch (SQLException ex) {
            ex.printStackTrace();
        }

    }

    /**
     *Método para alterar uma empresa no banco de dados
     */
    public void altEmpresa() {
        
        String comando = "update encaminhamento set nomeEmp = ?, numeroVagasEmp = ?, "
                + "razaoSocialEmp = ?, idEndereco = ? where cnpjEmp = ?";

        try {
            Connection conexao = new Conexao().getConnection();

            PreparedStatement comandoSQL = conexao.prepareStatement(comando);

            comandoSQL.setDouble(5, this.getCnpjEmp());
            comandoSQL.setString(1, this.getNomeEmp());
            comandoSQL.setInt(2, this.getNumeroVagasEmp());
            comandoSQL.setString(3, this.getRazaoSocialEmp());
            comandoSQL.setInt(4, this.getIdEndereco_FK());
            
            comandoSQL.executeUpdate();

            comandoSQL.close();
            conexao.close();
            
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }

    public EmpresaDAO getEmpresa() {

        EmpresaDAO empresa = new EmpresaDAO();

        String listarEmpresa = "SELECT * FROM encaminhamento";

        try {

            Connection conexao = new Conexao().getConnection();
            
            PreparedStatement comandoSQL = conexao.prepareStatement(listarEmpresa);

            ResultSet retorno = comandoSQL.executeQuery();

            while (retorno.next()) {

                empresa.setCnpjEmp(retorno.getDouble("cnpjEmp"));
                empresa.setNomeEmp(retorno.getString("nomeEmp"));
                empresa.setNumeroVagasEmp(retorno.getInt("numeroVagasEmp"));
                empresa.setRazaoSocialEmp(retorno.getString("razaoSocialEmp"));
                empresa.setIdEndereco_FK(retorno.getInt("idEndereco"));
                
            }
            
            comandoSQL.close();
            conexao.close();
            
        } catch (SQLException ex) {
            ex.printStackTrace();
        }

        return empresa;

    }
    
    public int getIdEndereco_FK() {
        return idEndereco_FK;
    }

    public void setIdEndereco_FK(int idEndereco_FK) {
        this.idEndereco_FK = idEndereco_FK;
    }

    public double getCnpjEmp() {
        return cnpjEmp;
    }

    public void setCnpjEmp(double cnpjEmp) {
        this.cnpjEmp = cnpjEmp;
    }

    public String getNomeEmp() {
        return nomeEmp;
    }

    public void setNomeEmp(String nomeEmp) {
        this.nomeEmp = nomeEmp;
    }

    public int getNumeroVagasEmp() {
        return numeroVagasEmp;
    }

    public void setNumeroVagasEmp(int numeroVagasEmp) {
        this.numeroVagasEmp = numeroVagasEmp;
    }

    public String getRazaoSocialEmp() {
        return razaoSocialEmp;
    }

    public void setRazaoSocialEmp(String razaoSocialEmp) {
        this.razaoSocialEmp = razaoSocialEmp;
    }
    
    
    
}
