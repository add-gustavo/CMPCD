package DTO;

public class UsuarioPcdInfo {
    private Usuario_Pcd usuarioPcd;
    private Usuario_PcdContato contato;
    private Usuario_PcdDeficiencia deficiencia;
    private Usuario_PcdMedico medico;
    private Usuario_PcdSocial social;
    private Responsavel responsavel;

    // Construtor
    public UsuarioPcdInfo(Usuario_Pcd usuarioPcd, Usuario_PcdContato contato, Usuario_PcdDeficiencia deficiencia,
            Usuario_PcdMedico medico, Usuario_PcdSocial social, Responsavel responsavel) {
        this.usuarioPcd = usuarioPcd;
        this.contato = contato;
        this.deficiencia = deficiencia;
        this.medico = medico;
        this.social = social;
        this.responsavel = responsavel;
    }

    // Getters e Setters
    public Usuario_Pcd getUsuarioPcd() {
        return usuarioPcd;
    }

    public void setUsuarioPcd(Usuario_Pcd usuarioPcd) {
        this.usuarioPcd = usuarioPcd;
    }

    public Usuario_PcdContato getContato() {
        return contato;
    }

    public void setContato(Usuario_PcdContato contato) {
        this.contato = contato;
    }

    public Usuario_PcdDeficiencia getDeficiencia() {
        return deficiencia;
    }

    public void setDeficiencia(Usuario_PcdDeficiencia deficiencia) {
        this.deficiencia = deficiencia;
    }

    public Usuario_PcdMedico getMedico() {
        return medico;
    }

    public void setMedico(Usuario_PcdMedico medico) {
        this.medico = medico;
    }

    public Usuario_PcdSocial getSocial() {
        return social;
    }

    public void setSocial(Usuario_PcdSocial social) {
        this.social = social;
    }

    public Responsavel getResponsavel() {
        return responsavel;
    }

    public void setResponsavel(Responsavel responsavel) {
        this.responsavel = responsavel;
    }
}
