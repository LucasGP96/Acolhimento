package DAO;

import Control.Conexao;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 * Classe para controlar a entidade de relacionamentos.
 *
 * @author Gabriel Ferreira Franco
 */
public class EncaminhamentoDAO {

    private String tipoEnc;
    private String localEnc;
    private String statusEnc;
    private long cpfFunc_FK;
    private long nProntuarioUsu_FK;
    private long idEndereco_FK;

    public EncaminhamentoDAO() {

    }

    public EncaminhamentoDAO(String tipoEnc, String localEnc, String statusEnc, long cpfFunc_FK, long nProntuarioUsu_FK, long idEndereco_FK) {
        this.tipoEnc = tipoEnc;
        this.localEnc = localEnc;
        this.statusEnc = statusEnc;
        this.cpfFunc_FK = cpfFunc_FK;
        this.nProntuarioUsu_FK = nProntuarioUsu_FK;
        this.idEndereco_FK = idEndereco_FK;
    }

    /**
     * Método para inserir um encaminhamento no banco de dados.
     */
    public void setEncaminhamento() {

        String comando = "insert into encaminhamento (tipoEnc, localEnc, statusEnc, cpfFunc,"
                + " nProntuarioUsu, idEndereco) values (?,?,?,?,?,?)";

        try {
            Connection conexao = new Conexao().getConnection();

            PreparedStatement comandoSQL = conexao.prepareStatement(comando);

            comandoSQL.setString(1, this.getTipoEnc());
            comandoSQL.setString(2, this.getLocalEnc());
            comandoSQL.setString(3, this.getStatusEnc());
            comandoSQL.setLong(4, this.getCpfFunc_FK());
            comandoSQL.setLong(5, this.getnProntuarioUsu_FK());
            comandoSQL.setLong(6, this.getIdEndereco_FK());

            comandoSQL.executeUpdate();

            comandoSQL.close();
            conexao.close();
        } catch (SQLException ex) {
            ex.printStackTrace();
        }

    }

    /**
     *Método para alterar um encaminhamento no banco de dados
     */
    public void altEncaminhamento() {
        
        String comando = "update encaminhamento set tipoEnc = ?, localEnc = ?,"
                + " statusEnc = ?, cpfFunc = ?, nProntuarioUsu = ?, idEndereco = ?";

        try {
            Connection conexao = new Conexao().getConnection();

            PreparedStatement comandoSQL = conexao.prepareStatement(comando);

            comandoSQL.setString(1, this.getTipoEnc());
            comandoSQL.setString(2, this.getLocalEnc());
            comandoSQL.setString(3, this.getStatusEnc());
            comandoSQL.setLong(4, this.getCpfFunc_FK());
            comandoSQL.setLong(5, this.getnProntuarioUsu_FK());
            comandoSQL.setLong(6, this.getIdEndereco_FK());

            comandoSQL.executeUpdate();

            comandoSQL.close();
            conexao.close();
            
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        
    }

    /**
     * Método para retornar todos os encaminhamentos
     *
     * @return
     */
    public ArrayList getEncaminhamento() {

        ArrayList lista = new ArrayList();

        String listarEncaminhamentos = "SELECT tipoEnc, localEnc, statusEnc, cpfFunc, nProntuarioUsu, idEndereco "
                + "FROM encaminhamento";

        Connection conexao;
        try {
            conexao = new Conexao().getConnection();
            
            PreparedStatement comandoSQL = conexao.prepareStatement(listarEncaminhamentos);

            ResultSet retorno = comandoSQL.executeQuery();

            while (retorno.next()) {

                Object[] linha = new Object[6];

                linha[0] = retorno.getString("tipoEnc");
                linha[1] = retorno.getString("localEnc");
                linha[2] = retorno.getString("statusEnc");
                linha[3] = retorno.getLong("cpfFunc");
                linha[4] = retorno.getLong("nProntuarioUsu");
                linha[5] = retorno.getString("idEndereco");

                lista.add(linha);
            }
            
            comandoSQL.close();
            conexao.close();
            
        } catch (SQLException ex) {
            ex.printStackTrace();
        }

        return lista;
    }

    public EncaminhamentoDAO getEncaminhamento(long idEnc) {

        EncaminhamentoDAO lista = new EncaminhamentoDAO();

        String listarEncaminhamentos = "SELECT tipoEnc, localEnc, statusEnc, cpfFunc, nProntuarioUsu, idEndereco "
                + "FROM encaminhamento WHERE idEnc = ?";

        try {

            Connection conexao = new Conexao().getConnection();
            PreparedStatement comandoSQL = conexao.prepareStatement(listarEncaminhamentos);

            comandoSQL.setLong(1, idEnc);

            ResultSet retorno = comandoSQL.executeQuery();

            while (retorno.next()) {

                lista.setTipoEnc(retorno.getString("tipoEnc"));
                lista.setLocalEnc(retorno.getString("localEnc"));
                lista.setStatusEnc(retorno.getString("statusEnc"));
                lista.setCpfFunc_FK(retorno.getLong("cpfFunc"));
                lista.setnProntuarioUsu_FK(retorno.getLong("nProntuarioUsu"));
                lista.setIdEndereco_FK(retorno.getLong("idEndereco"));
            }
            
            comandoSQL.close();
            conexao.close();
            
        } catch (SQLException ex) {
            ex.printStackTrace();
        }

        return lista;

    }

    public long getIdEndereco_FK() {
        return idEndereco_FK;
    }

    public void setIdEndereco_FK(long idEndereco_FK) {
        this.idEndereco_FK = idEndereco_FK;
    }

    public String getLocalEnc() {
        return localEnc;
    }

    public void setLocalEnc(String localEnc) {
        this.localEnc = localEnc;
    }

    public String getStatusEnc() {
        return statusEnc;
    }

    public void setStatusEnc(String statusEnc) {
        this.statusEnc = statusEnc;
    }

    public long getCpfFunc_FK() {
        return cpfFunc_FK;
    }

    public void setCpfFunc_FK(long cpfFunc_FK) {
        this.cpfFunc_FK = cpfFunc_FK;
    }

    public long getnProntuarioUsu_FK() {
        return nProntuarioUsu_FK;
    }

    public void setnProntuarioUsu_FK(long nProntuarioUsu_FK) {
        this.nProntuarioUsu_FK = nProntuarioUsu_FK;
    }

    public String getTipoEnc() {
        return tipoEnc;
    }

    public void setTipoEnc(String tipoEnc) {
        this.tipoEnc = tipoEnc;
    }

}
