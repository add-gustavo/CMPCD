package DTO;

public class Usuario_PcdContato {
    public int codigoUsuario;
    public String telefone;
    public String endereco;

    public Usuario_PcdContato(int codigoUsuario, String telefone, String endereco) {
        this.codigoUsuario = codigoUsuario;
        this.telefone = telefone;
        this.endereco = endereco;
    }

    public Usuario_PcdContato(String telefone, String endereco) {
        this.telefone = telefone;
        this.endereco = endereco;
    }

    // Getters and Setters
    public int getCodigoUsuario() {
        return codigoUsuario;
    }

    public void setCodigoUsuario(int codigoUsuario) {
        this.codigoUsuario = codigoUsuario;
    }

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    public String getEndereco() {
        return endereco;
    }

    public void setEndereco(String endereco) {
        this.endereco = endereco;
    }
}
