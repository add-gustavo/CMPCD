package CMPCD.Pastas.src.Forum;

import CMPCD.BACK.src.DTO.Pessoa;

public class Postagem {
    private int codigo;
    private String comentario;
    private String datetime;
    private Pessoa autor;
    private Topico topico;

    public Postagem(String comentario, Pessoa autor) {
        this.comentario = comentario;
        this.autor = autor;
    }

    public Postagem(int codigo, String comentario, String datetime, Pessoa autor, Topico topico) {
        this.codigo = codigo;
        this.comentario = comentario;
        this.autor = autor;
        this.datetime = datetime;
        this.topico = topico;
    }

    public int getCodigo() {
        return codigo;
    }

    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }

    public String getComentario() {
        return comentario;
    }

    public void setComentario(String comentario) {
        this.comentario = comentario;
    }

    public Pessoa getAutor() {
        return autor;
    }

    public void setAutor(Pessoa autor) {
        this.autor = autor;
    }

    public String getDatetime() {
        return datetime;
    }

    public void setDatetime(String datetime) {
        this.datetime = datetime;
    }

    public Topico getCodigoTopico() {
        return topico;
    }

    public void setCodigoTopico(Topico topico) {
        this.topico = topico;
    }
}
