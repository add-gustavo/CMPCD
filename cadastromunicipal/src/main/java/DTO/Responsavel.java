package DTO;

public class Responsavel {
    public int id;
    public int codigoUsuario;
    public String nomeCompleto;
    public String telefone;
    public String email;
    public String endereco;

    public Responsavel(int id, int codigoUsuario, String nomeCompleto, String telefone, String email, String endereco) {
        this.id = id;
        this.codigoUsuario = codigoUsuario;
        this.nomeCompleto = nomeCompleto;
        this.telefone = telefone;
        this.email = email;
        this.endereco = endereco;
    }

    public Responsavel(int codigoUsuario, String nomeCompleto, String telefone, String email, String endereco) {
        this.codigoUsuario = codigoUsuario;
        this.nomeCompleto = nomeCompleto;
        this.telefone = telefone;
        this.email = email;
        this.endereco = endereco;
    }

    public Responsavel(String nomeCompleto, String telefone, String email, String endereco) {
        this.nomeCompleto = nomeCompleto;
        this.telefone = telefone;
        this.email = email;
        this.endereco = endereco;
    }

    // Getters and Setters
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getCodigoUsuario() {
        return codigoUsuario;
    }

    public void setCodigoUsuario(int codigoUsuario) {
        this.codigoUsuario = codigoUsuario;
    }

    public String getNomeCompleto() {
        return nomeCompleto;
    }

    public void setNomeCompleto(String nomeCompleto) {
        this.nomeCompleto = nomeCompleto;
    }

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getEndereco() {
        return endereco;
    }

    public void setEndereco(String endereco) {
        this.endereco = endereco;
    }
}
