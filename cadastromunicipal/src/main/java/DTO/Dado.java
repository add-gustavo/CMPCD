package DTO;

public class Dado {
    private String tipoDeficiencia;
    private int quantidade;

    public Dado(String tipoDeficiencia, int quantidade) {
        this.tipoDeficiencia = tipoDeficiencia;
        this.quantidade = quantidade;
    }

    public String getTipoDeficiencia() {
        return tipoDeficiencia;
    }

    public int getQuantidade() {
        return quantidade;
    }
}