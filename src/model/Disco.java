package model;

public abstract class Disco {
    private int id;
    private String nome;
    private double preco;

    public Disco(String nome, double preco) {
        this.nome = nome;
        this.preco = preco;
    }

    public int getId() {
        return id;
    }

    public void setID() {
        CriaId id = CriaId.getInstance();
        this.id = id.pegaId();
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public double getPreco() {
        return preco;
    }

    public void setPreco(double preco) {
        this.preco = preco;
    }
}
