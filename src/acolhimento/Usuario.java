
package acolhimento;

import java.util.Date;


public class Usuario {
    
    private Integer numProntuario;
    private String nome;
    private TipoUser tipoUsuario;
    private Date dataCadastro;
    private StatusUser statusUsuario;
    private String sexo;
    private Date dataNascimento;
    private String documento;
    private String cidadeOrigem;
    private String responsavel;
    private String parecerTec;
    private String drogas;
    private String endereco;

    public Usuario(String nome, TipoUser tipoUsuario, Date dataCadastro, StatusUser statusUsuario, String sexo, Date dataNascimento, String documento, String cidadeOrigem, String responsavel, String parecerTec, String drogas, String endereco) {
        this.nome = nome;
        this.tipoUsuario = tipoUsuario;
        this.dataCadastro = dataCadastro;
        this.statusUsuario = statusUsuario;
        this.sexo = sexo;
        this.dataNascimento = dataNascimento;
        this.documento = documento;
        this.cidadeOrigem = cidadeOrigem;
        this.responsavel = responsavel;
        this.parecerTec = parecerTec;
        this.drogas = drogas;
        this.endereco = endereco;
    }

    public Usuario() {
    }
    
    public Integer getNumProntuario() {
        return numProntuario;
    }

    public void setNumProntuario(Integer numProntuario) {
        this.numProntuario = numProntuario;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public TipoUser getTipoUsuario() {
        return tipoUsuario;
    }

    public void setTipoUsuario(TipoUser tipoUsuario) {
        this.tipoUsuario = tipoUsuario;
    }

    public Date getDataCadastro() {
        return dataCadastro;
    }

    public void setDataCadastro(Date dataCadastro) {
        this.dataCadastro = dataCadastro;
    }

    public StatusUser getStatusUsuario() {
        return statusUsuario;
    }

    public void setStatusUsuario(StatusUser statusUsuario) {
        this.statusUsuario = statusUsuario;
    }

    public String getSexo() {
        return sexo;
    }

    public void setSexo(String sexo) {
        this.sexo = sexo;
    }

    public Date getDataNascimento() {
        return dataNascimento;
    }

    public void setDataNascimento(Date dataNascimento) {
        this.dataNascimento = dataNascimento;
    }

    public String getDocumento() {
        return documento;
    }

    public void setDocumento(String documento) {
        this.documento = documento;
    }

    public String getCidadeOrigem() {
        return cidadeOrigem;
    }

    public void setCidadeOrigem(String cidadeOrigem) {
        this.cidadeOrigem = cidadeOrigem;
    }

    public String getResponsavel() {
        return responsavel;
    }

    public void setResponsavel(String responsavel) {
        this.responsavel = responsavel;
    }

    public String getParecerTec() {
        return parecerTec;
    }

    public void setParecerTec(String parecerTec) {
        this.parecerTec = parecerTec;
    }

    public String getDrogas() {
        return drogas;
    }

    public void setDrogas(String drogas) {
        this.drogas = drogas;
    }

    public String getEndereco() {
        return endereco;
    }

    public void setEndereco(String endereco) {
        this.endereco = endereco;
    }
    
    
    
}
