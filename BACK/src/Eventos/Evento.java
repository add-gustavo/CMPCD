package CMPCD.BACK.src.Eventos;

public class Evento {
    private String codigo;
    private String titulo;
    private String descrição;
    private String keywords;
    private Imagem imagens;
    private String texto = null;
    private String date = null;

    public Evento(String codigo, String titulo, String descricao, String keywords, Imagem imagens) {
        this.codigo = codigo;
        this.titulo = titulo;
        this.descrição = descricao;
        this.keywords = keywords;
        this.imagens = imagens;
    }

    public Imagem getImagens() {
        return imagens;
    }

    public void setImagens(Imagem imagens) {
        this.imagens = imagens;
    }

    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getDescrição() {
        return descrição;
    }

    public void setDescrição(String descrição) {
        this.descrição = descrição;
    }

    public String getTexto() {
        return texto;
    }

    public void setTexto(String texto) {
        this.texto = texto;
    }

    public String getKeywords() {
        return keywords;
    }

    public void setKeywords(String keywords) {
        this.keywords = keywords;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

}
