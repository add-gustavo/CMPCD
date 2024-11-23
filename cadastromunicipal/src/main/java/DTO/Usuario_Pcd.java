package DTO;

public class Usuario_Pcd {
    public int codigo;
    public String nomeCompleto;
    public String cpf;
    public java.sql.Date dataNascimento;
    public String sexo;
    public String estadoCivil;
    public String nomeLogin;
    public String senha;
    public String email;

    public Usuario_Pcd(int codigo, String nomeCompleto, String cpf, java.sql.Date dataNascimento, String sexo,
            String estadoCivil, String nomeLogin, String senha, String email) {
        this.codigo = codigo;
        this.nomeCompleto = nomeCompleto;
        this.cpf = cpf;
        this.dataNascimento = dataNascimento;
        this.sexo = sexo;
        this.estadoCivil = estadoCivil;
        this.nomeLogin = nomeLogin;
        this.senha = senha;
        this.email = email;
    }

    public Usuario_Pcd(String nomeCompleto, String cpf, java.sql.Date dataNascimento, String sexo, String estadoCivil,
            String nomeLogin, String senha, String email) {
        this.nomeCompleto = nomeCompleto;
        this.cpf = cpf;
        this.dataNascimento = dataNascimento;
        this.sexo = sexo;
        this.estadoCivil = estadoCivil;
        this.nomeLogin = nomeLogin;
        this.senha = senha;
        this.email = email;
    }

    public Usuario_Pcd(String email, String senha) {
        this.email = email;
        this.senha = senha;
    }

    // Getters and Setters
    public int getCodigo() {
        return codigo;
    }

    public void setCodigo(int codigo) {
        this.codigo = codigo;
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

    public java.sql.Date getDataNascimento() {
        return dataNascimento;
    }

    public void setDataNascimento(java.sql.Date dataNascimento) {
        this.dataNascimento = dataNascimento;
    }

    public String getSexo() {
        return sexo;
    }

    public void setSexo(String sexo) {
        this.sexo = sexo;
    }

    public String getEstadoCivil() {
        return estadoCivil;
    }

    public void setEstadoCivil(String estadoCivil) {
        this.estadoCivil = estadoCivil;
    }

    public String getNomeLogin() {
        return nomeLogin;
    }

    public void setNomeLogin(String nomeLogin) {
        this.nomeLogin = nomeLogin;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
