package DTO;

public class Pessoa extends Usuario {

    private String nomeCompleto;
    private String cpf;
    private String dataNascimento;
    private String tipoDeficiencia;
    private String Endereco;
    private String ocupacao;
    private String genero; // Novo atributo para Gênero
    private String estadocivil; // Novo atributo para Estado Civil
    private String grauDeficiencia; // Novo atributo para Grau de Deficiência
    private String nivelEscolaridade; // Novo atributo para Nível de Escolaridade
    private double rendaFamiliarPCapita; // Novo atributo para Renda Familiar per Capita
    private String historicoMedicoRelevante; // Novo atributo para Histórico Médico Relevante
    private String telefone;
    private boolean necessidadeAcompanhante; // Novo atributo para Necessidade de Acompanhante
    private boolean necessidadeEquipamento; // Novo atributo para Necessidade de Equipamento
    private boolean necessidadeTransporteAdaptado; // Novo atributo para Necessidade de Transporte Adaptado
    private boolean necessidadeAdaptacaoLocalAtendimento; // Novo atributo para Necessidade de Adaptação Local de
                                                          // Atendimento
    private boolean necessidadeApoioEducacional; // Novo atributo para Necessidade de Apoio Educacional
    private boolean programaAssistenciasocial; // Novo atributo para Programa de Assistência Social
    private boolean usoMedicacao; // Novo atributo para Uso de Medicação
    private boolean participaCentroApoio; // Novo atributo para Participação em Centro de Apoio
    private boolean atendimentoEspecialista; // Novo atributo para Atendimento Especialista

    public Pessoa(int codigo, String nomelogin, String email, String senha, String nomeCompleto, String cpf,
            String dataNascimento, String tipoDeficiencia, String Endereco, String ocupacao,
            String genero, String estadocivil, String grauDeficiencia, boolean necessidadeAcompanhante,
            boolean necessidadeEquipamento, boolean necessidadeTransporteAdaptado,
            boolean necessidadeAdaptacaoLocalAtendimento, String nivelEscolaridade,
            boolean necessidadeApoioEducacional, double rendaFamiliarPCapita,
            boolean programaAssistenciasocial, String historicoMedicoRelevante, boolean usoMedicacao,
            boolean participaCentroApoio, boolean atendimentoEspecialista, String telefone) {
        super(codigo, nomelogin, email, senha);
        this.nomeCompleto = nomeCompleto;
        this.cpf = cpf;
        this.dataNascimento = dataNascimento;
        this.tipoDeficiencia = tipoDeficiencia;
        this.Endereco = Endereco;
        this.ocupacao = ocupacao;
        this.genero = genero;
        this.estadocivil = estadocivil;
        this.grauDeficiencia = grauDeficiencia;
        this.necessidadeAcompanhante = necessidadeAcompanhante;
        this.necessidadeEquipamento = necessidadeEquipamento;
        this.necessidadeTransporteAdaptado = necessidadeTransporteAdaptado;
        this.necessidadeAdaptacaoLocalAtendimento = necessidadeAdaptacaoLocalAtendimento;
        this.nivelEscolaridade = nivelEscolaridade;
        this.necessidadeApoioEducacional = necessidadeApoioEducacional;
        this.rendaFamiliarPCapita = rendaFamiliarPCapita;
        this.programaAssistenciasocial = programaAssistenciasocial;
        this.historicoMedicoRelevante = historicoMedicoRelevante;
        this.usoMedicacao = usoMedicacao;
        this.participaCentroApoio = participaCentroApoio;
        this.atendimentoEspecialista = atendimentoEspecialista;
        this.telefone = telefone;
    }

    // Métodos getters e setters para cada atributo

    public Pessoa(String nomelogin, String email, String senha, String nomeCompleto, String cpf,
            String dataNascimento, String tipoDeficiencia, String endereco, String ocupacao, String genero,
            String estadocivil, String grauDeficiencia, boolean necessidadeAcompanhante,
            boolean necessidadeEquipamento, boolean necessidadeTransporteAdaptado,
            boolean necessidadeAdaptacaoLocalAtendimento, String nivelEscolaridade,
            boolean necessidadeApoioEducacional, double rendaFamiliarPCapita, boolean programaAssistenciasocial,
            String historicoMedicoRelevante, boolean usoMedicacao, boolean participaCentroApoio,
            boolean atendimentoEspecialista, String telefone) {
        super(nomelogin, email, senha);
        this.nomeCompleto = nomeCompleto;
        this.cpf = cpf;
        this.dataNascimento = dataNascimento;
        this.tipoDeficiencia = tipoDeficiencia;
        this.Endereco = endereco;
        this.ocupacao = ocupacao;
        this.genero = genero;
        this.estadocivil = estadocivil;
        this.grauDeficiencia = grauDeficiencia;
        this.necessidadeAcompanhante = necessidadeAcompanhante;
        this.necessidadeEquipamento = necessidadeEquipamento;
        this.necessidadeTransporteAdaptado = necessidadeTransporteAdaptado;
        this.necessidadeAdaptacaoLocalAtendimento = necessidadeAdaptacaoLocalAtendimento;
        this.nivelEscolaridade = nivelEscolaridade;
        this.necessidadeApoioEducacional = necessidadeApoioEducacional;
        this.rendaFamiliarPCapita = rendaFamiliarPCapita;
        this.programaAssistenciasocial = programaAssistenciasocial;
        this.historicoMedicoRelevante = historicoMedicoRelevante;
        this.usoMedicacao = usoMedicacao;
        this.participaCentroApoio = participaCentroApoio;
        this.atendimentoEspecialista = atendimentoEspecialista;
        this.telefone = telefone;
    }

