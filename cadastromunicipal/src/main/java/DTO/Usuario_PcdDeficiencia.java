package DTO;

public class Usuario_PcdDeficiencia {
    public int codigoUsuario;
    public String tipoDeficiencia;
    public boolean necessidadeAcompanhante;
    public boolean necessidadeEquipamento;
    public String explicacaoNecessidadeEquipamento;
    public boolean necessidadeAdaptacao;
    public String explicacaoNecessidadeAdaptacao;
    public boolean necessidadeAdaptacaoLocalAtendimento;
    public String explicacaoNecessidadeAdaptacaoLocalAtendimento;
    public boolean necessidadeEducacional;
    public String explicacaonecessidadeEducacional;

    public Usuario_PcdDeficiencia(int codigoUsuario, String tipoDeficiencia, boolean necessidadeAcompanhante,
            boolean necessidadeEquipamento,
            String explicacaoNecessidadeEquipamento, boolean necessidadeAdaptacao,
            String explicacaoNecessidadeAdaptacao, boolean necessidadeAdaptacaoLocalAtendimento,
            String explicacaoNecessidadeAdaptacaoLocalAtendimento, boolean necessidadeEducacional,
            String explicacaonecessidadeEducacional) {
        this.codigoUsuario = codigoUsuario;
        this.tipoDeficiencia = tipoDeficiencia;
        this.necessidadeAcompanhante = necessidadeAcompanhante;
        this.necessidadeEquipamento = necessidadeEquipamento;
        this.explicacaoNecessidadeEquipamento = explicacaoNecessidadeEquipamento;
        this.necessidadeAdaptacao = necessidadeAdaptacao;
        this.explicacaoNecessidadeAdaptacao = explicacaoNecessidadeAdaptacao;
        this.necessidadeAdaptacaoLocalAtendimento = necessidadeAdaptacaoLocalAtendimento;
        this.explicacaoNecessidadeAdaptacaoLocalAtendimento = explicacaoNecessidadeAdaptacaoLocalAtendimento;
        this.necessidadeEducacional = necessidadeEducacional;
        this.explicacaonecessidadeEducacional = explicacaonecessidadeEducacional;
    }

    public Usuario_PcdDeficiencia(String tipoDeficiencia, boolean necessidadeAcompanhante,
            boolean necessidadeEquipamento,
            String explicacaoNecessidadeEquipamento, boolean necessidadeAdaptacao,
            String explicacaoNecessidadeAdaptacao, boolean necessidadeAdaptacaoLocalAtendimento,
            String explicacaoNecessidadeAdaptacaoLocalAtendimento, boolean necessidadeEducacional,
            String explicacaonecessidadeEducacional) {

        this.tipoDeficiencia = tipoDeficiencia;
        this.necessidadeAcompanhante = necessidadeAcompanhante;
        this.necessidadeEquipamento = necessidadeEquipamento;
        this.explicacaoNecessidadeEquipamento = explicacaoNecessidadeEquipamento;
        this.necessidadeAdaptacao = necessidadeAdaptacao;
        this.explicacaoNecessidadeAdaptacao = explicacaoNecessidadeAdaptacao;
        this.necessidadeAdaptacaoLocalAtendimento = necessidadeAdaptacaoLocalAtendimento;
        this.explicacaoNecessidadeAdaptacaoLocalAtendimento = explicacaoNecessidadeAdaptacaoLocalAtendimento;
        this.necessidadeEducacional = necessidadeEducacional;
        this.explicacaonecessidadeEducacional = explicacaonecessidadeEducacional;

    }

    // Getters and Setters
    public int getCodigoUsuario() {
        return codigoUsuario;
    }

    public void setCodigoUsuario(int codigoUsuario) {
        this.codigoUsuario = codigoUsuario;
    }

    public String getTipoDeficiencia() {
        return tipoDeficiencia;
    }

    public void setTipoDeficiencia(String tipoDeficiencia) {
        this.tipoDeficiencia = tipoDeficiencia;
    }

    public boolean isNecessidadeAcompanhante() {
        return necessidadeAcompanhante;
    }

    public void setNecessidadeAcompanhante(boolean necessidadeAcompanhante) {
        this.necessidadeAcompanhante = necessidadeAcompanhante;
    }

    public boolean isNecessidadeEquipamento() {
        return necessidadeEquipamento;
    }

    public void setNecessidadeEquipamento(boolean necessidadeEquipamento) {
        this.necessidadeEquipamento = necessidadeEquipamento;
    }

    public String getExplicacaoNecessidadeEquipamento() {
        return explicacaoNecessidadeEquipamento;
    }

    public void setExplicacaoNecessidadeEquipamento(String explicacaoNecessidadeEquipamento) {
        this.explicacaoNecessidadeEquipamento = explicacaoNecessidadeEquipamento;
    }

    public boolean isNecessidadeAdaptacao() {
        return necessidadeAdaptacao;
    }

    public void setNecessidadeAdaptacao(boolean necessidadeAdaptacao) {
        this.necessidadeAdaptacao = necessidadeAdaptacao;
    }

    public String getExplicacaoNecessidadeAdaptacao() {
        return explicacaoNecessidadeAdaptacao;
    }

    public void setExplicacaoNecessidadeAdaptacao(String explicacaoNecessidadeAdaptacao) {
        this.explicacaoNecessidadeAdaptacao = explicacaoNecessidadeAdaptacao;
    }

    public boolean isNecessidadeAdaptacaoLocalAtendimento() {
        return necessidadeAdaptacaoLocalAtendimento;
    }

    public void setNecessidadeAdaptacaoLocalAtendimento(boolean necessidadeAdaptacaoLocalAtendimento) {
        this.necessidadeAdaptacaoLocalAtendimento = necessidadeAdaptacaoLocalAtendimento;
    }

    public String getExplicacaoNecessidadeAdaptacaoLocalAtendimento() {
        return explicacaoNecessidadeAdaptacaoLocalAtendimento;
    }

    public void setExplicacaoNecessidadeAdaptacaoLocalAtendimento(
            String explicacaoNecessidadeAdaptacaoLocalAtendimento) {
        this.explicacaoNecessidadeAdaptacaoLocalAtendimento = explicacaoNecessidadeAdaptacaoLocalAtendimento;
    }

    public boolean getNecessidadeEducacional() {
        return necessidadeEducacional;
    }

    public void setNecessidadeEducacional(boolean necessidadeEducacional) {
        this.necessidadeEducacional = necessidadeEducacional;
    }

    public String getExplicacaonecessidadeEducacional() {
        return explicacaonecessidadeEducacional;
    }

    public void setExplicacaonecessidadeEducacional(String explicacaonecessidadeEducacional) {
        this.explicacaonecessidadeEducacional = explicacaonecessidadeEducacional;
    }
}
