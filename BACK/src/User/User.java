package CMPCD.BACK.src.User;

public class User {
    protected String codigo;
    protected String senha;
    protected String nomelogin;

    public User(String nomelogin, String senha) {
        this.senha = senha;
        this.nomelogin = nomelogin;
    }

    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
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