    public String getNomeCompleto() {
        return nomeCompleto;
    }

    public void setNomeCompleto(String nomeCompleto) {
        this.nomeCompleto = nomeCompleto;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public String getDataNascimento() {
        return dataNascimento;
    }

    public void setDataNascimento(String dataNascimento) {
        this.dataNascimento = dataNascimento;
    }

    public String getTipoDeficiencia() {
        return tipoDeficiencia;
    }

    public void setTipoDeficiencia(String tipoDeficiencia) {
        this.tipoDeficiencia = tipoDeficiencia;
    }

    public String getEndereco() {
        return Endereco;
    }

    public void setEnderecobairro(String endereco) {
        Endereco = endereco;
    }

    public String getOcupacao() {
        return ocupacao;
    }

    public void setOcupacao(String ocupacao) {
        this.ocupacao = ocupacao;
    }

    public String getGenero() {
        return genero;
    }

    public void setGenero(String genero) {
        this.genero = genero;
    }

    public String getEstadocivil() {
        return estadocivil;
    }

    public void setEstadocivil(String estadocivil) {
        this.estadocivil = estadocivil;
    }

    public String getGrauDeficiencia() {
        return grauDeficiencia;
    }

    public void setGrauDeficiencia(String grauDeficiencia) {
        this.grauDeficiencia = grauDeficiencia;
    }

    public boolean getNecessidadeAcompanhante() {
        return necessidadeAcompanhante;
    }

    public void setNecessidadeAcompanhante(boolean necessidadeAcompanhante) {
        this.necessidadeAcompanhante = necessidadeAcompanhante;
    }

    public boolean getNecessidadeEquipamento() {
        return necessidadeEquipamento;
    }

    public void setNecessidadeEquipamento(boolean necessidadeEquipamento) {
        this.necessidadeEquipamento = necessidadeEquipamento;
    }

    public boolean getNecessidadeTransporteAdaptado() {
        return necessidadeTransporteAdaptado;
    }

    public void setNecessidadeTransporteAdaptado(boolean necessidadeTransporteAdaptado) {
        this.necessidadeTransporteAdaptado = necessidadeTransporteAdaptado;
    }

    public boolean getNecessidadeAdaptacaoLocalAtendimento() {
        return necessidadeAdaptacaoLocalAtendimento;
    }

    public void setNecessidadeAdaptacaoLocalAtendimento(boolean necessidadeAdaptacaoLocalAtendimento) {
        this.necessidadeAdaptacaoLocalAtendimento = necessidadeAdaptacaoLocalAtendimento;
    }

    public String getNivelEscolaridade() {
        return nivelEscolaridade;
    }

    public void setNivelEscolaridade(String nivelEscolaridade) {
        this.nivelEscolaridade = nivelEscolaridade;
    }

    public boolean getNecessidadeApoioEducacional() {
        return necessidadeApoioEducacional;
    }

    public void setNecessidadeApoioEducacional(boolean necessidadeApoioEducacional) {
        this.necessidadeApoioEducacional = necessidadeApoioEducacional;
    }

    public double getRendaFamiliarPCapita() {
        return rendaFamiliarPCapita;
    }

    public void setRendaFamiliarPCapita(double rendaFamiliarPCapita) {
        this.rendaFamiliarPCapita = rendaFamiliarPCapita;
    }

    public boolean getProgramaAssistenciasocial() {
        return programaAssistenciasocial;
    }

    public void setProgramaAssistenciasocial(boolean programaAssistenciasocial) {
        this.programaAssistenciasocial = programaAssistenciasocial;
    }

    public String getHistoricoMedicoRelevante() {
        return historicoMedicoRelevante;
    }

    public void setHistoricoMedicoRelevante(String historicoMedicoRelevante) {
        this.historicoMedicoRelevante = historicoMedicoRelevante;
    }

    public boolean getUsoMedicacao() {
        return usoMedicacao;
    }

    public void setUsoMedicacao(boolean usoMedicacao) {
        this.usoMedicacao = usoMedicacao;
    }

    public boolean getParticipaCentroApoio() {
        return participaCentroApoio;
    }

    public void setParticipaCentroApoio(boolean participaCentroApoio) {
        this.participaCentroApoio = participaCentroApoio;
    }

    public boolean getAtendimentoEspecialista() {
        return atendimentoEspecialista;
    }

    public void setAtendimentoEspecialista(boolean atendimentoEspecialista) {
        this.atendimentoEspecialista = atendimentoEspecialista;
    }

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }
}
