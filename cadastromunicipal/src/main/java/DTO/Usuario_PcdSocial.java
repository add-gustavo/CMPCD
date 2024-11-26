package DTO;

public class Usuario_PcdSocial {
    public int codigoUsuario;
    public String ocupacao;
    public String nivelEscolaridade;
    public String rendaFamiliarPcapita;
    public String programaAssistenciaSocial;

    public Usuario_PcdSocial(int codigoUsuario, String ocupacao, String nivelEscolaridade, String rendaFamiliarPcapita,
            String programaAssistenciaSocial) {
        this.codigoUsuario = codigoUsuario;
        this.ocupacao = ocupacao;
        this.nivelEscolaridade = nivelEscolaridade;
        this.rendaFamiliarPcapita = rendaFamiliarPcapita;
        this.programaAssistenciaSocial = programaAssistenciaSocial;
    }

    public Usuario_PcdSocial(String ocupacao, String nivelEscolaridade, String rendaFamiliarPcapita,
            String programaAssistenciaSocial) {
        this.ocupacao = ocupacao;
        this.nivelEscolaridade = nivelEscolaridade;
        this.rendaFamiliarPcapita = rendaFamiliarPcapita;
        this.programaAssistenciaSocial = programaAssistenciaSocial;
    }

    // Getters and Setters
    public int getCodigoUsuario() {
        return codigoUsuario;
    }

    public void setCodigoUsuario(int codigoUsuario) {
        this.codigoUsuario = codigoUsuario;
    }

    public String getOcupacao() {
        return ocupacao;
    }

    public void setOcupacao(String ocupacao) {
        this.ocupacao = ocupacao;
    }

    public String getNivelEscolaridade() {
        return nivelEscolaridade;
    }

    public void setNivelEscolaridade(String nivelEscolaridade) {
        this.nivelEscolaridade = nivelEscolaridade;
    }

    public String getRendaFamiliarPcapita() {
        return rendaFamiliarPcapita;
    }

    public void setRendaFamiliarPcapita(String rendaFamiliarPcapita) {
        this.rendaFamiliarPcapita = rendaFamiliarPcapita;
    }

    public String getProgramaAssistenciaSocial() {
        return programaAssistenciaSocial;
    }

    public void setProgramaAssistenciaSocial(String programaAssistenciaSocial) {
        this.programaAssistenciaSocial = programaAssistenciaSocial;
    }
}