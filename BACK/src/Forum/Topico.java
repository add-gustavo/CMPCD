package CMPCD.BACK.src.Forum;

import CMPCD.BACK.src.User.Usuario;

public class Topico {
    private int codigo;
    private String titulo;
    private Usuario autor;

    public Topico(int codigo, String titulo, Usuario autor) {
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

    public Usuario getAutor() {
        return autor;
    }

    public void setAutor(Usuario autor) {
        this.autor = autor;
    }
}
