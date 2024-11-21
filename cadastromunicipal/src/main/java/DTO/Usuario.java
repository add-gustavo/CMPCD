package DTO;

public class Usuario {

    protected int codigo;
    protected String email;
    protected String nomelogin;
    protected String senha;

    public Usuario(int codigo, String nomelogin, String email) {
        this.codigo = codigo;
        this.nomelogin = nomelogin;
        this.email = email;
    }

    public Usuario(int codigo, String nomelogin, String email, String senha) {
        this.codigo = codigo;
        this.nomelogin = nomelogin;
        this.email = email;
        this.senha = senha;

    }

    public Usuario(String email, String senha) {
        this.email = email;
        this.senha = senha;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public int getCodigo() {
        return codigo;
    }

    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    public String getNomelogin() {
        return nomelogin;
    }

    public void setNomelogin(String nomelogin) {
        this.nomelogin = nomelogin;
    }

}
