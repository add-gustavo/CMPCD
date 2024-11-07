package CMPCD.BACK.src.User;

import java.sql.ResultSet;

public class Usuario extends User {

    private String nomeCompleto = null;
    private String cpf = null;
    private String dataNascimento = null;
    private String telefone = null;
    private String tipoDeficiencia = null;

    public Usuario(int codigo, String nomelogin) {
        super(codigo, nomelogin);
    }

    public void loginAuthenticacao(Usuario usuario) {
        try {
            ControlUsuario objuser = new ControlUsuario();
            ResultSet rsusuario = objuser.authentificacaoUsuario(usuario);

            if (rsusuario.next()) {

            } else {

            }

        } catch (Exception e) {
            // TODO: handle exception
        }

    }

    public String getNomeCompleto() {
        return nomeCompleto;
    }

    public void setNomeCompleto(String nomeCompleto) {
        this.nomeCompleto = nomeCompleto;
    }

    public String getDataNascimento() {
        return dataNascimento;
    }

    public void setDataNascimento(String dataNascimento) {
        this.dataNascimento = dataNascimento;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    public String getTipoDeficiencia() {
        return tipoDeficiencia;
    }

    public void setTipoDeficiencia(String tipoDeficiencia) {
        this.tipoDeficiencia = tipoDeficiencia;
    }

}
