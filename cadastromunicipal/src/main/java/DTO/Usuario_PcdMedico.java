package DTO;

public class Usuario_PcdMedico {
    public int codigoUsuario;
    public String historicoMedicoRelevante;
    public boolean usoMedicacao;
    public String explicacaoUsoMedicacao;
    public boolean atendimentoEspecialista;
    public String explicacaoAtendimentoEspecialista;
    public boolean participacaoCentroApoio;
    public String explicacaoParticipacaoCentroApoio;

    public Usuario_PcdMedico(int codigoUsuario, String historicoMedicoRelevante, boolean usoMedicacao,
            String explicacaoUsoMedicacao, boolean atendimentoEspecialista, String explicacaoAtendimentoEspecialista,
            boolean participacaoCentroApoio, String explicacaoParticipacaoCentroApoio) {
        this.codigoUsuario = codigoUsuario;
        this.historicoMedicoRelevante = historicoMedicoRelevante;
        this.usoMedicacao = usoMedicacao;
        this.explicacaoUsoMedicacao = explicacaoUsoMedicacao;
        this.atendimentoEspecialista = atendimentoEspecialista;
        this.explicacaoAtendimentoEspecialista = explicacaoAtendimentoEspecialista;
        this.participacaoCentroApoio = participacaoCentroApoio;
        this.explicacaoParticipacaoCentroApoio = explicacaoParticipacaoCentroApoio;
    }

    public Usuario_PcdMedico(String historicoMedicoRelevante, boolean usoMedicacao,
            String explicacaoUsoMedicacao, boolean atendimentoEspecialista, String explicacaoAtendimentoEspecialista,
            boolean participacaoCentroApoio, String explicacaoParticipacaoCentroApoio) {
        this.historicoMedicoRelevante = historicoMedicoRelevante;
        this.usoMedicacao = usoMedicacao;
        this.explicacaoUsoMedicacao = explicacaoUsoMedicacao;
        this.atendimentoEspecialista = atendimentoEspecialista;
        this.explicacaoAtendimentoEspecialista = explicacaoAtendimentoEspecialista;
        this.participacaoCentroApoio = participacaoCentroApoio;
        this.explicacaoParticipacaoCentroApoio = explicacaoParticipacaoCentroApoio;
    }

    // Getters and Setters
    public int getCodigoUsuario() {
        return codigoUsuario;
    }

    public void setCodigoUsuario(int codigoUsuario) {
        this.codigoUsuario = codigoUsuario;
    }

    public String getHistoricoMedicoRelevante() {
        return historicoMedicoRelevante;
    }

    public void setHistoricoMedicoRelevante(String historicoMedicoRelevante) {
        this.historicoMedicoRelevante = historicoMedicoRelevante;
    }

    public boolean isUsoMedicacao() {
        return usoMedicacao;
    }

    public void setUsoMedicacao(boolean usoMedicacao) {
        this.usoMedicacao = usoMedicacao;
    }

    public String getExplicacaoUsoMedicacao() {
        return explicacaoUsoMedicacao;
    }

    public void setExplicacaoUsoMedicacao(String explicacaoUsoMedicacao) {
        this.explicacaoUsoMedicacao = explicacaoUsoMedicacao;
    }

    public boolean isAtendimentoEspecialista() {
        return atendimentoEspecialista;
    }

    public void setAtendimentoEspecialista(boolean atendimentoEspecialista) {
        this.atendimentoEspecialista = atendimentoEspecialista;
    }

    public String getExplicacaoAtendimentoEspecialista() {
        return explicacaoAtendimentoEspecialista;
    }

    public void setExplicacaoAtendimentoEspecialista(String explicacaoAtendimentoEspecialista) {
        this.explicacaoAtendimentoEspecialista = explicacaoAtendimentoEspecialista;
    }

    public boolean isParticipacaoCentroApoio() {
        return participacaoCentroApoio;
    }

    public void setParticipacaoCentroApoio(boolean participacaoCentroApoio) {
        this.participacaoCentroApoio = participacaoCentroApoio;
    }

    public String getExplicacaoParticipacaoCentroApoio() {
        return explicacaoParticipacaoCentroApoio;
    }

    public void setExplicacaoParticipacaoCentroApoio(String explicacaoParticipacaoCentroApoio) {
        this.explicacaoParticipacaoCentroApoio = explicacaoParticipacaoCentroApoio;
    }
}