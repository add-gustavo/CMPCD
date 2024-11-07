package CMPCD.BACK.src.Eventos;

public class Imagem {
    private int codigo;

    private String ImagemPrincipal;
    private String ImagemSecundaria1 = null;
    private String ImagemSecundaria2 = null;
    private String ImagemSecundaria3 = null;

    public Imagem(String ImagemPrincipal) {
        this.ImagemPrincipal = ImagemPrincipal;
    }

    public int getCodigo() {
        return codigo;
    }

    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }

    public String getImagemPrincipal() {
        return ImagemPrincipal;
    }

    public void setImagemPrincipal(String ImagemPrincipal) {
        this.ImagemPrincipal = ImagemPrincipal;
    }

    public String getImagemSecundaria1() {
        return ImagemSecundaria1;
    }

    public void setImagemSecundaria1(String imagemSecundaria1) {
        ImagemSecundaria1 = imagemSecundaria1;
    }

    public String getImagemSecundaria2() {
        return ImagemSecundaria2;
    }

    public void setImagemSecundaria2(String imagemSecundaria2) {
        ImagemSecundaria2 = imagemSecundaria2;
    }

    public String getImagemSecundaria3() {
        return ImagemSecundaria3;
    }

    public void setImagemSecundaria3(String imagemSecundaria3) {
        ImagemSecundaria3 = imagemSecundaria3;
    }
}
