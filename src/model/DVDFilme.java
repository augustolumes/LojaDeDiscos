package model;

import utils.Utils;

public class DVDFilme extends Disco {
    private String diretor;
    private Double nota;

    public DVDFilme(String nome, double preco, String diretor, Double nota) {
        super(nome, preco);
        this.diretor = diretor;
        this.nota = nota;
        setID();
    }

    public String getDiretor() {
        return diretor;
    }

    public void setDiretor(String diretor) {
        this.diretor = diretor;
    }

    public Double getNota() {
        return nota;
    }

    public void setNota(Double nota) {
        this.nota = nota;
    }

    @Override
    public String toString() {
        return "Id: " + this.getId() + "\nTítulo: " + this.getNome() + "\nDiretor: " + this.getDiretor() + "\nNota: "
                + this.getNota()
                + "\nPreço: " + Utils.doubleToString(this.getPreco());
    }

}
