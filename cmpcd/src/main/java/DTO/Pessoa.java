package DTO;

import java.sql.ResultSet;
import DAO.ControlUsuario;

public class Pessoa extends Usuario {

    private String nomeCompleto;
    private String cpf;
    private String dataNascimento;
    private String telefone;
    private String ocupacao;
    private String tipoDeficiencia;
    private String Enderecobairro;
    private String Enderecorua;
    private int EndereconumeroCasa;
    private String Enderecocomplemento;

    public Pessoa(int codigo, String nomelogin, String email, String senha, String nomeCompleto, String cpf,
            String dataNascimento,
            String telefone, String ocupacao, String tipoDeficiencia, String Enderecobairro, String Enderecorua,
            int EndereconumeroCasa, String Enderecocomplemento) {
        super(codigo, nomelogin, email, senha);
        this.nomeCompleto = nomeCompleto;
        this.cpf = cpf;
        this.dataNascimento = dataNascimento;
        this.telefone = telefone;
        this.ocupacao = ocupacao;
        this.tipoDeficiencia = tipoDeficiencia;
        this.Enderecobairro = Enderecobairro;
        this.Enderecorua = Enderecorua;
        this.EndereconumeroCasa = EndereconumeroCasa;
        this.Enderecocomplemento = Enderecocomplemento;

    }

    public Pessoa(int codigo, String nomelogin, String email) {
        super(codigo, nomelogin, email);
    }

    public void loginAuthenticacao(Pessoa usuario) {
        try {
            ControlUsuario objuser = new ControlUsuario();
            ResultSet rsusuario = objuser.authentificacaoUsuario(usuario);

            if (rsusuario.next()) {

            } else {

            }

        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    public String getOcupacao() {
        return ocupacao;
    }

    public void setOcupacao(String ocupacao) {
        this.ocupacao = ocupacao;
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

    public String getEnderecobairro() {
        return Enderecobairro;
    }

    public void setEnderecobairro(String enderecobairro) {
        Enderecobairro = enderecobairro;
    }

    public String getEnderecorua() {
        return Enderecorua;
    }

    public void setEnderecorua(String enderecorua) {
        Enderecorua = enderecorua;
    }

    public int getEndereconumeroCasa() {
        return EndereconumeroCasa;
    }

    public void setEndereconumeroCasa(int endereconumeroCasa) {
        EndereconumeroCasa = endereconumeroCasa;
    }

    public String getEnderecocomplemento() {
        return Enderecocomplemento;
    }

    public void setEnderecocomplemento(String enderecocomplemento) {
        Enderecocomplemento = enderecocomplemento;
    }
}
