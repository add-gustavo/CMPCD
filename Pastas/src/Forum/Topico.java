package CMPCD.Pastas.src.Forum;

import CMPCD.BACK.src.DTO.Pessoa;

public class Topico {
    private int codigo;
    private String titulo;
    private String descricao;
    private String datetime;
    private Pessoa autor;

    public Topico(int codigo, String titulo, Pessoa autor) {
        this.codigo = codigo;
        this.titulo = titulo;
        this.autor = autor;
    }

    public int getCodigo() {
        return codigo;
    }

    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public String getDatetime() {
        return datetime;
    }

    public void setDatetime(String datetime) {
        this.datetime = datetime;
    }

    public Pessoa getAutor() {
        return autor;
    }

    public void setAutor(Pessoa autor) {
        this.autor = autor;
    }
}
