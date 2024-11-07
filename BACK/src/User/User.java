package CMPCD.BACK.src.User;

public class User {

    protected int codigo;
    protected String email;
    protected String nomelogin;
    protected String senha;

    public User(int codigo, String nomelogin) {
        this.codigo = codigo;
        this.nomelogin = nomelogin;
    }

    public User(int codigo) {

    }

    public void loginAuthenticacao(User user) {

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
