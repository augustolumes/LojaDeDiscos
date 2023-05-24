package model;

import utils.Utils;

public class CD extends Disco {
    private int numFaixas;
    private String artista;

    public CD(String nome, double preco, int numFaixas, String artista) {
        super(nome, preco);
        this.numFaixas = numFaixas;
        this.artista = artista;
        setID();
    }

    public int getNumFaixas() {
        return numFaixas;
    }

    public void setNumFaixas(int numFaixas) {
        this.numFaixas = numFaixas;
    }

    public String getArtista() {
        return artista;
    }

    public void setArtista(String artista) {
        this.artista = artista;
    }

    @Override
    public String toString() {
        return "Id: " + this.getId() + "\nTítulo: " + this.getNome() + "\nArtista: " + this.getArtista() + "\nFaixas: "
                + this.getNumFaixas()
                + "\nPreço: " + Utils.doubleToString(this.getPreco());
    }

}
